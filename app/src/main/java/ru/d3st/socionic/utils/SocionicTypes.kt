package ru.d3st.socionic.utils

/**
 * All Socionic types
 */
enum class SocionicTypes(val id: String, val oldId: Int) {
    GORKIY("ISTJ", 116),
    ROB("INTJ", 115),
    DOSTOEVSKIY("INFJ", 114),
    DRAIZER("ISFJ", 113),
    LONDON("ENTJ", 112),
    SHTIRLITZ("ESTJ", 111),
    GAMLET("ENFJ", 110),
    HUGO("ESFJ", 109),
    DUMA("ISFP",108),
    GABEN("ISTP",107),
    BALZAK("INTP", 106),
    ESENIN("INFP",105),
    DON("ENTP", 104),
    GEKSLI("ENFP", 103),
    JUKOV("ESTP", 102),
    NAPOLEON("ESFP", 101);

    companion object {
        private val map = SocionicTypes.values().associateBy { it.id }
        infix fun from(value: String) = map[value]
    }
}