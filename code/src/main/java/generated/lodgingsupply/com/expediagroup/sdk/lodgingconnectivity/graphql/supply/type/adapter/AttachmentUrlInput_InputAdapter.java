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
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AttachmentUrlInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum AttachmentUrlInput_InputAdapter implements Adapter<AttachmentUrlInput> {
  INSTANCE;

  @Override
  public AttachmentUrlInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      AttachmentUrlInput value) throws IOException {
    writer.name("key");
    AttachmentType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.key);
    if (value.value instanceof Optional.Present) {
      writer.name("value");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.value);
    }
  }
}
