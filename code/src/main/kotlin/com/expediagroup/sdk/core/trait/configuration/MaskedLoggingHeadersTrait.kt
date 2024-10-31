package com.expediagroup.sdk.core.trait.configuration

/**
 * Trait for managing the headers that should be masked in logs.
 *
 * This trait extends `ClientConfiguration`, adding a specific method to provide
 * a set of HTTP header names whose values should not appear in logs.
 *
 * The `getMaskedLoggingHeaders` method allows specifying headers that need
 * to be masked for security and privacy reasons.
 */
interface MaskedLoggingHeadersTrait: ClientConfiguration {
    fun getMaskedLoggingHeaders(): Set<String>
}
