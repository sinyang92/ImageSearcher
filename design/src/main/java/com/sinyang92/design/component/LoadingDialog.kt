package com.sinyang92.design.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.sinyang92.design.theme.LocalAppDimens

@Composable
fun LoadingDialog() {
    Dialog(onDismissRequest = {}) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(LocalAppDimens.current.lg32)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    LoadingDialog()
}