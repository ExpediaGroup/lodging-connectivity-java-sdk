//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewsOrderBy;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum ReviewsOrderBy_InputAdapter implements Adapter<ReviewsOrderBy> {
  INSTANCE;

  @Override
  public ReviewsOrderBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      ReviewsOrderBy value) throws IOException {
    if (value.createdDateTime instanceof Optional.Present) {
      writer.name("createdDateTime");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.createdDateTime);
    }
    if (value.lastUpdatedDateTime instanceof Optional.Present) {
      writer.name("lastUpdatedDateTime");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.lastUpdatedDateTime);
    }
    if (value.ownerResponseCreatedDateTime instanceof Optional.Present) {
      writer.name("ownerResponseCreatedDateTime");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.ownerResponseCreatedDateTime);
    }
    if (value.ownerResponseLastUpdatedDateTime instanceof Optional.Present) {
      writer.name("ownerResponseLastUpdatedDateTime");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.ownerResponseLastUpdatedDateTime);
    }
    if (value.reservationCheckInDate instanceof Optional.Present) {
      writer.name("reservationCheckInDate");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.reservationCheckInDate);
    }
    if (value.reservationCheckOutDate instanceof Optional.Present) {
      writer.name("reservationCheckOutDate");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(SortOrder_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.reservationCheckOutDate);
    }
  }
}