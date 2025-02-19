package ru.d3st.socionic.models.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CharacterDescription(
    val id: Int, // 109
    val letterId: String, //ENTJ
    val name: String, // Гюго
    val shortName: String, //ESI
    val longName: String, //Этико-Сенсорный интроверт
    @DrawableRes val portrait: Int,
    @StringRes val descriptions: Int,
)