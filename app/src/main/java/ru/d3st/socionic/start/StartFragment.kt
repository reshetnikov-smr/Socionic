package ru.d3st.socionic.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.databinding.FragmentStartBinding

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

        binding.btnFast.setOnClickListener {
            navigateToFastGame()
        }

        return binding.root
    }

    private fun navigateToFastGame() {
        val action = StartFragmentDirections.actionStartFragmentToQuestionsFragment()
        findNavController().navigate(action)
    }
}