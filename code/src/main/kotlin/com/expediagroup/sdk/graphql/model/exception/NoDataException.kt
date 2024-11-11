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

package com.expediagroup.sdk.graphql.model.exception

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.model.response.Error

/**
 * An exception that is thrown when there is no data received from the server in a GraphQL execution.
 * Extends ExpediaGroupServiceException.
 * @param message An optional error message.
 * @param cause An optional cause of the error.
 * @param errors A list of GraphQL errors associated with the exception.
 */
class NoDataException(
    message: String? = null,
    cause: Throwable? = null,
    val errors: List<Error>,
) : ExpediaGroupServiceException(message, cause)
