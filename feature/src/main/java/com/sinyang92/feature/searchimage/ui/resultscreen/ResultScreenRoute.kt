package com.sinyang92.feature.searchimage.ui.resultscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinyang92.design.component.LoadingDialog
import com.sinyang92.feature.searchimage.ui.model.ImagesUiState

@Composable
fun ResultScreenRoute(
    navigateUp: () -> Unit,
    viewModel: ResultScreenViewModel = hiltViewModel()
) {
    val imagesStateFlow by viewModel.imagesStateFlow.collectAsStateWithLifecycle()

    when (imagesStateFlow) {
        is ImagesUiState.Loading -> LoadingDialog()

        is ImagesUiState.Error -> ErrorScreen(
            onButtonClicked = navigateUp
        )

        is ImagesUiState.Images -> ImagesDisplayScreen(
            images = (imagesStateFlow as ImagesUiState.Images).images
        )
    }
}