package ru.d3st.socionic.presenatation.questions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ru.d3st.socionic.data.QuestionStorage
import ru.d3st.socionic.models.presentation.TestType
import ru.d3st.socionic.utils.IdConverter
import ru.d3st.socionic.utils.TypeCalculator

class QuestionsViewModelFactory @AssistedInject constructor(
    @Assisted private val type: TestType,
    private val storageFactory: QuestionStorageFactory,
    private val typeCalculator: TypeCalculator,
    private val converter: IdConverter,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val storage = storageFactory.create(type)

        if (modelClass.isAssignableFrom(QuestionsViewModel::class.java)) {
            return QuestionsViewModel(storage, typeCalculator, converter) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


interface QuestionStorageFactory {
    fun create(type: TestType): QuestionStorage
}
