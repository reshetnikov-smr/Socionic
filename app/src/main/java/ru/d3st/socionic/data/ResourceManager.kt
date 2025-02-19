package ru.d3st.socionic.data

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resource: Int): String
}