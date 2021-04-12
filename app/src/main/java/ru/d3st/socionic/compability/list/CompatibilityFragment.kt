package ru.d3st.socionic.compability.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.databinding.FragmentCompabilityBinding
import javax.inject.Inject

@AndroidEntryPoint
class CompatibilityFragment : Fragment() {

    private lateinit var binding: FragmentCompabilityBinding

    //get data from QuestionsFragment
    private val args: CompatibilityFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: CompatibilityViewModelFactory

    private val viewModel: CompatibilityViewModel by viewModels {
        CompatibilityViewModel.provideFactory(viewModelFactory, args.characterId)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {

        binding = FragmentCompabilityBinding.inflate(inflater, container, false)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this


        //init adapter
        val adapter =
                CompatibilityListAdapter(CompatibilityListAdapter.CompatibilityClickListener { secondaryCharacter, compat ->
                    navigateToDetailComparison(args.characterId, secondaryCharacter, compat)
                })
        binding.rvCharactersCompatibility.adapter = adapter

        adapter.submitList(viewModel.comparisonList.value)

        return binding.root
    }

    private fun navigateToDetailComparison(
            mainCharacterId: Int,
            secondaryCharacterId: Int,
            compat: String,
    ) {
        val action =
                CompatibilityFragmentDirections.actionCompatibilityFragmentToComparisonFragment(
                        mainCharacterId,
                        secondaryCharacterId,
                        compat
                )
        findNavController().navigate(action)

    }
}
