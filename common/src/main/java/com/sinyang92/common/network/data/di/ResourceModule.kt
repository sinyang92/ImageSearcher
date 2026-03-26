package com.sinyang92.common.network.data.di

import android.content.Context
import com.sinyang92.common.network.data.impl.ResourceHandlerImpl
import com.sinyang92.common.network.domain.ResourceHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ResourceModule {

    @Provides
    @Singleton
    fun provideResourceHandler(
        @ApplicationContext context: Context
    ): ResourceHandler =
        ResourceHandlerImpl(context)
}