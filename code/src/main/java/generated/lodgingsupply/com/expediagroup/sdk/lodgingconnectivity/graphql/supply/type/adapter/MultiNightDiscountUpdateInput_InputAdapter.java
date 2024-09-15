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
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountUpdateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum MultiNightDiscountUpdateInput_InputAdapter implements Adapter<MultiNightDiscountUpdateInput> {
  INSTANCE;

  @Override
  public MultiNightDiscountUpdateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      MultiNightDiscountUpdateInput value) throws IOException {
    if (value.unit instanceof Optional.Present) {
      writer.name("unit");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(DiscountUnit_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.unit);
    }
    if (value.value instanceof Optional.Present) {
      writer.name("value");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.value);
    }
    if (value.memberOnlyAdditionalValue instanceof Optional.Present) {
      writer.name("memberOnlyAdditionalValue");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.memberOnlyAdditionalValue);
    }
    writer.name("applicableNight");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.applicableNight);
    if (value.isRecurring instanceof Optional.Present) {
      writer.name("isRecurring");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.isRecurring);
    }
  }
}