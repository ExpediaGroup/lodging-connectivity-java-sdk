package com.expediagroup.sdk.lodgingconnectivity.payment.function

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.PaymentInstrumentQuery
import com.expediagroup.sdk.lodgingconnectivity.payment.model.GetPaymentInstrumentResponse

fun getPaymentInstrumentFun(graphQLExecutor: GraphQLExecutor, token: String): GetPaymentInstrumentResponse {
    val operation = PaymentInstrumentQuery(token)
    val response = graphQLExecutor.execute(operation)

    val paymentInstrument = response.data.paymentInstrument.getOrThrow {
        ExpediaGroupServiceException("Couldn't fetch payment instrument")
    }

    return GetPaymentInstrumentResponse(
        data = paymentInstrument.paymentInstrumentData,
        rawResponse = response
    )
}
