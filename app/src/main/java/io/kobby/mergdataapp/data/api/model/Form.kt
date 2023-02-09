package io.kobby.mergdataapp.data.api.model

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class Form(
    @SerialName("number_of_questions")
    val number_of_questions: Int,
    @SerialName("questions")
    val questions: List<Question>?=null
)