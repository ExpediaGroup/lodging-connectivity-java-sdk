//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ExactOrApproximateTimeInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ExactOrApproximateTimeInput_InputAdapter implements Adapter<ExactOrApproximateTimeInput> {
  INSTANCE;

  @Override
  public ExactOrApproximateTimeInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ExactOrApproximateTimeInput value) throws IOException {
    if (value.approximateTime instanceof Optional.Present) {
      writer.name("approximateTime");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.approximateTime);
    }
    if (value.exactTime instanceof Optional.Present) {
      writer.name("exactTime");
      new ApolloOptionalAdapter<>(Adapters.NullableAnyAdapter).toJson(writer, customScalarAdapters, value.exactTime);
    }
  }
}
