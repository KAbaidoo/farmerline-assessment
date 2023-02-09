package io.kobby.mergdataapp.data.api


import io.kobby.mergdataapp.data.api.model.Form
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface FormApi {
    @GET("assessment/{endpoint}")
     suspend fun getForm(@Path("endpoint") endpoint:String):Response<Form>

    companion object {
        const val BASE_URL= "https://app-testing.mergdata.net/"
    }
}