package ru.d3st.socionic.presenatation.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.d3st.socionic.data.StorageQuestions3
import ru.d3st.socionic.models.QuestionForm
import ru.d3st.socionic.models.SocionicAttribute
import ru.d3st.socionic.utils.IdConverter
import ru.d3st.socionic.utils.TypeCalculator
import timber.log.Timber
import javax.inject.Inject

/**
 * ViewModel for full test
 */
@HiltViewModel
class Questions3ViewModel @Inject constructor(
    private val source: StorageQuestions3,
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
    private val _currentQuestion = MutableLiveData<QuestionForm?>()

    /**
     * Current question data
     */
    val currentQuestion: LiveData<QuestionForm?> = _currentQuestion

    init {
        amountQuestions = source.questions3.size
        //get 1st question from question list
        _currentQuestion.value = source.questions3[_currentQuestionNumber.value]
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
        val nextQuestion = source.questions3[next]
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
                _currentQuestion.value = source.questions3[it]
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