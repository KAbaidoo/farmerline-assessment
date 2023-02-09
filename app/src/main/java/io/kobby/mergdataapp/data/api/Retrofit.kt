package io.kobby.mergdataapp.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun provideRetrofit(): Retrofit {

    val gson = GsonBuilder()
        .setLenient()
        .create();
   return Retrofit.Builder()
        .baseUrl(FormApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideCourseApi(retrofit: Retrofit): FormApi =
    retrofit

        .create(FormApi::class.java)