//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.WeightInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum WeightInput_InputAdapter implements Adapter<WeightInput> {
  INSTANCE;

  @Override
  public WeightInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      WeightInput value) throws IOException {
    writer.name("amount");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.amount);
    writer.name("weightUnit");
    BaseWeightUnit_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.weightUnit);
  }
}
