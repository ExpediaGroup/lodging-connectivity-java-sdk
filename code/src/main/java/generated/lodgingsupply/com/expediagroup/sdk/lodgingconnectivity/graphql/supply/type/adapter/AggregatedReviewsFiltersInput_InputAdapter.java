//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AggregatedReviewsFiltersInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum AggregatedReviewsFiltersInput_InputAdapter implements Adapter<AggregatedReviewsFiltersInput> {
  INSTANCE;

  @Override
  public AggregatedReviewsFiltersInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      AggregatedReviewsFiltersInput value) throws IOException {
    writer.name("brandNames");
    new ListAdapter<>(ReviewBrand_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.brandNames);
  }
}