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

package com.expediagroup.sdk.lodgingconnectivity.configuration

/**
 * An enumeration representing the possible environments for the API clients.
 *
 * This enum defines the different environments in which an API client can operate, including
 * production, test, and sandbox environments. It is used in the configuration to determine
 * which endpoints and settings to apply based on the environment selected.
 */
enum class ClientEnvironment {

    /**
     * Represents the production environment.
     * Clients in this environment interact with the live, production-grade API.
     */
    PROD,

    /**
     * Represents the test environment.
     * Clients in this environment interact with EG internal test/lab API.
     */
    TEST,

    /**
     * Represents the sandbox version of the production environment.
     *
     * This environment is only available for `ReservationClient`
     */
    SANDBOX_PROD,

    /**
     * Represents the sandbox version of the EG internal test/lab environment.
     *
     * This environment is only available for `ReservationClient`
     */
    SANDBOX_TEST
}
