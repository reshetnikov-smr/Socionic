package ru.d3st.socionic.models

import androidx.annotation.StringRes

/**
 * Model of answer
 */
data class GulenkoQuestion(
    @StringRes val question: Int,
    val goalType: SocionicAttribute,
)