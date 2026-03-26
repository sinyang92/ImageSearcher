package com.sinyang92.common.network.data.impl

import android.content.Context
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

class ResourceHandlerImplTest {
    private val context: Context = mockk(relaxed = true)

    private val resourceHandler = ResourceHandlerImpl(context)

    @Test
    fun `test getString`() {
        every { context.getString(12345) } returns "Expected string"
        assertEquals("Expected string", resourceHandler.getString(12345))

        every { context.getString(12345, "param1", "param2") } returns "Expected string"
        assertEquals("Expected string", resourceHandler.getString(12345, "param1", "param2"))
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}