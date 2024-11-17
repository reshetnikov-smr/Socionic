package ru.d3st.socionic.domain.storage

import ru.d3st.socionic.data.QuestionStorage
import ru.d3st.socionic.di.FullTest
import ru.d3st.socionic.di.ShortTest
import ru.d3st.socionic.models.presentation.TestType
import ru.d3st.socionic.presenatation.questions.QuestionStorageFactory
import javax.inject.Inject

class DefaultQuestionStorageFactory @Inject constructor(
    @ShortTest private val shortTest: QuestionStorage,
    @FullTest private val fullTest: QuestionStorage,
) : QuestionStorageFactory {
    override fun create(type: TestType): QuestionStorage {
        return when (type) {
            TestType.SHORT -> shortTest
            TestType.FULL -> fullTest
        }
    }
}