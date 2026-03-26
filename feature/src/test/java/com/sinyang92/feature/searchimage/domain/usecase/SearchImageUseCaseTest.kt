package com.sinyang92.feature.searchimage.domain.usecase

import app.cash.turbine.test
import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.searchimage.domain.repository.ImageRepository
import com.sinyang92.feature.searchimage.getMockSearchImageResponse
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SearchImageUseCaseTest {

    private val imageRepository: ImageRepository = mockk()
    private val useCase = SearchImageUseCase(
        imageRepository = imageRepository
    )

    @Test
    fun `test use case`() = runTest {
        // Success
        every { imageRepository.searchImage(any()) } returns flowOf(
            Resource.Success(getMockSearchImageResponse())
        )

        useCase("kittens").test {
            awaitItem().apply {
                assertTrue(this is Resource.Success)
                assertEquals(1, (this as Resource.Success).data.photos.photo.size)
            }

            awaitComplete()
        }

        // Error
        every { imageRepository.searchImage(any()) } returns flowOf(
            Resource.Error("Some errors")
        )

        useCase("kittens").test {
            awaitItem().apply {
                assertTrue(this is Resource.Error)
                assertEquals("Some errors", (this as Resource.Error).message)
            }

            awaitComplete()
        }
    }
}