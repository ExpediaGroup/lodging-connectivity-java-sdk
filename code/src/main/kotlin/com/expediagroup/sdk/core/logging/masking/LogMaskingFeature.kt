package com.expediagroup.sdk.core.logging.masking

import com.expediagroup.sdk.core.common.Feature

/**
 * Interface representing the configuration for masking.
 */
internal abstract class LogMaskingFeature: Feature {
    /**
     * A set of globally masked fields.
     *
     * @return A set of strings representing the global masked fields.
     */
    open val globalMaskedFields: Set<String>
        get() = emptySet()

    /**
     * A set of path-specific masked fields.
     *
     * @return A set of lists of strings representing the path masked fields.
     */
    open val pathMaskedFields: Set<List<String>>
        get() = emptySet()

    override fun enable() {
        mask.addPatternIfNotExists(
            *MaskingPatternBuilder().apply {
                globalFields(*globalMaskedFields.toTypedArray())
                pathFields(*pathMaskedFields.toTypedArray())
            }.build().toTypedArray()
        )
    }
}
