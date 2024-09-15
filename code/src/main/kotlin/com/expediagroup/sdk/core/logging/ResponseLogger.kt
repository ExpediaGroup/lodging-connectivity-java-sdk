//package com.expediagroup.sdk.core.logging
//
//import com.expediagroup.sdk.core.gapiclient.extension.getBodyLogMessage
//import com.expediagroup.sdk.core.gapiclient.extension.getHeadersLogMessage
//import com.google.api.client.http.HttpResponse
//import com.google.api.client.http.HttpResponseInterceptor
//import org.slf4j.Logger
//
//class ResponseLogger(
//    private val logger: Logger
//): HttpResponseInterceptor {
//    override fun interceptResponse(response: HttpResponse) {
//        logger.info(response.getHeadersLogMessage().toString())
//        logger.debug(response.getBodyLogMessage().toString())
//    }
//}