//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.RatePlanQuery;
import java.io.IOException;

public enum RatePlanQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, RatePlanQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    writer.name("ratePlanId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.ratePlanId);
  }
}
