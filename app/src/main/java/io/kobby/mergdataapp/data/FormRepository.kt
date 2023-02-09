package io.kobby.mergdataapp.data

import io.kobby.mergdataapp.data.api.FormApi
import io.kobby.mergdataapp.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class FormRepository(val api: FormApi) {

    suspend fun getForm(endpoint: String) = flow {
        emit(DataState.Loading())
        try {
            emit(DataState.Success(api.getForm(endpoint)))
        } catch (throwable: Throwable) {
            emit(DataState.Exception(throwable, null))
        }
    }.flowOn(Dispatchers.IO)

}