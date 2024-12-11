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
 * A model representing all loaded metadata about the running environment and artifact.
 */
data class Metadata(
    val groupId: String,
    val artifactId: String,
    val version: String,
    val jdkVersion: String,
    val jdkVendor: String,
    val osName: String,
    val osVersion: String,
    val arch: String,
    val locale: String
) {
    /**
     * Generates a `User-Agent` string based on the metadata.
     *
     * Format:
     * `artifactId/version (Provider/groupId; Java/jdkVersion; Vendor/jdkVendor; OS/osName - osVersion; Arch/arch; Locale/locale)`
     */
    fun asUserAgentString(): String {
        return "$artifactId/$version (Provider/$groupId; Java/$jdkVersion; Vendor/$jdkVendor; OS/$osName - $osVersion; Arch/$arch; Locale/$locale)"
    }
}

/**
 * A utility object for finding and loading metadata from manifests.
 *
 * The `MetadataLoader` scans the classpath for `META-INF/MANIFEST.MF` files and tries to find a manifest
 * with an artifactId that matches the given argument. If found, it stores a single [Metadata] instance.
 *
 * Subsequent calls to [MetadataLoader.load] will return the same [Metadata] instance without reloading.
 */
internal object MetadataLoader {

    private const val ARTIFACT_ID = "artifactId"
    private const val VERSION = "version"
    private const val GROUP_ID = "groupId"
    private const val UNKNOWN = "unknown"

    @Volatile
    private var metadata: Metadata? = null

    /**
     * Attempts to find a `META-INF/MANIFEST.MF` on the classpath that has a matching `artifactId`.
     * If found, sets and returns a [Metadata] instance with loaded values. Otherwise, returns a default [Metadata]
     * with unknown values.
     *
     * If `initialize` has already been called before, it returns the previously stored [Metadata].
     *
     * @param targetArtifactId The artifactId to look for in the searched manifests files.
     * @return A [Metadata] instance representing the found attributes or defaults if none found.
     */
    fun load(targetArtifactId: String): Metadata {
        metadata?.let { return it }

        synchronized(this) {
            val attributes = loadManifestAttributes(targetArtifactId) ?: emptyMap()

            val artifactId = attributes[ARTIFACT_ID] ?: UNKNOWN
            val version = attributes[VERSION] ?: UNKNOWN
            val groupId = attributes[GROUP_ID] ?: UNKNOWN

            return Metadata(
                groupId = groupId,
                artifactId = artifactId,
                version = version,
                jdkVersion = System.getProperty("java.version", UNKNOWN),
                jdkVendor = System.getProperty("java.vendor", UNKNOWN),
                osName = System.getProperty("os.name", UNKNOWN),
                osVersion = System.getProperty("os.version", UNKNOWN),
                arch = System.getProperty("os.arch", UNKNOWN),
                locale = Locale.getDefault().toString()
            ).apply { metadata = this }
        }
    }

    /**
     * Loads all `META-INF/MANIFEST.MF` resources and returns attributes from the first one that matches
     * the requested artifactId.
     *
     * @param targetArtifactId The artifactId to look for.
     * @return A map of attributes if a suitable manifest is found, or `null` otherwise.
     */
    private fun loadManifestAttributes(targetArtifactId: String): Map<String, String>? {
        val resources = Thread.currentThread().contextClassLoader.getResources("META-INF/MANIFEST.MF")
        return resources.toList().asSequence()
            .mapNotNull { url ->
                url.openStream().use { stream ->
                    val manifest = Manifest(stream)
                    val foundArtifact = manifest.mainAttributes.getValue(ARTIFACT_ID)
                    val foundVersion = manifest.mainAttributes.getValue(VERSION)
                    val foundGroupId = manifest.mainAttributes.getValue(GROUP_ID)

                    if (foundArtifact == targetArtifactId) {
                        mapOf(
                            ARTIFACT_ID to foundArtifact,
                            VERSION to foundVersion,
                            GROUP_ID to foundGroupId
                        )
                    } else {
                        null
                    }
                }
            }
            .firstOrNull()
    }
}
