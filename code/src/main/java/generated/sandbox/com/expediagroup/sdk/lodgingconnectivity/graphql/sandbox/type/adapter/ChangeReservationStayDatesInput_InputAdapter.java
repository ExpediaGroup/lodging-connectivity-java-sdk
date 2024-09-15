//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ChangeReservationStayDatesInput_InputAdapter implements Adapter<ChangeReservationStayDatesInput> {
  INSTANCE;

  @Override
  public ChangeReservationStayDatesInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ChangeReservationStayDatesInput value) throws IOException {
    writer.name("checkInDate");
    com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkInDate);
    writer.name("checkOutDate");
    com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkOutDate);
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.sendNotification instanceof Optional.Present) {
      writer.name("sendNotification");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.sendNotification);
    }
  }
}