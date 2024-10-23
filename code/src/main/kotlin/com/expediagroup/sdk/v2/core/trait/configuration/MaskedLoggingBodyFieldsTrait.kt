package com.expediagroup.sdk.v2.core.trait.configuration

/**
 * Trait for managing the body fields that should be masked in logs.
 *
 * This trait extends `ClientConfiguration`, adding a specific method that provides
 * a set of body field names whose contents should not appear in logs.
 *
 * The `getMaskedLoggingBodyFields` method is used to define which fields in the body of
 * requests and responses should be masked for security and privacy reasons.
 */
interface MaskedLoggingBodyFieldsTrait: ClientConfiguration {
    fun getMaskedLoggingBodyFields(): Set<String>
}
