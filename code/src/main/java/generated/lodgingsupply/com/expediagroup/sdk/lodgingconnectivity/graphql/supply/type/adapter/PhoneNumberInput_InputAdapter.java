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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PhoneNumberInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum PhoneNumberInput_InputAdapter implements Adapter<PhoneNumberInput> {
  INSTANCE;

  @Override
  public PhoneNumberInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      PhoneNumberInput value) throws IOException {
    if (value.areaCode instanceof Optional.Present) {
      writer.name("areaCode");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.areaCode);
    }
    if (value.countryCode instanceof Optional.Present) {
      writer.name("countryCode");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.countryCode);
    }
    if (value.extension instanceof Optional.Present) {
      writer.name("extension");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.extension);
    }
    writer.name("number");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.number);
    writer.name("phoneNumberType");
    PhoneNumberType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.phoneNumberType);
  }
}
