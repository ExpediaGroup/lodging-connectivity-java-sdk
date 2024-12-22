package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.core.logging.masking.LogMaskingFeature

/**
 * Object implementing the MaskingConfiguration interface.
 * Initializes and adds masking patterns based on global and path-specific fields at startup time automatically.
 */
internal val LodgingConnectivityLogMasking =
    object : LogMaskingFeature() {
        /**
         * A set of globally masked fields.
         *
         * @return A set of strings representing the global masked fields.
         */
        override val globalMaskedFields: Set<String> = setOf(
            "cvv",
            "cvv2",
        )

        /**
         * A set of path-specific masked fields.
         *
         * @return A set of lists of strings representing the path masked fields.
         */
        override val pathMaskedFields: Set<List<String>> = setOf()
    }
