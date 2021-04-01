package ru.d3st.socionic

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltAndroidApp
class MainApplication: Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)


    private fun delayedInit() {
        applicationScope.launch {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }
}