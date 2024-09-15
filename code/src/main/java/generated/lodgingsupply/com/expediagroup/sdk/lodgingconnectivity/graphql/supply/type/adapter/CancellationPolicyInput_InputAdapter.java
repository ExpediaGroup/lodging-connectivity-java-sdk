//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyTierInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CancellationPolicyInput_InputAdapter implements Adapter<CancellationPolicyInput> {
  INSTANCE;

  @Override
  public CancellationPolicyInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CancellationPolicyInput value) throws IOException {
    if (value.tiers instanceof Optional.Present) {
      writer.name("tiers");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<CancellationPolicyTierInput>(CancellationPolicyTierInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.tiers);
    }
    writer.name("type");
    CancellationPolicyType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
  }
}