package ru.d3st.socionic.models

import androidx.annotation.StringRes

/**
 * Model of answer
 */
data class QuestionForm(
    @StringRes val question: Int,
    val goalType: SocionicAttribute,
)