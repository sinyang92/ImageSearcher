package com.sinyang92.feature.searchimage.ui.resultscreen

import androidx.lifecycle.SavedStateHandle
import com.sinyang92.common.network.domain.ResourceHandler
import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.searchimage.domain.usecase.SearchImageUseCase
import com.sinyang92.feature.searchimage.getMockSearchImageResponse
import com.sinyang92.feature.searchimage.ui.model.ImagesUiState
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ResultScreenViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private val searchImageUseCase: SearchImageUseCase = mockk()
    private val resourceHandler: ResourceHandler = mockk()
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()

    private lateinit var viewModel: ResultScreenViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        every { resourceHandler.getString(any(), any(), any(), any(), any()) } returns "some string"
    }

    @Test
    fun `test searchImage when view model is created`() = runTest {
        // Success
        every { searchImageUseCase(any()) } returns flowOf(
            Resource.Success(getMockSearchImageResponse())
        )

        initViewModel()
        advanceUntilIdle()

        assertEquals(true, viewModel.imagesStateFlow.value is ImagesUiState.Images)

        // Error
        every { searchImageUseCase(any()) } returns flowOf(
            Resource.Error("some errors")
        )

        initViewModel()
        advanceUntilIdle()

        assertEquals(true, viewModel.imagesStateFlow.value is ImagesUiState.Error)
    }

    private fun initViewModel() {
        viewModel = ResultScreenViewModel(
            searchImageUseCase = searchImageUseCase,
            resourceHandler = resourceHandler,
            savedStateHandle = savedStateHandle.apply {
                set("query", "kittens")
            }
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}