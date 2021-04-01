package ru.d3st.socionic.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.d3st.socionic.questions.ResourcesHelper
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Modules {

    @Provides
    @Singleton
    fun provideData(application: Application): ResourcesHelper {
        return ResourcesHelper(application)
    }
}