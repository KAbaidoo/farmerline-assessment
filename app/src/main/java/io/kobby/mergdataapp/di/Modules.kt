package io.kobby.mergdataapp.di

import io.kobby.mergdataapp.data.FormRepository
import io.kobby.mergdataapp.data.api.FormApi
import io.kobby.mergdataapp.data.api.KtorHttpClient
import org.koin.dsl.module

val appModule = module {
    single { KtorHttpClient().getHttpClient() }

    factory { FormApi(get()) }
    factory { FormRepository(get()) }

}