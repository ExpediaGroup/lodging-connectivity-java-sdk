//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateNotificationCallbackConfigInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;

public enum CreateNotificationCallbackConfigInput_InputAdapter implements Adapter<CreateNotificationCallbackConfigInput> {
  INSTANCE;

  @Override
  public CreateNotificationCallbackConfigInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreateNotificationCallbackConfigInput value) throws IOException {
    writer.name("callbackUrl");
    com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.callbackUrl);
    writer.name("apiKey");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.apiKey);
    if (value.requestTimeoutSeconds.isPresent()) {
      writer.name("requestTimeoutSeconds");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.requestTimeoutSeconds);
    }
    writer.name("contactEmail");
    (customScalarAdapters.<String>responseAdapterFor(EmailAddress.type)).toJson(writer, customScalarAdapters, value.contactEmail);
  }
}
