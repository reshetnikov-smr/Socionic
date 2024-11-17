package ru.d3st.socionic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    Font(
        R.font.hammersmith_one,
        FontWeight.Light,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
)

val SanSerifFamily = FontFamily(
    Font(
        DeviceFontFamilyName("sans-serif"),
        FontWeight.Medium,
    )
)

val typography = Typography(
    titleMedium = TextStyle(
        fontFamily = MontserratFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.SemiBold
    ),
    headlineLarge = TextStyle(
        color = Color.White,
        fontFamily = HammerSmithFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp,
    ),
    headlineMedium = TextStyle(
        color = sc_theme_yellow_tint,
        fontFamily = HammerSmithFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = sc_theme_yellow_tint,
        textAlign = TextAlign.Center
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),
    bodyMedium = TextStyle(
        color = Color.White,
        fontSize = 18.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle(
        fontFamily = HammerSmithFamily,
        fontSize = 48.sp,
        color = Color.White,
        fontWeight = FontWeight.Light
    ),

    displayLarge = TextStyle(
        fontFamily = SanSerifFamily,
        fontSize = 48.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium
    )
)

val navTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = MontserratFamily,
        color = sc_theme_yellow_tint,
        fontSize = 18.sp
    )
)


