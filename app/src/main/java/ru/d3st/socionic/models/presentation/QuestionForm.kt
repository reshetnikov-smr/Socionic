package ru.d3st.socionic.models.presentation

import androidx.annotation.StringRes
import ru.d3st.socionic.models.data.SocionicAttribute

/**
 * Model of answer
 */
data class QuestionForm(
    @StringRes val question: Int,
    val goalType: SocionicAttribute,
)