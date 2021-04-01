package ru.d3st.socionic.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.databinding.FragmentDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class FragmentDetail : Fragment() {

    //connect dataBinding
    private lateinit var binding: FragmentDetailBinding
    //get data from QuestionsFragment
    private val args: FragmentDetailArgs by navArgs()

    //create Viemodel instance
    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(viewModelFactory, args.resultId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailBinding.inflate(
                inflater,
                container,
                false
        )
        //init viewModel
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this



        return binding.root
    }
}