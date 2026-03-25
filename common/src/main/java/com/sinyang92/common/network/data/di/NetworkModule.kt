package com.sinyang92.common.network.data.di

import com.sinyang92.common.network.data.impl.NetworkResponseHandlerImpl
import com.sinyang92.common.network.domain.NetworkResponseHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkResponseHandler(): NetworkResponseHandler =
        NetworkResponseHandlerImpl()
}