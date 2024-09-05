package com.expediagroup.sdk.core.v2.constant

import com.expediagroup.sdk.core.configuration.ClientConfiguration
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration

val DEFAULT_CLIENT_CONFIGURATION: ClientConfiguration = ExpediaGroupClientConfiguration.builder()
//    .requestTimeout()
    .build()