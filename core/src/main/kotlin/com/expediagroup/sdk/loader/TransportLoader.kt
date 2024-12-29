package com.expediagroup.sdk.loader

import com.expediagroup.sdk.client.Transport
import java.util.ServiceLoader

object TransportLoader {
    fun load(): Transport {

        val loader = ServiceLoader.load(Transport::class.java)

        return loader.firstOrNull()
            ?: error("No Transport implementation found. Please include a valid client dependency.")
    }
}
