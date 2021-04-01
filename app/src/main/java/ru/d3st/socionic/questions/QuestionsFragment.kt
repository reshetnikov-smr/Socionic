package ru.d3st.socionic.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.d3st.socionic.databinding.FragmentQuestionsBinding
import ru.d3st.socionic.domain.Question
import timber.log.Timber

class QuestionsFragment : Fragment() {


    private lateinit var binding: FragmentQuestionsBinding
    lateinit var currentQuestion: Question
    private var even = 0
    private var odd = 0
    private var next = 0
    private lateinit var questions: MutableList<Question>
    private lateinit var oneNext: BranchName
    private lateinit var twoNext: BranchName

    private var index = 0

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



        //first question in test
        questions = ResourcesHelper(requireActivity().application).questions1
        currentQuestion = questions[0]
        binding.tvQuestion.text = currentQuestion.text



        binding.btnYes.setOnClickListener {
            //номер вопроса



            if (currentQuestion.number % 2 == 0) even++ else odd++
            next = currentQuestion.nextYes

            Timber.i("Game question number ${currentQuestion.number}\"", )
            Timber.i("even = $even, odd = $odd")
            setQuestion()
            binding.invalidateAll()
        }
        binding.btnNo.setOnClickListener {
            next = currentQuestion.nextNo
            Timber.i( "question number ${currentQuestion.number}")
            setQuestion()
            binding.invalidateAll()

        }

        return binding.root
    }

    private fun refreshStartValue() {
        index = 0
        odd = 0
        even = 0
    }

    private fun setQuestion() {
        var nextPoint = 0


        when (currentQuestion.number) {
            6 -> {
                oneNext = if (odd > even) BranchName.A else BranchName.B
                refreshStartValue()
                questions.addAll(ResourcesHelper(requireActivity().application).questions2)

            }
            12 -> {
                twoNext = if (odd > even) BranchName.C else BranchName.D
                refreshStartValue()
                setNextBranchQuestions(oneNext, twoNext)
                next = questions.first().number
                nextPoint = next+6

            }
        }

        if (currentQuestion.number >12 && currentQuestion.number ==  nextPoint){
            if (odd < even) next+4
        }

        if (next > 100) {
            navigateToResult(next)
        } else {
            currentQuestion = questions.first { it.number == next }
            binding.tvQuestion.text = currentQuestion.text
        }

    }

    private fun setNextBranchQuestions(one : BranchName, two: BranchName) {
        Pair(one, two)
        questions.removeAll(questions)
        val lastQuestions = ResourcesHelper(requireActivity().application).mapDb[Pair(one, two)]
        lastQuestions?.let { questions.addAll(it) }

    }

    private fun navigateToResult(resultId: Int) {
        val action = QuestionsFragmentDirections.actionQuestionsFragmentToFragmentDetail(resultId)
        findNavController().navigate(action)
    }
}