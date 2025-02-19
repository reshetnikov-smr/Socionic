package ru.d3st.socionic.data

import ru.d3st.socionic.R
import ru.d3st.socionic.models.presentation.CharacterDescription
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypeDescriptions @Inject constructor(){

    val characters = listOf(
        CharacterDescription(
            101,
            "",
            "Наполеон",
            "СЭЭ",
            "Сенсорно-этический экстраверт",
            R.drawable.napoleon,
            R.string.desc_nap
        ),
        CharacterDescription(
            102,
            "",
            "Жуков",
            "СЛЭ",
            "Сэнсорно-логический экстраверт",
            R.drawable.jukov,
           R.string.desc_juckov
        ),
        CharacterDescription(
            103,
            "",
            "Гексли",
            "ИЭЭ",
            "Интуитивно-этический экстраверт",
            R.drawable.geksli,
            R.string.desc_geksli
        ),
        CharacterDescription(
            104,
            "",
            "Дон Кихот",
            "ИЛЭ",
            "Интуитивно-логический экстраверт",
            R.drawable.don_kihot,
            R.string.desc_don
        ),
        CharacterDescription(
            105,
            "",
            "Есенин",
            "ИЭИ",
            "Интуитивно-этический интроверт",
            R.drawable.esenin,
            R.string.desc_esenin
        ),
        CharacterDescription(
            106,
            "",
            "Бальзак",
            "ИЛИ",
            "Интуитивно-логический интроверт",
            R.drawable.balzak,
            R.string.desc_balzak
        ),
        CharacterDescription(
            107,
            "",
            "Габен",
            "СЛИ",
            "Сенсорно-логический интроверт",
            R.drawable.gaben,
            R.string.desc_gaben
        ),
        CharacterDescription(
            108,
            "",
            "Дюма",
            "СЭИ",
            "Сенсорно-этический интроверт",
            R.drawable.duma,
            R.string.desc_duma
        ),
        CharacterDescription(
            109,
            "",
            "Гюго",
            "ЭСЭ",
            "Этико-сенсорный экстраверт",
            R.drawable.hugo,
            R.string.desc_gugo
        ),
        CharacterDescription(
            110,
            "",
            "Гамлет",
            "ЭИЭ",
            "Этико-интуитивный экстраверт",
            R.drawable.gamlet,
            R.string.desc_gamlet
        ),
        CharacterDescription(
            111,
            "",
            "Штирлиц",
            "ЛСЭ",
            "Логико-сенсорный экстраверт",
            R.drawable.shtirliz,
            R.string.desc_shtirlic
        ),
        CharacterDescription(
            112,
            "",
            "Джек Лондон",
            "ЛИЭ",
            "Логико-интуитивный экстраверт",
            R.drawable.london,
            R.string.desc_jack
        ),
        CharacterDescription(
            113,
            "",
            "Драйзер",
            "ЭСИ",
            "Этико-сенсорный интроверт",
            R.drawable.draizer,
            R.string.desc_draizer
        ),
        CharacterDescription(
            114,
            "",
            "Достоевский",
            "ЭИИ",
            "Этико-интуитивный интроверт",
            R.drawable.dostoevskiy,
            R.string.desc_dostoevski
        ),
        CharacterDescription(
            115,
            "",
            "Робеспьер",
            "ЛИИ",
            "Логико-интуитивный интроверт",
            R.drawable.robespiere,
            R.string.desc_rob
        ),
        CharacterDescription(
            116,
            "",
            "Максим Горький",
            "ЛСИ",
            "Логико-сенсорный интроверт",
            R.drawable.gorkiy,
            R.string.desc_max
        ),
    )
}