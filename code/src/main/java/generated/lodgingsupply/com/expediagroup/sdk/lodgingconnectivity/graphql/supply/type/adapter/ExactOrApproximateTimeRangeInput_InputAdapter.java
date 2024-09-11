//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ExactOrApproximateTimeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ExactOrApproximateTimeRangeInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ExactOrApproximateTimeRangeInput_InputAdapter implements Adapter<ExactOrApproximateTimeRangeInput> {
  INSTANCE;

  @Override
  public ExactOrApproximateTimeRangeInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ExactOrApproximateTimeRangeInput value) throws IOException {
    if (value.end instanceof Optional.Present) {
      writer.name("end");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<ExactOrApproximateTimeInput>(ExactOrApproximateTimeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.end);
    }
    writer.name("start");
    new ObjectAdapter<ExactOrApproximateTimeInput>(ExactOrApproximateTimeInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.start);
  }
}
