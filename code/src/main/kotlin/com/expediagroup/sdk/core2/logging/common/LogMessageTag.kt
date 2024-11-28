package com.expediagroup.sdk.core2.logging.common

/**
 * Enumeration representing the different tags available for log messages.
 *
 * @property tag The string representation of the log message tag.
 */
enum class LogMessageTag(val tag: String) {
    PROGRESSING("PROGRESSING"),
    SUCCESS("SUCCESS"),
    ERROR("ERROR"),
    INCOMING("INCOMING"),
    OUTGOING("OUTGOING");

    override fun toString(): String = tag
}
