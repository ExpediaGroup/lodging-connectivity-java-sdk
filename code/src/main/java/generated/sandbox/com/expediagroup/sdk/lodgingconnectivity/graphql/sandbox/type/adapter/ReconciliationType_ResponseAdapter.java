//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ReconciliationType;
import java.io.IOException;
import java.lang.Override;

public enum ReconciliationType_ResponseAdapter implements Adapter<ReconciliationType> {
  INSTANCE;

  @Override
  public ReconciliationType fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    String rawValue = reader.nextString();
    return ReconciliationType.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ReconciliationType value) throws IOException {
    writer.value(value.rawValue);
  }
}
