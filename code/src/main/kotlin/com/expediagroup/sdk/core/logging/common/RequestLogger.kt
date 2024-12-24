/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.core.logging.common

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import java.io.IOException
import java.nio.charset.Charset
import okio.Buffer

internal object RequestLogger {
    fun log(
        logger: LoggerDecorator,
        request: Request,
        vararg tags: String,
        maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
    ) {
        try {
            val requestBodyString = request.body?.let { it.readLoggableBody(maxBodyLogSize, it.mediaType()?.charset) }

            buildString {
                append("[URL=${request.url}, Method=${request.method}, Headers=[${request.headers}], Body=[${requestBodyString}]")
            }.also {
                logger.info(it, "Outgoing", *tags)
            }

        } catch (e: Exception) {
            logger.warn("Failed to log request")
        }
    }

    @Throws(IOException::class)
    private fun RequestBody.readLoggableBody(maxBodyLogSize: Long, charset: Charset?): String {
        this.mediaType().also {
            if (it === null) {
                return "Request body of unknown media type cannot be logged"
            }

            if (!isLoggable(it)) {
                return "Request body of type ${it.fullType} cannot be logged"
            }
        }

        val buffer = Buffer().apply { writeTo(this) }
        val bytesToRead = minOf(maxBodyLogSize, buffer.size)

        return buffer.readString(bytesToRead, charset ?: Charsets.UTF_8)
    }
}
