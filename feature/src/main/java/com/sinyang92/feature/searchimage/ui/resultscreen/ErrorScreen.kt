package com.sinyang92.feature.searchimage.ui.resultscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sinyang92.design.component.PaddedColumn
import com.sinyang92.design.component.SecondaryButton
import com.sinyang92.design.component.SpacerMedium
import com.sinyang92.feature.R

@Composable
fun ErrorScreen(
    onButtonClicked: () -> Unit
) {
    PaddedColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.search_image_error_screen_body)
        )

        SpacerMedium()

        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.search_image_error_screen_button_text),
            onClick = onButtonClicked
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ErrorScreen(
        onButtonClicked = {}
    )
}