/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.core.common

import java.util.Locale
import java.util.jar.Manifest

/**
 * A utility object for loading and managing application metadata.
 *
 * The `MetadataLoader` extracts metadata from the `META-INF/MANIFEST.MF` file
 * and system properties to provide detailed runtime information. This metadata
 * is used to generate a consistent and descriptive `User-Agent` string.
 *
 */
internal object MetadataLoader {

    /**
     * The artifact ID of the application, extracted from the manifest file.
     */
    val artifactId: String

    /**
     * The version of the application, extracted from the manifest file.
     */
    val version: String

    /**
     * The prefix used in the `User-Agent` string, extracted from the manifest file.
     */
    val userAgentPrefix: String

    /**
     * The version of the Java runtime in use.
     * Retrieved from the `java.version` system property.
     */
    val jdkVersion: String

    /**
     * The vendor of the Java runtime in use.
     * Retrieved from the `java.vendor` system property.
     */
    val jdkVendor: String

    /**
     * The name of the operating system.
     * Retrieved from the `os.name` system property.
     */
    val osName: String

    /**
     * The version of the operating system.
     * Retrieved from the `os.version` system property.
     */
    val osVersion: String

    /**
     * The architecture of the operating system.
     * Retrieved from the `os.arch` system property.
     */
    val arch: String

    /**
     * The default locale of the system in the format `language_COUNTRY`.
     * Retrieved from the `Locale.getDefault()` method.
     */
    val locale: String

    init {
        this::class.java.classLoader.getResourceAsStream("META-INF/MANIFEST.MF").use {
            Manifest(it).apply {
                artifactId = mainAttributes.getValue("artifactId") ?: "UnknownArtifact"
                version = mainAttributes.getValue("version") ?: "UnknownVersion"
                userAgentPrefix = mainAttributes.getValue("userAgentPrefix") ?: "SDK"
                jdkVersion = System.getProperty("java.version", "UnknownJavaVersion")
                jdkVendor = System.getProperty("java.vendor", "UnknownVendor")
                osName = System.getProperty("os.name", "UnknownOS")
                osVersion = System.getProperty("os.version", "UnknownOSVersion")
                arch = System.getProperty("os.arch", "UnknownArch")
                locale = Locale.getDefault().toString()
            }
        }
    }

    /**
     * Generates a `User-Agent` string based on the metadata and system properties.
     *
     * The `User-Agent` string contains the following information:
     * - User agent prefix and version
     * - SDK artifact ID
     * - Java version and vendor
     * - Operating system name, version, and architecture
     * - Locale information
     *
     * @return `User-Agent` string.
     */
    fun asUserAgentString(): String {
        return "$userAgentPrefix/$version (SDK/$artifactId; Java/$jdkVersion; Vendor/$jdkVendor; OS/$osName - $osVersion; Arch/$arch; Locale/$locale)"
    }
}
