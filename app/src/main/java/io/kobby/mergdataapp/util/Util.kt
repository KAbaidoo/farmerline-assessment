package io.kobby.mergdataapp.util

sealed class DataState<T>(
    val data: T? = null,
    val error: Throwable? = null,
    val errorMsg: String? = null

) {
    class Success<T>(data: T) : DataState<T>(data)
    class Loading<T>(data: T? = null) : DataState<T>(data)
    class Failure<T>(data: T? = null, errorMsg: String) : DataState<T>(data)
    class Exception<T>(throwable: Throwable, data: T? = null) : DataState<T>(data, throwable)
}