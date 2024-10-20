/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.v2.core.logging

import com.expediagroup.sdk.v2.core.constant.Constant
import com.expediagroup.sdk.v2.core.constant.LoggingMessage.LOGGING_PREFIX
import com.expediagroup.sdk.v2.core.logging.mask.maskLogs
import org.slf4j.Logger

/**
 * The ExpediaGroupLogger class is a decorator for the Logger interface that enhances log messages
 * with additional formatting and tagging functionality.
 *
 * @param logger The underlying Logger instance to delegate logging actions to.
 */
internal class ExpediaGroupLogger(private val logger: Logger) : Logger by logger {
    override fun info(msg: String) = logger.info(decorate(msg))

    fun info(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.info(decorate(msg, tags))

    override fun warn(msg: String) = logger.warn(decorate(msg))

    fun warn(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.warn(decorate(msg, tags))

    override fun debug(msg: String) = logger.debug(decorate(msg))

    fun debug(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.debug(decorate(msg, tags))

    override fun error(msg: String) = logger.error(decorate(msg))

    fun error(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.error(decorate(msg, tags))

    /**
     * Normalizes a log message by applying specific formatting and tagging.
     *
     * @param msg The log message to normalize.
     * @param tags A set of tags to include in the normalized message.
     * @return A formatted and tagged log message.
     */
    private fun normalize(msg: String, tags: Set<LogMessageTag> = emptySet()): String =
        buildList {
            maskLogs(msg).trim().split(Constant.NEWLINE).forEach { line ->
                tags.joinToString(Constant.COMMA_SPACE).let { tagsPrefix ->
                    if (tagsPrefix.isNotBlank()) "[$tagsPrefix]" else ""
                }.also {
                    add("${Constant.DOUBLE_RIGHT_ANGLE_BRACKETS} $it $line".trim())
                }
            }
        }.joinToString(Constant.NEWLINE)

    /**
     * Decorates a log message by prefixing it with a logging prefix and normalizing its format using provided tags.
     *
     * @param msg The message to be decorated.
     * @param tags A set of tags to include in the decorated message. Defaults to an empty set.
     * @return The decorated log message with the logging prefix and normalized format.
     */
    private fun decorate(msg: String, tags: Set<LogMessageTag> = emptySet()): String = "$LOGGING_PREFIX\n${normalize(msg, tags)}".trim()
}
