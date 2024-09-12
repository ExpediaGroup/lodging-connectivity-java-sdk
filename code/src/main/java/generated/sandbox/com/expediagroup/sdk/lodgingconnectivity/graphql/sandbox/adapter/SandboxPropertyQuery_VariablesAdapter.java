//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.OptionalAdapters;
import java.io.IOException;

public enum SandboxPropertyQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, SandboxPropertyQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    writer.name("reservationsCursor");
    OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.reservationsCursor);
    writer.name("reservationsLimit");
    OptionalAdapters.OptionalIntAdapter.toJson(writer, customScalarAdapters, value.reservationsLimit);
    if (value.skipReservations.isPresent()) {
      writer.name("skipReservations");
      new OptionalAdapter<>(Adapters.BooleanAdapter).toJson(writer, customScalarAdapters, value.skipReservations);
    }
    else if (withDefaultValues) {
      writer.name("skipReservations");
      Adapters.NullableAnyAdapter.toJson(writer, CustomScalarAdapters.Empty, false);
    }
  }
}
