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
 * Represents a response object that contains data of type T and a raw response of type R could be any implementation of Apollo's Operation.Data class.
 *
 * This interface includes two properties:
 * - `data`: The main data payload of type T.
 * - `rawResponse`: The raw response object of type R.
 *
 * @param T The type of data contained in the response.
 * @param R The type of the raw response object.
 */
interface Response<T, R : Operation.Data> {
    /**
     * Represents the main data payload within a response. The type T represents the data contained in the response.
     */
    val data: T

    /**
     * Represents a raw response object containing data of type R and an optional list of errors.
     */
    val rawResponse: RawResponse<R>
}
