//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.PaymentInstrumentQuery;
import java.io.IOException;

public enum PaymentInstrumentQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, PaymentInstrumentQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("token");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.token);
  }
}
