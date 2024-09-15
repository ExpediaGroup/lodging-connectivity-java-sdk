package com.expediagroup.sdk.core.gapiclient

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.exception.ApolloNetworkException
import com.apollographql.apollo3.network.http.HttpEngine
import com.expediagroup.sdk.core.gapiclient.model.GRequest
import com.expediagroup.sdk.core.gapiclient.util.toApolloHeaders
import okio.Buffer
import kotlin.coroutines.cancellation.CancellationException


class GClientHttpEngine(
    private val gClient: GClient
) : HttpEngine {
    override fun dispose() {
    }

    override suspend fun execute(request: HttpRequest): HttpResponse =
        try {
            GRequest(
                gClient,
                graphQLRequest = request,
                responseType = Any::class.java
            ).executeUnparsed().let { response ->
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