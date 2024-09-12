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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegistrationRecordInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum RegistrationRecordInput_InputAdapter implements Adapter<RegistrationRecordInput> {
  INSTANCE;

  @Override
  public RegistrationRecordInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      RegistrationRecordInput value) throws IOException {
    if (value.expiry.isPresent()) {
      writer.name("expiry");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.expiry);
    }
    writer.name("registrationNumber");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.registrationNumber);
    if (value.registrationNumberType.isPresent()) {
      writer.name("registrationNumberType");
      new OptionalAdapter<>(new OptionalAdapter<>(RegistrationNumberType_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.registrationNumberType);
    }
  }
}
