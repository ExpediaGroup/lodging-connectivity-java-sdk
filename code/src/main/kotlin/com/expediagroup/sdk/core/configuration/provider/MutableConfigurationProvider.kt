package com.expediagroup.sdk.core.configuration.provider

interface MutableConfigurationProvider : ConfigurationProvider {
    override var name: String
    override var key: String?
    override var secret: String?
    override var endpoint: String?
    override var authEndpoint: String?
    override var requestTimeout: Long?
    override var connectionTimeout: Long?
    override var socketTimeout: Long?
    override var maskedLoggingHeaders: Set<String>?
    override var maskedLoggingBodyFields: Set<String>?
    override var maxConnTotal: Int?
    override var maxConnPerRoute: Int?

    fun toImmutable(self: MutableConfigurationProvider = this): ConfigurationProvider = object : ConfigurationProvider {
        override val name: String = self.name
        override val key: String? = self.key
        override val secret: String? = self.secret
        override val endpoint: String? = self.endpoint
        override val authEndpoint: String? = self.authEndpoint
        override val requestTimeout: Long? = self.requestTimeout
        override val connectionTimeout: Long? = self.connectionTimeout
        override val socketTimeout: Long? = self.socketTimeout
        override val maskedLoggingHeaders: Set<String>? = self.maskedLoggingHeaders
        override val maskedLoggingBodyFields: Set<String>? = self.maskedLoggingBodyFields
        override val maxConnTotal: Int? = self.maxConnTotal
        override val maxConnPerRoute: Int? = self.maxConnPerRoute
    }
}