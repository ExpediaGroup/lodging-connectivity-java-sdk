package com.expediagroup.sdk.core.common

import java.util.Locale
import java.util.jar.Manifest

internal object MetadataLoader {
    val artifactId: String
    val version: String
    val userAgentPrefix: String
    val jdkVersion: String
    val jdkVendor: String
    val osName: String
    val osVersion: String
    val arch: String
    val locale: String

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
                arch = System.getProperty("os.arch")
                locale = Locale.getDefault().toString()
            }
        }
    }

    fun asUserAgentString(): String {
        return "$userAgentPrefix/$version (SDK/$artifactId; Java/$jdkVersion; Vendor/$jdkVendor; OS/$osName - $osVersion; Arch/$arch; Locale/$locale)"
    }
}
