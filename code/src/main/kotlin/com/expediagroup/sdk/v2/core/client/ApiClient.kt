package com.expediagroup.sdk.v2.core.client

import com.expediagroup.sdk.v2.core.configuration.ExpediaGroupDefaultClientConfiguration
import com.expediagroup.sdk.v2.core.logging.mask.configureLogMasking
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingBodyFieldsTrait
import com.expediagroup.sdk.v2.core.trait.configuration.MaskedLoggingHeadersTrait
import com.google.api.client.googleapis.services.AbstractGoogleClient
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest


/**
 * ApiClient class is responsible for making API requests using an extended Google API client.
 *
 * @param builder The ApiClientBuilder instance used for building the API client.
 * @param configuration The client configuration implementing `ClientConfiguration`.
 *
 * The ApiClient utilizes the provided builder to initialize and configure the API client. It ensures that
 * the given configuration adheres to both `MaskedLoggingHeadersTrait` and `MaskedLoggingBodyFieldsTrait`.
 * It configures log masking for the headers and body fields as specified by these traits.
 */
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

    /**
     * Initializes the given HTTP client request with additional configurations.
     *
     * @param httpClientRequest The HTTP client request to be initialized.
     *                          It can be an instance of `AbstractGoogleClientRequest`.
     */
    override fun initialize(httpClientRequest: AbstractGoogleClientRequest<*>?) {
        super.initialize(httpClientRequest)
    }
}
