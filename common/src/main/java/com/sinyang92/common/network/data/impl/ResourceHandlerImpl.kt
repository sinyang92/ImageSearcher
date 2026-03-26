package com.sinyang92.common.network.data.impl

import android.content.Context
import com.sinyang92.common.network.domain.ResourceHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceHandlerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceHandler {

    override fun getString(resId: Int): String = context.getString(resId)

    override fun getString(resId: Int, vararg args: Any): String = context.getString(resId, *args)
}