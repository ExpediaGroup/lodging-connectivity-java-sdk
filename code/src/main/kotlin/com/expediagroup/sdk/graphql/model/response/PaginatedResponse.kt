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
import com.expediagroup.sdk.graphql.model.paging.PageInfo

/**
 * Represents a paginated response containing data of type T and a raw response of type R, which could be any implementation of Apollo's Operation.Data class.
 *
 * This interface extends the Response interface and includes an additional property:
 * - 'pageInfo': Contains information about pagination such as page size, cursor, and total count of items.
 */
interface PaginatedResponse<T, R : Operation.Data> : Response<T, R> {
    /**
     * Represents pagination information such as page size, whether there is a next page,
     * the cursor for the current page, the cursor for the next page, and the total count of items.
     */
    val pageInfo: PageInfo
}
