package ru.d3st.socionic.overview

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.R
import ru.d3st.socionic.databinding.FragmentOverviewBinding
import ru.d3st.socionic.utils.OVERVIEW
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding


    //get data from QuestionsFragment
    private val args: OverviewFragmentArgs by navArgs()

    //create Viewmodel instance
    @Inject
    lateinit var viewModelFactory: OverviewViewModelFactory

    private val viewModel: OverviewViewModel by viewModels {
        OverviewViewModel.provideFactory(viewModelFactory, args.category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this


        //init adapter
        val adapter =
            OverviewListAdapter(OverviewListAdapter.CharacterClickListener { view, characterId ->
                navigateToCharacter(view, characterId)
            })
        binding.rvListPersons.adapter = adapter

        //Так как Портреты Соционических типов в списке имеет фиксированное значение,
        //получаем его ширину в пикселях исходя из DP данного устройства
        val itemWidth = resources.getDimensionPixelSize(R.dimen.width_rv_character)

        val orientation: Int = resources.configuration.orientation
        //в зависимости от ориентации будет выбираться количество столбцов либо 2 либо 4
        val spanCount = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //in landscape
            4
        } else {
            // In portrait
            2
        }
        val manager = GridLayoutManager(
            activity,
            spanCount
        )
        binding.rvListPersons.layoutManager = manager
        //настраиваем равные отступы и центрирование элементов в нашем списке(сетке)
        binding.rvListPersons.addItemDecoration(GridSpacingItemDecoration(spanCount, itemWidth))

        adapter.submitList(viewModel.characters)

        //binding back button
        binding.btnBack.setOnClickListener {
            navigateToStartScreen()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }


    private fun navigateToStartScreen() {
        val action = OverviewFragmentDirections.actionFragmentOverviewToStartFragment()
        findNavController().navigate(action)
    }

    private fun navigateToCharacter(view: View, characterId: Int) {
        Hold().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        exitTransition = Hold().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }

        reenterTransition = Hold().apply {
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
        }
        val cardTransactionName = getString(R.string.character_card_detail_transition_name)
        val extras = FragmentNavigatorExtras(view to cardTransactionName)
        Timber.i("category is ${args.category}")
        val directions = when (args.category) {
            OVERVIEW -> OverviewFragmentDirections.actionFragmentOverviewToFragmentDetail(
                characterId
            )
            else -> OverviewFragmentDirections.actionFragmentOverviewToCompatibilityFragment(
                characterId
            )
        }

        findNavController().navigate(directions, extras)
    }



}