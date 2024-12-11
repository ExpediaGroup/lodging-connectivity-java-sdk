package com.expediagroup.sdk.core.common

import java.io.InputStream
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class MetadataLoaderTest {

    @AfterEach
    fun tearDown() {
        MetadataLoader.clear()
    }

    @Test
    fun `should load metadata from sdk properties file`() {
        val metadata = MetadataLoader.load()

        assertEquals("com.expediagroup", metadata.groupId)
        assertEquals("expedia-group-test-sdk", metadata.artifactName)
        assertEquals("1.0.0", metadata.version)
        assertNotNull(metadata.jdkVersion)
        assertNotNull(metadata.jdkVendor)
        assertNotNull(metadata.osName)
        assertNotNull(metadata.osVersion)
        assertNotNull(metadata.arch)
        assertNotNull(metadata.locale)
    }

    @Test
    fun `should load default metadata if no sdk properties file is found`() {
        val originalClassLoader = Thread.currentThread().contextClassLoader

        try {
            Thread.currentThread().contextClassLoader = object : ClassLoader(originalClassLoader) {
                override fun getResourceAsStream(name: String?): InputStream? {
                    return if (name == "sdk.properties") null else super.getResourceAsStream(name)
                }
            }

            val metadata = MetadataLoader.load()

            assertEquals("unknown", metadata.artifactName)
            assertEquals("unknown", metadata.groupId)
            assertEquals("unknown", metadata.version)
        } finally {
            Thread.currentThread().contextClassLoader = originalClassLoader
        }
    }

    @Test
    fun `should load default metadata if failed to get the current thread class loader`() {
        val originalClassLoader = Thread.currentThread().contextClassLoader

        try {
            Thread.currentThread().contextClassLoader = null

            val metadata = MetadataLoader.load()

            assertEquals("unknown", metadata.artifactName)
            assertEquals("unknown", metadata.groupId)
            assertEquals("unknown", metadata.version)
        } finally {
            Thread.currentThread().contextClassLoader = originalClassLoader
        }
    }

    @Test
    fun `should return the same metadata instance if called multiple times`() {
        assertSame(MetadataLoader.load(), MetadataLoader.load())
    }
}
