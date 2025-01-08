package com.expediagroup.sdk.core.extension

inline fun <T> T?.getOrThrow(exceptionProvider: () -> Throwable): T = this ?: throw exceptionProvider()

fun Boolean?.orFalseIfNull(): Boolean = this == true

fun String?.orNullIfBlank(): String? = this?.takeUnless { it.isBlank() }
