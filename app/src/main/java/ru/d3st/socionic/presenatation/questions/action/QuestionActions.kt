package ru.d3st.socionic.presenatation.questions.action

data class QuestionActions(
    val previous: () -> Unit = {},
    val goToMain: () -> Unit = {},
    val onYes: () -> Unit = {},
    val onNo: () -> Unit = {},
    val onResult: () -> Unit = {},
)