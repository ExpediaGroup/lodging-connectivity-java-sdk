package com.expediagroup.sdk.lodgingconnectivity.payment.function

import com.expediagroup.sdk.core.extension.getOrThrow
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.PaymentInstrumentQuery
import com.expediagroup.sdk.lodgingconnectivity.payment.model.PaymentInstrumentResponse

fun getPaymentInstrumentFun(graphQLExecutor: GraphQLExecutor, token: String): PaymentInstrumentResponse {
    val operation = PaymentInstrumentQuery(token)
    val response = graphQLExecutor.execute(operation)

    val paymentInstrument = response.data.paymentInstrument.getOrThrow {
        ExpediaGroupServiceException("Couldn't fetch payment instrument")
    }

    return PaymentInstrumentResponse(
        data = paymentInstrument.paymentInstrumentData,
        rawResponse = response
    )
}
