package com.expediagroup.sdk.v2.core.client.util

import com.apollographql.apollo.api.http.HttpHeader
import com.google.api.client.http.HttpHeaders

/**
 * Converts the [HttpHeaders] into a list of [HttpHeader]s suitable for Apollo requests.
 *
 * This method processes each header field and value in the [HttpHeaders] instance, transforming
 * them into [HttpHeader] objects. If a value is an iterable, each element in the iterable is converted
 * to a string and added to the list as individual headers. Otherwise, the value is converted to a string
 * and added directly as a single header.
 *
 * @return a list of [HttpHeader] objects converted from the original [HttpHeaders].
 */
fun HttpHeaders.toApolloHeaders(): List<HttpHeader> {
    val self = this

    return buildList {
        self.forEach { key, value ->
            when (value) {
                is Iterable<*> -> this.addAll(value.map { HttpHeader(key, value.toString()) })
                else -> this.add(HttpHeader(key, value.toString()))
            }
        }
    }
}