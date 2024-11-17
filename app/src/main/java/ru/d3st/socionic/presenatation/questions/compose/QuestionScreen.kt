package ru.d3st.socionic.presenatation.questions.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3st.socionic.R
import ru.d3st.socionic.presenatation.compose.ImageButton
import ru.d3st.socionic.presenatation.compose.SimpleButton
import ru.d3st.socionic.presenatation.questions.action.QuestionActions
import ru.d3st.socionic.ui.theme.gradientColors
import ru.d3st.socionic.ui.theme.shapes
import ru.d3st.socionic.ui.theme.typography

@Composable
fun QuestionScreen(
    number: Int,
    questionText: String,
    progress: () -> Float,
    modifier: Modifier = Modifier,
    previousButtonText: String? = null,
    nextButtonText: String? = null,
    hiddenAnswerButtons: Boolean = false,
    actions: QuestionActions = QuestionActions(),
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.back_night_long),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.BottomCenter
            )
            .padding(16.dp),
    ) {
        Column {
            Column(
                modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                QuestionAppBar(number = number, iconAction = actions.goToMain)
                LinearProgressIndicator(
                    progress = progress,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                )
                QuestionField(questionText)
                if (!hiddenAnswerButtons) {
                    ButtonsBlock(
                        modifier = modifier.weight(1f),
                        actions = actions
                    )
                }
            }
            FooterBlock(
                modifier = modifier,
                previousButtonText = previousButtonText,
                nextButtonText = nextButtonText,
                actions = actions
            )
        }

    }
}

@Composable
internal fun ButtonsBlock(
    modifier: Modifier = Modifier,
    actions: QuestionActions = QuestionActions(),
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        SimpleButton(
            R.string.yes,
            modifier
                .requiredWidthIn(120.dp),
            onClickAction = actions.onYes
        )
        SimpleButton(
            R.string.no, modifier
                .requiredWidthIn(120.dp),
            onClickAction = actions.onNo
        )
    }
}

@Composable
fun FooterBlock(
    modifier: Modifier = Modifier,
    previousButtonText: String? = null,
    nextButtonText: String? = null,
    actions: QuestionActions = QuestionActions(),
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 36.dp)
    ) {
        previousButtonText?.let {
            ImageButton(
                modifier = modifier,
                text = it,
                leftSideIcon = R.drawable.ic_vector_left,
                action = actions.previous
            )
        }
        nextButtonText?.let {
            ImageButton(
                modifier = modifier,
                text = it,
                rightSideIcon = R.drawable.ic_vector_right,
                horizontalArrangement = Arrangement.End,
                action = actions.onResult,
            )
        }
    }
}

@Composable
internal fun QuestionField(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(colors = gradientColors),
                shape = shapes.small
            )
            .border(1.dp, color = Color.White, shape = shapes.small)
            .padding(16.dp),
        style = typography.bodyMedium,
    )
}

@Composable
@Preview
fun QuestionScreenPreview() {
    QuestionScreen(
        number = 69,
        questionText = "Доверяю приобретенному опыту, а не интуиции.",
        progress = { 0.5f },
        previousButtonText = "Предыдущий",
    )
}

@Composable
@Preview
fun QuestionScreenWithoutButtonsPreview() {
    QuestionScreen(
        number = 69,
        questionText = "Доверяю приобретенному опыту, а не интуиции.",
        progress = { 0.5f },
        previousButtonText = "Предыдущий",
        hiddenAnswerButtons = true
    )
}

