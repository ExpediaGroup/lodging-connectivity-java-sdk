//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateReservationInput_InputAdapter implements Adapter<UpdateReservationInput> {
  INSTANCE;

  @Override
  public UpdateReservationInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateReservationInput value) throws IOException {
    if (value.adultCount.isPresent()) {
      writer.name("adultCount");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.adultCount);
    }
    if (value.checkInDate.isPresent()) {
      writer.name("checkInDate");
      new OptionalAdapter<>(new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.checkInDate);
    }
    if (value.checkOutDate.isPresent()) {
      writer.name("checkOutDate");
      new OptionalAdapter<>(new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.checkOutDate);
    }
    if (value.childAges.isPresent()) {
      writer.name("childAges");
      new OptionalAdapter<>(new OptionalAdapter<>(new ListAdapter<>(Adapters.IntAdapter))).toJson(writer, customScalarAdapters, value.childAges);
    }
    if (value.childCount.isPresent()) {
      writer.name("childCount");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.childCount);
    }
    if (value.clientMutationId.isPresent()) {
      writer.name("clientMutationId");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.sendNotification.isPresent()) {
      writer.name("sendNotification");
      new OptionalAdapter<>(OptionalAdapters.OptionalBooleanAdapter).toJson(writer, customScalarAdapters, value.sendNotification);
    }
    if (value.specialRequestText.isPresent()) {
      writer.name("specialRequestText");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.specialRequestText);
    }
    if (value.status.isPresent()) {
      writer.name("status");
      new OptionalAdapter<>(new OptionalAdapter<>(ReservationStatusInput_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.status);
    }
  }
}
