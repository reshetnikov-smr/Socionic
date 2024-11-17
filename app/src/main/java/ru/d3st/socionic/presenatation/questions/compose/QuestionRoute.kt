package ru.d3st.socionic.presenatation.questions.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.d3st.socionic.R
import ru.d3st.socionic.presenatation.questions.QuestionsViewModel
import ru.d3st.socionic.presenatation.questions.action.QuestionActions
import ru.d3st.socionic.presenatation.questions.action.QuestionPerformAction

@Composable
fun QuestionRoute(
    viewModel: QuestionsViewModel = hiltViewModel<QuestionsViewModel>(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    state.content?.run {
        QuestionScreen(
            number = number,
            questionText = stringResource(text),
            progress = { progressBar },
            previousButtonText = if (state.isStarted) {
                null
            } else {
                stringResource(R.string.previous)
            },
            nextButtonText = if (state.isFinished) {
                stringResource(R.string.result)
            } else {
                null
            },
            hiddenAnswerButtons = state.isFinished,
            actions = QuestionActions(
                previous = { viewModel.perform(QuestionPerformAction.Previous) },
                goToMain = { viewModel.perform(QuestionPerformAction.Exit) },
                onYes = { viewModel.perform(QuestionPerformAction.Yes) },
                onNo = { viewModel.perform(QuestionPerformAction.No) },
                onResult = { viewModel.perform(QuestionPerformAction.Result) }
            ),
        )
    }
}