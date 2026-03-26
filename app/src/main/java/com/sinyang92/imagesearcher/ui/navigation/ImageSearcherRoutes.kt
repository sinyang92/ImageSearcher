package com.sinyang92.imagesearcher.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object SearchImageScreen

@Serializable
data class SearchImageResultScreen(
    val query: String
)