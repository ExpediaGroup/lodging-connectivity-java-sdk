package com.expediagroup.sdk.v2.core.trait.configuration

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
