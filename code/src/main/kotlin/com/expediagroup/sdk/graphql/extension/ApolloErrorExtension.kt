package com.expediagroup.sdk.graphql.extension

import com.apollographql.apollo.api.Error

fun Error.toSDKError() =
    com.expediagroup.sdk.graphql.model.response.Error(
        message = this.message,
        path = this.path?.map { it.toString() }
    )
