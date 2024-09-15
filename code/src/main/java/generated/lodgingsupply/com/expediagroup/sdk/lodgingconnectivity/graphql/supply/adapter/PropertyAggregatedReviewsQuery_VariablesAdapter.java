//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyAggregatedReviewsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AggregatedReviewsFiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.AggregatedReviewsFiltersInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum PropertyAggregatedReviewsQuery_VariablesAdapter implements Adapter<PropertyAggregatedReviewsQuery> {
  INSTANCE;

  @Override
  public PropertyAggregatedReviewsQuery fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      PropertyAggregatedReviewsQuery value) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    writer.name("filters");
    new ObjectAdapter<AggregatedReviewsFiltersInput>(AggregatedReviewsFiltersInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.filters);
  }
}