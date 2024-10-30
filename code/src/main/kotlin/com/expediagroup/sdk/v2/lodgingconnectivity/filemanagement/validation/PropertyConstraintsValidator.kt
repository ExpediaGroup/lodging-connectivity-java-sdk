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


package com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.validation

import com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.models.exception.PropertyConstraintViolation
import com.expediagroup.sdk.v2.lodgingconnectivity.filemanagement.models.exception.PropertyConstraintViolationException
import javax.validation.ConstraintViolation
import javax.validation.Validation
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import java.util.stream.Collectors

internal object PropertyConstraintsValidator {
    fun validateConstraints(obj: Any?) {
        obj?.let {
            Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(ParameterMessageInterpolator())
                .buildValidatorFactory().use { factory ->
                    val violations = factory.validator.validate(obj)
                    if (violations.isNotEmpty()) {
                        throw PropertyConstraintViolationException(
                            "Some field constraints have been violated",
                            violations.stream().map { toConstraintViolation(it) }.collect(Collectors.toList())
                        )
                    }
                }
        }
    }

    private fun toConstraintViolation(violation: ConstraintViolation<*>): PropertyConstraintViolation {
        return PropertyConstraintViolation(
            violation.propertyPath.iterator().next().name,
            violation.propertyPath.toString(),
            violation.message
        )
    }
}
