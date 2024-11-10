package com.expediagroup.sdk.lodgingconnectivity.payment.model

import com.expediagroup.sdk.graphql.model.response.RawResponse
import com.expediagroup.sdk.graphql.model.response.Response
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.PaymentInstrumentQuery
import com.expediagroup.sdk.lodgingconnectivity.payment.operation.fragment.PaymentInstrumentData

data class GetPaymentInstrumentResponse(
    override val data: PaymentInstrumentData,
    override val rawResponse: RawResponse<PaymentInstrumentQuery.Data>,
) : Response<PaymentInstrumentData, PaymentInstrumentQuery.Data>
