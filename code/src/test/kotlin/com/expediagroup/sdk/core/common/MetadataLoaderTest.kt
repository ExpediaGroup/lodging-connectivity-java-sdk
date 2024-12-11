package com.expediagroup.sdk.core.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MetadataLoaderTest {

    @Test
    fun `should load metadata from sdk properties file`() {
        assertEquals("com.expediagroup", MetadataLoader.groupId)
        assertEquals("expedia-group-test-sdk", MetadataLoader.artifactName)
        assertEquals("1.0.0", MetadataLoader.version)
    }
}
