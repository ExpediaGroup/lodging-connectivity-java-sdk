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

package com.expediagroup.sdk.core.common

import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.interceptor.Interceptor

/**
 * Interceptor for setting required headers before executing the request
 */
class RequestHeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val metadata = MetadataLoader.load()

        val request = chain.request().newBuilder()
            .setHeader("User-Agent", metadata.asUserAgentString())
            .build()

        return chain.proceed(request)
    }
}
