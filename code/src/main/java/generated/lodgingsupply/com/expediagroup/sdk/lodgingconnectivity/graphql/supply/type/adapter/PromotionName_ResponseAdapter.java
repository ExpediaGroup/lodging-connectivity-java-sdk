//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionName;
import java.io.IOException;
import java.lang.Override;

public enum PromotionName_ResponseAdapter implements Adapter<PromotionName> {
  INSTANCE;

  @Override
  public PromotionName fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    String rawValue = reader.nextString();
    return PromotionName.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      PromotionName value) throws IOException {
    writer.value(value.rawValue);
  }
}