package ru.d3st.socionic.presenatation.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
fun HeadLineText(
    stringRes: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = stringRes),
        style = typography.headlineLarge,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Preview
@Composable
fun TextPreview() {
    Column {
        BaseButton(textRes = R.string.start_test) {
        }
    }

}