package com.expediagroup.sdk.core.logging.model

data class LogMessage(
    val title: LogMessageLine = LogMessageLine.NULL_INSTANCE,
    val body: LogMessageLines = LogMessageLines.NULL_INSTANCE,
    val tags: Set<LogMessageTag> = emptySet()
) {
    constructor(
        body: String,
        tags: Set<LogMessageTag> = emptySet()
    ) : this(
        title = LogMessageLine.NULL_INSTANCE,
        body = LogMessageLines().addLine { LogMessageLine(line = body, tags = tags) },
        tags = tags
    )

    constructor(body: LogMessageLine): this(
        title = LogMessageLine.NULL_INSTANCE,
        body = LogMessageLines().addLine(body),
        tags = body.tags
    )

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
