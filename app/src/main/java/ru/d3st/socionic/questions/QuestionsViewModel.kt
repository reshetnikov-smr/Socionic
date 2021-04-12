package ru.d3st.socionic.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.d3st.socionic.domain.Question
import ru.d3st.socionic.utils.BranchName
import ru.d3st.socionic.utils.ResourcesHelper
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(val res: ResourcesHelper) : ViewModel() {

    //List questions
    val questions = mutableListOf<Question>()


    private var nextQuestion = 0

    //result liveData for send data that the test result is ready
    private val _resultId = MutableLiveData(0)
    val resultId: LiveData<Int>
        get() = _resultId

    //count user answers
    private val _progress = MutableLiveData(0)
    val progress: LiveData<Int>
        get() = _progress


    private val resultFirstBranch = MutableLiveData<BranchName>()
    private val resultSecondBranch = MutableLiveData<BranchName>()

    //save current question
    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    val answers: MutableMap<Int, String> = mutableMapOf()

    init {
        //load 1st part question
        questions.addAll(res.questions1)
        //get 1st question from question list
        _currentQuestion.value = questions.first()
        Timber.i("${currentQuestion.value!!.number}")
    }

    fun onClickYes() {
        nextQuestion = currentQuestion.value!!.nextYes
        val number = currentQuestion.value!!.number
        if (number % 2 == 0) setUserResult("even") else setUserResult("odd")
        Timber.i("Question ${currentQuestion.value!!.number} and chet ${answers.filter { it.value == "even" }.size}  nechet ${answers.filter { it.value == "odd" }.size}")
        setQuestion(currentQuestion.value!!.number)
    }

    fun onCLickNo() {
        nextQuestion = currentQuestion.value!!.nextNo
        setUserResult("pass")
        Timber.i("Question ${currentQuestion.value!!.number}")
        setQuestion(currentQuestion.value!!.number)

    }

    private fun setUserResult(answer: String) {
        val number = currentQuestion.value!!.number
        answers[number] = answer
        changeProgress()
    }


    fun removeLastResult() {
        if (answers.isNotEmpty()) {
            answers.remove(answers.maxOf { it.key })
            if (_resultId.value != 0) _resultId.value = 0
            changeProgress()
            Timber.i("remove last result answers contained ${answers.size}")
            nextQuestion = answers.maxOfOrNull { it.key } ?: 1
            changeProgress()
            setCurrentQuestion(nextQuestion)
        }
    }


    private fun setQuestion(number: Int) {
        var nextPoint = 0
        when (number) {
            6 -> {
                resultFirstBranch.value =
                        if (answers.filter { it.value == "even" }.size > answers.filter { it.value == "odd" }.size) BranchName.B else BranchName.A
                Timber.i("Question $number and first branch ${resultFirstBranch.value} and second branch ${resultSecondBranch.value}")
                questions.addAll(res.questions2)

            }
            12 -> {
                val lastSixResult = answers.filter { it.key > 6 }
                resultSecondBranch.value =
                        if (lastSixResult.filter { it.value == "even" }.size > lastSixResult.filter { it.value == "odd" }.size) BranchName.D else BranchName.C
                Timber.i("Question $number and first branch ${resultFirstBranch.value} and second branch ${resultSecondBranch.value}")
                setNextBranchQuestions(resultFirstBranch.value, resultSecondBranch.value)
                nextQuestion = questions.first { it.number > 12 }.number
                nextPoint = nextQuestion + 6
            }
        }

        if (number > 12 && number == nextPoint) {
            val lastSixResult = answers.filter { it.key > 12 }
            if (lastSixResult.filter { it.value == "even" }.size > lastSixResult.filter { it.value == "odd" }.size) nextQuestion + 4
        }
        if (nextQuestion > 100) {
            _resultId.value = nextQuestion
        } else {
            setCurrentQuestion(nextQuestion)
        }


    }

    private fun setCurrentQuestion(number: Int) {
        _currentQuestion.value = questions.firstOrNull { it.number == number }
    }


    private fun setNextBranchQuestions(one: BranchName?, two: BranchName?) {
        val finishQuestions = res.mapDb[Pair(one, two)]
        finishQuestions?.let { questions.addAll(it) }
    }

    private fun changeProgress() {
        _progress.value = answers.size
    }


}


