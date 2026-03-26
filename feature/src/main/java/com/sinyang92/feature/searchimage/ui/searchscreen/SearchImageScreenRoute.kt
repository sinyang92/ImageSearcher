package com.sinyang92.feature.searchimage.ui.searchscreen

import androidx.compose.runtime.Composable

@Composable
fun SearchImageScreenRoute(
    onSearchClicked: (String) -> Unit
) {
    SearchImageScreen(
        onSearchClicked = onSearchClicked
    )
}