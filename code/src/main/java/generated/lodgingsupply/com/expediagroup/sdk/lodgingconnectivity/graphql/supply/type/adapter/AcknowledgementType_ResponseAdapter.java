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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AcknowledgementType;
import java.io.IOException;
import java.lang.Override;

public enum AcknowledgementType_ResponseAdapter implements Adapter<AcknowledgementType> {
  INSTANCE;

  @Override
  public AcknowledgementType fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    String rawValue = reader.nextString();
    return AcknowledgementType.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      AcknowledgementType value) throws IOException {
    writer.value(value.rawValue);
  }
}
