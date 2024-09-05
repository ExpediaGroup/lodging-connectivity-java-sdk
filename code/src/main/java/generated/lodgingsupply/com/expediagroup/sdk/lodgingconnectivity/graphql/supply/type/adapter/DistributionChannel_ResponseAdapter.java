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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DistributionChannel;
import java.io.IOException;
import java.lang.Override;

public enum DistributionChannel_ResponseAdapter implements Adapter<DistributionChannel> {
  INSTANCE;

  @Override
  public DistributionChannel fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    String rawValue = reader.nextString();
    return DistributionChannel.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      DistributionChannel value) throws IOException {
    writer.value(value.rawValue);
  }
}
