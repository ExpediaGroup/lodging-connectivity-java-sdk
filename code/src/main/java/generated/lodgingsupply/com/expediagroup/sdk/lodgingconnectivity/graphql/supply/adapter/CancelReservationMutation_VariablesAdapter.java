//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.CancelReservationInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CancelReservationMutation_VariablesAdapter implements Adapter<CancelReservationMutation> {
  INSTANCE;

  @Override
  public CancelReservationMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CancelReservationMutation value) throws IOException {
    writer.name("input");
    new ObjectAdapter<CancelReservationInput>(CancelReservationInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
