package com.expediagroup.sdk.v2.core.apache.extension

import org.apache.http.protocol.HttpContext
import org.apache.http.protocol.HttpCoreContext

fun HttpContext.getRequestUrl(): String =
    HttpCoreContext.adapt(this).let {
        "${it.targetHost}${it.request.requestLine.uri}"
    }

fun HttpContext.getRequestMethod(): String =
    HttpCoreContext.adapt(this).request.requestLine.method

fun HttpContext.getProtocol(): String =
    HttpCoreContext.adapt(this).request.requestLine.protocolVersion.toString()

fun HttpContext.getRequestMetadataLine(): String {
    val method = getRequestMethod()
    val url = getRequestUrl()
    val protocol = getProtocol()

    return "$protocol $method $url"
}
