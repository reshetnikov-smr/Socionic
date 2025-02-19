package ru.d3st.socionic.utils

import android.content.Context
import ru.d3st.socionic.data.ResourceManager

class ResourceManagerImpl(val context: Context) : ResourceManager {

    override fun getString(resource: Int): String {
        return context.getString(resource)
    }
}