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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyPromotionsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.FiltersInput_InputAdapter;
import java.io.IOException;

public enum PropertyPromotionsQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, PropertyPromotionsQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.filter instanceof Optional.Present) {
      writer.name("filter");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<FiltersInput>(FiltersInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.filter);
    }
    writer.name("pageSize");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.pageSize);
    if (value.after instanceof Optional.Present) {
      writer.name("after");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.after);
    }
  }
}
