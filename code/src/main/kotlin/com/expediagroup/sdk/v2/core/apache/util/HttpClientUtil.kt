package com.expediagroup.sdk.v2.core.apache.util

import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfigurationTrait
import com.google.api.client.http.apache.v2.ApacheHttpTransport
import org.apache.http.client.HttpClient


fun createHttpClient(configuration: ClientConfigurationTrait): HttpClient {
    // TODO: Consume configuration
    return ApacheHttpTransport.newDefaultHttpClient()
}
