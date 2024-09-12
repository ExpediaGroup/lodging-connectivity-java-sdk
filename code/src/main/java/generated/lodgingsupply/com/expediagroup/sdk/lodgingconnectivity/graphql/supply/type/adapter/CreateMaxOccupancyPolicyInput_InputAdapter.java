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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateMaxOccupancyPolicyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedStringInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CreateMaxOccupancyPolicyInput_InputAdapter implements Adapter<CreateMaxOccupancyPolicyInput> {
  INSTANCE;

  @Override
  public CreateMaxOccupancyPolicyInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreateMaxOccupancyPolicyInput value) throws IOException {
    if (value.adultCount.isPresent()) {
      writer.name("adultCount");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.adultCount);
    }
    if (value.note.isPresent()) {
      writer.name("note");
      new OptionalAdapter<>(new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<LocalizedStringInput>(LocalizedStringInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.note);
    }
    writer.name("totalGuestCount");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalGuestCount);
  }
}
