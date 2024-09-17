package com.expediagroup.sdk.v2.core.gapiclient

import com.expediagroup.sdk.v2.core.configuration.ExpediaGroupDefaultClientConfiguration
import com.expediagroup.sdk.v2.core.logging.mask.configureLogMasking
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingBodyFieldsTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingHeadersTrait
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest


class GClient(
    builder: GClientBuilder,
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