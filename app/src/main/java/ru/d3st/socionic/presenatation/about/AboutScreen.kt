package ru.d3st.socionic.presenatation.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.d3st.socionic.R
import ru.d3st.socionic.ui.theme.SocionicTheme
import ru.d3st.socionic.ui.theme.sc_theme_purple_tint
import ru.d3st.socionic.ui.theme.typography
import timber.log.Timber

@Composable
fun AboutScreen(
    onBack: () -> Unit = {},
) {
    // Background image
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back_night_long),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            Box {
                IconButton(
                    onClick = {
                        Timber.tag("AboutScreen").d("Back button clicked")
                        onBack()
                    },
                    modifier = Modifier
                        .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
                        .size(48.dp)

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_button),
                        contentDescription = stringResource(id = R.string.back_button_description),
                        tint = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.quan_light),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(vertical = 8.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.background(color = sc_theme_purple_tint)
                ) {
                    Text(
                        text = stringResource(id = R.string.about_app),
                        style = typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }

                Text(
                    text = stringResource(id = R.string.this_is_socionics),
                    style = typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 8.dp)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.background(color = sc_theme_purple_tint)
                ) {
                    Text(
                        text = stringResource(id = R.string.what_psychotype),
                        style = typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
                Text(
                    text = stringResource(id = R.string.desc_psychotype),
                    style = typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    SocionicTheme {
        AboutScreen()
    }
}
