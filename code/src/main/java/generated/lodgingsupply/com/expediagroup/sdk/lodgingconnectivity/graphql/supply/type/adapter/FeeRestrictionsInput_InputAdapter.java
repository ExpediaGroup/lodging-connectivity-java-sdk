//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeDateRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FeeRestrictionsInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IntRangeInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum FeeRestrictionsInput_InputAdapter implements Adapter<FeeRestrictionsInput> {
  INSTANCE;

  @Override
  public FeeRestrictionsInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      FeeRestrictionsInput value) throws IOException {
    if (value.dateRange instanceof Optional.Present) {
      writer.name("dateRange");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<FeeDateRangeInput>(FeeDateRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.dateRange);
    }
    if (value.extraGuestRange instanceof Optional.Present) {
      writer.name("extraGuestRange");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.extraGuestRange);
    }
    if (value.rangeOfNight instanceof Optional.Present) {
      writer.name("rangeOfNight");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.rangeOfNight);
    }
  }
}
