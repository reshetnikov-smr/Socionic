package ru.d3st.socionic.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.R
import ru.d3st.socionic.databinding.FragmentDetailBinding
import ru.d3st.socionic.utils.themeColor
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {

    //connect dataBinding
    private lateinit var binding: FragmentDetailBinding
    //get data from QuestionsFragment
    private val args: DetailFragmentArgs by navArgs()

    //create Viemodel instance
    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(viewModelFactory, args.resultId)
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailBinding.inflate(
                inflater,
                container,
                false
        )
        //init viewModel
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        //binding BackButton
        binding.btnBack.setOnClickListener {
            //заменяет нажатие кнопки назад в системе Андроид
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }



        return binding.root
    }
}