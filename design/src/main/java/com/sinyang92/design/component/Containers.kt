package com.sinyang92.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sinyang92.design.theme.ImageSearcherTheme
import com.sinyang92.design.theme.LocalAppDimens

@Composable
fun PaddedColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .padding(LocalAppDimens.current.rg16)
            .fillMaxWidth()
            .background(Color.White),
        content = content,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    )
}

@Preview
@Composable
private fun Preview() {
    ImageSearcherTheme {
        Column(
            modifier = Modifier
                .background(color = Color.Black)
        ) {
            PaddedColumn(
                modifier = Modifier
                    .background(color = Color.White)
            ) {
                Text(text = "This is PaddedColumn")
                Text(text = "This is PaddedColumn")
                Text(text = "This is PaddedColumn")
            }
        }
    }
}