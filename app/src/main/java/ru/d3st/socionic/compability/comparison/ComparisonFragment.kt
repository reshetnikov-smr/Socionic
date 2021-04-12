package ru.d3st.socionic.compability.comparison

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.databinding.FragmentComparisonBinding
import javax.inject.Inject

@AndroidEntryPoint
class ComparisonFragment:Fragment() {

    private lateinit var binding: FragmentComparisonBinding

    //get data from QuestionsFragment
    private val args: ComparisonFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ComparisonViewModelFactory

    private val viewModel: ComparisonViewModel by viewModels {
        ComparisonViewModel.provideFactory(viewModelFactory, Pair(args.main, args.secondary))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentComparisonBinding.inflate(inflater,container,false)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.btnBack.setOnClickListener {
            val action = ComparisonFragmentDirections
                    .actionComparisonFragmentToCompatibilityFragment(args.main)
              findNavController().navigate(action)
        }

        return binding.root
    }
}