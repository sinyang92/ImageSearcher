package com.sinyang92.feature.searchimage

import com.sinyang92.feature.searchimage.data.dto.Photo
import com.sinyang92.feature.searchimage.data.dto.Photos
import com.sinyang92.feature.searchimage.data.dto.SearchImageResponse

fun getMockSearchImageResponse() =
    SearchImageResponse(
        photos = Photos(
            photo = listOf(
                Photo(
                    id = "39593986652",
                    farm = 5,
                    server = "4740",
                    secret = "0ec416669f"
                )
            )
        )
    )