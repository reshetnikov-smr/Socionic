package ru.d3st.socionic.presenatation.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.d3st.socionic.databinding.FragmentQuestionsBinding

@AndroidEntryPoint
class QuestionsFragment : Fragment() {

    private val viewModel: Questions2ViewModel by viewModels()

    private lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuestionsBinding.inflate(
            inflater,
            container,
            false
        )
        //init viemodel
        binding.viewmodel = viewModel

        //binding button Back for navigate to Main Screen
        binding.btnBack.setOnClickListener {
            navigateToStartScreen()
        }

        //button Previous for cancel result last question
        binding.btnPrevious.setOnClickListener{
            viewModel.removeLastResult()
            binding.invalidateAll()
        }


        //Handle button Yes
        binding.btnYes.setOnClickListener {
            viewModel.onClickYes()
            binding.invalidateAll()

        }

        //handle Button No
        binding.btnNo.setOnClickListener {
            viewModel.onCLickNo()
            binding.invalidateAll()

        }

        binding.btnResult.setOnClickListener {
            viewModel.showResult()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateToResult.observe(viewLifecycleOwner){
            if (it != null && it != 0){
                navigateToResult(it)
                viewModel.resetNavigation()
            }
        }
    }

    private fun navigateToStartScreen() {
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToStartFragment()
        findNavController().navigate(action)
    }

    private fun navigateToResult(resultId: Int) {
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToFragmentDetail(resultId)
        findNavController().navigate(action)
    }
}