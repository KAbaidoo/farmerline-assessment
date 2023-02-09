package io.kobby.mergdataapp.data.api.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RadioButtonOption(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)