package ru.d3st.socionic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.d3st.socionic.R

val MontserratFamily = FontFamily(
    Font(
        R.font.montserrat_700,
        FontWeight.SemiBold,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
    Font(
        R.font.montserat_200,
        FontWeight.Light,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
    Font(
        R.font.montserrat_500,
        FontWeight.Normal,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
)
val HammerSmithFamily = FontFamily(
    Font(
        R.font.hammersmith_one,
        FontWeight.Medium,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
)

val SanSerifFamily = FontFamily(
    Font(
        DeviceFontFamilyName("sans-serif"),
        FontWeight.Medium,
    )
)

internal val defaultTypography = Typography()

val typography = Typography(
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold
    ),
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontFamily = HammerSmithFamily,
        fontWeight = FontWeight.SemiBold,
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Medium
    ),

    headlineSmall = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = SanSerifFamily,
        fontSize = 48.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium
    )
)


