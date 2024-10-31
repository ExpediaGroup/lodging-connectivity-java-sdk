package com.expediagroup.sdk.lodgingconnectivity.graphql.extension

import com.apollographql.apollo.api.Error
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.SDKApolloError

fun Error.toSDKError() =
    SDKApolloError(
        message = this.message,
        path = this.path?.map { it.toString() }
    )
