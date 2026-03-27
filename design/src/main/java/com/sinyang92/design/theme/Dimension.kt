package com.sinyang92.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimension(
    val xs8: Dp = 8.dp,
    val rg16: Dp = 16.dp,
    val lg32: Dp = 32.dp
)

val LocalAppDimens = staticCompositionLocalOf { Dimension() }