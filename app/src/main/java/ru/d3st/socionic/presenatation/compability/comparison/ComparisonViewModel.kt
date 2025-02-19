package ru.d3st.socionic.presenatation.compability.comparison

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.d3st.socionic.data.CompatibilityHelper
import ru.d3st.socionic.data.TypeDescriptions
import ru.d3st.socionic.utils.asComparisonData

class ComparisonViewModel @AssistedInject constructor(
    resources: TypeDescriptions,
    compat: CompatibilityHelper,
    @Assisted private val characters: Pair<Int, Int>,

    ) : ViewModel() {


    val mainCharacter = resources.characters.first { it.id == characters.first }
    val secondaryCharacter = resources.characters.first { it.id == characters.second }

    val compatTitle: String
    val compatDescription: String

    init {
        compatTitle = findCompatibility(compat)
        compatDescription = getCompatibilityDescription(compatTitle, compat)
    }

    private fun getCompatibilityDescription(compatTitle: String, res: CompatibilityHelper): String {
        return when (compatTitle) {
            res.tojd -> res.tojdDesc
            res.dual -> res.dualDesc
            res.akt -> res.aktDesc
            res.zerk -> res.zerkDesc
            res.zak -> res.zakDesc
            res.rev -> res.revDesc
            res.del -> res.delDesc
            res.mirj -> res.mirjDesc
            res.sego -> res.segoDesc
            res.ppol -> res.ppolDesc
            res.kvtoj -> res.kvtojDesc
            res.konf -> res.konfDesc
            res.rods -> res.rodsDesc
            res.pdual -> res.pdualDesc
            else -> "Unknown Compatibility"
        }
    }

    private fun findCompatibility(compat: CompatibilityHelper): String {
        val characterCompat = compat.compatibilities.first { it.characterId == characters.first }
        val compatibility = characterCompat.asComparisonData().filter { it.id == characters.second }
        return compatibility.first().compatibilityTitle
    }


    companion object {
        fun provideFactory(
            assistedFactory: ComparisonViewModelFactory,
            characters: Pair<Int, Int>,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(characters) as T
            }
        }
    }

}


@AssistedFactory
interface ComparisonViewModelFactory {
    fun create(
            characters: Pair<Int, Int>,
    ): ComparisonViewModel
}