package ru.d3st.socionic.start

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var rocketAnimation: AnimationDrawable



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStartBinding.inflate(
                inflater,
                container,
                false)



        binding.btnFast.setOnClickListener {
            navigateToFastGame()
        }
        binding.btnOverview.setOnClickListener {
            navigateToOverview()
        }
        binding.ivQuAn.setOnClickListener {
            navigateToFAQ()
        }

        return binding.root
    }

    private fun navigateToFAQ() {
        val action = StartFragmentDirections.actionStartFragmentToAboutFragment()
        findNavController().navigate(action)

    }

    private fun navigateToOverview() {
        val action = StartFragmentDirections.actionStartFragmentToFragmentOverview()
        findNavController().navigate(action)
    }

    private fun navigateToFastGame() {
        val action = StartFragmentDirections.actionStartFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }
}