//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyReservationsMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyReservationsInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.DeletePropertyReservationsInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum SandboxDeletePropertyReservationsMutation_VariablesAdapter implements Adapter<SandboxDeletePropertyReservationsMutation> {
  INSTANCE;

  @Override
  public SandboxDeletePropertyReservationsMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      SandboxDeletePropertyReservationsMutation value) throws IOException {
    writer.name("input");
    new ObjectAdapter<DeletePropertyReservationsInput>(DeletePropertyReservationsInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
