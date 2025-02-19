package ru.d3st.socionic.presenatation.compose

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.d3st.socionic.R
import ru.d3st.socionic.ui.theme.HammerSmithFamily
import ru.d3st.socionic.ui.theme.sc_theme_yellow_tint
import ru.d3st.socionic.ui.theme.typography
import ru.d3st.socionic.utils.COMPATIBILITY

/**
 * Composable start screen
 *
 * @param onStartTest start fast test
 * @param onFullTest start full test
 * @param onOverview navigate to overview screen
 * @param onGoFAQ navigate to FAQ
 * @param modifier modifier view
 *
 */
@Composable
fun StartScreen(
    onStartTest: () -> Unit,
    onFullTest: () -> Unit,
    onOverview: (Int) -> Unit,
    onGoFAQ: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.back_night_long),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomCenter
        )
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoHeader()
            BaseButton(
                R.string.fast_start,
                modifier.padding(top = 100.dp),
                typography.headlineLarge,
                onStartTest
            )
            BaseButton(
                R.string.full_test,
                modifier.padding(top = 24.dp),
                typography.headlineLarge,
                onFullTest
            )
            BaseButton(
                R.string.compatibility,
                modifier.padding(top = 24.dp),
                typography.headlineLarge
            ) { onOverview.invoke(COMPATIBILITY) }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 24.dp),
                Arrangement.Center
            ) {
                IconCircle(
                    R.drawable.ic_quan,
                    onGoFAQ,
                    modifier.weight(1f)
                )
                IconCircle(
                    R.drawable.ic_head_question,
                    { onOverview.invoke(COMPATIBILITY) },
                    modifier.weight(1f)
                )
            }


        }
    }
}


@Composable
private fun LogoHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(modifier = modifier.padding(start = 24.dp)) {
            HeadIconAnim()
            Column(
                modifier = modifier
                    .padding(top = 36.dp)
                    .offset(x = (-24).dp)
            ) {
                Text(
                    text = stringResource(id = R.string.ocionics),
                    color = Color.White,
                    fontSize = 48.sp,
                    fontFamily = HammerSmithFamily,
                    fontWeight = FontWeight.Medium
                )
                Box(
                    modifier
                        .align(Alignment.End)
                        .wrapContentSize()
                ) {
                    Text(
                        text = stringResource(id = R.string.recognize_yourself),
                        color = sc_theme_yellow_tint,
                        fontSize = 20.sp,
                        fontFamily = HammerSmithFamily,
                        modifier = modifier
                            .offset(y = (-10).dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun HeadIconAnim(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(105.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.head),
            modifier = modifier.fillMaxSize(),
            contentDescription = null
        )
        AnimateQuestionSign(modifier)
    }
}

@Composable
fun AnimateQuestionSign(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int = R.drawable.ic_question_sign,
    labelAnim: String = "rotateImage",
) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1500
            },
            repeatMode = RepeatMode.Restart,

            ), label = labelAnim
    )

    Image(
        painter = painterResource(id = drawableRes),
        contentDescription = null,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
            .height(90.dp)
            .graphicsLayer(rotationY = rotate),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun IconCircle(
    @DrawableRes iconRes: Int,
    onClickIcon: () -> Unit,
    modifier: Modifier,
    circleColor: Color = sc_theme_yellow_tint,
    description: String? = null,
) {
    Box(
        modifier = modifier
            .requiredSize(100.dp)
            .background(
                color = circleColor,
                shape = CircleShape
            )
            .clickable {
                onClickIcon.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = description,
            modifier = modifier
                .size(68.dp)
        )
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen({}, {}, {}, {})
}