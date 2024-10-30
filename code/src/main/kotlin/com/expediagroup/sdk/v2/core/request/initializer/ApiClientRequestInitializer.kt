package com.expediagroup.sdk.v2.core.request.initializer

import com.expediagroup.sdk.v2.core.model.UserAgent
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer

/**
 * Initializes API client requests with default settings.
 *
 * This class extends `CommonGoogleClientRequestInitializer` and provides
 * a mechanism for setting up default initialization parameters for API client requests.
 *
 * @constructor Creates an instance of `DefaultApiClientRequestInitializer` with a provided builder.
 *
 * @param builder The builder used to construct the `DefaultApiClientRequestInitializer` instance.
 */
class ApiClientRequestInitializer(
    builder: Builder
) : CommonGoogleClientRequestInitializer(builder) {
    companion object {
        /**
         * Provides a default instance of `DefaultApiClientRequestInitializer` using the internal builder.
         *
         * This method creates a new instance of `Builder` and uses it to construct and return a
         * `DefaultApiClientRequestInitializer` object. It serves as the standard way to obtain
         * a pre-configured request initializer for API client requests.
         *
         * @return A default instance of `DefaultApiClientRequestInitializer` configured with the default builder settings.
         */
        @JvmStatic
        fun default(): ApiClientRequestInitializer {
            val builder = Builder()
            return ApiClientRequestInitializer(builder)
        }

        /**
         * A builder class for creating instances of `DefaultApiClientRequestInitializer`.
         *
         * This class extends `CommonGoogleClientRequestInitializer.Builder` and overrides the `build` method
         * to return a `DefaultApiClientRequestInitializer` with the current builder instance as a parameter.
         */
        class Builder : CommonGoogleClientRequestInitializer.Builder() {
            override fun build(): ApiClientRequestInitializer {
                return ApiClientRequestInitializer(this)
            }
        }
    }

    /**
     * Initializes the provided Google client request.
     *
     *@param request The Google client request to be initialized.
     */
    override fun initialize(request: AbstractGoogleClientRequest<*>) {
        super.initialize(request)
        overrideUserAgent(request)
    }

    /**
     * Overrides the user agent in the provided Google client request with a custom user agent string.
     *
     * @param request The Google client request whose user agent will be overridden.
     */
    private fun overrideUserAgent(request: AbstractGoogleClientRequest<*>) {
        val (jdk, _, os) = request.requestHeaders.getFirstHeaderStringValue("x-goog-api-client")
            .split(" ")

        request.requestHeaders.userAgent = UserAgent(
            jdkVersion = jdk,
            operatingSystem = os
        ).toString()
    }
}
