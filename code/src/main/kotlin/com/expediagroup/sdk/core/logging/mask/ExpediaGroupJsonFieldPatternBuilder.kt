package com.expediagroup.sdk.core.logging.mask

import com.ebay.ejmask.extenstion.builder.json.JsonFieldPatternBuilder
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED

internal class ExpediaGroupJsonFieldPatternBuilder: JsonFieldPatternBuilder() {
    override fun buildReplacement(visibleCharacters: Int, vararg fieldNames: String?): String = "\"$1$2$OMITTED\""
}
