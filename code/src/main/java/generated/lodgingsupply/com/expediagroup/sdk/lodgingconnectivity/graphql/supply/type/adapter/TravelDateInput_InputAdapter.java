//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TravelDateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum TravelDateInput_InputAdapter implements Adapter<TravelDateInput> {
  INSTANCE;

  @Override
  public TravelDateInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      TravelDateInput value) throws IOException {
    if (value.from instanceof Optional.Present) {
      writer.name("from");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.from);
    }
    if (value.to instanceof Optional.Present) {
      writer.name("to");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.to);
    }
  }
}