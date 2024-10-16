package com.expediagroup.sdk.v2.core.client.util

import com.apollographql.apollo.api.http.HttpHeader
import com.google.api.client.http.HttpHeaders

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