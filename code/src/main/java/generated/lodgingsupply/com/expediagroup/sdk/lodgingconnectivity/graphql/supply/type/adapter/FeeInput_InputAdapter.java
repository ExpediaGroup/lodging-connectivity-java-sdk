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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeChargeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeRestrictionsInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum FeeInput_InputAdapter implements Adapter<FeeInput> {
  INSTANCE;

  @Override
  public FeeInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, FeeInput value)
      throws IOException {
    if (value.ageCategory instanceof Optional.Present) {
      writer.name("ageCategory");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(FeeAgeCategory_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.ageCategory);
    }
    writer.name("charges");
    new ListAdapter<>(new ObjectAdapter<FeeChargeInput>(FeeChargeInput_InputAdapter.INSTANCE, false)).toJson(writer, customScalarAdapters, value.charges);
    writer.name("name");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);
    if (value.restrictions instanceof Optional.Present) {
      writer.name("restrictions");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<FeeRestrictionsInput>(FeeRestrictionsInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.restrictions);
    }
    writer.name("scope");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.scope);
    if (value.taxable instanceof Optional.Present) {
      writer.name("taxable");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.taxable);
    }
    writer.name("type");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.type);
    if (value.variesByLengthOfStay instanceof Optional.Present) {
      writer.name("variesByLengthOfStay");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.variesByLengthOfStay);
    }
  }
}
