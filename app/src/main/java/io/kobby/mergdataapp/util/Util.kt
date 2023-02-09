package io.kobby.mergdataapp.util

import io.kobby.mergdataapp.R



sealed class Resource<out R> {
    data class Success<out R>(val data: R): Resource<R>()
    data class Failure<out R>(val errorMsg: String): Resource<R>()
    object Loading: Resource<Nothing>()
    data class Exception<R>(val throwable: Throwable, val data: R? = null) : Resource<R>()
}


