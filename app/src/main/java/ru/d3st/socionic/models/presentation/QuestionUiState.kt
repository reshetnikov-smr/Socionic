package ru.d3st.socionic.models.presentation

data class QuestionUiState(
    val isStarted: Boolean = false,
    val isFinished: Boolean = false,
    val content: QuestionContent? = null,
)