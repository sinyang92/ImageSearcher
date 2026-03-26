package com.sinyang92.feature.searchimage.data.repositoryimpl

import com.sinyang92.common.network.domain.NetworkResponseHandler
import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.searchimage.data.dto.SearchImageResponse
import com.sinyang92.feature.searchimage.data.service.ImageService
import com.sinyang92.feature.searchimage.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageService: ImageService,
    private val networkResponseHandler: NetworkResponseHandler
) : ImageRepository {

    override fun searchImage(query: String): Flow<Resource<SearchImageResponse>> =
        networkResponseHandler.getResourceFromResponse {
            imageService.searchImage(
                query = query
            )
        }
}