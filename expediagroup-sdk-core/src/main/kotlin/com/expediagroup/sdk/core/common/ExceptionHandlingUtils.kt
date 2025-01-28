package com.expediagroup.sdk.core.common

import com.expediagroup.sdk.core.exception.ExpediaGroupException

fun <T> runCatchingUncaught(
    block: () -> T,
    unwrappedExceptionHandler: (e: Throwable) -> Throwable,
): T =
    try {
        block()
    } catch (e: ExpediaGroupException) {
        throw e
    } catch (e: Exception) {
        throw unwrappedExceptionHandler(e)
    }
