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

package com.expediagroup.sdk.core.logging.masking

import com.ebay.ejmask.api.MaskingPattern

internal class LogMasker(
    globalMaskedFields: Set<String> = emptySet(),
    pathMaskedFields: Set<List<String>> = emptySet(),
) : (String) -> String {
    private val patterns: List<MaskingPattern> =
        MaskingPatternBuilder()
            .apply {
                globalFields(globalMaskedFields)
                pathFields(pathMaskedFields)
            }.build()

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
}
