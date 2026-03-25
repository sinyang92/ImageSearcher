package com.sinyang92.common.network.domain

import com.sinyang92.common.network.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NetworkResponseHandler {

    fun <T> getResourceFromResponse(
        apiCall: suspend () -> Response<T>
    ): Flow<Resource<T>>
}