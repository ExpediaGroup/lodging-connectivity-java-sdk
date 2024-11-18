package com.expediagroup.sdk.core2.http;

/**
 * Enumeration of HTTP protocols.
 */
enum class Protocol {
    HTTP_1_0,
    HTTP_1_1,
    HTTP_2,
    H2_PRIOR_KNOWLEDGE,
    QUIC;

    companion object {
        /**
         * Parses a protocol string to a [Protocol] enum.
         */
        fun get(protocol: String): Protocol = when (protocol.uppercase()) {
            "HTTP/1.0" -> HTTP_1_0
            "HTTP/1.1" -> HTTP_1_1
            "HTTP/2", "HTTP/2.0" -> HTTP_2
            "H2_PRIOR_KNOWLEDGE" -> H2_PRIOR_KNOWLEDGE
            "QUIC" -> QUIC
            else -> throw IllegalArgumentException("Unexpected protocol: $protocol")
        }
    }

    override fun toString(): String = when (this) {
        HTTP_1_0 -> "http/1.0"
        HTTP_1_1 -> "http/1.1"
        HTTP_2 -> "http/2"
        H2_PRIOR_KNOWLEDGE -> "h2_prior_knowledge"
        QUIC -> "quic"
    }
}
