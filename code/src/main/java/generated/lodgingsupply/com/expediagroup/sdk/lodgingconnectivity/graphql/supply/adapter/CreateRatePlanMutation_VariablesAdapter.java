//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreateRatePlanMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateRatePlanInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.CreateRatePlanInput_InputAdapter;
import java.io.IOException;

public enum CreateRatePlanMutation_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, CreateRatePlanMutation value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("input");
    new ObjectAdapter<CreateRatePlanInput>(CreateRatePlanInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
