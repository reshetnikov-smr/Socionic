package ru.d3st.socionic.presenatation.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import ru.d3st.socionic.ui.theme.navTypography
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
        textAlign = TextAlign.Justify
    )
}

@Composable
fun SimpleText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = navTypography.bodyMedium,
) {
    Text(text = text, modifier = modifier, style = style)
}