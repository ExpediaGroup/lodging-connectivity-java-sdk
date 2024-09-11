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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboCancellationPolicyPenalty;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum VrboCancellationPolicyPenalty_InputAdapter implements Adapter<VrboCancellationPolicyPenalty> {
  INSTANCE;

  @Override
  public VrboCancellationPolicyPenalty fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      VrboCancellationPolicyPenalty value) throws IOException {
    writer.name("type");
    VrboCancellationPolicyPenaltyType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
    if (value.percent instanceof Optional.Present) {
      writer.name("percent");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.percent);
    }
  }
}
