package ru.d3st.socionic.compability.comparison

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.d3st.socionic.utils.CompatibilityHelper
import ru.d3st.socionic.utils.ResourcesHelper
import ru.d3st.socionic.utils.asComparisonData

class ComparisonViewModel @AssistedInject constructor(
        resources: ResourcesHelper,
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
            res.tojd -> res.tojd_desc
            res.dual -> res.dual_desc
            res.akt -> res.akt_desc
            res.zerk -> res.zerk_desc
            res.zak -> res.zak_desc
            res.rev -> res.rev_desc
            res.del -> res.del_desc
            res.mirj -> res.mirj_desc
            res.sego -> res.sego_desc
            res.ppol -> res.ppol_desc
            res.kvtoj -> res.kvtoj_desc
            res.konf -> res.konf_desc
            res.rods -> res.rods_desc
            res.pdual -> res.pdual_desc
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
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
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