package com.sinyang92.feature.searchimage.data.di

import com.sinyang92.feature.searchimage.data.repositoryimpl.ImageRepositoryImpl
import com.sinyang92.feature.searchimage.domain.repository.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ImageRepositoryModule {

    @Binds
    @Singleton
    fun bindImageRepository(
        imageRepositoryImpl: ImageRepositoryImpl
    ): ImageRepository
}