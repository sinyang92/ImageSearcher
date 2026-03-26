package com.sinyang92.feature.searchimage.domain.repository

import com.sinyang92.common.network.domain.model.Resource
import com.sinyang92.feature.searchimage.data.dto.SearchImageResponse
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    fun searchImage(query: String) : Flow<Resource<SearchImageResponse>>
}