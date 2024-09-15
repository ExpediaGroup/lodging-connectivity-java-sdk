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
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountCreateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum MultiNightDiscountCreateInput_InputAdapter implements Adapter<MultiNightDiscountCreateInput> {
  INSTANCE;

  @Override
  public MultiNightDiscountCreateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      MultiNightDiscountCreateInput value) throws IOException {
    writer.name("unit");
    DiscountUnit_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.unit);
    writer.name("value");
    Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.value);
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