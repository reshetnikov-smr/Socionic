package ru.d3st.socionic.presenatation.questions.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3st.socionic.R
import ru.d3st.socionic.ui.theme.sc_theme_purple_tint
import ru.d3st.socionic.ui.theme.typography

@Composable
internal fun QuestionAppBar(
    number: Int,
    modifier: Modifier = Modifier,
    iconAction: () -> Unit = {},
) {
    Box(
        modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = modifier
                .padding(top = 16.dp)
                .size(48.dp)
                .clickable {
                    iconAction.invoke()
                },
            painter = painterResource(R.drawable.ic_back_button), contentDescription = null
        )
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                modifier = modifier
                    .drawBehind {
                        drawCircle(
                            color = sc_theme_purple_tint,
                            radius = 50.dp.toPx()
                        )
                    },
                text = number.toString(),
                style = typography.displayLarge
            )
        }
    }
}

@Composable
@Preview
fun QuestionAppBarPreview() {
    QuestionAppBar(69)
}