package com.sinyang92.feature.searchimage.ui.searchscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sinyang92.design.component.PaddedColumn
import com.sinyang92.design.component.PrimaryButton
import com.sinyang92.design.component.SpacerMedium
import com.sinyang92.feature.R

@Composable
fun SearchImageScreen(
    onSearchClicked: (String) -> Unit
) {
    PaddedColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        var searchQuery by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchQuery,
            onValueChange = { newValue ->
                searchQuery = newValue
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_image_screen_text_field_place_holder)
                )
            },
            singleLine = true
        )

        SpacerMedium()

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.search_image_screen_search_button_text),
            enabled = searchQuery.isNotEmpty(),
            onClick = {
                onSearchClicked(searchQuery)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SearchImageScreen(
        onSearchClicked = {}
    )
}