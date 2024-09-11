//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyAmenitiesQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenitiesFiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.AmenitiesFiltersInput_InputAdapter;
import java.io.IOException;

public enum PropertyAmenitiesQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, PropertyAmenitiesQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.filters instanceof Optional.Present) {
      writer.name("filters");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<AmenitiesFiltersInput>(AmenitiesFiltersInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.filters);
    }
  }
}
