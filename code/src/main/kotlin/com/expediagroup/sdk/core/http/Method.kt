package com.expediagroup.sdk.core.http

enum class Method(val method: String) {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE"),
    CONNECT("CONNECT");

    override fun toString(): String = method
}
