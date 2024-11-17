package ru.d3st.socionic.presenatation.questions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.d3st.socionic.R
import ru.d3st.socionic.data.QuestionStorage
import ru.d3st.socionic.models.SocionicAttribute
import ru.d3st.socionic.models.presentation.QuestionContent
import ru.d3st.socionic.models.presentation.QuestionUiState
import ru.d3st.socionic.presenatation.questions.action.QuestionEffect
import ru.d3st.socionic.presenatation.questions.action.QuestionPerformAction
import ru.d3st.socionic.utils.IdConverter
import ru.d3st.socionic.utils.TypeCalculator

class QuestionsViewModel @AssistedInject constructor(
    @Assisted private val res: QuestionStorage,
    private val typeCalculator: TypeCalculator,
    private val converter: IdConverter,
) : ViewModel() {

    private val _uiState = MutableStateFlow(QuestionUiState())
    val uiState: StateFlow<QuestionUiState> = _uiState

    private val _effects = MutableSharedFlow<QuestionEffect>()
    val effects: SharedFlow<QuestionEffect> = _effects

    private var currentNumber = 1
    private val result = mutableMapOf<Int, SocionicAttribute>()

    init {
        setState(currentNumber)
    }

    fun perform(action: QuestionPerformAction) {
        when (action) {
            QuestionPerformAction.Exit -> exitTest()
            QuestionPerformAction.Previous -> prevQuestion()
            QuestionPerformAction.Result -> toResult()
            QuestionPerformAction.No -> nextQuestion()
            QuestionPerformAction.Yes -> {
                nextQuestion()
                setResult(currentNumber)
            }
        }
    }

    private fun toResult() {
        currentNumber = res.questions.size
        setState(currentNumber)
        viewModelScope.launch {
            converter.convert(typeCalculator.calculateType(result))?.let { resultId ->
                _effects.emit(QuestionEffect.ToResult(resultId))
            }
        }
    }

    private fun exitTest() {
        viewModelScope.launch {
            _effects.emit(QuestionEffect.CloseTest)
        }
    }

    private fun nextQuestion() {
        if (currentNumber < res.questions.size.plus(1)) {
            currentNumber++
            setState(currentNumber)
        }
    }

    private fun setState(number: Int) {
        if (currentNumber > res.questions.size) {
            _uiState.update {
                it.copy(
                    isFinished = true,
                    content = QuestionContent(
                        number = res.questions.size,
                        progressBar = 1f,
                        text = R.string.test_finished
                    )
                )
            }
        } else {
            res.questions[number]?.run {
                _uiState.update {
                    QuestionUiState(
                        isStarted = currentNumber == 1,
                        isFinished = false,
                        content = QuestionContent(
                            number = currentNumber,
                            progressBar = currentNumber.minus(1) / res.questions.size.toFloat(),
                            text = question
                        )
                    )
                }
            }
        }
    }

    private fun setResult(number: Int) {
        res.questions[number]?.run {
            result.put(number, goalType)
        }
    }

    private fun prevQuestion() {
        currentNumber--
        setState(currentNumber)
        result.remove(currentNumber)
    }
}