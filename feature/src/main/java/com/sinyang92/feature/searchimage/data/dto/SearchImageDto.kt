package com.sinyang92.feature.searchimage.data.dto

data class SearchImageResponse(
    val photos: Photos
)

data class Photos(
    val photo: List<Photo>
)

data class Photo(
    val id: String,
    val farm: Int,
    val server: String,
    val secret: String
)