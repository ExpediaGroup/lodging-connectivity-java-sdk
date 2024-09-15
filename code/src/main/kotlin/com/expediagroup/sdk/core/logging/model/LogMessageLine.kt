package com.expediagroup.sdk.core.logging.model

import com.expediagroup.sdk.core.constant.Constant

data class LogMessageLine(
    val head: String = "",
    val prefix: String = Constant.DOUBLE_RIGHT_ANGLE_BRACKETS + Constant.SPACE,
    val tags: Set<LogMessageTag> = emptySet(),
    val line: String = "",
    val suffix: String = "",
    val tail: String = Constant.EMPTY_STRING
) {
    companion object {
        val NULL_INSTANCE = LogMessageLine(
            head = Constant.EMPTY_STRING,
            prefix = Constant.EMPTY_STRING,
            tags = emptySet(),
            line = Constant.EMPTY_STRING,
            suffix = Constant.EMPTY_STRING,
            tail = Constant.EMPTY_STRING
        )
    }

    // TODO: refactor the double split
    fun split(delimiter: String = Constant.NEWLINE): LogMessageLines {
        return LogMessageLines().addLines {
            line.split(delimiter).map {
                LogMessageLine(
                    head = Constant.EMPTY_STRING,
                    prefix = prefix,
                    tags = tags,
                    line = it.trim(),
                    suffix = suffix,
                    tail = Constant.EMPTY_STRING,
                )
            }
        }
    }

    override fun toString(): String =
        StringBuilder()
            .append(head)
            .append(prefix)
            .append(
                when (tags.isNotEmpty()) {
                    true -> "[${tags.joinToString(Constant.COMMA_SPACE)}]" + Constant.SPACE
                    false -> Constant.EMPTY_STRING
                }
            )
            .append(line)
            .append(suffix)
            .append(tail)
            .toString()
}