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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenityInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TextInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateAddressInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePoliciesInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePropertyLocationInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdatePropertyInput_InputAdapter implements Adapter<UpdatePropertyInput> {
  INSTANCE;

  @Override
  public UpdatePropertyInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdatePropertyInput value) throws IOException {
    if (value.address instanceof Optional.Present) {
      writer.name("address");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<UpdateAddressInput>(UpdateAddressInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.address);
    }
    if (value.amenities instanceof Optional.Present) {
      writer.name("amenities");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<AmenityInput>(AmenityInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.amenities);
    }
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.location instanceof Optional.Present) {
      writer.name("location");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<UpdatePropertyLocationInput>(UpdatePropertyLocationInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.location);
    }
    if (value.name instanceof Optional.Present) {
      writer.name("name");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.name);
    }
    if (value.names instanceof Optional.Present) {
      writer.name("names");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.names);
    }
    if (value.policies instanceof Optional.Present) {
      writer.name("policies");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<UpdatePoliciesInput>(UpdatePoliciesInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.policies);
    }
    if (value.referenceName instanceof Optional.Present) {
      writer.name("referenceName");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.referenceName);
    }
    if (value.text instanceof Optional.Present) {
      writer.name("text");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<TextInput>(TextInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.text);
    }
    if (value.type instanceof Optional.Present) {
      writer.name("type");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.type);
    }
  }
}
