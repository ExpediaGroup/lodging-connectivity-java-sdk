package com.expediagroup.sdk.v2.core.configuration

import com.expediagroup.sdk.v2.core.model.exception.client.ExpediaGroupConfigurationException
import java.io.FileInputStream
import java.io.IOException
import java.util.Properties


/**
 * Singleton object that holds metadata information about the SDK.
 *
 * This metadata is loaded from the `gradle.properties` file and includes:
 * - `artifactId`: The artifact ID of the SDK.
 * - `version`: The version of the SDK.
 * - `groupId`: The group ID of the SDK.
 * - `description`: A brief description of the SDK.
 *
 * If the metadata cannot be loaded due to an `IOException`, an `ExpediaGroupConfigurationException` is thrown.
 */
internal data object SdkMetadata {
    val artifactId: String
    val version: String
    val groupId: String
    val description: String

    init {
        try {
            Properties().apply {
                FileInputStream("gradle.properties").use {
                    load(it)
                }
            }.also { props ->
                artifactId = props.getProperty("artifactName")
                version = props.getProperty("version")
                groupId = props.getProperty("groupId")
                description = props.getProperty("description")
            }
        } catch (ioException: IOException) {
            throw ExpediaGroupConfigurationException("Unable to load SDK metadata", ioException)
        }
    }
}