package ru.d3st.socionic.questions

import android.app.Application
import android.content.res.Resources
import ru.d3st.socionic.R
import ru.d3st.socionic.domain.Question
import ru.d3st.socionic.domain.ResultCharacter
import javax.inject.Inject
import javax.inject.Singleton

enum class BranchName {
    A, B, C, D
}

const val LSI: Int = 116
const val LII: Int = 115
const val EII: Int = 114
const val ESI: Int = 113
const val LIE: Int = 112
const val LSE: Int = 111
const val EIE: Int = 110
const val ESE: Int = 109
const val SEI: Int = 108
const val SLI: Int = 107
const val ILI: Int = 106
const val IEI: Int = 105
const val ILE: Int = 104
const val IEE: Int = 103
const val SLE: Int = 102
const val SEE: Int = 101

@Singleton
class ResourcesHelper @Inject constructor(applicationContext: Application) {

    val res: Resources = applicationContext.resources
    val questions1 =
            mutableListOf(
                    Question(1, res.getString(R.string.q1), 2, 2),
                    Question(2, res.getString(R.string.q2), 3, 3),
                    Question(3, res.getString(R.string.q3), 4, 4),
                    Question(4, res.getString(R.string.q4), 5, 5),
                    Question(5, res.getString(R.string.q5), 6, 6),
                    Question(6, res.getString(R.string.q6), 7, 7),

                    )
    val questions2 =
            mutableListOf(
                    Question(7, res.getString(R.string.q7), 8, 8),
                    Question(8, res.getString(R.string.q8), 9, 9),
                    Question(9, res.getString(R.string.q9), 10, 10),
                    Question(10, res.getString(R.string.q10), 11, 11),
                    Question(11, res.getString(R.string.q11), 12, 12),
                    Question(12, res.getString(R.string.q12), 13, 13),
            )
    val questionsAC =
            mutableListOf(
                    Question(13, res.getString(R.string.q13), 14, 14),
                    Question(14, res.getString(R.string.q14), 15, 15),
                    Question(15, res.getString(R.string.q15), 16, 16),
                    Question(16, res.getString(R.string.q16), 17, 17),
                    Question(17, res.getString(R.string.q17), 18, 18),
                    Question(18, res.getString(R.string.q18), 19, 19),
                    Question(19, res.getString(R.string.q19), 21, 20),
                    Question(20, res.getString(R.string.q20), 22, 21),
                    Question(21, res.getString(R.string.q21), SEE, SLE),
                    Question(22, res.getString(R.string.q22), SLE, SEE),
                    Question(23, res.getString(R.string.q23), 25, 24),
                    Question(24, res.getString(R.string.q24), 26, 25),
                    Question(25, res.getString(R.string.q25), IEE, ILE),
                    Question(26, res.getString(R.string.q26), ILE, IEE),
            )
    val questionsAD =
            mutableListOf(
                    Question(27, res.getString(R.string.q27), 28, 28),
                    Question(28, res.getString(R.string.q28), 29, 29),
                    Question(29, res.getString(R.string.q29), 30, 30),
                    Question(30, res.getString(R.string.q30), 31, 31),
                    Question(31, res.getString(R.string.q31), 32, 32),
                    Question(32, res.getString(R.string.q32), 33, 33),
                    Question(33, res.getString(R.string.q33), 35, 34),
                    Question(34, res.getString(R.string.q34), 36, 35),
                    Question(35, res.getString(R.string.q35), IEI, ILI),
                    Question(36, res.getString(R.string.q36), ILI, IEI),
                    Question(37, res.getString(R.string.q37), 39, 38),
                    Question(38, res.getString(R.string.q38), 40, 39),
                    Question(39, res.getString(R.string.q39), SLI, SEI),
                    Question(40, res.getString(R.string.q40), SEI, SLI),
            )
    val questionsBC =
            mutableListOf(
                    Question(41, res.getString(R.string.q41), 42, 42),
                    Question(42, res.getString(R.string.q42), 43, 43),
                    Question(43, res.getString(R.string.q43), 44, 44),
                    Question(44, res.getString(R.string.q44), 45, 45),
                    Question(45, res.getString(R.string.q45), 46, 46),
                    Question(46, res.getString(R.string.q46), 47, 47),

                    Question(47, res.getString(R.string.q47), 49, 48),
                    Question(48, res.getString(R.string.q48), 50, 49),
                    Question(49, res.getString(R.string.q49), ESE, EIE),
                    Question(50, res.getString(R.string.q50), EIE, ESE),
                    Question(51, res.getString(R.string.q51), 53, 52),
                    Question(52, res.getString(R.string.q52), 54, 53),
                    Question(53, res.getString(R.string.q53), LSE, LIE),
                    Question(54, res.getString(R.string.q54), LIE, LSE),
            )
    val questionsBD =
            mutableListOf(
                    Question(55, res.getString(R.string.q55), 56, 56),
                    Question(56, res.getString(R.string.q56), 57, 57),
                    Question(57, res.getString(R.string.q57), 58, 58),
                    Question(58, res.getString(R.string.q58), 59, 59),
                    Question(59, res.getString(R.string.q59), 60, 60),
                    Question(60, res.getString(R.string.q60), 61, 61),

                    Question(61, res.getString(R.string.q61), 63, 62),
                    Question(62, res.getString(R.string.q62), 64, 63),
                    Question(63, res.getString(R.string.q63), ESI, EII),
                    Question(64, res.getString(R.string.q64), EII, ESI),
                    Question(65, res.getString(R.string.q65), 67, 66),
                    Question(66, res.getString(R.string.q66), 68, 67),
                    Question(67, res.getString(R.string.q67), LII, LSI),
                    Question(68, res.getString(R.string.q68), LSI, LII),
            )

