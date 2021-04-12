package ru.d3st.socionic.compability.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.d3st.socionic.domain.Comparison
import ru.d3st.socionic.utils.CompatibilityHelper
import ru.d3st.socionic.utils.ResourcesHelper
import ru.d3st.socionic.utils.asComparisonData

class CompatibilityViewModel @AssistedInject constructor(
        resources: ResourcesHelper,
        compat: CompatibilityHelper,
        @Assisted private val characterId: Int,

        ) : ViewModel() {

    val character = resources.characters.first { it.id == characterId }

    private val _comparisonList = MutableLiveData<List<Comparison>>()
    val comparisonList: LiveData<List<Comparison>>
        get() = _comparisonList

    init {
        _comparisonList.value =createComparisonList(compat)
    }

    private fun createComparisonList(compat: CompatibilityHelper):List<Comparison> {
        val compatibility =  compat.compatibilities.first { it.characterId == characterId }
        return compatibility.asComparisonData()
    }


    companion object {
        fun provideFactory(
                assistedFactory: CompatibilityViewModelFactory,
                characterId: Int,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(characterId) as T
            }
        }
    }
}


@AssistedFactory
interface CompatibilityViewModelFactory {
    fun create(characterId: Int): CompatibilityViewModel
}