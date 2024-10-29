package com.expediagroup.sdk.v2.core.model

import com.google.common.io.Resources
import java.io.FileInputStream
import java.util.Properties

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
    private lateinit var userAgentPrefix: String

    init {
        Resources.getResource("sdk.properties").file?.let { path ->
            Properties().apply {
                load(FileInputStream(path))
            }.also { properties ->
                userAgentPrefix = properties.getProperty("userAgentPrefix")
            }
        }
    }

    override fun toString(): String =
        "$userAgentPrefix ($jdkVersion; $operatingSystem)"
}
