package ru.d3st.socionic.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.d3st.socionic.data.CompatibilityHelper
import ru.d3st.socionic.data.ResourceManager
import ru.d3st.socionic.utils.ResourceManagerImpl

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideResourceManager(@ApplicationContext context: Context): ResourceManager =
        ResourceManagerImpl(context)

    @Provides
    fun provideCompatibilityHelper(resourceManager: ResourceManager): CompatibilityHelper =
        CompatibilityHelper(resourceManager)
}