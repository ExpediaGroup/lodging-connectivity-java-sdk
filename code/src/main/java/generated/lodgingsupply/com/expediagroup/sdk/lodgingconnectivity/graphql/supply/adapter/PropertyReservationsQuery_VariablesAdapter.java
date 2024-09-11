//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReservationsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CheckOutDateFilter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationFilterInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.CheckOutDateFilter_InputAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ReservationFilterInput_InputAdapter;
import java.io.IOException;

public enum PropertyReservationsQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, PropertyReservationsQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.checkOutDate instanceof Optional.Present) {
      writer.name("checkOutDate");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<CheckOutDateFilter>(CheckOutDateFilter_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.checkOutDate);
    }
    if (value.filter instanceof Optional.Present) {
      writer.name("filter");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<ReservationFilterInput>(ReservationFilterInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.filter);
    }
    writer.name("pageSize");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.pageSize);
    if (value.after instanceof Optional.Present) {
      writer.name("after");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.after);
    }
    if (value.includePaymentInstrumentToken instanceof Optional.Present) {
      writer.name("includePaymentInstrumentToken");
      new ApolloOptionalAdapter<>(Adapters.BooleanAdapter).toJson(writer, customScalarAdapters, value.includePaymentInstrumentToken);
    }
    else if (withDefaultValues) {
      writer.name("includePaymentInstrumentToken");
      Adapters.NullableAnyAdapter.toJson(writer, CustomScalarAdapters.Empty, false);
    }
    if (value.includeSupplierAmount instanceof Optional.Present) {
      writer.name("includeSupplierAmount");
      new ApolloOptionalAdapter<>(Adapters.BooleanAdapter).toJson(writer, customScalarAdapters, value.includeSupplierAmount);
    }
    else if (withDefaultValues) {
      writer.name("includeSupplierAmount");
      Adapters.NullableAnyAdapter.toJson(writer, CustomScalarAdapters.Empty, false);
    }
  }
}
