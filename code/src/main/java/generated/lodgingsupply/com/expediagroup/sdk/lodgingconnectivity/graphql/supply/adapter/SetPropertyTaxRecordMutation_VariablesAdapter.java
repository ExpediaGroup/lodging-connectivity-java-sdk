//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.SetPropertyTaxRecordMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SetPropertyTaxRecordInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.SetPropertyTaxRecordInput_InputAdapter;
import java.io.IOException;

public enum SetPropertyTaxRecordMutation_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, SetPropertyTaxRecordMutation value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("input");
    new ObjectAdapter<SetPropertyTaxRecordInput>(SetPropertyTaxRecordInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}
