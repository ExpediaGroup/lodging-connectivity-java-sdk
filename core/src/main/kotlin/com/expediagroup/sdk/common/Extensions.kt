package com.expediagroup.sdk.common

inline fun <T> T?.getOrThrow(exceptionProvider: () -> Throwable): T {
    return this ?: throw exceptionProvider()
}