package com.expediagroup.sdk.v2.core.configuration

import com.google.common.io.Resources
import java.io.FileInputStream
import java.util.Properties

internal object SdkMetadata {
    private lateinit var artifactId: String
    private lateinit var version: String
    private lateinit var userAgentPrefix: String

    fun getArtifactId(): String = artifactId
    fun getVersion(): String = version
    fun getUserAgentPrefix(): String = userAgentPrefix

    init {
        Resources.getResource("sdk.properties").file?.let { path ->
            Properties().apply {
                load(FileInputStream(path))
            }.also { properties ->
                artifactId = properties.getProperty("artifactId")
                version = properties.getProperty("version")
                userAgentPrefix = properties.getProperty("userAgentPrefix")
            }
        }
    }
}
