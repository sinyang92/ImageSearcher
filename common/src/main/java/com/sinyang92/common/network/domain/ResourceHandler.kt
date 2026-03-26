package com.sinyang92.common.network.domain

import androidx.annotation.StringRes

interface ResourceHandler {

    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg args: Any): String
}