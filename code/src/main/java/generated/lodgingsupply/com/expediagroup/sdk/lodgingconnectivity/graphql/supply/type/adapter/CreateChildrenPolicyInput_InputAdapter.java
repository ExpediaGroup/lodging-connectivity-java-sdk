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
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AgeRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateChildrenPolicyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CreateChildrenPolicyInput_InputAdapter implements Adapter<CreateChildrenPolicyInput> {
  INSTANCE;

  @Override
  public CreateChildrenPolicyInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreateChildrenPolicyInput value) throws IOException {
    writer.name("allowed");
    Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.allowed);
    if (value.allowedAges instanceof Optional.Present) {
      writer.name("allowedAges");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<AgeRangeInput>(AgeRangeInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.allowedAges);
    }
    if (value.childrenAllowedNote instanceof Optional.Present) {
      writer.name("childrenAllowedNote");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.childrenAllowedNote);
    }
    if (value.childrenNotAllowedNote instanceof Optional.Present) {
      writer.name("childrenNotAllowedNote");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.childrenNotAllowedNote);
    }
  }
}