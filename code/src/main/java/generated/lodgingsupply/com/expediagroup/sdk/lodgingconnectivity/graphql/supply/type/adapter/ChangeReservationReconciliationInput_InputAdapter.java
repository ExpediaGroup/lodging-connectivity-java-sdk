//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierAmountInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ChangeReservationReconciliationInput_InputAdapter implements Adapter<ChangeReservationReconciliationInput> {
  INSTANCE;

  @Override
  public ChangeReservationReconciliationInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ChangeReservationReconciliationInput value) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    writer.name("reservationId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.reservationId);
    if (value.supplierAmount instanceof Optional.Present) {
      writer.name("supplierAmount");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<SupplierAmountInput>(SupplierAmountInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.supplierAmount);
    }
    writer.name("checkInDate");
    com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkInDate);
    writer.name("checkOutDate");
    com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkOutDate);
    if (value.reason instanceof Optional.Present) {
      writer.name("reason");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(ReservationChangeReason_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.reason);
    }
  }
}