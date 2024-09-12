//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreatePropertyImageInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CreatePropertyImageInput_InputAdapter implements Adapter<CreatePropertyImageInput> {
  INSTANCE;

  @Override
  public CreatePropertyImageInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreatePropertyImageInput value) throws IOException {
    if (value.active.isPresent()) {
      writer.name("active");
      new OptionalAdapter<>(OptionalAdapters.OptionalBooleanAdapter).toJson(writer, customScalarAdapters, value.active);
    }
    if (value.captions.isPresent()) {
      writer.name("captions");
      new OptionalAdapter<>(new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.captions);
    }
    if (value.clientMutationId.isPresent()) {
      writer.name("clientMutationId");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    if (value.featured.isPresent()) {
      writer.name("featured");
      new OptionalAdapter<>(OptionalAdapters.OptionalBooleanAdapter).toJson(writer, customScalarAdapters, value.featured);
    }
    if (value.fileName.isPresent()) {
      writer.name("fileName");
      new OptionalAdapter<>(OptionalAdapters.OptionalStringAdapter).toJson(writer, customScalarAdapters, value.fileName);
    }
    writer.name("fileUrl");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.fileUrl);
    if (value.order.isPresent()) {
      writer.name("order");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.order);
    }
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.rotation.isPresent()) {
      writer.name("rotation");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.rotation);
    }
  }
}
