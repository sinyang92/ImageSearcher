package com.sinyang92.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinyang92.design.theme.LocalAppDimens

private val minButtonWidth = 100.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .widthIn(min = minButtonWidth),
        shape = RoundedCornerShape(size = LocalAppDimens.current.xs8),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = typography.bodyLarge
        )
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .widthIn(min = minButtonWidth),
        shape = RoundedCornerShape(size = LocalAppDimens.current.xs8),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        PrimaryButton(text = "PrimaryButton") { }
        SecondaryButton(text = "SecondaryButton") { }
    }
}