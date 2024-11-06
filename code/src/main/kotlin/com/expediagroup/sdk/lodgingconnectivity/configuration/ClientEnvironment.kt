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
     * This environment is only available for `SupplyClient`
     */
    SANDBOX_PROD,

    /**
     * Represents the sandbox version of the EG internal test/lab environment.
     *
     * This environment is only available for `SupplyClient`
     */
    SANDBOX_TEST
}
