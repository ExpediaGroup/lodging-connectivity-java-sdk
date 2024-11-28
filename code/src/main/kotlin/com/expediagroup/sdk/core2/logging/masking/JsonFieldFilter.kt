package com.expediagroup.sdk.core2.logging.masking

import com.ebay.ejmask.core.BaseFilter

/**
 * A filter class that extends the BaseFilter to apply masking on specific JSON fields using
 * `ExpediaGroupJsonFieldPatternBuilder` for pattern building.
 *
 * This filter helps in masking sensitive JSON fields by replacing them with a predefined pattern.
 *
 * @constructor
 * Initializes ExpediaGroupJsonFieldFilter with the specified fields to be masked.
 *
 * @param maskedFields An array of strings representing the names of the fields to be masked.
 */
internal class JsonFieldFilter(maskedFields: Array<String>) : BaseFilter(
    JsonFieldPatternBuilder::class.java,
    *maskedFields
)
