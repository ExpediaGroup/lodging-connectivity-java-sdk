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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateMaxOccupancyPolicyInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateMaxOccupancyPolicyInput_InputAdapter implements Adapter<UpdateMaxOccupancyPolicyInput> {
  INSTANCE;

  @Override
  public UpdateMaxOccupancyPolicyInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateMaxOccupancyPolicyInput value) throws IOException {
    if (value.adultCount instanceof Optional.Present) {
      writer.name("adultCount");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.adultCount);
    }
    if (value.note instanceof Optional.Present) {
      writer.name("note");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.note);
    }
    if (value.totalGuestCount instanceof Optional.Present) {
      writer.name("totalGuestCount");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.totalGuestCount);
    }
  }
}
