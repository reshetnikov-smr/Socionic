package ru.d3st.socionic.presenatation.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3st.socionic.R
import ru.d3st.socionic.ui.theme.gradientColors
import ru.d3st.socionic.ui.theme.main_strokes
import ru.d3st.socionic.ui.theme.shapes
import ru.d3st.socionic.ui.theme.typography


@Composable
fun BaseButton(
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = typography.titleMedium,
    onClickAction: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(horizontal = 32.dp),
        onClick = onClickAction,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        border = main_strokes,
        shape = shapes.small,
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(brush = Brush.horizontalGradient(colors = gradientColors))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = textRes),
                style = textStyle
            )
        }
    }
}

@Composable
fun SimpleButton(
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = typography.bodyLarge,
    onClickAction: () -> Unit,
) {
    Button(
        modifier = modifier
            .heightIn(36.dp)
            .background(
                brush = Brush.horizontalGradient(colors = gradientColors),
                shape = shapes.small
            ),
        shape = shapes.small,
        border = main_strokes,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick = onClickAction
    ) {
        Text(
            text = stringResource(textRes),
            style = textStyle,
        )
    }
}

@Composable
fun ImageButton(
    text: String,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceAround,
    @DrawableRes leftSideIcon: Int? = null,
    @DrawableRes rightSideIcon: Int? = null,
    action: () -> Unit = {},
) {

    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressed = mutableInteractionSource.collectIsPressedAsState()
    val animSize = animateSizeAsState(
        targetValue = if (pressed.value) {
            Size(1.2F, 1.2F)
        } else {
            Size(1F, 1F)
        },
        label = "size"
    )
    Row(
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        modifier = modifier
            .padding(vertical = 16.dp)
            .graphicsLayer {
                this.scaleX = animSize.value.height
                this.scaleY = animSize.value.width
            }
            .clickable(interactionSource = mutableInteractionSource, indication = null) {
                action.invoke()
            }) {
        leftSideIcon?.let {
            Image(
                painter = painterResource(it),
                modifier = modifier
                    .padding(end = 8.dp),
                contentDescription = null
            )
        }
        SimpleText(text = text)
        rightSideIcon?.let {
            Image(
                painter = painterResource(it),
                modifier = modifier.padding(start = 8.dp),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun TextPreview() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BaseButton(textRes = R.string.start_test) {}
        SimpleButton(R.string.yes) { }
        ImageButton(
            text = "Продолжить",
            rightSideIcon = R.drawable.ic_vector_right
        )
    }
}