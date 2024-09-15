//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BookingLocalDateTimeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.FiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TravelDateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum FiltersInput_InputAdapter implements Adapter<FiltersInput> {
  INSTANCE;

  @Override
  public FiltersInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws
      IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      FiltersInput value) throws IOException {
    if (value.status instanceof Optional.Present) {
      writer.name("status");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(PromotionStatus_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.status);
    }
    if (value.discountTypes instanceof Optional.Present) {
      writer.name("discountTypes");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(DiscountType_ResponseAdapter.INSTANCE))).toJson(writer, customScalarAdapters, value.discountTypes);
    }
    if (value.id instanceof Optional.Present) {
      writer.name("id");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.id);
    }
    if (value.bookingLocalDateTime instanceof Optional.Present) {
      writer.name("bookingLocalDateTime");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<BookingLocalDateTimeInput>(BookingLocalDateTimeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.bookingLocalDateTime);
    }
    if (value.travelDate instanceof Optional.Present) {
      writer.name("travelDate");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<TravelDateInput>(TravelDateInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.travelDate);
    }
  }
}