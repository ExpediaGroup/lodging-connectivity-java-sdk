package com.expediagroup.sdk.loader

import com.expediagroup.sdk.transport.AsyncTransport
import java.util.ServiceLoader

object AsyncTransportLoader {
    fun load(): AsyncTransport {

        val loader = ServiceLoader.load(AsyncTransport::class.java)

        return loader.firstOrNull()
            ?: error("No AsyncTransport implementation found. Please include a valid client dependency.")
    }
}
