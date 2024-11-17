package ru.d3st.socionic.models.presentation

import androidx.annotation.StringRes

data class QuestionContent(
    val number: Int,
    val progressBar: Float,
    @StringRes val text: Int,
)