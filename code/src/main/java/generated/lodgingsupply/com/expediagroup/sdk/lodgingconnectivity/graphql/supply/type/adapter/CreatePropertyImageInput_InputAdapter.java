//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
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
    if (value.active instanceof Optional.Present) {
      writer.name("active");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.active);
    }
    if (value.captions instanceof Optional.Present) {
      writer.name("captions");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.captions);
    }
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    if (value.featured instanceof Optional.Present) {
      writer.name("featured");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.featured);
    }
    if (value.fileName instanceof Optional.Present) {
      writer.name("fileName");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.fileName);
    }
    writer.name("fileUrl");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.fileUrl);
    if (value.order instanceof Optional.Present) {
      writer.name("order");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.order);
    }
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.rotation instanceof Optional.Present) {
      writer.name("rotation");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.rotation);
    }
  }
}
