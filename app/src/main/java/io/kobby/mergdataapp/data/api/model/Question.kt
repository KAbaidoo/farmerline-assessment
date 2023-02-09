package io.kobby.mergdataapp.data.api.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Question(
    @SerialName("defaultAnswer")
    val defaultAnswer: String,
    @SerialName("form_type")
    val form_type: String,
    @SerialName("id")
    val id: Int,
    @SerialName("question_number")
    val question_number: Int,
    @SerialName("radio_button_option")
    val radio_button_option: List<RadioButtonOption>,
    @SerialName("title")
    val title: String
)