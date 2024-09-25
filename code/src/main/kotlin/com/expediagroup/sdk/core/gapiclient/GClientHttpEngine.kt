package com.expediagroup.sdk.core.gapiclient

import com.apollographql.apollo.api.http.HttpRequest
import com.apollographql.apollo.api.http.HttpResponse
import com.apollographql.apollo.exception.ApolloNetworkException
import com.apollographql.apollo.network.http.HttpEngine
import com.expediagroup.sdk.core.gapiclient.model.GRequest
import com.expediagroup.sdk.core.gapiclient.util.toApolloHeaders
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException


class GClientHttpEngine(
    private val gClient: GClient
) : HttpEngine {
    override fun close() {
        super.close()
    }

    override suspend fun execute(request: HttpRequest): HttpResponse =
        try {
            GRequest(
                gClient,
                graphQLRequest = request,
                responseType = Any::class.java
            ).executeUnparsed().let { response ->
                if (!response.isSuccessStatusCode) {
                    throw ExpediaGroupServiceException(
                        message = response.statusMessage
                    )
                }

                HttpResponse.Builder(statusCode = response.statusCode).apply {
                    body(Buffer().readFrom(response.content))
                    headers(response.headers.toApolloHeaders())
                }.build()
            }
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            throw ApolloNetworkException(t.message, t)
        }
}
