package com.sinyang92.common.network.data.impl

import com.sinyang92.common.network.domain.NetworkResponseHandler
import com.sinyang92.common.network.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class NetworkResponseHandlerImpl : NetworkResponseHandler {

    override fun <T> getResourceFromResponse(
        apiCall: suspend () -> Response<T>
    ): Flow<Resource<T>> =
        flow<Resource<T>> {
            emit(Resource.Loading(data = null))
            emit(
                apiCall.invoke().let { response ->
                    if (response.isSuccessful) {
                        when (val data = response.body()) {
                            null -> Resource.Error("No data available")

                            else -> Resource.Success(data)
                        }
                    } else {
                        Resource.Error(message = "Error Code: ${response.code()} Message: ${response.message()}")
                    }
                }
            )
        }.catch { error ->
            emit(Resource.Error(error.message ?: "Unknown Error"))
        }
}