package ru.d3st.socionic.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.d3st.socionic.data.DefaultQuestionStorageFactory
import ru.d3st.socionic.data.FullTestStorage
import ru.d3st.socionic.data.ShortTestStorage
import ru.d3st.socionic.presenatation.questions.QuestionStorage
import ru.d3st.socionic.presenatation.questions.QuestionStorageFactory
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
abstract class QuestionStorageModule {

    @Binds
    @ShortTest
    abstract fun bindShortStorage(storage: ShortTestStorage): QuestionStorage

    @Binds
    @FullTest
    abstract fun bindFullStorage(storage: FullTestStorage): QuestionStorage
}

@InstallIn(SingletonComponent::class)
@Module
class QuestionStorageFactoryModule {

    @Provides
    fun provideQuestionStorageFactory(
        @ShortTest shortTest: QuestionStorage,
        @FullTest fullTest: QuestionStorage,
    ): QuestionStorageFactory {
        return DefaultQuestionStorageFactory(shortTest, fullTest)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ShortTest

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FullTest
