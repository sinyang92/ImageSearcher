package com.sinyang92.feature.searchimage.ui.searchscreen

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun SearchImageScreenRoute(
    onSearchClicked: (String) -> Unit
) {
    SearchImageScreen(
        onSearchClicked = onSearchClicked
    )
}