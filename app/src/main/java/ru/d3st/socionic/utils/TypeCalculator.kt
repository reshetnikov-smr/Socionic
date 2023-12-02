package ru.d3st.socionic.utils

import ru.d3st.socionic.models.SocionicAttribute
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class contains data for define type
 */
@Singleton
class TypeCalculator @Inject constructor() {

    fun calculateType(result: Map<Int, SocionicAttribute>): String{
        val counts = mutableMapOf<SocionicAttribute, Int>()
        result.forEach {
            val count: Int = counts[it.value] ?: 0
            counts[it.value] = count.plus(1)
        }

        return buildString {
            append(getAttribute(counts, SocionicAttribute.EXTRA, SocionicAttribute.INTRA))
            append(getAttribute(counts, SocionicAttribute.INTA, SocionicAttribute.SENSORIC))
            append(getAttribute(counts, SocionicAttribute.LOGIC, SocionicAttribute.ETHIC))
            append(getAttribute(counts, SocionicAttribute.RACIONAL, SocionicAttribute.IRRACIONAL))
        }
    }

    private fun getAttribute(
        counts: MutableMap<SocionicAttribute, Int>,
        first: SocionicAttribute,
        second: SocionicAttribute,
    ): String = if ((counts[first] ?: 0) > (counts[second] ?: 0)) first.letter else second.letter
}