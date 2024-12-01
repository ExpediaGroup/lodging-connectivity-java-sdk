package com.expediagroup.sdk.core.extension

import java.nio.charset.Charset

inline fun <T> T?.getOrThrow(exceptionProvider: () -> Throwable): T {
    return this ?: throw exceptionProvider()
}

fun Boolean?.orFalseIfNull(): Boolean = this == true

fun String?.orNullIfBlank(): String? = this?.takeUnless { it.isBlank() }

fun Charset?.orUtf8() = this ?: Charsets.UTF_8
