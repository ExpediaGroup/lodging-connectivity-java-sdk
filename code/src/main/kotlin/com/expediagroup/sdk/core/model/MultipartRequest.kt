package com.expediagroup.sdk.core.model

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest
import com.google.api.client.http.EmptyContent

abstract class MultipartRequest (
    client: AbstractGoogleJsonClient,
    operation: Operation<*>,
): AbstractGoogleJsonClientRequest<Any>(
    client,
    operation.method,
    operation.url,
    operation.requestBody,
    Any::class.java
) {
     fun setHttpContent() {
       this.buildHttpRequest().setContent(EmptyContent())
    }
}