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
 * An HTTP interceptor that adds a `User-Agent` header to all outgoing requests.
 *
 * The `User-Agent` header value is generated dynamically using the `MetadataLoader`,
 * which provides detailed runtime information such as SDK name, version, Java version,
 * vendor, operating system details, and locale.
 *
 * This interceptor ensures that all requests include a descriptive `User-Agent` string
 * for better tracking, debugging, and analytics purposes.
 */
class UserAgentHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .setHeader("User-Agent", MetadataLoader.asUserAgentString())
            .build()

        return chain.proceed(request)
    }
}
