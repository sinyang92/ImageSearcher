package com.sinyang92.feature.searchimage.ui.resultscreen

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sinyang92.design.R
import com.sinyang92.design.component.PaddedColumn
import com.sinyang92.feature.searchimage.ui.model.Image

@Composable
fun ImagesDisplayScreen(
    images: List<Image>
) {
    PaddedColumn {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
        ) {
            items(images, key = { it.id }) { image ->
                AsyncImage(
                    modifier = Modifier.aspectRatio(1f),
                    model = image.imageUrl,
                    contentDescription = null,
                    placeholder = painterResource(R.drawable.ic_placeholder),
                    error = painterResource(R.drawable.ic_placeholder),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ImagesDisplayScreen(
        images = listOf(
            Image("1", "https://"),
            Image("2", "https://"),
            Image("3", "https://"),
            Image("4", "https://")
        )
    )
}