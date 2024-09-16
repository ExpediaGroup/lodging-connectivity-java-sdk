package com.expediagroup.sdk.core.logging.model

import com.expediagroup.sdk.core.constant.Constant

data class LogMessageLines(
    private val lines: Iterable<LogMessageLine> = emptyList(),
    private val separator: String = Constant.NEWLINE
) {
    companion object {
        val NULL_INSTANCE = LogMessageLines(
            lines = emptyList(),
            separator = Constant.EMPTY_STRING
        )
    }

    override fun toString(): String =
        lines.joinToString(separator = separator)

    fun addLine(line: LogMessageLine): LogMessageLines =
        LogMessageLines(
            lines = lines.plus(line),
            separator = separator
        )

    fun addLines(lines: Iterable<LogMessageLine>): LogMessageLines =
        LogMessageLines(
            lines = lines.plus(lines),
            separator = separator
        )

    fun addLine(block: () -> LogMessageLine): LogMessageLines =
        addLine(block())

    fun addLines(block: () -> Iterable<LogMessageLine>): LogMessageLines =
        addLines(block())


}
