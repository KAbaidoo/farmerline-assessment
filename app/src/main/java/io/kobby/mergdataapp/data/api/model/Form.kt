package io.kobby.mergdataapp.data.api.model

data class Form(
    val number_of_questions: Int,
    val questions: List<Question>
)