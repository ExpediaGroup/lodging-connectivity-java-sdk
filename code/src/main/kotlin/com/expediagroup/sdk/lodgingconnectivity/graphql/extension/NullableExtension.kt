package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

inline fun <T> T?.getOrThrow(exceptionProvider: () -> Throwable): T {
    return this ?: throw exceptionProvider()
}

fun Boolean?.orFalseIfNull(): Boolean = this ?: false

fun String?.orNullIfBlank(): String? = this?.takeUnless { it.isBlank() }
