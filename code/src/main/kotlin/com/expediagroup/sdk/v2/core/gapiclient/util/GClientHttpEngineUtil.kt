package com.expediagroup.sdk.v2.core.gapiclient.util

import com.expediagroup.sdk.v2.core.gapiclient.GClientHttpEngine
import com.expediagroup.sdk.v2.core.trait.configuration.ClientConfiguration

fun createGClientHttpEngine(
    namespace: String,
    configuration: ClientConfiguration,
) = GClientHttpEngine(
    createGClient(
        namespace = namespace,
        configuration = configuration
    )
)