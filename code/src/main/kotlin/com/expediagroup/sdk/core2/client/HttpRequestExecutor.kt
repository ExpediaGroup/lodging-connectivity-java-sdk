package com.expediagroup.sdk.core2.client

import com.expediagroup.sdk.core2.http.HttpRequest
import com.expediagroup.sdk.core2.http.HttpResponse
import com.expediagroup.sdk.core2.interceptor.common.SDKInterceptor
import java.io.IOException

/**
 * Abstract class responsible for managing HTTP request execution within the SDK.
 *
 * This class acts as a wrapper around a user-provided [HttpClient], applying SDK-specific logic and governance
 * during request execution, such as handling interceptors and enforcing additional rules or transformations.
 *
 * Each SDK should implement its own version of this class to define specific behavior, such as request preprocessing,
 * applying interceptors, or handling governance rules.
 *
 * @param httpClient The user-implemented [HttpClient] responsible for executing HTTP requests.
 */
abstract class HttpRequestExecutor(val httpClient: HttpClient) {
    /**
     * The list of SDK-specific interceptors to apply during request execution.
     *
     * Interceptors can be used to modify requests, log information, handle retries, or enforce governance rules.
     */
    protected abstract val interceptors: List<SDKInterceptor>

    /**
     * Executes the given HTTP request, applying SDK-specific logic and governance.
     *
     * This method wraps the [HttpClient.execute] call, applying interceptors and other custom logic
     * before and after the actual request execution.
     *
     * @param request The [HttpRequest] to be executed.
     * @return The [HttpResponse] resulting from the execution of the request.
     * @throws IOException If an I/O error occurs during request execution.
     */
    @Throws(IOException::class)
    abstract fun execute(request: HttpRequest): HttpResponse
}
