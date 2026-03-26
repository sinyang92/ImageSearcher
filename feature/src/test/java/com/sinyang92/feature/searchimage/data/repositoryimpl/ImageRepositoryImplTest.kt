package com.sinyang92.feature.searchimage.data.repositoryimpl

import app.cash.turbine.test
import com.sinyang92.common.network.domain.NetworkResponseHandler
import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.searchimage.data.dto.SearchImageResponse
import com.sinyang92.feature.searchimage.data.service.ImageService
import com.sinyang92.feature.searchimage.getMockSearchImageResponse
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response

class ImageRepositoryImplTest {

    private val imageService: ImageService = mockk()
    private val networkResponseHandler: NetworkResponseHandler = mockk()
    private val repository = ImageRepositoryImpl(
        imageService = imageService,
        networkResponseHandler = networkResponseHandler
    )

    @Test
    fun `test searchImage`() = runTest {
        val serviceResponseSlot = slot<suspend () -> Response<SearchImageResponse>>()

        // Success
        coEvery { imageService.searchImage(any()) } returns Response.success(200,
            getMockSearchImageResponse()
        )

        every { networkResponseHandler.getResourceFromResponse(capture(serviceResponseSlot)) } returns flowOf(
            Resource.Success(getMockSearchImageResponse())
        )

        repository.searchImage("kittens").test {
            assertEquals(
                "0ec416669f",
                (awaitItem() as Resource.Success).data.photos.photo[0].secret
            )

            awaitComplete()
        }

        val result = serviceResponseSlot.captured.invoke()
        assertEquals(getMockSearchImageResponse(), result.body())

        // Error
        coEvery { imageService.searchImage(any()) } returns Response.error(
            500,
            "error".toResponseBody()
        )

        every { networkResponseHandler.getResourceFromResponse(capture(serviceResponseSlot)) } returns flowOf(
            Resource.Error("error message")
        )

        repository.searchImage("kittens").test {
            assertEquals(
                "error message",
                (awaitItem() as Resource.Error).message
            )

            awaitComplete()
        }

        val errorResult = serviceResponseSlot.captured.invoke()
        assertTrue(!errorResult.isSuccessful)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}