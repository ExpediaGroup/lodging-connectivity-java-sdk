package com.expediagroup.sdk.core.client

import com.expediagroup.sdk.core.constant.HeaderKey
import com.expediagroup.sdk.core.model.Properties
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpHeaders
import java.util.UUID

interface EnvironmentProvider {
    fun HttpRequestBuilder.appendHeaders()
}

class DefaultEnvironmentProvider(
    namespace: String
) : EnvironmentProvider {
    private var properties: Map<String, String?>

    init{
        val propertiesResource = javaClass.classLoader.getResource("sdk.properties")
        properties = emptyMap()
    }

    private val javaVersion = System.getProperty("java.version")
    private val operatingSystemName = System.getProperty("os.name")
    private val operatingSystemVersion = System.getProperty("os.version")
//    private val userAgent = "expediagroup-sdk-java-$namespace/${properties["sdk-version"]!!} (Java $javaVersion; $operatingSystemName $operatingSystemVersion)"

    override fun HttpRequestBuilder.appendHeaders() {
        with(headers) {
            append(HttpHeaders.UserAgent, "")
            append(HeaderKey.X_SDK_TITLE, "")
            append(HeaderKey.TRANSACTION_ID, UUID.randomUUID().toString())
        }
    }
}
