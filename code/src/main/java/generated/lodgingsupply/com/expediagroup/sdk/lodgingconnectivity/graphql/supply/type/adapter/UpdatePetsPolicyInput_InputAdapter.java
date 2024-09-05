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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AllowedPetsInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePetsPolicyInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdatePetsPolicyInput_InputAdapter implements Adapter<UpdatePetsPolicyInput> {
  INSTANCE;

  @Override
  public UpdatePetsPolicyInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdatePetsPolicyInput value) throws IOException {
    if (value.allowed instanceof Optional.Present) {
      writer.name("allowed");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.allowed);
    }
    if (value.allowedPets instanceof Optional.Present) {
      writer.name("allowedPets");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<AllowedPetsInput>(AllowedPetsInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.allowedPets);
    }
    if (value.note instanceof Optional.Present) {
      writer.name("note");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.note);
    }
  }
}
