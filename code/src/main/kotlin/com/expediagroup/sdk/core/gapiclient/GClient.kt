package com.expediagroup.sdk.core.gapiclient

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.configuration.provider.ExpediaGroupConfigurationProvider
import com.expediagroup.sdk.core.logging.mask.configureLogMasking
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest


class GClient(
    builder: GClientBuilder,
    configurationProvider: ConfigurationProvider = ExpediaGroupConfigurationProvider
) : AbstractGoogleClient(builder) {
    init {
        configureLogMasking(configurationProvider.maskedLoggingHeaders!!)
        configureLogMasking(configurationProvider.maskedLoggingBodyFields!!)
    }

    override fun initialize(httpClientRequest: AbstractGoogleClientRequest<*>?) {
        super.initialize(httpClientRequest)
    }
}