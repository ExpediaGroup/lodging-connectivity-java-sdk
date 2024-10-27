package com.expediagroup.sdk.v2.core.model

import com.expediagroup.sdk.v2.core.configuration.SdkMetadata

/**
 * Data class representing a user agent which contains information about the Java Development Kit (JDK) version,
 * operating system, SDK namespace, and SDK version.
 *
 * @param jdkVersion the version of the Java Development Kit (JDK) being used.
 * @param operatingSystem the operating system on which the application is running.
 * @param sdkNamespace the namespace of the SDK being used.
 * @param sdkVersion the version of the SDK being used.
 */
data class UserAgent(
    val jdkVersion: String,
    val operatingSystem: String,
    val sdkNamespace: String,
    val sdkVersion: String,
) {
    constructor(
        jdkVersion: String,
        operatingSystem: String,
    ) : this(
        jdkVersion,
        operatingSystem,
        SdkMetadata.artifactId.removeSuffix("-sdk"),
        SdkMetadata.version
    )

    /**
     * Returns a string representation of the user agent.
     *
     * @return a formatted string containing the SDK namespace and version, along with the JDK version and operating system.
     */
    override fun toString(): String =
        "expediagroup-sdk-java-$sdkNamespace/$sdkVersion ($jdkVersion; $operatingSystem)"
}
