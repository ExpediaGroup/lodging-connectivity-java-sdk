//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.RefreshNotificationCallbackConfigSecretMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefreshNotificationCallbackConfigSecretInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.RefreshNotificationCallbackConfigSecretInput_InputAdapter;
import java.io.IOException;

public enum RefreshNotificationCallbackConfigSecretMutation_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer,
      RefreshNotificationCallbackConfigSecretMutation value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("input");
    new ObjectAdapter<RefreshNotificationCallbackConfigSecretInput>(RefreshNotificationCallbackConfigSecretInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