    val mapDb: Map<Pair<BranchName, BranchName>, List<Question>> =
            mapOf(
                    Pair(Pair(BranchName.A, BranchName.C), questionsAC),
                    Pair(Pair(BranchName.A, BranchName.D), questionsAD),
                    Pair(Pair(BranchName.B, BranchName.C), questionsBC),
                    Pair(Pair(BranchName.B, BranchName.D), questionsBD),
            )

    companion object

        val characters = listOf(
            ResultCharacter(
                    101,
                    "Наполеон",
                    "СЭЭ",
                    "Сенсорно-этический экстраверт",
                    R.drawable.napoleon,
                    res.getString(R.string.desc_nap)
            ),
            ResultCharacter(
                    102,
                    "Жуков",
                    "СЛЭ",
                    "Сэнсорно-логический экстраверт",
                    R.drawable.juckov,
                    res.getString(R.string.desc_juckov)
            ),
            ResultCharacter(
                    103,
                    "Гексли",
                    "ИЭЭ",
                    "Интуитивно-этический экстраверт",
                    R.drawable.geksli,
                    res.getString(R.string.desc_geksli)
            ),
            ResultCharacter(
                    104,
                    "Дон Кихот",
                    "ИЛЭ",
                    "Интуитивно-логический экстраверт",
                    R.drawable.don2,
                    res.getString(R.string.desc_don)
            ),
            ResultCharacter(
                    105,
                    "Есенин",
                    "ИЭИ",
                    "Интуитивно-этический интроверт",
                    R.drawable.esenin,
                    res.getString(R.string.desc_esenin)
            ),
            ResultCharacter(
                    106,
                    "Бальзак",
                    "ИЛИ",
                    "Интуитивно-логический интроверт",
                    R.drawable.balzak,
                    res.getString(R.string.desc_balzak)
            ),
            ResultCharacter(
                    107,
                    "Есенин",
                    "СЛИ",
                    "Сенсорно-логический интроверт",
                    R.drawable.gaben,
                    res.getString(R.string.desc_gaben)
            ),
            ResultCharacter(
                    108,
                    "Дюма",
                    "СЭИ",
                    "Сенсорно-этический интроверт",
                    R.drawable.duma,
                    res.getString(R.string.desc_duma)
            ),
            ResultCharacter(
                    109,
                    "Гюго",
                    "ЭСЭ",
                    "Этико-сенсорный экстраверт",
                    R.drawable.gugo,
                    res.getString(R.string.desc_gugo)
            ),
            ResultCharacter(
                    110,
                    "Гамлет",
                    "ЭИЭ",
                    "Этико-интуитивный экстраверт",
                    R.drawable.gamlet,
                    res.getString(R.string.desc_gamlet)
            ),
            ResultCharacter(
                    111,
                    "Штирлиц",
                    "ЛСЭ",
                    "Логико-сенсорный экстраверт",
                    R.drawable.shtirlic,
                    res.getString(R.string.desc_shtirlic)
            ),
            ResultCharacter(
                    112,
                    "Джек Лондон",
                    "ЛИЭ",
                    "Логико-интуитивный экстраверт",
                    R.drawable.jack,
                    res.getString(R.string.desc_jack)
            ),
            ResultCharacter(
                    113,
                    "Драйзер",
                    "ЭСИ",
                    "Этико-сенсорный интроверт",
                    R.drawable.draizer,
                    res.getString(R.string.desc_draizer)
            ),
            ResultCharacter(
                    114,
                    "Достоевский",
                    "ЭИИ",
                    "Этико-интуитивный интроверт",
                    R.drawable.dosoevski,
                    res.getString(R.string.desc_dostoevski)
            ),
            ResultCharacter(
                    115,
                    "Робеспьер",
                    "ЛИИ",
                    "Логико-интуитивный интроверт",
                    R.drawable.rob,
                    res.getString(R.string.desc_rob)
            ),
            ResultCharacter(
                    116,
                    "Максим Горький",
                    "ЛСИ",
                    "Логико-сенсорный интроверт",
                    R.drawable.max2,
                    res.getString(R.string.desc_max)
            ),


    )
}

