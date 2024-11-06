package com.expediagroup.sdk.core.trait.configuration

/**
 * Interface representing a full configuration trait which amalgamates
 * various individual configuration traits required for client configuration.
 *
 * This interface extends the following traits:
 * - `KeyTrait`: Provides access to the client's key.
 * - `SecretTrait`: Provides access to the client's secret.
 * - `EndpointTrait`: Provides access to the endpoint.
 * - `AuthEndpointTrait`: Provides access to the authentication endpoint.
 * - `MaskedLoggingHeadersTrait`: Provides headers that should be masked in logs.
 * - `MaskedLoggingBodyFieldsTrait`: Provides body fields that should be masked in logs.
 * - `RequestTimeoutTrait`: Provides the request timeout duration.
 * - `SocketTimeoutTrait`: Provides the socket timeout duration.
 * - `ConnectionTimeoutTrait`: Provides the connection timeout duration.
 * - `AuthenticationStrategyTrait`: Provides the authentication strategy to be used.
 * - `MaxConnectionsTotalTrait`: Provides the maximum number of total connections allowed.
 * - `MaxConnectionsPerRouteTrait`: Provides the maximum number of connections allowed per route.
 */
interface FullConfigurationTrait :
        KeyTrait,
        SecretTrait,
        EndpointTrait,
        AuthEndpointTrait,
        MaskedLoggingHeadersTrait,
        MaskedLoggingBodyFieldsTrait,
        RequestTimeoutTrait,
        SocketTimeoutTrait,
        ConnectionTimeoutTrait,
        AuthenticationStrategyTrait,
        MaxConnectionsTotalTrait,
        MaxConnectionsPerRouteTrait
