//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Decimal;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeChargeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MoneyInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;

public enum FeeChargeInput_InputAdapter implements Adapter<FeeChargeInput> {
  INSTANCE;

  @Override
  public FeeChargeInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      FeeChargeInput value) throws IOException {
    writer.name("duration");
    FeeChargeDuration_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.duration);
    if (value.flatAmount.isPresent()) {
      writer.name("flatAmount");
      new OptionalAdapter<>(new OptionalAdapter<>(new ObjectAdapter<MoneyInput>(MoneyInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.flatAmount);
    }
    if (value.percentage.isPresent()) {
      writer.name("percentage");
      new OptionalAdapter<>(new OptionalAdapter<>((customScalarAdapters.<String>responseAdapterFor(Decimal.type)))).toJson(writer, customScalarAdapters, value.percentage);
    }
    writer.name("type");
    FeeChargeType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
  }
}
