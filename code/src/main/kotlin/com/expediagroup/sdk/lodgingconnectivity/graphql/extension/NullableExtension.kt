package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

inline fun <T> T?.getOrThrow(exceptionProvider: () -> Throwable): T {
    return this ?: throw exceptionProvider()
}

fun Boolean?.falseIfNull(): Boolean = this ?: false

fun String?.nullIfBlank(): String? = this?.takeUnless { it.isBlank() }
