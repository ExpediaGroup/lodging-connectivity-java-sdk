package com.expediagroup.sdk.core.logging.masking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class AbstractLogMaskingFeatureTest {
    @Test
    fun `verify globalMaskedFields returns empty set`() {
        val maskingConfiguration = object : AbstractLogMaskingFeature() {}
        assertTrue(maskingConfiguration.globalMaskedFields.isEmpty())
    }

    @Test
    fun `verify pathMaskedFields returns empty set`() {
        val maskingConfiguration = object : AbstractLogMaskingFeature() {}
        assertTrue(maskingConfiguration.pathMaskedFields.isEmpty())
    }

    @Test
    fun `verify globalMaskedFields is overridable`() {
        val maskingConfiguration = object : AbstractLogMaskingFeature() {
            override val globalMaskedFields: Set<String>
                get() = setOf("field1", "field2")
        }

        assertEquals(2, maskingConfiguration.globalMaskedFields.size)
        assertTrue(maskingConfiguration.globalMaskedFields.contains("field1"))
        assertTrue(maskingConfiguration.globalMaskedFields.contains("field2"))
    }

    @Test
    fun `verify pathMaskedFields is overridable`() {
        val maskingConfiguration = object : AbstractLogMaskingFeature() {
            override val pathMaskedFields: Set<List<String>>
                get() = setOf(listOf("field1", "field2"))
        }

        assertEquals(1, maskingConfiguration.pathMaskedFields.size)
        assertTrue(maskingConfiguration.pathMaskedFields.contains(listOf("field1", "field2")))
    }

    @Test
    fun `verify pathMaskedFields and globalMaskedFields are overridable interchangeably`() {
        val maskingConfiguration = object : AbstractLogMaskingFeature() {
            override val globalMaskedFields: Set<String>
                get() = setOf("field1", "field2")
            override val pathMaskedFields: Set<List<String>>
                get() = setOf(listOf("field3", "field4"))
        }

        assertEquals(maskingConfiguration.globalMaskedFields.size, 2)
    }
}
