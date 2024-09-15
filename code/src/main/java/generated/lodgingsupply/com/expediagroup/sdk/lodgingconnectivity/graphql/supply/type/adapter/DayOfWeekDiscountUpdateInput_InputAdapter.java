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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DayOfWeekDiscountUpdateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum DayOfWeekDiscountUpdateInput_InputAdapter implements Adapter<DayOfWeekDiscountUpdateInput> {
  INSTANCE;

  @Override
  public DayOfWeekDiscountUpdateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      DayOfWeekDiscountUpdateInput value) throws IOException {
    if (value.unit instanceof Optional.Present) {
      writer.name("unit");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(DiscountUnit_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.unit);
    }
    if (value.monday instanceof Optional.Present) {
      writer.name("monday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.monday);
    }
    if (value.tuesday instanceof Optional.Present) {
      writer.name("tuesday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.tuesday);
    }
    if (value.wednesday instanceof Optional.Present) {
      writer.name("wednesday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.wednesday);
    }
    if (value.thursday instanceof Optional.Present) {
      writer.name("thursday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.thursday);
    }
    if (value.friday instanceof Optional.Present) {
      writer.name("friday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.friday);
    }
    if (value.saturday instanceof Optional.Present) {
      writer.name("saturday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.saturday);
    }
    if (value.sunday instanceof Optional.Present) {
      writer.name("sunday");
      new ApolloOptionalAdapter<>(Adapters.NullableDoubleAdapter).toJson(writer, customScalarAdapters, value.sunday);
    }
  }
}