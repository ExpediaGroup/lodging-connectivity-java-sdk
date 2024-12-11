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
import java.util.Properties

/**
 * A utility object that scans the classpath for `sdk.properties` file.
 */
internal object MetadataLoader {
    val artifactName: String
    val groupId: String
    val version: String
    val jdkVersion: String
    val jdkVendor: String
    val osName: String
    val osVersion: String
    val arch: String
    val locale: String

    const val UNKNOWN = "unknown"

    init {
        val props = Properties()

        this::class.java.classLoader.getResourceAsStream("sdk.properties")?.use {
            props.load(it)
        }

        artifactName = props.getProperty("artifactName", UNKNOWN)
        groupId = props.getProperty("groupId", UNKNOWN)
        version = props.getProperty("version", UNKNOWN)
        jdkVersion = System.getProperty("java.version", UNKNOWN)
        jdkVendor = System.getProperty("java.vendor", UNKNOWN)
        osName = System.getProperty("os.name", UNKNOWN)
        osVersion = System.getProperty("os.version", UNKNOWN)
        arch = System.getProperty("os.arch", UNKNOWN)
        locale = Locale.getDefault().toString()
    }

    /**
     * Builds a `User-Agent` string from the loaded metadata.
     *
     * Format:
     * `userAgentPrefix/version (Provider/artifactId; Java/jdkVersion; Vendor/jdkVendor; OS/osName - osVersion; Arch/arch; Locale/locale)`
     */
    fun asUserAgentString(): String {
        return "$artifactName/$version (Provider/$groupId; Java/$jdkVersion; Vendor/$jdkVendor; OS/$osName - $osVersion; Arch/$arch; Locale/$locale)"
    }
}
