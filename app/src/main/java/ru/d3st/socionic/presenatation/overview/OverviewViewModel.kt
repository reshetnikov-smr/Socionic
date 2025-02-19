package ru.d3st.socionic.presenatation.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.d3st.socionic.data.TypeDescriptions
import ru.d3st.socionic.models.presentation.CharacterDescription
import timber.log.Timber

class OverviewViewModel @AssistedInject constructor(
    @Assisted private val category: Int,
    resources: TypeDescriptions,
): ViewModel() {

    val characters = mutableListOf<CharacterDescription>()

    init {
        characters.addAll(resources.characters)
        Timber.i("Characters has ${characters.size}")
    }

    companion object {
        fun provideFactory(
            assistedFactory: OverviewViewModelFactory,
            category: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(category) as T
            }
        }
    }

}

@AssistedFactory
interface OverviewViewModelFactory {
    fun create(category: Int): OverviewViewModel
}