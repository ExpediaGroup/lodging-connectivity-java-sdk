package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

import java.util.Optional

fun Optional<String>.nullIfBlank(): String? {
    if (this.isPresent) {
        val cursorValue = this.get()

        if (cursorValue.isBlank()) {
            return null
        }

        return cursorValue
    }

    return null
}
