/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity.configuration

import com.expediagroup.sdk.core.logging.masking.AbstractLogMaskingFeature

/**
 * Object implementing the MaskingConfiguration interface.
 * Initializes and adds masking patterns based on global and path-specific fields at startup time automatically.
 */
internal val LogMasking =
    object : AbstractLogMaskingFeature() {
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
