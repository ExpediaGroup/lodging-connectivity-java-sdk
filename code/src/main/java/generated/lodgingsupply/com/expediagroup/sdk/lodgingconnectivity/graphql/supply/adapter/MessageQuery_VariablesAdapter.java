//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.MessageQuery;
import java.io.IOException;

public enum MessageQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, MessageQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("messageId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.messageId);
  }
}
