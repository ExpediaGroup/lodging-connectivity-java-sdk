package com.expediagroup.sdk.core.logging.masking

import com.ebay.ejmask.api.MaskingPattern

/**
 * Builder class for creating masking patterns.
 */
internal class MaskingPatternBuilder {
    private var globalFields: Set<String> = setOf()
    private var pathFields: Set<List<String>> = setOf()

    /**
     * Adds global fields to be masked.
     *
     * @param name Vararg of field names to be masked globally.
     * @return The current instance of MaskingPatternBuilder.
     */
    fun globalFields(vararg name: String): MaskingPatternBuilder = apply {
        globalFields += name.toSortedSet()
    }

    /**
     * Adds path-specific fields to be masked.
     *
     * @param paths Vararg of lists of field names to be masked by path.
     * @return The current instance of MaskingPatternBuilder.
     */
    fun pathFields(vararg paths: List<String>) = apply {
        pathFields += paths.map { it.takeLast(2) }
    }

    /**
     * Builds the list of MaskingPattern based on the added global and path fields.
     *
     * @return A list of MaskingPattern.
     */
    fun build(): List<MaskingPattern> = buildList {
        /**
         * Builds masking patterns for global fields.
         *
         * @return A list of MaskingPattern for global fields.
         */
        fun buildGlobalFieldsMaskingPattern(): List<MaskingPattern> =
            if (globalFields.isEmpty()) {
                emptyList()
            } else {
                val patternGenerator = CustomJsonFullValuePatternBuilder()
                listOf(
                    MaskingPattern(
                        0,
                        patternGenerator.buildPattern(0, *globalFields.toTypedArray()),
                        patternGenerator.buildReplacement(0, *globalFields.toTypedArray())
                    )
                )
            }

        /**
         * Builds masking patterns for path-specific fields.
         *
         * @return A list of MaskingPattern for path-specific fields.
         */
        fun buildPathFieldsMaskingPattern(): List<MaskingPattern> = buildList {
            pathFields.forEachIndexed { index, path ->
                CustomJsonRelativeFieldPatternBuilder().also { patternGenerator ->
                    add(
                        MaskingPattern(
                            index + 1,
                            patternGenerator.buildPattern(1, *path.toTypedArray()),
                            patternGenerator.buildReplacement(1, *path.toTypedArray())
                        )
                    )
                }
            }
        }

        addAll(buildGlobalFieldsMaskingPattern())
        addAll(buildPathFieldsMaskingPattern())
    }
}
