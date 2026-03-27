package com.sinyang92.design.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sinyang92.design.theme.LocalAppDimens

@Composable
fun SpacerMedium() {
    Spacer(modifier = Modifier.height(LocalAppDimens.current.rg16))
}