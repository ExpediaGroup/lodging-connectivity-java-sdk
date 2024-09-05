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
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReplaceFeeSetInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ReplaceFeeSetInput_InputAdapter implements Adapter<ReplaceFeeSetInput> {
  INSTANCE;

  @Override
  public ReplaceFeeSetInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ReplaceFeeSetInput value) throws IOException {
    writer.name("businessModel");
    FeeBusinessModel_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.businessModel);
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("fees");
    new ListAdapter<>(new ObjectAdapter<FeeInput>(FeeInput_InputAdapter.INSTANCE, false)).toJson(writer, customScalarAdapters, value.fees);
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    writer.name("name");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
  }
}
