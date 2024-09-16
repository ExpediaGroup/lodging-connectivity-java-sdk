package com.expediagroup.sdk.core.logging

enum class LogMessageTag(val tag: String) {
    PROGRESSING("PROGRESSING"),
    SUCCESS("SUCCESS"),
    ERROR("ERROR"),
    INCOMING("INCOMING"),
    OUTGOING("OUTGOING");

    override fun toString(): String = tag
}
