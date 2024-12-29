package com.expediagroup.sdk.lodgingconnectivity.common

fun Boolean?.orFalseIfNull(): Boolean = this == true

fun String?.orNullIfBlank(): String? = this?.takeUnless { it.isBlank() }