//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UnsubscribeNotificationEventTypeMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UnsubscribeNotificationEventTypeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.UnsubscribeNotificationEventTypeInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UnsubscribeNotificationEventTypeMutation_VariablesAdapter implements Adapter<UnsubscribeNotificationEventTypeMutation> {
  INSTANCE;

  @Override
  public UnsubscribeNotificationEventTypeMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UnsubscribeNotificationEventTypeMutation value) throws IOException {
    writer.name("input");
    new ObjectAdapter<UnsubscribeNotificationEventTypeInput>(UnsubscribeNotificationEventTypeInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}