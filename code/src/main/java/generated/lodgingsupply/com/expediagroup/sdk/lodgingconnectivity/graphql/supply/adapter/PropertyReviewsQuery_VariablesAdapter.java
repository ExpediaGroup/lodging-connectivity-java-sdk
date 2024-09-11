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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReviewsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewFilter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewsOrderBy;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ReviewFilter_InputAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ReviewsOrderBy_InputAdapter;
import java.io.IOException;

public enum PropertyReviewsQuery_VariablesAdapter {
  INSTANCE;

  public void serializeVariables(JsonWriter writer, PropertyReviewsQuery value,
      CustomScalarAdapters customScalarAdapters, boolean withDefaultValues) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.orderBy instanceof Optional.Present) {
      writer.name("orderBy");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<ReviewsOrderBy>(ReviewsOrderBy_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.orderBy);
    }
    if (value.filter instanceof Optional.Present) {
      writer.name("filter");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<ReviewFilter>(ReviewFilter_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.filter);
    }
    writer.name("pageSize");
    Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.pageSize);
    if (value.after instanceof Optional.Present) {
      writer.name("after");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.after);
    }
  }
}
