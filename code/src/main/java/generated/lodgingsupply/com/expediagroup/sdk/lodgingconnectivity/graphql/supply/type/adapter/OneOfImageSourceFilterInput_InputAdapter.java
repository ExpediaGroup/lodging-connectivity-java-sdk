//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.OneOfImageSourceFilterInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum OneOfImageSourceFilterInput_InputAdapter implements Adapter<OneOfImageSourceFilterInput> {
  INSTANCE;

  @Override
  public OneOfImageSourceFilterInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      OneOfImageSourceFilterInput value) throws IOException {
    if (value.operator instanceof Optional.Present) {
      writer.name("operator");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(OneOfOperator_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.operator);
    }
    writer.name("values");
    new ListAdapter<>(ImageSource_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.values);
  }
}
