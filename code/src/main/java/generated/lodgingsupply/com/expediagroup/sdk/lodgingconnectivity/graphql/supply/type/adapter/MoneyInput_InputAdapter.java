//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CurrencyCode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Decimal;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MoneyInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;

public enum MoneyInput_InputAdapter implements Adapter<MoneyInput> {
  INSTANCE;

  @Override
  public MoneyInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, MoneyInput value)
      throws IOException {
    writer.name("amount");
    (customScalarAdapters.<String>responseAdapterFor(Decimal.type)).toJson(writer, customScalarAdapters, value.amount);
    writer.name("currencyCode");
    (customScalarAdapters.<String>responseAdapterFor(CurrencyCode.type)).toJson(writer, customScalarAdapters, value.currencyCode);
  }
}
