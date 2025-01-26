package com.expediagroup.sdk.lodgingconnectivity.util

fun Boolean?.orFalseIfNull(): Boolean = this == true

fun String?.orNullIfBlank(): String? = this?.takeUnless { it.isBlank() }
