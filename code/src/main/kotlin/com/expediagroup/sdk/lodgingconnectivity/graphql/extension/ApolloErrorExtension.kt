package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

import com.apollographql.apollo.api.Error

fun Error.toSDKError() =
    com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Error(
        message = this.message,
        path = this.path?.map { it.toString() }
    )
