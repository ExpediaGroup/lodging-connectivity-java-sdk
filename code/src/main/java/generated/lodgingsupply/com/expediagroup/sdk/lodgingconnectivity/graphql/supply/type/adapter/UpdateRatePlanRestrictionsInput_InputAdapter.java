//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
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
    if (value.advanceBookingDays.isPresent()) {
      writer.name("advanceBookingDays");
      new OptionalAdapter<>(new OptionalAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.advanceBookingDays);
    }
    if (value.lengthOfStay.isPresent()) {
      writer.name("lengthOfStay");
      new OptionalAdapter<>(new OptionalAdapter<>(new ObjectAdapter<IntRangeInput>(IntRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.lengthOfStay);
    }
    if (value.reservationDates.isPresent()) {
      writer.name("reservationDates");
      new OptionalAdapter<>(new OptionalAdapter<>(new ObjectAdapter<DateRangeInput>(DateRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.reservationDates);
    }
    if (value.travelDates.isPresent()) {
      writer.name("travelDates");
      new OptionalAdapter<>(new OptionalAdapter<>(new ObjectAdapter<DateRangeInput>(DateRangeInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.travelDates);
    }
  }
}
