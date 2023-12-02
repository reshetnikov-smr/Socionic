package ru.d3st.socionic.data

import ru.d3st.socionic.R
import ru.d3st.socionic.models.GulenkoQuestion
import ru.d3st.socionic.models.SocionicAttribute
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Test by Gulenko
 */
@Singleton
class GulenkoQuestions @Inject constructor() {

    val questions = mapOf(
        1 to GulenkoQuestion(R.string.g1, SocionicAttribute.EXTRA),
        2 to GulenkoQuestion(R.string.g2, SocionicAttribute.INTRA),
        3 to GulenkoQuestion(R.string.g3, SocionicAttribute.EXTRA),
        4 to GulenkoQuestion(R.string.g4, SocionicAttribute.INTRA),
        5 to GulenkoQuestion(R.string.g5, SocionicAttribute.EXTRA),
        6 to GulenkoQuestion(R.string.g6, SocionicAttribute.INTRA),
        7 to GulenkoQuestion(R.string.g7, SocionicAttribute.EXTRA),
        8 to GulenkoQuestion(R.string.g8, SocionicAttribute.INTRA),
        9 to GulenkoQuestion(R.string.g9, SocionicAttribute.EXTRA),
        10 to GulenkoQuestion(R.string.g10, SocionicAttribute.INTRA),
        11 to GulenkoQuestion(R.string.g11, SocionicAttribute.EXTRA),
        12 to GulenkoQuestion(R.string.g12, SocionicAttribute.INTRA),

        13 to GulenkoQuestion(R.string.g13, SocionicAttribute.RACIONAL),
        14 to GulenkoQuestion(R.string.g14, SocionicAttribute.IRRACIONAL),
        15 to GulenkoQuestion(R.string.g15, SocionicAttribute.RACIONAL),
        16 to GulenkoQuestion(R.string.g16, SocionicAttribute.IRRACIONAL),
        17 to GulenkoQuestion(R.string.g17, SocionicAttribute.RACIONAL),
        18 to GulenkoQuestion(R.string.g18, SocionicAttribute.IRRACIONAL),
        19 to GulenkoQuestion(R.string.g19, SocionicAttribute.RACIONAL),
        20 to GulenkoQuestion(R.string.g20, SocionicAttribute.IRRACIONAL),
        21 to GulenkoQuestion(R.string.g21, SocionicAttribute.RACIONAL),
        22 to GulenkoQuestion(R.string.g22, SocionicAttribute.IRRACIONAL),
        23 to GulenkoQuestion(R.string.g23, SocionicAttribute.RACIONAL),
        24 to GulenkoQuestion(R.string.g24, SocionicAttribute.IRRACIONAL),

        25 to GulenkoQuestion(R.string.g25, SocionicAttribute.SENSORIC),
        26 to GulenkoQuestion(R.string.g26, SocionicAttribute.INTA),
        27 to GulenkoQuestion(R.string.g27, SocionicAttribute.SENSORIC),
        28 to GulenkoQuestion(R.string.g28, SocionicAttribute.INTA),
        29 to GulenkoQuestion(R.string.g29, SocionicAttribute.SENSORIC),
        30 to GulenkoQuestion(R.string.g30, SocionicAttribute.INTA),
        31 to GulenkoQuestion(R.string.g31, SocionicAttribute.SENSORIC),
        32 to GulenkoQuestion(R.string.g32, SocionicAttribute.INTA),
        33 to GulenkoQuestion(R.string.g33, SocionicAttribute.SENSORIC),
        34 to GulenkoQuestion(R.string.g34, SocionicAttribute.INTA),
        35 to GulenkoQuestion(R.string.g35, SocionicAttribute.SENSORIC),
        36 to GulenkoQuestion(R.string.g36, SocionicAttribute.INTA),

        37 to GulenkoQuestion(R.string.g37, SocionicAttribute.LOGIC),
        38 to GulenkoQuestion(R.string.g38, SocionicAttribute.ETHIC),
        39 to GulenkoQuestion(R.string.g39, SocionicAttribute.LOGIC),
        40 to GulenkoQuestion(R.string.g40, SocionicAttribute.ETHIC),
        41 to GulenkoQuestion(R.string.g41, SocionicAttribute.LOGIC),
        42 to GulenkoQuestion(R.string.g42, SocionicAttribute.ETHIC),
        43 to GulenkoQuestion(R.string.g43, SocionicAttribute.LOGIC),
        44 to GulenkoQuestion(R.string.g44, SocionicAttribute.ETHIC),
        45 to GulenkoQuestion(R.string.g45, SocionicAttribute.LOGIC),
        46 to GulenkoQuestion(R.string.g46, SocionicAttribute.ETHIC),
        47 to GulenkoQuestion(R.string.g47, SocionicAttribute.LOGIC),
        48 to GulenkoQuestion(R.string.g48, SocionicAttribute.ETHIC),
    )
}