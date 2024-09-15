package com.expediagroup.sdk.core.logging.model

enum class LogMessageTag(val tag: String) {
    INCOMING("INCOMING"),
    OUTGOING("OUTGOING");

    override fun toString(): String = tag
}