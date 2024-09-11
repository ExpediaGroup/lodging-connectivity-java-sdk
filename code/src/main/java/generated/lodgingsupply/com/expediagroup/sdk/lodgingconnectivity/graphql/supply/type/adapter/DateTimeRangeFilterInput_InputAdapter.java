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
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DateTimeRangeFilterInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum DateTimeRangeFilterInput_InputAdapter implements Adapter<DateTimeRangeFilterInput> {
  INSTANCE;

  @Override
  public DateTimeRangeFilterInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      DateTimeRangeFilterInput value) throws IOException {
    writer.name("from");
    Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.from);
    writer.name("to");
    Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.to);
    if (value.operator instanceof Optional.Present) {
      writer.name("operator");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(RangeOperator_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.operator);
    }
  }
}
