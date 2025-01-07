package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.logging.common.Constant.OMITTED
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LogMaskerTest {
    @Nested
    inner class FieldMaskingConfigurationTest {
        @Test
        fun `adding global fields to the masking pattern builder`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(globalFields).build()

            assertEquals(1, patterns.size)

            assertTrue(patterns.first().pattern.pattern().contains("globalField1"))
            assertTrue(patterns.first().pattern.pattern().contains("globalField2"))
        }

        @Test
        fun `adding path fields to the masking pattern builder`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))
            val patterns = MaskingPatternBuilder().pathFields(pathFields).build()

            assertEquals(pathFields.size, patterns.size)
        }

        @Test
        fun `adding global and path fields to the masking pattern builder`() {
            val globalFields = setOf("globalField1", "globalField2")
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))

            val maskingPatterns = MaskingPatternBuilder()
                .globalFields(globalFields)
                .pathFields(pathFields)
                .build()

            // 1 global field pattern + 2 path field patterns
            assertEquals(pathFields.size + 1, maskingPatterns.size)
        }
    }

    @Nested
    inner class MaskingBehaviorTest {
        @Test
        fun `masks global fields in json payload`() {
            val globalFields = setOf("globalField1", "globalField2")
            val patterns = MaskingPatternBuilder().globalFields(globalFields).build()

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
        fun `masks path fields in json payload`() {
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))
            val patterns = MaskingPatternBuilder().pathFields(pathFields).build()

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
        fun `masks global and path fields in json payload`() {
            val globalFields = setOf("globalField1", "globalField2")
            val pathFields = setOf(listOf("first", "second"), listOf("first1", "second1", "third1", "as"))

            val maskingPatterns = MaskingPatternBuilder()
                .globalFields(globalFields)
                .pathFields(pathFields)
                .build()

            assertEquals(pathFields.size + 1, maskingPatterns.size)

            var actual = """
                {
                    "globalField1": "value1",
                    "globalField2": {
                        "globalField1": "value2"
                    },
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
