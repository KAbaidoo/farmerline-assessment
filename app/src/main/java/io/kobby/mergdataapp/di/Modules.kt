package io.kobby.mergdataapp.di


import io.kobby.mergdataapp.data.FormRepository
import io.kobby.mergdataapp.data.api.provideCourseApi
import io.kobby.mergdataapp.data.api.provideRetrofit

import io.kobby.mergdataapp.ui.form.FormViewModel
import io.kobby.mergdataapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    factory { provideRetrofit() }
    single{ provideCourseApi(get()) }

    factory { FormRepository(get()) }

    viewModel { FormViewModel(get(), get()) }
    viewModel { HomeViewModel() }

}