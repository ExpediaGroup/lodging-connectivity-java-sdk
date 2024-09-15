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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenitiesFiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.OneOfStringFilterInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum AmenitiesFiltersInput_InputAdapter implements Adapter<AmenitiesFiltersInput> {
  INSTANCE;

  @Override
  public AmenitiesFiltersInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      AmenitiesFiltersInput value) throws IOException {
    if (value.available instanceof Optional.Present) {
      writer.name("available");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.available);
    }
    if (value.keys instanceof Optional.Present) {
      writer.name("keys");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<OneOfStringFilterInput>(OneOfStringFilterInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.keys);
    }
  }
}