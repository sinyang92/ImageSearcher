package com.sinyang92.common.network.data.impl

import app.cash.turbine.test
import com.sinyang92.common.network.domain.model.Resource
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response

class NetworkResponseHandlerImplTest {

    private val networkResponseHandlerImpl = NetworkResponseHandlerImpl()

    @Test
    fun `test getResourceFromResponse with successful response`() =
        runTest {
            val mockApiCall = suspend {
                Response.success("Success Data")
            }

            networkResponseHandlerImpl.getResourceFromResponse(mockApiCall).test {
                assertTrue(awaitItem() is Resource.Loading)
                assertTrue(awaitItem() is Resource.Success)
                awaitComplete()
            }
        }

    @Test
    fun `test getResourceFromResponse with error response`() =
        runTest {
            val mockApiCall = suspend {
                Response.error<String>(404, "error body".toResponseBody())
            }

            networkResponseHandlerImpl.getResourceFromResponse(mockApiCall).test {
                assertTrue(awaitItem() is Resource.Loading)
                assertTrue(awaitItem() is Resource.Error)
                awaitComplete()
            }
        }
}