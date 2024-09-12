//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ConfirmReservationNotificationInput_InputAdapter implements Adapter<ConfirmReservationNotificationInput> {
  INSTANCE;

  @Override
  public ConfirmReservationNotificationInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ConfirmReservationNotificationInput value) throws IOException {
    if (value.clientMutationId.isPresent()) {
      writer.name("clientMutationId");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    writer.name("reservationId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.reservationId);
    writer.name("confirmationToken");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.confirmationToken);
    writer.name("actionType");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.actionType);
    writer.name("confirmationCode");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.confirmationCode);
  }
}
