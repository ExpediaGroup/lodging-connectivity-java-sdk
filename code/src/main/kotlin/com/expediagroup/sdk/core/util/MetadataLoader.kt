package com.expediagroup.sdk.core.util

import java.util.jar.Manifest

internal object MetadataLoader {
    val artifactId: String
    val version: String
    val userAgentPrefix: String
    val jdkVersion: String
    val jdkVendor: String
    val osName: String
    val osVersion: String

    init {
        this::class.java.classLoader.getResourceAsStream("META-INF/MANIFEST.MF").use {
            Manifest(it).apply {
                artifactId = mainAttributes.getValue("artifactId")
                version = mainAttributes.getValue("version")
                userAgentPrefix = mainAttributes.getValue("userAgentPrefix")
                jdkVersion = System.getProperty("java.version")
                jdkVendor = System.getProperty("java.vendor")
                osName = System.getProperty("os.name")
                osVersion = System.getProperty("os.version")
            }
        }
    }

    fun asUserAgentString() = "$userAgentPrefix/$version ($artifactId; $jdkVendor; $jdkVersion; $osName - $osVersion)"
}
