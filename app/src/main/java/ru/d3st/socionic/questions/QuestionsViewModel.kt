package ru.d3st.socionic.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.d3st.socionic.domain.Question
import ru.d3st.socionic.utils.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(val res: ResourcesHelper) : ViewModel() {

    //List questions
    val questions = mutableListOf<Question>()

    //point count data odd and even answers
    private var nextPoint = 13

    //Следующий вопрос
    private var nextQuestion = 0

    //result liveData for send data that the test result is ready
    private val _resultId = MutableLiveData(0)
    val resultId: LiveData<Int>
        get() = _resultId

    //count user answers
    private val _progress = MutableLiveData(0)
    val progress: LiveData<Int>
        get() = _progress

    //save current question
    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    val answers: HashMap<Int, Int> = hashMapOf()

    init {
        //load 1st part question
        questions.addAll(res.questions1)
        questions.addAll(res.questions2)

        //get 1st question from question list
        _currentQuestion.value = questions.first()
    }

    fun onClickYes() {
        nextQuestion = currentQuestion.value?.nextYes ?: 1
        val number = currentQuestion.value?.number
        if (number != null) {
            if (number % 2 == 0) setUserResult(EVEN) else setUserResult(ODD)
        }
        currentQuestion.value?.let { setQuestion(it.number) }
    }

    fun onCLickNo() {
        nextQuestion = currentQuestion.value?.nextNo ?: 1
        setUserResult(PASS)
        currentQuestion.value?.let { setQuestion(it.number) }

    }

    private fun setUserResult(answer: Int) {
        currentQuestion.value?.let {
            answers[it.number] = answer
        }



        changeProgress(answers.size)
    }


    fun removeLastResult() {
        if (answers.isNotEmpty()) {
            nextQuestion = answers.maxOf { it.key }
            //remove last answer information
            answers.remove(answers.maxOf { it.key })
            //reset result
            if (_resultId.value != 0) _resultId.value = 0
            //change progressbar
            changeProgress(answers.size)
            Timber.i("remove last result answers contained ${answers.size}")
            setCurrentQuestion(nextQuestion)
        }
    }


    private fun setQuestion(number: Int) {

        when (number) {

            12 -> {
                removeFinishQuestions()
                var oddCount: Int
                var evenCount: Int
                val firstSixAnswers = answers.filter { it.key <= 6 }
                oddCount = firstSixAnswers.filter { it.value == ODD }.size
                evenCount = firstSixAnswers.filter { it.value == EVEN }.size
                val branchFirst = if (evenCount > oddCount) BranchName.B else BranchName.A
                Timber.i("Answers first six is $branchFirst")

                val lastSixResult = answers.filter { it.key > 6 }
                oddCount = lastSixResult.filter { it.value == ODD }.size
                evenCount = lastSixResult.filter { it.value == EVEN }.size
                val branchSecond = if (evenCount > oddCount) BranchName.D else BranchName.C
                Timber.i("Answers second six is $branchSecond")
                setNextBranchQuestions(branchFirst, branchSecond)
                nextQuestion = questions.first { it.number > 12 }.number
                nextPoint = nextQuestion + 5
            }
        }

        if (number == nextPoint) {

            val lastSixResult = answers.filter { it.key > 12 }
            val oddCount = lastSixResult.filter { it.value == ODD }.size
            val evenCount = lastSixResult.filter { it.value == EVEN }.size
            if (evenCount > oddCount) nextQuestion += 4
            Timber.i("Next questions $nextQuestion")
        }
        if (nextQuestion > 100) {
            _resultId.value = nextQuestion
        } else {
            setCurrentQuestion(nextQuestion)
        }
    }

    private fun removeFinishQuestions() {
        questions.removeAll(questions.filter { it.number > 12 })
        Timber.i("Questions contain ${questions.size} elements")
    }

    private fun setCurrentQuestion(number: Int) {
        _currentQuestion.value = questions.firstOrNull { it.number == number }
        Timber.i("Current question number ${currentQuestion.value?.number}")
        Timber.i("Current count odd = ${answers.filter { it.value == ODD }.size} ")
        Timber.i("Current count even = ${answers.filter { it.value == EVEN }.size} ")
    }


    private fun setNextBranchQuestions(one: BranchName, two: BranchName) {
        val finishQuestions = res.mapDb[Pair(one, two)]
        finishQuestions?.let { questions.addAll(it) }
    }

    private fun changeProgress(progressCount: Int) {
        _progress.value = progressCount
    }


}


