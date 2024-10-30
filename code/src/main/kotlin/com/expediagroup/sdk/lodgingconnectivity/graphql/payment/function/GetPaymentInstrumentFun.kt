@file:JvmName("PaymentInstrumentRequest")

package com.expediagroup.sdk.lodgingconnectivity.graphql.payment.function

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.lodgingconnectivity.graphql.common.GraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.graphql.extension.getOrThrow
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.RawResponse
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.PaymentInstrumentQuery
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.fragment.PaymentInstrumentData

data class PaymentInstrumentResponse(
    override val data: PaymentInstrumentData,
    override val rawResponse: RawResponse<PaymentInstrumentQuery.Data>,
) : Response<PaymentInstrumentData, PaymentInstrumentQuery.Data>

@JvmName("execute")
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
