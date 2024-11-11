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

package com.expediagroup.sdk.graphql.model.response

import com.apollographql.apollo.api.Operation

/**
 * Represents a raw response object containing data of type T and an optional list of errors.
 *
 * @param T The type of data included in the raw response.
 * @property data The main data payload of type T.
 * @property errors An optional list of Error objects indicating any errors in the response.
 */
open class RawResponse<T : Operation.Data>(
    val data: T,
    val errors: List<Error>?
)
