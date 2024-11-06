package com.expediagroup.sdk.core.configuration

import java.util.jar.Manifest

internal object SdkMetadata {
    private lateinit var artifactId: String
    private lateinit var version: String
    private lateinit var userAgentPrefix: String

    fun getArtifactId(): String = artifactId
    fun getVersion(): String = version
    fun getUserAgentPrefix(): String = userAgentPrefix

    init {
        this::class.java.classLoader.getResourceAsStream("META-INF/MANIFEST.MF").use {
            Manifest(it).apply {
                artifactId = mainAttributes.getValue("artifactId")
                version = mainAttributes.getValue("version")
                userAgentPrefix = mainAttributes.getValue("userAgentPrefix")
            }
        }
    }
}
