package com.expediagroup.sdk.core.logging.masking

import com.ebay.ejmask.api.MaskingPattern

/**
 * Interface for pattern-based masking.
 */
internal interface PatternBasedMask : (String) -> String {
    /**
     * Adds masking patterns if they do not already exist.
     *
     * @param maskingPatterns Vararg of MaskingPattern to be added.
     * @return True if patterns were added, false if they already existed.
     */
    fun addPatternIfNotExists(vararg maskingPatterns: MaskingPattern): Boolean

    /**
     * Retrieves the list of current masking patterns.
     *
     * @return A list of MaskingPattern.
     */
    fun patterns(): List<MaskingPattern>

    /**
     * Clears all existing masking patterns.
     */
    fun clear()
}

/**
 * Object implementing the PatternBasedMask interface.
 */
internal val mask = object : PatternBasedMask {
    val patterns: MutableList<MaskingPattern> = mutableListOf()

    /**
     * Applies all masking patterns to the input string.
     *
     * @param input The input string to be masked.
     * @return The masked string.
     */
    override fun invoke(input: String): String {
        var masked = input

        patterns.forEach { pattern: MaskingPattern ->
            masked = pattern.replaceAll(masked)
        }

        return masked
    }

    /**
     * Retrieves the list of current masking patterns.
     *
     * @return A list of MaskingPattern.
     */
    override fun patterns() =
        this.patterns.toList()

    /**
     * Clears all existing masking patterns.
     */
    override fun clear() {
        patterns.clear()
    }

    /**
     * Adds masking patterns if they do not already exist.
     *
     * @param maskingPatterns Vararg of MaskingPattern to be added.
     * @return True if patterns were added, false if they already existed.
     */
    override fun addPatternIfNotExists(vararg maskingPatterns: MaskingPattern): Boolean {
        var addedPattern = false

        maskingPatterns.forEach newPatterns@{ pattern ->
            patterns.forEach existingPatterns@{
                val patternExists = (it.pattern.pattern() == pattern.pattern.pattern())
                    .and(it.replacement == pattern.replacement)

                if (patternExists) {
                    return@newPatterns
                }
            }

            patterns.add(pattern).also { addedPattern = true }
        }

        return addedPattern
    }
}
