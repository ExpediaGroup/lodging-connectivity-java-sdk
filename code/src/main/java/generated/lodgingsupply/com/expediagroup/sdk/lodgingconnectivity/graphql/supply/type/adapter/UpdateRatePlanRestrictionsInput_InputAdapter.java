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
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DateRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IntRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateRatePlanRestrictionsInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateRatePlanRestrictionsInput_InputAdapter implements Adapter<UpdateRatePlanRestrictionsInput> {
  INSTANCE;

  @Override
  public UpdateRatePlanRestrictionsInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateRatePlanRestrictionsInput value) throws IOException {
    if (value.advanceBookingDays instanceof Optional.Present) {
      writer.name("advanceBookingDays");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.advanceBookingDays);
    }
    if (value.lengthOfStay instanceof Optional.Present) {
      writer.name("lengthOfStay");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.lengthOfStay);
    }
    if (value.reservationDates instanceof Optional.Present) {
      writer.name("reservationDates");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<DateRangeInput>(DateRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.reservationDates);
    }
    if (value.travelDates instanceof Optional.Present) {
      writer.name("travelDates");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<DateRangeInput>(DateRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.travelDates);
    }
  }
}
