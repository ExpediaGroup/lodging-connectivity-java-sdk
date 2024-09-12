//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum DeleteReservationInput_InputAdapter implements Adapter<DeleteReservationInput> {
  INSTANCE;

  @Override
  public DeleteReservationInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      DeleteReservationInput value) throws IOException {
    if (value.clientMutationId.isPresent()) {
      writer.name("clientMutationId");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
  }
}
