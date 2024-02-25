package ru.d3st.socionic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.d3st.socionic.R

val socionicFontFamily = FontFamily(
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
val hammersmithFamily = FontFamily(
    Font(
        R.font.hammersmith_one,
        FontWeight.Medium,
        loadingStrategy = FontLoadingStrategy.OptionalLocal
    ),
    )

val typography = Typography(
    titleMedium = TextStyle(
        fontFamily = socionicFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.SemiBold
    ),
    headlineLarge = TextStyle(
        color = Color.White,
        fontFamily = hammersmithFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp,
    ),
    headlineMedium = TextStyle(
        color = sc_theme_yellow_tint,
        fontFamily = hammersmithFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)


