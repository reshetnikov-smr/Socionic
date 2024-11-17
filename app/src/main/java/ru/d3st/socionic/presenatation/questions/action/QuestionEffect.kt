package ru.d3st.socionic.presenatation.questions.action

sealed class QuestionEffect {
    data object CloseTest : QuestionEffect()
    data class ToResult(val resultId: Int) : QuestionEffect()
}