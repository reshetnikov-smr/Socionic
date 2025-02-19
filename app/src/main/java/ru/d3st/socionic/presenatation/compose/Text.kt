package ru.d3st.socionic.presenatation.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import ru.d3st.socionic.ui.theme.sc_theme_yellow_tint
import ru.d3st.socionic.ui.theme.typography

@Composable
fun HeadLineText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = typography.headlineLarge,
        modifier = modifier,
        color = Color.White,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun SimpleText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = typography.bodyLarge,
    color: Color = sc_theme_yellow_tint,
) {
    Text(text = text, modifier = modifier, style = style, color = color)
}