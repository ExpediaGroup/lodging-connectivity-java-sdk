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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewReservationIdNodeInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ReviewReservationIdNodeInput_InputAdapter implements Adapter<ReviewReservationIdNodeInput> {
  INSTANCE;

  @Override
  public ReviewReservationIdNodeInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ReviewReservationIdNodeInput value) throws IOException {
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    writer.name("idSource");
    IdSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.idSource);
  }
}
