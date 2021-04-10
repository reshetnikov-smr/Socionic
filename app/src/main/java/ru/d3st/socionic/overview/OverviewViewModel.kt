package ru.d3st.socionic.overview

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.d3st.socionic.domain.ResultCharacter
import ru.d3st.socionic.questions.ResourcesHelper
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(resources: ResourcesHelper): ViewModel() {

    val characters = mutableListOf<ResultCharacter>()

    init {
        characters.addAll(resources.characters)
        Timber.i("Characters has ${characters.size}")
    }

}