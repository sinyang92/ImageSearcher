package com.sinyang92.feature.searchimage.domain.usecase

import com.sinyang92.feature.searchimage.domain.repository.ImageRepository
import javax.inject.Inject

class SearchImageUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {

    operator fun invoke(query: String) = imageRepository.searchImage(query = query)
}