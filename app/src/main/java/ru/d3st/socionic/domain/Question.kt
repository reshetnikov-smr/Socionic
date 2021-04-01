package ru.d3st.socionic.domain

data class Question(
        val number: Int,
        val text: String,
        val nextYes: Int,
        val nextNo: Int,
)
