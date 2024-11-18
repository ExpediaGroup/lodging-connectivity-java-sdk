package com.expediagroup.sdk.core2.http

import java.net.IDN
import java.net.InetAddress
import java.net.MalformedURLException
import java.net.URI
import java.net.URISyntaxException
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Locale

/**
 * Represents an immutable URL with proper encoding and parsing.
 *
 * The [Url] class provides functionality for creating, validating, and manipulating URLs. It ensures that
 * URLs are correctly encoded, parsed, and represented as standardized strings or objects like [URI] and [URL].
 *
 * Instances of [Url] are immutable and must be created using the [Builder] or the [parse] method.
 */
class Url private constructor(
    private val scheme: String,
    private val userInfo: String?,
    private val host: String,
    private val port: Int,
    private val encodedPath: String,
    private val encodedQuery: String?,
    private val fragment: String?
) {

    /**
     * Returns the URL as a properly formatted string.
     * The string representation includes the scheme, user info, host, port, path, query, and fragment.
     */
    override fun toString(): String = buildString {
        append(scheme)
        append("://")
        if (userInfo != null) {
            append(userInfo)
            append("@")
        }
        append(hostToString(host))
        if (port != defaultPort(scheme)) {
            append(":")
            append(port)
        }
        append(encodedPath)
        if (encodedQuery != null) {
            append("?")
            append(encodedQuery)
        }
        if (fragment != null) {
            append("#")
            append(fragment)
        }
    }

    /**
     * Converts the URL to a [URI] object.
     *
     * @return A [URI] representation of the URL.
     * @throws URISyntaxException
     */
    @Throws(URISyntaxException::class)
    fun toUri(): URI = URI(
        scheme,
        userInfo,
        host,
        if (port != defaultPort(scheme)) port else -1,
        encodedPath,
        encodedQuery,
        fragment
    )

    /**
     * Converts the URL to a [URL] object.
     *
     * @return A [URL] representation of the URL.
     * @throws MalformedURLException
     */
    @Throws(MalformedURLException::class)
    fun toUrl(): URL = toUri().toURL()

    /**
     * Builder for creating and constructing [Url] instances.
     *
     * The [Builder] class provides a fluent API for incrementally specifying the components of a URL, such as
     * the scheme, host, port, path segments, query parameters, and fragment. It ensures that all components
     * are properly validated and encoded.
     */
    class Builder {
        private var scheme: String? = null
        private var userInfo: String? = null
        private var host: String? = null
        private var port: Int? = null
        private val pathSegments: MutableList<String> = mutableListOf()
        private val queryParameters: MutableList<Pair<String, String?>> = mutableListOf()
        private var fragment: String? = null

        /**
         * Sets the URL scheme (e.g., "http", "https").
         *
         * @param scheme The scheme to use for the URL.
         * @return The [Builder] instance for chaining.
         * @throws IllegalArgumentException If the scheme is invalid.
         */
        fun scheme(scheme: String) = apply {
            require(scheme.matches(Regex("^[a-zA-Z][a-zA-Z0-9+\\-.]*$"))) {
                "Invalid URL scheme: $scheme"
            }
            this.scheme = scheme.lowercase(Locale.US)
        }

        /**
         * Sets the user info (e.g., "user:password").
         *
         * @param userInfo The user info to include in the URL.
         * @return The [Builder] instance for chaining.
         */
        fun userInfo(userInfo: String) = apply {
            this.userInfo = userInfo
        }

        /**
         * Sets the host of the URL.
         *
         * @param host The hostname or IP address.
         * @return The [Builder] instance for chaining.
         * @throws IllegalArgumentException If the host is invalid.
         */
        fun host(host: String) = apply {
            require(isValidHost(host)) { "Invalid host: $host" }
            this.host = host
        }

        /**
         * Sets the port of the URL.
         *
         * @param port The port number.
         * @return The [Builder] instance for chaining.
         * @throws IllegalArgumentException If the port is out of range (1–65535).
         */
        fun port(port: Int) = apply {
            require(port in 1..65535) { "Invalid port: $port" }
            this.port = port
        }

        /**
         * Adds a path segment to the URL.
         *
         * @param segment The path segment to add.
         * @return The [Builder] instance for chaining.
         */
        fun addPathSegment(segment: String) = apply {
            pathSegments.add(encodePathSegment(segment))
        }

        /**
         * Adds a query parameter to the URL.
         *
         * @param name The query parameter name.
         * @param value The query parameter value.
         * @return The [Builder] instance for chaining.
         */
        fun addQueryParameter(name: String, value: String) = apply {
            queryParameters.add(encodeQueryParameter(name) to encodeQueryParameter(value))
        }

        /**
         * Sets the fragment of the URL.
         *
         * @param fragment The fragment identifier.
         * @return The [Builder] instance for chaining.
         */
        fun fragment(fragment: String) = apply {
            this.fragment = encodeFragment(fragment)
        }

        /**
         * Builds and returns a new [Url] instance.
         *
         * @return The constructed [Url].
         * @throws IllegalStateException If required components (e.g., scheme or host) are missing.
         */
        fun build(): Url {
            val scheme = this.scheme ?: throw IllegalStateException("Scheme is required.")
            val host = this.host ?: throw IllegalStateException("Host is required.")
            val port = this.port ?: defaultPort(scheme)
            val encodedPath = buildEncodedPath()
            val encodedQuery = buildEncodedQuery()
            return Url(
                scheme,
                userInfo,
                host,
                port,
                encodedPath,
                encodedQuery,
                fragment
            )
        }

        private fun buildEncodedPath(): String {
            return if (pathSegments.isEmpty()) {
                "/"
            } else {
                pathSegments.joinToString("/", prefix = "/")
            }
        }

        private fun buildEncodedQuery(): String? {
            return if (queryParameters.isEmpty()) {
                null
            } else {
                queryParameters.joinToString("&") { (name, value) ->
                    if (value != null) "$name=$value" else name
                }
            }
        }

        private fun encodePathSegment(segment: String): String {
            return URLEncoder.encode(segment, StandardCharsets.UTF_8.name())
                .replace("+", "%20")
                .replace("%2F", "/")
        }

        private fun encodeQueryParameter(value: String): String {
            return value.let {
                URLEncoder.encode(it, StandardCharsets.UTF_8.name())
                    .replace("+", "%20")
            }
        }

        private fun encodeFragment(fragment: String): String {
            return URLEncoder.encode(fragment, StandardCharsets.UTF_8.name())
                .replace("+", "%20")
        }

        private fun isValidHost(host: String): Boolean {
            return try {
                val idnHost = IDN.toASCII(host)
                InetAddress.getByName(idnHost)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    companion object {
        /**
         * Parses a URL string into an [Url] instance.
         *
         * This method parses the given string, extracting and validating its components (e.g., scheme, host, port, path).
         *
         * @param url The URL string to parse.
         * @return A [Url] instance representing the parsed URL, or `null` if the URL is invalid.
         * @throws URISyntaxException If the URL cannot be parsed due to syntax issues.
         */
        @Throws(URISyntaxException::class)
        fun parse(url: String): Url? {
            val uri = URI(url)
            val scheme = uri.scheme ?: return null
            val host = uri.host ?: return null
            val port = if (uri.port != -1) uri.port else defaultPort(scheme)
            val userInfo = uri.userInfo
            val encodedPath = if (uri.rawPath != null && uri.rawPath.isNotEmpty()) uri.rawPath else "/"
            val encodedQuery = uri.rawQuery
            val fragment = uri.rawFragment

            return Url(
                scheme = scheme,
                userInfo = userInfo,
                host = host,
                port = port,
                encodedPath = encodedPath,
                encodedQuery = encodedQuery,
                fragment = fragment
            )
        }

        /**
         * Returns the default port for a given scheme.
         *
         * @param scheme The URL scheme (e.g., "http", "https").
         * @return The default port for the scheme, or -1 if unknown.
         */
        private fun defaultPort(scheme: String): Int {
            return when (scheme.lowercase(Locale.US)) {
                "http" -> 80
                "https" -> 443
                else -> -1
            }
        }

        /**
         * Converts the host string to its proper string representation.
         *
         * @param host The hostname or IP address.
         * @return The string representation of the host, with IPv6 addresses enclosed in brackets.
         */
        private fun hostToString(host: String): String {
            return if (host.contains(":") && !host.startsWith("[")) {
                "[$host]" // Enclose IPv6 addresses in brackets
            } else {
                host
            }
        }
    }
}
