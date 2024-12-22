package com.expediagroup.sdk.core.logging.masking

import com.ebay.ejmask.api.MaskingPattern
import com.expediagroup.sdk.core.logging.common.Constant.OMITTED
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LogMaskerTest {
    @AfterEach
    fun afterEach() {
        mask.clear()
    }

    @Nested
    inner class FieldLogMaskingFeatureTest {
        @Test
        fun `adding global fields to the masking pattern builder`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(*globalFields.toTypedArray()).build()

            assertEquals(1, patterns.size)

            assertTrue(patterns.first().pattern.pattern().contains("globalField1"))
            assertTrue(patterns.first().pattern.pattern().contains("globalField2"))
        }

        @Test
        fun `adding path fields to the masking pattern builder`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()

            assertEquals(pathFields.size, patterns.size)
        }

        @Test
        fun `adding global and path fields to the masking pattern builder`() {
            val globalFields = setOf("globalField1", "globalField2")
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))

            val maskingPatterns = MaskingPatternBuilder()
                .globalFields(*globalFields.toTypedArray())
                .pathFields(*pathFields.toTypedArray())
                .build()

            assertEquals(pathFields.size + 1, maskingPatterns.size)
        }

        @Test
        fun `masking patterns are not added to the mask if they already exist`() {
            val maskingPatterns = listOf(
                MaskingPattern(0, "pattern1", "replacement1"),
                MaskingPattern(1, "pattern2", "replacement2")
            )
            mask.addPatternIfNotExists(*maskingPatterns.toTypedArray())

            assertEquals(maskingPatterns, mask.patterns())

            val newMaskingPatterns = listOf(
                MaskingPattern(0, "pattern1", "replacement1"),
                MaskingPattern(1, "pattern2", "replacement2")
            )

            val addResult = mask.addPatternIfNotExists(*newMaskingPatterns.toTypedArray())

            assertFalse(addResult)
            assertEquals(maskingPatterns, mask.patterns())
        }

        @Test
        fun `masking patterns are cleared from the mask`() {
            val maskingPatterns = listOf(
                MaskingPattern(0, "pattern1", "replacement1"),
                MaskingPattern(1, "pattern2", "replacement2")
            )
            mask.addPatternIfNotExists(*maskingPatterns.toTypedArray())

            assertTrue(mask.patterns().isNotEmpty())
            assertEquals(maskingPatterns.size, mask.patterns().size)
            assertEquals(maskingPatterns, mask.patterns())

            mask.clear()

            assertTrue(mask.patterns().isEmpty())
        }
    }

    @Nested
    inner class MaskingBehaviorTest {
        @Test
        fun `masking patterns are applied to the input string`() {
            val maskingPatterns = listOf(
                MaskingPattern(0, "pattern1", "replacement1"),
                MaskingPattern(1, "pattern2", "replacement2")
            )

            mask.addPatternIfNotExists(*maskingPatterns.toTypedArray())

            val masked = mask(
                """
                {
                    "pattern1": "value1",
                    "pattern2": "value2"
                }
                """.trimIndent()
            )

            val expected = """
                {
                    "replacement1": "value1",
                    "replacement2": "value2"
                }
                """.trimIndent()

            assertEquals(expected, masked)
        }

        @Test
        fun `masks global fields in json payload`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(*globalFields.toTypedArray()).build()

            assertEquals(1, patterns.size)

            val actual = patterns.first().replaceAll(
                """
                {
                    "globalField1": "value1",
                    "globalField2": {
                        "globalField1": "value2"
                    }
                }
                """.trimIndent()
            )
            val expected =  """
                {
                    "globalField1": "$OMITTED",
                    "globalField2": {
                        "globalField1": "$OMITTED"
                    }
                }
                """.trimIndent()

            assertEquals(expected, actual)
        }
    }
}
