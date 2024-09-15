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
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateAddressInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateAddressInput_InputAdapter implements Adapter<UpdateAddressInput> {
  INSTANCE;

  @Override
  public UpdateAddressInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateAddressInput value) throws IOException {
    if (value.addressLines instanceof Optional.Present) {
      writer.name("addressLines");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(Adapters.StringAdapter))).toJson(writer, customScalarAdapters, value.addressLines);
    }
    if (value.administrativeArea instanceof Optional.Present) {
      writer.name("administrativeArea");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.administrativeArea);
    }
    if (value.countryCode instanceof Optional.Present) {
      writer.name("countryCode");
      new ApolloOptionalAdapter<>(Adapters.NullableAnyAdapter).toJson(writer, customScalarAdapters, value.countryCode);
    }
    if (value.locality instanceof Optional.Present) {
      writer.name("locality");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.locality);
    }
    if (value.postalCode instanceof Optional.Present) {
      writer.name("postalCode");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.postalCode);
    }
  }
}