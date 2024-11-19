package com.expediagroup.sdk.core2.client

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import java.io.IOException

interface HttpClient {
    @Throws(IOException::class)
    fun execute(request: HttpRequest): HttpResponse
}
