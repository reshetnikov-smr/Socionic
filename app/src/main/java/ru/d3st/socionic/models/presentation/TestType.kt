package ru.d3st.socionic.models.presentation

enum class TestType(val value: Int) {
    SHORT(1), FULL(2);

    companion object {
        fun findType(value: Int) = entries.first { it.value == value }
    }
}