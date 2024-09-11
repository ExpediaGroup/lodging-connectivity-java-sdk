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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboCancellationPolicyOverride;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboCancellationPolicyPenalty;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum VrboCancellationPolicyOverride_InputAdapter implements Adapter<VrboCancellationPolicyOverride> {
  INSTANCE;

  @Override
  public VrboCancellationPolicyOverride fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      VrboCancellationPolicyOverride value) throws IOException {
    writer.name("overrideType");
    VrboCancellationPolicyOverrideType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.overrideType);
    if (value.penalty instanceof Optional.Present) {
      writer.name("penalty");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<VrboCancellationPolicyPenalty>(VrboCancellationPolicyPenalty_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.penalty);
    }
  }
}
