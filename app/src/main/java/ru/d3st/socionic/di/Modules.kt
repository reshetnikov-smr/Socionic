package ru.d3st.socionic.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.d3st.socionic.utils.CompatibilityHelper
import ru.d3st.socionic.utils.ResourcesHelper

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideResourcesHelper(application: Application): ResourcesHelper =
        ResourcesHelper(application)

    @Provides
    fun provideCompatibilityHelper(application: Application): CompatibilityHelper =
        CompatibilityHelper(application)
}