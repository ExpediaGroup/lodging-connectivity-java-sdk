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

import com.ebay.ejmask.extenstion.builder.json.JsonFullValuePatternBuilder
import com.ebay.ejmask.extenstion.builder.json.JsonRelativeFieldPatternBuilder
import com.expediagroup.sdk.core.logging.common.Constant.OMITTED

/**
 * Custom implementation of JsonFieldPatternBuilder for building JSON field patterns.
 */
internal class CustomJsonFullValuePatternBuilder : JsonFullValuePatternBuilder() {
    companion object {
        @JvmStatic
        val REPLACEMENT_TEMPLATE = "\"$1$2$OMITTED\""
    }

    /**
     * Builds the replacement string for the given field names.
     * Ignores the visibleCharacters parameter.
     *
     * @param visibleCharacters Number of visible characters. Value is ignored.
     * @param fieldNames Vararg of field names.
     * @return The replacement string.
     */
    override fun buildReplacement(
        visibleCharacters: Int,
        vararg fieldNames: String?,
    ): String = REPLACEMENT_TEMPLATE
}

internal class CustomJsonRelativeFieldPatternBuilder : JsonRelativeFieldPatternBuilder() {
    companion object {
        @JvmStatic
        val REPLACEMENT_TEMPLATE = "$1$OMITTED$3"
    }

    /**
     * Builds the replacement string for the given field names.
     * Ignores the visibleCharacters parameter.
     *
     * @param visibleCharacters Number of visible characters. Value is ignored.
     * @param fieldNames Vararg of field names.
     * @return The replacement string.
     */
    override fun buildReplacement(
        visibleCharacters: Int,
        vararg fieldNames: String?,
    ): String = REPLACEMENT_TEMPLATE
}
