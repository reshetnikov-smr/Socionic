package ru.d3st.socionic.presenatation.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.d3st.socionic.models.GulenkoQuestion
import ru.d3st.socionic.data.GulenkoQuestions
import ru.d3st.socionic.models.SocionicAttribute
import ru.d3st.socionic.utils.IdConverter
import ru.d3st.socionic.utils.TypeCalculator
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GeneralQuestionsViewModel @Inject constructor(
    private val res: GulenkoQuestions,
    private val typeCalculator: TypeCalculator,
    private val converter: IdConverter,
) : ViewModel() {

    private val result = mutableMapOf<Int, SocionicAttribute>()
    var amountQuestions = 0

    private val _isResultReady = MutableLiveData(false)
    val isResultReady: LiveData<Boolean> = _isResultReady

    private val _navigateToResult = MutableLiveData<Int>(0)
    val navigateToResult: LiveData<Int> = _navigateToResult

    //count user answers
    private val _currentQuestionNumber = MutableLiveData(1)

    /**
     * Current number test questions
     */
    val currentQuestionNumber: LiveData<Int> = _currentQuestionNumber

    //save current question
    private val _currentQuestion = MutableLiveData<GulenkoQuestion?>()

    /**
     * Current question data
     */
    val currentQuestion: LiveData<GulenkoQuestion?> = _currentQuestion

    init {
        amountQuestions = res.questions.size
        //get 1st question from question list
        _currentQuestion.value = res.questions[_currentQuestionNumber.value]
        Timber.i("current question ${currentQuestionNumber.value}")
    }

    fun onClickYes() {
        _currentQuestionNumber.value?.run {
            _currentQuestion.value?.goalType?.let { result.put(this, it) }
            nextQuestion()
        }
    }

    fun onCLickNo() {
        nextQuestion()
    }

    fun removeLastResult() {
        _currentQuestionNumber.value?.run {
            result.remove(this)
            previousQuestion()
        }
    }

    private fun nextQuestion() {
        val next = _currentQuestionNumber.value?.plus(1)
        val nextQuestion = res.questions[next]
        if (nextQuestion != null) {
            _currentQuestion.value = nextQuestion
            _currentQuestionNumber.value = next
        } else {
            _isResultReady.value = true
        }
    }

    private fun previousQuestion() {
        if (isResultReady.value == true) {
            _isResultReady.value = false
        } else {
            _currentQuestionNumber.value?.minus(1)?.let {
                _currentQuestionNumber.value = it
                _currentQuestion.value = res.questions[it]
            }

        }
    }

    fun showResult() {
        if (isResultReady.value == true) {
            _navigateToResult.value =
                converter.convert(typeCalculator.calculateType(result))
        }
    }

    fun resetNavigation() {
        _navigateToResult.value = 0
    }


}


