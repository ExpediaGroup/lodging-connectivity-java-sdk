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
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeleteReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.DeleteReservationInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum SandboxDeleteReservationMutation_VariablesAdapter implements Adapter<SandboxDeleteReservationMutation> {
  INSTANCE;

  @Override
  public SandboxDeleteReservationMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      SandboxDeleteReservationMutation value) throws IOException {
    writer.name("input");
    new ObjectAdapter<DeleteReservationInput>(DeleteReservationInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}