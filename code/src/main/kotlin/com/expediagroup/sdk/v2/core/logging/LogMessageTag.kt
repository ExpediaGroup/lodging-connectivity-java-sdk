package com.expediagroup.sdk.v2.core.logging

enum class LogMessageTag(val tag: String) {
    PROGRESSING("PROGRESSING"),
    SUCCESS("SUCCESS"),
    ERROR("ERROR"),
    INCOMING("INCOMING"),
    OUTGOING("OUTGOING");

    override fun toString(): String = tag
}
