//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreatePropertyMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.CreatePropertyInput_InputAdapter;
import java.io.IOException;

public enum CreatePropertyMutation_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, CreatePropertyMutation value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("input");
    new ObjectAdapter<CreatePropertyInput>(CreatePropertyInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
