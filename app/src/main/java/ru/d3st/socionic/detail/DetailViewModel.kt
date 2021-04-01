package ru.d3st.socionic.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.d3st.socionic.domain.ResultCharacter
import ru.d3st.socionic.questions.ResourcesHelper

class DetailViewModel @AssistedInject constructor(
    res: ResourcesHelper,
    @Assisted private val resultId: Int
) : ViewModel() {

    private val _result = MutableLiveData<ResultCharacter>()
    val result: LiveData<ResultCharacter>
        get() = _result

    init {
        _result.value = res.characters.first { it.id == resultId }
    }


    companion object {
        fun provideFactory(
            assistedFactory: DetailsViewModelFactory,
            resultId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(resultId) as T
            }
        }
    }

}

@AssistedFactory
interface DetailsViewModelFactory {
    fun create(resultId: Int): DetailViewModel
}