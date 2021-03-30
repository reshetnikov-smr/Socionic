package ru.d3st.socionic.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.d3st.socionic.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {

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

        return binding.root
    }
}