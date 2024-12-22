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
    override fun buildReplacement(visibleCharacters: Int, vararg fieldNames: String?): String =
        REPLACEMENT_TEMPLATE
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
    override fun buildReplacement(visibleCharacters: Int, vararg fieldNames: String?): String =
        REPLACEMENT_TEMPLATE
}
