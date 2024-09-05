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

package com.expediagroup.sdk.lodgingconnectivity.filemanagement.models


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


import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * The object used the describe an error, containing both human-readable and in a machine-readable information.
 * @param type Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon.
 * @param detail A human-readable explanation of the error, specific to this error occurrence.
 */
data class GenericError(
    /* Snake cased all caps error code interpreted from the HTTP status code that can programmatically be acted upon. */
@JsonProperty("type")

    
    
    
    
    @field:Valid
    val type: kotlin.String,

    /* A human-readable explanation of the error, specific to this error occurrence. */
@JsonProperty("detail")

    
    
    
    
    @field:Valid
    val detail: kotlin.String
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var type: kotlin.String? = null,
        private var detail: kotlin.String? = null
    ) {
        fun type(type: kotlin.String) = apply { this.type = type }
        fun detail(detail: kotlin.String) = apply { this.detail = detail }

        fun build(): GenericError {
            // Check required params
            validateNullity()
            return GenericError(
                type = type!!,
                detail = detail!!
            )
        }

        private fun validateNullity() {
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
            if (detail == null) {
                throw NullPointerException("Required parameter detail is missing")
            }
        }
    }
}

