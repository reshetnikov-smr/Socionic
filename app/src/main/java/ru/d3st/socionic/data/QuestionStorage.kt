package ru.d3st.socionic.data

import ru.d3st.socionic.models.QuestionForm

interface QuestionStorage {
    val questions: HashMap<Int, QuestionForm>
}