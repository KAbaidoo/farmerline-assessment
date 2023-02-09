package io.kobby.mergdataapp.data.api.model

data class Question(
    val defaultAnswer: String,
    val form_type: String,
    val id: Int,
    val question_number: Int,
    val radio_button_option: List<RadioButtonOption>,
    val title: String
)