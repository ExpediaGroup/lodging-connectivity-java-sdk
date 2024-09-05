package com.expediagroup.sdk.core.gapiclient

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient
import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory


class GJsonHttpClient(builder: GJsonClientBuilder) : AbstractGoogleJsonClient(builder) {
//    companion object {
//        class Builder private constructor(
//            private var transport: HttpTransport? = null,
//            private var jsonFactory: JsonFactory? = null
//        ) {
//            private var rootUrl: GenericUrl? = null
//            private var initializer: HttpRequestInitializer? = null
//            private var servicePath: String? = null
//            private var namespace: String? = null
//            private var builder: GJsonClientBuilder? = null
//
//            companion object {
//                @JvmStatic
//                fun newInstance(transport: HttpTransport, jsonFactory: JsonFactory): Builder {
//                    return Builder(
//                        transport = transport,
//                        jsonFactory = jsonFactory
//                    )
//                }
//            }
//
//            init {
//                builder = GJsonClientBuilder(
//                    transport = transport!!,
//                    jsonFactory = jsonFactory!!,
//                    rootUrl = rootUrl ?: GenericUrl(),
//                    servicePath = servicePath ?: "",
//                    requestInitializer = initializer,
//                    namespace = namespace!!
//                )
//            }
//
//            fun setRootUrl(rootUrl: GenericUrl): Builder {
//                this.rootUrl = rootUrl
//                return this
//            }
//
//            fun setInitializer(initializer: HttpRequestInitializer): Builder {
//                this.initializer = initializer
//                return this
//            }
//
//            fun setServicePath(servicePath: String): Builder {
//                this.servicePath = servicePath
//                return this
//            }
//
//            fun build(): GJsonHttpClient {
//                builder!!.let { builder ->
//                    servicePath?.let {
//                        builder.servicePath = it
//                    }
//
//                    rootUrl?.let {
//                        builder.rootUrl = it.build()
//                    }
//
//                    initializer?.let {
//                        builder.httpRequestInitializer = it
//                    }
//
//                    namespace?.let {
//                        builder.applicationName = it
//                    }
//                }
//
//                return GJsonHttpClient(builder!!)
//            }
//        }
//    }
}