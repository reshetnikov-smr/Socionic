package ru.d3st.socionic.presenatation.questions.action

sealed class QuestionPerformAction {
    data object Previous : QuestionPerformAction()
    data object Result : QuestionPerformAction()
    data object Exit : QuestionPerformAction()
    data object Yes : QuestionPerformAction()
    data object No : QuestionPerformAction()
}