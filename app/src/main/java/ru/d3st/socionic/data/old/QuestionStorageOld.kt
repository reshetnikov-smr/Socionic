package ru.d3st.socionic.data.old

import ru.d3st.socionic.R
import ru.d3st.socionic.data.ResourceManager
import ru.d3st.socionic.models.presentation.Question
import ru.d3st.socionic.utils.BALZAK
import ru.d3st.socionic.utils.DON
import ru.d3st.socionic.utils.DOSTOEVSKIY
import ru.d3st.socionic.utils.DRAIZER
import ru.d3st.socionic.utils.DUMA
import ru.d3st.socionic.utils.ESENIN
import ru.d3st.socionic.utils.GABEN
import ru.d3st.socionic.utils.GAMLET
import ru.d3st.socionic.utils.GEKSLI
import ru.d3st.socionic.utils.GORKIY
import ru.d3st.socionic.utils.HUGO
import ru.d3st.socionic.utils.JUKOV
import ru.d3st.socionic.utils.LONDON
import ru.d3st.socionic.utils.NAPOLEON
import ru.d3st.socionic.utils.ROB
import ru.d3st.socionic.utils.SHTIRLITZ
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionStorageOld @Inject constructor(res: ResourceManager) {

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
    private val questionsAC =
        mutableListOf(
            Question(13, res.getString(R.string.q13), 14, 14),
            Question(14, res.getString(R.string.q14), 15, 15),
            Question(15, res.getString(R.string.q15), 16, 16),
            Question(16, res.getString(R.string.q16), 17, 17),
            Question(17, res.getString(R.string.q17), 18, 18),
            Question(18, res.getString(R.string.q18), 19, 19),
            Question(19, res.getString(R.string.q19), 21, 20),
            Question(20, res.getString(R.string.q20), 22, 21),
            Question(21, res.getString(R.string.q21), NAPOLEON, JUKOV),
            Question(22, res.getString(R.string.q22), JUKOV, NAPOLEON),
            Question(23, res.getString(R.string.q23), 25, 24),
            Question(24, res.getString(R.string.q24), 26, 25),
            Question(25, res.getString(R.string.q25), GEKSLI, DON),
            Question(26, res.getString(R.string.q26), DON, GEKSLI),
        )
    private val questionsAD =
        mutableListOf(
            Question(27, res.getString(R.string.q27), 28, 28),
            Question(28, res.getString(R.string.q28), 29, 29),
            Question(29, res.getString(R.string.q29), 30, 30),
            Question(30, res.getString(R.string.q30), 31, 31),
            Question(31, res.getString(R.string.q31), 32, 32),
            Question(32, res.getString(R.string.q32), 33, 33),
            Question(33, res.getString(R.string.q33), 35, 34),
            Question(34, res.getString(R.string.q34), 36, 35),
            Question(35, res.getString(R.string.q35), ESENIN, BALZAK),
            Question(36, res.getString(R.string.q36), BALZAK, ESENIN),
            Question(37, res.getString(R.string.q37), 39, 38),
            Question(38, res.getString(R.string.q38), 40, 39),
            Question(39, res.getString(R.string.q39), GABEN, DUMA),
            Question(40, res.getString(R.string.q40), DUMA, GABEN),
        )
    private val questionsBC =
        mutableListOf(
            Question(41, res.getString(R.string.q41), 42, 42),
            Question(42, res.getString(R.string.q42), 43, 43),
            Question(43, res.getString(R.string.q43), 44, 44),
            Question(44, res.getString(R.string.q44), 45, 45),
            Question(45, res.getString(R.string.q45), 46, 46),
            Question(46, res.getString(R.string.q46), 47, 47),

            Question(47, res.getString(R.string.q47), 49, 48),
            Question(48, res.getString(R.string.q48), 50, 49),
            Question(49, res.getString(R.string.q49), HUGO, GAMLET),
            Question(50, res.getString(R.string.q50), GAMLET, HUGO),
            Question(51, res.getString(R.string.q51), 53, 52),
            Question(52, res.getString(R.string.q52), 54, 53),
            Question(53, res.getString(R.string.q53), SHTIRLITZ, LONDON),
            Question(54, res.getString(R.string.q54), LONDON, SHTIRLITZ),
        )
    private val questionsBD =
        mutableListOf(
            Question(55, res.getString(R.string.q55), 56, 56),
            Question(56, res.getString(R.string.q56), 57, 57),
            Question(57, res.getString(R.string.q57), 58, 58),
            Question(58, res.getString(R.string.q58), 59, 59),
            Question(59, res.getString(R.string.q59), 60, 60),
            Question(60, res.getString(R.string.q60), 61, 61),

            Question(61, res.getString(R.string.q61), 63, 62),
            Question(62, res.getString(R.string.q62), 64, 63),
            Question(63, res.getString(R.string.q63), DRAIZER, DOSTOEVSKIY),
            Question(64, res.getString(R.string.q64), DOSTOEVSKIY, DRAIZER),
            Question(65, res.getString(R.string.q65), 67, 66),
            Question(66, res.getString(R.string.q66), 68, 67),
            Question(67, res.getString(R.string.q67), ROB, GORKIY),
            Question(68, res.getString(R.string.q68), GORKIY, ROB),
        )

    val mapDb: Map<Pair<BranchName, BranchName>, List<Question>> =
        mapOf(
            Pair(Pair(BranchName.A, BranchName.C), questionsAC),
            Pair(Pair(BranchName.A, BranchName.D), questionsAD),
            Pair(Pair(BranchName.B, BranchName.C), questionsBC),
            Pair(Pair(BranchName.B, BranchName.D), questionsBD),
        )
}

enum class BranchName {
    A, B, C, D
}