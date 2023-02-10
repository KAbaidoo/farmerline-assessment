package io.kobby.mergdataapp.data


import io.kobby.mergdataapp.data.api.FormApi
import io.kobby.mergdataapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class FormRepository(private val api: FormApi) {

    suspend fun getForm(endpoint: String) = flow {
        emit(Resource.Loading)
        try {
            val response = api.getForm(endpoint)

            if (!response.isSuccessful) {
                val errorMsg = response.errorBody()?.string()
                response.errorBody()?.close()
                errorMsg?.let {
                    emit(Resource.Failure<String>(it))
                }

            } else {

                emit(Resource.Success(response.body()))
            }

        } catch (throwable: Throwable) {
            emit(Resource.Exception(throwable,null))
        }
    }.flowOn(Dispatchers.IO)

}