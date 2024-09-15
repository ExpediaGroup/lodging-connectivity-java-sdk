//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.BusinessModel;
import java.io.IOException;
import java.lang.Override;

public enum BusinessModel_ResponseAdapter implements Adapter<BusinessModel> {
  INSTANCE;

  @Override
  public BusinessModel fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    String rawValue = reader.nextString();
    return BusinessModel.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      BusinessModel value) throws IOException {
    writer.value(value.rawValue);
  }
}