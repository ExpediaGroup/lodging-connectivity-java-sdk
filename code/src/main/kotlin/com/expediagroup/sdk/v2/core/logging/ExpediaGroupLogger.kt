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

import com.expediagroup.sdk.core.constant.Constant
import com.expediagroup.sdk.core.constant.LoggingMessage.LOGGING_PREFIX
import com.expediagroup.sdk.core.logging.mask.maskLogs
import org.slf4j.Logger

internal class ExpediaGroupLogger(private val logger: Logger) : Logger by logger {
    override fun info(msg: String) = logger.info(decorate(msg))

    fun info(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.info(decorate(msg, tags))

    override fun warn(msg: String) = logger.warn(decorate(msg))

    fun warn(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.warn(decorate(msg, tags))

    override fun debug(msg: String) = logger.debug(decorate(msg))

    fun debug(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.debug(decorate(msg, tags))

    override fun error(msg: String) = logger.error(decorate(msg))

    fun error(msg: String, tags: Set<LogMessageTag> = emptySet()) = logger.error(decorate(msg, tags))

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

    private fun decorate(msg: String, tags: Set<LogMessageTag> = emptySet()): String = "$LOGGING_PREFIX\n${normalize(msg, tags)}".trim()
}
