package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.logging.common.Constant.OMITTED
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MaskingPatternBuilderTest {
    @Nested
    inner class PatternGenerationTest {
        @Test
        fun `generated masking patterns are empty if no fields are passed`() {
            assertEquals(0, MaskingPatternBuilder().build().size)
        }

        @Test
        fun `generated masking patterns size is one when only global fields are passed regardless of their count`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(*globalFields.toTypedArray()).build()

            assertEquals(1, patterns.size)
        }

        @Test
        fun `passed path fields are truncated to the last two elements`() {
            val pathFields = setOf(listOf("first", "second", "third", "fourth"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()

            assertEquals(1, patterns.size)

            println(patterns.first().pattern.pattern())
            assertFalse(patterns.first().pattern.pattern().contains("first"))
            assertFalse(patterns.first().pattern.pattern().contains("second"))

            assertTrue(patterns.first().pattern.pattern().contains("third"))
            assertTrue(patterns.first().pattern.pattern().contains("fourth"))
        }

        @Test
        fun `generated masking patterns size is not affected by pattern duplication caused by truncated patterns`() {
            val pathFields = setOf(listOf("second", "third"), listOf("first", "second", "third"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()

            assertEquals(1, patterns.size)
        }

        @Test
        fun `generated masking patterns size grows linearly when only path-based fields are passed`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first", "second", "third"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()

            assertEquals(pathFields.size, patterns.size)
        }

        @Test
        fun `generated masking patterns size equals the number of path-based fields passed +1 for global fields when both are passed`() {
            val globalFields = setOf("globalField1", "globalField2")
            val pathFields = setOf(listOf("first", "second"), listOf("first", "second", "third"))

            val maskingPatterns = MaskingPatternBuilder()
                .globalFields(*globalFields.toTypedArray())
                .pathFields(*pathFields.toTypedArray())
                .build()

            assertEquals(pathFields.size + 1, maskingPatterns.size)
        }

        @Test
        fun `global path fields are passed to builder and consumed in masking patterns generation`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(*globalFields.toTypedArray()).build()

            assertEquals(1, patterns.size)

            assertTrue(patterns.first().pattern.pattern().contains("globalField1"))
            assertTrue(patterns.first().pattern.pattern().contains("globalField2"))
        }

        @Test
        fun `path fields are passed to builder and consumed in masking patterns generation`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()


            assertEquals(pathFields.size, patterns.size)


            assertAll(
                { assertTrue(patterns[0].pattern.pattern().contains("first")) },
                { assertTrue(patterns[0].pattern.pattern().contains("second")) },
                { assertTrue(patterns[1].pattern.pattern().contains("third1")) },
                { assertTrue(patterns[1].pattern.pattern().contains("as")) }
            )
        }
    }

    @Nested
    inner class PatternsBehaviourTest {
        @Test
        fun `masks a field globally when a global field is passed`() {
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
            val expected = """
            {
                "globalField1": "$OMITTED",
                "globalField2": {
                    "globalField1": "$OMITTED"
                }
            }
            """.trimIndent()

            assertEquals(expected, actual)
        }

        @Test
        fun `masks a field in a path when a path field is passed`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))
            val patterns = MaskingPatternBuilder().pathFields(*pathFields.toTypedArray()).build()

            assertEquals(pathFields.size, patterns.size)

            var actual = """
            {
                "first": {
                    "second": "value1"
                },
                "first1": {
                    "second1": {
                        "third1": {
                            "as": "value2"
                        }
                    }
                }
            }
            """.trimIndent()

            patterns.forEach { actual = it.replaceAll(actual) }

            val expected = """
            {
                "first": {
                    "second": "$OMITTED"
                },
                "first1": {
                    "second1": {
                        "third1": {
                            "as": "$OMITTED"
                        }
                    }
                }
            }
            """.trimIndent()

            assertEquals(expected, actual)
        }

        @Test
        fun `masks a field globally and in a path when both are passed`() {
            val globalFields = setOf("globalField1", "globalField2")
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))

            val maskingPatterns = MaskingPatternBuilder()
                .globalFields(*globalFields.toTypedArray())
                .pathFields(*pathFields.toTypedArray())
                .build()

            assertEquals(pathFields.size + 1, maskingPatterns.size)

            var actual = """
            {
                "globalField1": "value1",
                "globalField2": {
                    "globalField1": "value2"
                },
                "first": {
                    "second": "value3"
                },
                "first1": {
                    "second1": {
                        "third1": {
                            "as": "value4"
                        }
                    }
                }
            }
            """.trimIndent()

            maskingPatterns.forEach { actual = it.replaceAll(actual) }

            val expected = """
            {
                "globalField1": "$OMITTED",
                "globalField2": {
                    "globalField1": "$OMITTED"
                },
                "first": {
                    "second": "$OMITTED"
                },
                "first1": {
                    "second1": {
                        "third1": {
                            "as": "$OMITTED"
                        }
                    }
                }
            }
            """.trimIndent()

            assertEquals(expected, actual)
        }
    }
}
