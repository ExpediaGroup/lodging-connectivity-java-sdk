package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.rest.util.StringifyQueryParam

/**
 * Data class representing a URL query parameter.
 *
 * @property key The key of the query parameter.
 * @property value The list of values associated with the query parameter.
 * @property stringify The stringifier used to convert the query parameter to a string.
 */
data class UrlQueryParam(
    val key: String,
    val value: List<String>,
    val stringify: StringifyQueryParam
) {
    /**
     * Converts the query parameter to a string using the provided stringifier.
     *
     * @return The string representation of the query parameter.
     */
    override fun toString(): String = stringify(this)
}
