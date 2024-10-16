package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.configuration.ExpediaGroupDefaultClientConfiguration
import com.expediagroup.sdk.v2.core.logging.mask.configureLogMasking
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingBodyFieldsTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingHeadersTrait
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest


class ApiClient(
    builder: ApiClientBuilder,
    configuration: ClientConfiguration = ExpediaGroupDefaultClientConfiguration
) : AbstractGoogleClient(builder) {
    init {
        require(configuration is MaskedLoggingHeadersTrait)
        require(configuration is MaskedLoggingBodyFieldsTrait)

        configureLogMasking((configuration as MaskedLoggingHeadersTrait).getMaskedLoggingHeaders())
        configureLogMasking((configuration as MaskedLoggingBodyFieldsTrait).getMaskedLoggingBodyFields())
    }

    override fun initialize(httpClientRequest: AbstractGoogleClientRequest<*>?) {
        super.initialize(httpClientRequest)
    }
}