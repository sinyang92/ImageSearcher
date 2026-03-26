package com.sinyang92.feature.searchimage.data.service

import com.sinyang92.common.BuildConfig
import com.sinyang92.feature.searchimage.data.dto.SearchImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {

    @GET("services/rest")
    suspend fun searchImage(
        @Query("text") query: String,
        @Query("api_key") apiKey: String = BuildConfig.IMAGE_API_KEY,
        @Query("method") method: String = "flickr.photos.search",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1
    ) : Response<SearchImageResponse>
}