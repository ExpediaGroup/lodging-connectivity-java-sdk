package com.expediagroup.sdk.core.logging.model

data class LogMessage(
    val title: LogMessageLine = LogMessageLine.NULL_INSTANCE,
    val body: LogMessageLines = LogMessageLines.NULL_INSTANCE,
    val tags: Set<LogMessageTag> = emptySet()
) {
    companion object {
        val NULL_INSTANCE = LogMessage(
            title = LogMessageLine.NULL_INSTANCE,
            body = LogMessageLines.NULL_INSTANCE,
            tags = emptySet()
        )
    }

    override fun toString(): String =
        StringBuilder()
            .append("ExpediaGroupSDK: \n")
            .append(title)
            .append(body)
            .toString()
}
