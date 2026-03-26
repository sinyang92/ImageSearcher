package com.sinyang92.feature.searchimage.ui.resultscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinyang92.common.network.domain.ResourceHandler
import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.R
import com.sinyang92.feature.searchimage.domain.usecase.SearchImageUseCase
import com.sinyang92.feature.searchimage.ui.model.Image
import com.sinyang92.feature.searchimage.ui.model.ImagesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultScreenViewModel @Inject constructor(
    private val searchImageUseCase: SearchImageUseCase,
    private val resourceHandler: ResourceHandler,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val query: String = savedStateHandle["query"] ?: ""

    private val _imagesStateFlow = MutableStateFlow<ImagesUiState>(ImagesUiState.Loading)
    val imagesStateFlow: StateFlow<ImagesUiState> = _imagesStateFlow

    init {
        searchImage(query)
    }

    fun searchImage(query: String) {
        viewModelScope.launch {
            searchImageUseCase(query).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _imagesStateFlow.tryEmit(ImagesUiState.Loading)

                    is Resource.Success -> _imagesStateFlow.tryEmit(
                        ImagesUiState.Images(
                            images = resource.data.photos.photo.map { photo ->
                                Image(
                                    id = photo.id,
                                    imageUrl = resourceHandler.getString(
                                        R.string.search_image_result_screen_image_url,
                                        photo.farm,
                                        photo.server,
                                        photo.id,
                                        photo.secret
                                    )
                                )
                            }
                        )
                    )

                    is Resource.Error -> _imagesStateFlow.tryEmit(ImagesUiState.Error)
                }
            }
        }
    }
}