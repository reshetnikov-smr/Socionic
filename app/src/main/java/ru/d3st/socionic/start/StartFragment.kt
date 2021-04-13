package ru.d3st.socionic.start

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.databinding.FragmentStartBinding
import ru.d3st.socionic.utils.COMPATIBILITY
import ru.d3st.socionic.utils.OVERVIEW

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStartBinding.inflate(
                inflater,
                container,
                false)

        //animation question sign
        val questionSign = binding.logo.ivIconQuestion
        //set animation property
        val anim = ObjectAnimator.ofFloat(questionSign, "rotationY", 360f).apply {
            duration = 1500
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
        }
        //start animation
        AnimatorSet().apply {
            play(anim)
            start()
        }



        binding.btnFast.setOnClickListener {
            navigateToFastGame()
        }
        binding.btnOverview.setOnClickListener {
            navigateToOverview(COMPATIBILITY)
        }
        binding.ivCircleLeft.setOnClickListener {
            navigateToFAQ()
        }
        binding.ivCircleRight.setOnClickListener {
            navigateToOverview(OVERVIEW)
        }

        return binding.root
    }

    private fun navigateToFAQ() {
        val action = StartFragmentDirections.actionStartFragmentToAboutFragment()
        findNavController().navigate(action)

    }

    private fun navigateToOverview(category: Int) {
        val action = StartFragmentDirections.actionStartFragmentToFragmentOverview(category)
        findNavController().navigate(action)
    }

    private fun navigateToFastGame() {
        val action = StartFragmentDirections.actionStartFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }
}