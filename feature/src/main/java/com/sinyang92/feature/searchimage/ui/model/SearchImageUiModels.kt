package com.sinyang92.feature.searchimage.ui.model

sealed class ImagesUiState {

    data class Images(
        val images: List<Image>
    ) : ImagesUiState()

    data object Loading : ImagesUiState()

    data object Error : ImagesUiState()
}

data class Image(
    val id: String,
    val imageUrl: String
)