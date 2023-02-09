package io.kobby.mergdataapp.data.api

import io.kobby.mergdataapp.data.api.model.Form
import io.ktor.client.*
import io.ktor.client.request.*

class FormApi (private val client : HttpClient){

    suspend fun getForm(endpoint : String): Form = client.get("$BASE_URL$endpoint")

    companion object {
        private const val BASE_URL= "https://app-testing.mergdata.net/assessment"
    }
}