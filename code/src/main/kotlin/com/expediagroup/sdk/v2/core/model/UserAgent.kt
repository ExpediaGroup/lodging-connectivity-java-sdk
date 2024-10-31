package com.expediagroup.sdk.v2.core.model

import com.expediagroup.sdk.v2.core.configuration.SdkMetadata

/**
 * Data class representing a user agent which contains information about the Java Development Kit (JDK) version,
 * operating system, SDK namespace, and SDK version.
 *
 * @param jdkVersion the version of the Java Development Kit (JDK) being used.
 * @param operatingSystem the operating system on which the application is running.
 */
data class UserAgent(
    val jdkVersion: String,
    val operatingSystem: String,
) {
    private val userAgentPrefix: String = SdkMetadata.getUserAgentPrefix()
    private val version: String = SdkMetadata.getVersion()

    override fun toString(): String =
        "$userAgentPrefix/$version ($jdkVersion; $operatingSystem)"
}
