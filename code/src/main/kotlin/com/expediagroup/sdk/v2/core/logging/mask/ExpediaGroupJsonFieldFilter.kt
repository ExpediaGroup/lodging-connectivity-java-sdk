package com.expediagroup.sdk.v2.core.logging.mask

import com.ebay.ejmask.core.BaseFilter

internal class ExpediaGroupJsonFieldFilter(maskedFields: Array<String>) : BaseFilter(
    ExpediaGroupJsonFieldPatternBuilder::class.java,
    *maskedFields
)
