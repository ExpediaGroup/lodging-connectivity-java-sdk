package com.expediagroup.sdk.core.apache5.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.google.api.client.http.apache.v5.Apache5HttpTransport

fun createApache5HttpTransport(configurationProvider: ConfigurationProvider) =
    Apache5HttpTransport(createHttpClient(configurationProvider))

fun createSingletonApache5HttpTransport(configurationProvider: ConfigurationProvider) =
    Apache5HttpTransport(createSingletonHttpClient(configurationProvider))
