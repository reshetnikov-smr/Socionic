package ru.d3st.socionic.data

import ru.d3st.socionic.R
import ru.d3st.socionic.models.data.SocionicAttribute
import ru.d3st.socionic.models.presentation.QuestionForm
import ru.d3st.socionic.presenatation.questions.QuestionStorage
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Questions for full test version 3
 */
@Singleton
class FullTestStorage @Inject constructor() : QuestionStorage {

    override val questions: HashMap<Int, QuestionForm> = hashMapOf(
        1 to QuestionForm(R.string.f1, SocionicAttribute.RACIONAL),
        2 to QuestionForm(R.string.f2, SocionicAttribute.IRRACIONAL),
        3 to QuestionForm(R.string.f3, SocionicAttribute.RACIONAL),
        4 to QuestionForm(R.string.f4, SocionicAttribute.IRRACIONAL),
        5 to QuestionForm(R.string.f5, SocionicAttribute.RACIONAL),
        6 to QuestionForm(R.string.f6, SocionicAttribute.IRRACIONAL),
        7 to QuestionForm(R.string.f7, SocionicAttribute.RACIONAL),
        8 to QuestionForm(R.string.f8, SocionicAttribute.IRRACIONAL),
        9 to QuestionForm(R.string.f9, SocionicAttribute.RACIONAL),
        10 to QuestionForm(R.string.f10, SocionicAttribute.IRRACIONAL),
        11 to QuestionForm(R.string.f11, SocionicAttribute.RACIONAL),
        12 to QuestionForm(R.string.f12, SocionicAttribute.IRRACIONAL),
        13 to QuestionForm(R.string.f13, SocionicAttribute.RACIONAL),
        14 to QuestionForm(R.string.f14, SocionicAttribute.IRRACIONAL),
        15 to QuestionForm(R.string.f15, SocionicAttribute.RACIONAL),
        16 to QuestionForm(R.string.f16, SocionicAttribute.IRRACIONAL),
        17 to QuestionForm(R.string.f17, SocionicAttribute.RACIONAL),
        18 to QuestionForm(R.string.f18, SocionicAttribute.IRRACIONAL),
        19 to QuestionForm(R.string.f19, SocionicAttribute.RACIONAL),
        20 to QuestionForm(R.string.f20, SocionicAttribute.IRRACIONAL),
        21 to QuestionForm(R.string.f21, SocionicAttribute.RACIONAL),
        22 to QuestionForm(R.string.f22, SocionicAttribute.IRRACIONAL),
        23 to QuestionForm(R.string.f23, SocionicAttribute.RACIONAL),
        24 to QuestionForm(R.string.f24, SocionicAttribute.IRRACIONAL),
        25 to QuestionForm(R.string.f25, SocionicAttribute.RACIONAL),
        26 to QuestionForm(R.string.f26, SocionicAttribute.IRRACIONAL),
        27 to QuestionForm(R.string.f27, SocionicAttribute.RACIONAL),
        28 to QuestionForm(R.string.f28, SocionicAttribute.IRRACIONAL),
        29 to QuestionForm(R.string.f29, SocionicAttribute.RACIONAL),
        30 to QuestionForm(R.string.f30, SocionicAttribute.IRRACIONAL),
        31 to QuestionForm(R.string.f31, SocionicAttribute.RACIONAL),
        32 to QuestionForm(R.string.f32, SocionicAttribute.IRRACIONAL),
        33 to QuestionForm(R.string.f33, SocionicAttribute.RACIONAL),
        34 to QuestionForm(R.string.f34, SocionicAttribute.IRRACIONAL),
        35 to QuestionForm(R.string.f35, SocionicAttribute.RACIONAL),
        36 to QuestionForm(R.string.f36, SocionicAttribute.IRRACIONAL),

        37 to QuestionForm(R.string.f37, SocionicAttribute.EXTRA),
        38 to QuestionForm(R.string.f38, SocionicAttribute.INTRA),
        39 to QuestionForm(R.string.f39, SocionicAttribute.EXTRA),
        40 to QuestionForm(R.string.f40, SocionicAttribute.INTRA),
        41 to QuestionForm(R.string.f41, SocionicAttribute.EXTRA),
        42 to QuestionForm(R.string.f42, SocionicAttribute.INTRA),
        43 to QuestionForm(R.string.f43, SocionicAttribute.EXTRA),
        44 to QuestionForm(R.string.f44, SocionicAttribute.INTRA),
        45 to QuestionForm(R.string.f45, SocionicAttribute.EXTRA),
        46 to QuestionForm(R.string.f46, SocionicAttribute.INTRA),
        47 to QuestionForm(R.string.f47, SocionicAttribute.EXTRA),
        48 to QuestionForm(R.string.f48, SocionicAttribute.INTRA),
        49 to QuestionForm(R.string.f49, SocionicAttribute.EXTRA),
        50 to QuestionForm(R.string.f50, SocionicAttribute.INTRA),
        51 to QuestionForm(R.string.f51, SocionicAttribute.EXTRA),
        52 to QuestionForm(R.string.f52, SocionicAttribute.INTRA),
        53 to QuestionForm(R.string.f53, SocionicAttribute.EXTRA),
        54 to QuestionForm(R.string.f54, SocionicAttribute.INTRA),
        55 to QuestionForm(R.string.f55, SocionicAttribute.EXTRA),
        56 to QuestionForm(R.string.f56, SocionicAttribute.INTRA),
        57 to QuestionForm(R.string.f57, SocionicAttribute.EXTRA),
        58 to QuestionForm(R.string.f58, SocionicAttribute.INTRA),
        59 to QuestionForm(R.string.f59, SocionicAttribute.EXTRA),
        60 to QuestionForm(R.string.f60, SocionicAttribute.INTRA),
        61 to QuestionForm(R.string.f61, SocionicAttribute.EXTRA),
        62 to QuestionForm(R.string.f62, SocionicAttribute.INTRA),
        63 to QuestionForm(R.string.f63, SocionicAttribute.EXTRA),
        64 to QuestionForm(R.string.f64, SocionicAttribute.INTRA),
        65 to QuestionForm(R.string.f65, SocionicAttribute.EXTRA),
        66 to QuestionForm(R.string.f66, SocionicAttribute.INTRA),
        67 to QuestionForm(R.string.f67, SocionicAttribute.EXTRA),
        68 to QuestionForm(R.string.f68, SocionicAttribute.INTRA),
        69 to QuestionForm(R.string.f69, SocionicAttribute.EXTRA),
        70 to QuestionForm(R.string.f70, SocionicAttribute.INTRA),
        71 to QuestionForm(R.string.f71, SocionicAttribute.EXTRA),
        72 to QuestionForm(R.string.f72, SocionicAttribute.INTRA),

        73 to QuestionForm(R.string.f73, SocionicAttribute.SENSORIC),
        74 to QuestionForm(R.string.f74, SocionicAttribute.INTA),
        75 to QuestionForm(R.string.f75, SocionicAttribute.SENSORIC),
        76 to QuestionForm(R.string.f76, SocionicAttribute.INTA),
        77 to QuestionForm(R.string.f77, SocionicAttribute.SENSORIC),
        78 to QuestionForm(R.string.f78, SocionicAttribute.INTA),
        79 to QuestionForm(R.string.f79, SocionicAttribute.SENSORIC),
        80 to QuestionForm(R.string.f80, SocionicAttribute.INTA),
        81 to QuestionForm(R.string.f81, SocionicAttribute.SENSORIC),
        82 to QuestionForm(R.string.f82, SocionicAttribute.INTA),
        83 to QuestionForm(R.string.f83, SocionicAttribute.SENSORIC),
        84 to QuestionForm(R.string.f84, SocionicAttribute.INTA),
        85 to QuestionForm(R.string.f85, SocionicAttribute.SENSORIC),
        86 to QuestionForm(R.string.f86, SocionicAttribute.INTA),
        87 to QuestionForm(R.string.f87, SocionicAttribute.SENSORIC),
        88 to QuestionForm(R.string.f88, SocionicAttribute.INTA),
        89 to QuestionForm(R.string.f89, SocionicAttribute.SENSORIC),
        90 to QuestionForm(R.string.f90, SocionicAttribute.INTA),
        91 to QuestionForm(R.string.f91, SocionicAttribute.SENSORIC),
        92 to QuestionForm(R.string.f92, SocionicAttribute.INTA),
        93 to QuestionForm(R.string.f93, SocionicAttribute.SENSORIC),
        94 to QuestionForm(R.string.f94, SocionicAttribute.INTA),
        95 to QuestionForm(R.string.f95, SocionicAttribute.SENSORIC),
        96 to QuestionForm(R.string.f96, SocionicAttribute.INTA),
        97 to QuestionForm(R.string.f97, SocionicAttribute.SENSORIC),
        98 to QuestionForm(R.string.f98, SocionicAttribute.INTA),
        99 to QuestionForm(R.string.f99, SocionicAttribute.SENSORIC),
        100 to QuestionForm(R.string.f100, SocionicAttribute.INTA),
        101 to QuestionForm(R.string.f101, SocionicAttribute.SENSORIC),
        102 to QuestionForm(R.string.f102, SocionicAttribute.INTA),
        103 to QuestionForm(R.string.f103, SocionicAttribute.SENSORIC),
        104 to QuestionForm(R.string.f104, SocionicAttribute.INTA),
        105 to QuestionForm(R.string.f105, SocionicAttribute.SENSORIC),
        106 to QuestionForm(R.string.f106, SocionicAttribute.INTA),
        107 to QuestionForm(R.string.f107, SocionicAttribute.SENSORIC),
        108 to QuestionForm(R.string.f108, SocionicAttribute.INTA),

        109 to QuestionForm(R.string.f109, SocionicAttribute.LOGIC),
        110 to QuestionForm(R.string.f110, SocionicAttribute.ETHIC),
        111 to QuestionForm(R.string.f111, SocionicAttribute.LOGIC),
        112 to QuestionForm(R.string.f112, SocionicAttribute.ETHIC),
        113 to QuestionForm(R.string.f113, SocionicAttribute.LOGIC),
        114 to QuestionForm(R.string.f114, SocionicAttribute.ETHIC),
        115 to QuestionForm(R.string.f115, SocionicAttribute.LOGIC),
        116 to QuestionForm(R.string.f116, SocionicAttribute.ETHIC),
        117 to QuestionForm(R.string.f117, SocionicAttribute.LOGIC),
        118 to QuestionForm(R.string.f118, SocionicAttribute.ETHIC),
        119 to QuestionForm(R.string.f119, SocionicAttribute.LOGIC),
        120 to QuestionForm(R.string.f120, SocionicAttribute.ETHIC),
        121 to QuestionForm(R.string.f121, SocionicAttribute.LOGIC),
        122 to QuestionForm(R.string.f122, SocionicAttribute.ETHIC),
        123 to QuestionForm(R.string.f123, SocionicAttribute.LOGIC),
        124 to QuestionForm(R.string.f124, SocionicAttribute.ETHIC),
        125 to QuestionForm(R.string.f125, SocionicAttribute.LOGIC),
        126 to QuestionForm(R.string.f126, SocionicAttribute.ETHIC),
        127 to QuestionForm(R.string.f127, SocionicAttribute.LOGIC),
        128 to QuestionForm(R.string.f128, SocionicAttribute.ETHIC),
        129 to QuestionForm(R.string.f129, SocionicAttribute.LOGIC),
        130 to QuestionForm(R.string.f130, SocionicAttribute.ETHIC),
        131 to QuestionForm(R.string.f131, SocionicAttribute.LOGIC),
        132 to QuestionForm(R.string.f132, SocionicAttribute.ETHIC),
        133 to QuestionForm(R.string.f133, SocionicAttribute.LOGIC),
        134 to QuestionForm(R.string.f134, SocionicAttribute.ETHIC),
        135 to QuestionForm(R.string.f135, SocionicAttribute.LOGIC),
        136 to QuestionForm(R.string.f136, SocionicAttribute.ETHIC),
        137 to QuestionForm(R.string.f137, SocionicAttribute.LOGIC),
        138 to QuestionForm(R.string.f138, SocionicAttribute.ETHIC),
        139 to QuestionForm(R.string.f139, SocionicAttribute.LOGIC),
        140 to QuestionForm(R.string.f140, SocionicAttribute.ETHIC),
        141 to QuestionForm(R.string.f141, SocionicAttribute.LOGIC),
        142 to QuestionForm(R.string.f142, SocionicAttribute.ETHIC),
        143 to QuestionForm(R.string.f143, SocionicAttribute.LOGIC),
        144 to QuestionForm(R.string.f144, SocionicAttribute.ETHIC),
    )
}