package com.expediagroup.sdk.core.common

import java.lang.reflect.Field
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MetadataLoaderTest {
    companion object {
        const val CORRECT_ARTIFACT_ID = "expedia-group-test-sdk" // artifactId in test/resources/META-INF/MANIFEST.MF
        const val WRONG_ARTIFACT_ID = "artifact-id-not-related-to-the-sdk"
    }

    @AfterEach
    fun tearDown() {
        // MetadataLoader loads the MANIFEST.MF once and caches the Metadata object. Therefore, we need to
        // reset the static metadata field to null after each test and start from a clean state
        val metadataField: Field = MetadataLoader::class.java.getDeclaredField("metadata")
        metadataField.isAccessible = true
        metadataField.set(null, null)
    }


    @Test
    fun `should load the metadata from a MANIFEST file if a matching artifactId is found`() {
        val metadata = MetadataLoader.load(CORRECT_ARTIFACT_ID)

        assertEquals("expedia-group-test-sdk", metadata.artifactId)
        assertEquals("1.0.0-SNAPSHOT", metadata.version)
        assertEquals("com.expediagroup", metadata.groupId)
        assertNotNull(metadata.asUserAgentString())
    }

    @Test
    fun `should set metadata fields to to (unknown) as a value if NO manifest file with a matching artifactId is found`() {
        val metadata = MetadataLoader.load(WRONG_ARTIFACT_ID)

        assertEquals("unknown", metadata.artifactId)
        assertEquals("unknown", metadata.version)
        assertEquals("unknown", metadata.groupId)
    }

    @Test
    fun `calling load multiple times returns same metadata`() {
        val metadataFirst = MetadataLoader.load(CORRECT_ARTIFACT_ID)
        val metadataSecond = MetadataLoader.load(CORRECT_ARTIFACT_ID)

        assertSame(metadataFirst, metadataSecond)
    }
}
