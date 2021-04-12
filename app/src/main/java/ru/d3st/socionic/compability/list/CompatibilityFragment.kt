package ru.d3st.socionic.compability.list

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.R
import ru.d3st.socionic.databinding.FragmentCompabilityBinding
import ru.d3st.socionic.utils.COMPATIBILITY
import ru.d3st.socionic.utils.themeColor
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
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

        binding.btnBack.setOnClickListener {
            val action = CompatibilityFragmentDirections
                    .actionCompatibilityFragmentToFragmentOverview(COMPATIBILITY)
            findNavController().navigate(action)
        }

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
