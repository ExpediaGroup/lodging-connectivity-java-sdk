package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.logging.common.Constant.OMITTED
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PatternBuildersTest {
    @Nested
    inner class CustomJsonFullValuePatternBuilderTest {
        @Test
        fun `buildReplacement contains omitted keyword`() {
            val custom = CustomJsonFullValuePatternBuilder()

            assertTrue(custom.buildReplacement(0, "field").contains(OMITTED))
        }

        @Test
        fun `buildReplacement always generates proper replacement template`() {
            val custom = CustomJsonFullValuePatternBuilder()

            custom.buildReplacement(0, "field1").also {
                assertEquals(CustomJsonFullValuePatternBuilder.REPLACEMENT_TEMPLATE, it)
            }

            custom.buildReplacement(0, "field1", "field2").also {
                assertEquals(CustomJsonFullValuePatternBuilder.REPLACEMENT_TEMPLATE, it)
            }

            custom.buildReplacement(0, "field".repeat(1000)).also {
                assertEquals(CustomJsonFullValuePatternBuilder.REPLACEMENT_TEMPLATE, it)
            }
        }
    }

    @Nested
    inner class CustomJsonRelativeFieldPatternBuilderTest {
        @Test
        fun `buildReplacement contains omitted keyword`() {
            val custom = CustomJsonRelativeFieldPatternBuilder()

            assertTrue(custom.buildReplacement(0, "field").contains(OMITTED))
        }

        @Test
        fun `buildReplacement always generates proper replacement template`() {
            val custom = CustomJsonRelativeFieldPatternBuilder()

            custom.buildReplacement(0, "field1").also {
                assertEquals(CustomJsonRelativeFieldPatternBuilder.REPLACEMENT_TEMPLATE, it)
            }

            custom.buildReplacement(0, "field1", "field2").also {
                assertEquals(CustomJsonRelativeFieldPatternBuilder.REPLACEMENT_TEMPLATE, it)
            }

            custom.buildReplacement(0, "field".repeat(1000)).also {
                assertEquals(CustomJsonRelativeFieldPatternBuilder.REPLACEMENT_TEMPLATE, it)
            }
        }
    }
}
