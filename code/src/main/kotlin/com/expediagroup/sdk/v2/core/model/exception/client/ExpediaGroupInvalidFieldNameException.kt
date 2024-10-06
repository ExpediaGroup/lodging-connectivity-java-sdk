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
package com.expediagroup.sdk.v2.core.model.exception.client

/**
 * Thrown to indicate that one or more passed field names are invalid.
 *
 * @param invalidFields the names of the invalid fields.
 */
class ExpediaGroupInvalidFieldNameException(invalidFields: Collection<String>) :
    ExpediaGroupClientException(
        "All fields names must contain only alphanumeric characters in addition to - and _ but found [${
            invalidFields.joinToString(
                ","
            )
        }]"
    )
