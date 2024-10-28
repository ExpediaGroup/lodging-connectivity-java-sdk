package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

import java.util.Optional

fun Optional<String>.orNullIfBlank(): String? = this.orElse(null)?.takeUnless { it.isBlank() }
