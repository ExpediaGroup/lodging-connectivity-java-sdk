package com.expediagroup.sdk.core.gapiclient.util

import com.expediagroup.sdk.core.configuration.provider.ConfigurationProvider
import com.expediagroup.sdk.core.gapiclient.GClientHttpEngine

fun createGClientHttpEngine(
    namespace: String,
    configurationProvider: ConfigurationProvider,
) = GClientHttpEngine(
    createGClient(
        namespace = namespace,
        configurationProvider = configurationProvider
    )
)