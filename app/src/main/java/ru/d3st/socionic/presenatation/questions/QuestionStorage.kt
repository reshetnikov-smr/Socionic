package ru.d3st.socionic.presenatation.questions

import ru.d3st.socionic.models.presentation.QuestionForm

interface QuestionStorage {
    val questions: HashMap<Int, QuestionForm>
}