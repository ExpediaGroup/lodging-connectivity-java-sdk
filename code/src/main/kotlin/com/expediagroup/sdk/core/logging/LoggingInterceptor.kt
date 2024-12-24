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

package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor
import com.expediagroup.sdk.core.logging.common.Constant.DEFAULT_MAX_BODY_SIZE
import com.expediagroup.sdk.core.logging.common.LoggerDecorator
import com.expediagroup.sdk.core.logging.common.RequestLogger
import com.expediagroup.sdk.core.logging.common.ResponseLogger
import java.io.IOException
import okio.Buffer
import org.slf4j.LoggerFactory

/**
 * An interceptor that logs HTTP requests and responses.
 *
 * @param maxBodyLogSize The maximum size of the request/response body to log. Defaults to 1MB.
 */
class LoggingInterceptor(
    private val maxBodyLogSize: Long = DEFAULT_MAX_BODY_SIZE
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        var reusableRequest: Request = request

        request.body?.let {
            reusableRequest = reusableRequest.newBuilder()
                .body(it.snapshot())
                .build()
        }

        RequestLogger.log(logger, reusableRequest, maxBodyLogSize = maxBodyLogSize)

        val response = chain.proceed(reusableRequest)

        ResponseLogger.log(logger, response, maxBodyLogSize = maxBodyLogSize)

        return response
    }

    private fun RequestBody.snapshot(): RequestBody {
        val buffer = Buffer().apply { use { writeTo(this) } }

        return RequestBody.create(
            byteString = buffer.snapshot(),
            mediaType = this.mediaType(),
            contentLength = this.contentLength()
        )
    }

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
