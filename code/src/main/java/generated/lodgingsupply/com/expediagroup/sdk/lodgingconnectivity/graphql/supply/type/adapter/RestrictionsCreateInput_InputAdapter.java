//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RestrictionsCreateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum RestrictionsCreateInput_InputAdapter implements Adapter<RestrictionsCreateInput> {
  INSTANCE;

  @Override
  public RestrictionsCreateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      RestrictionsCreateInput value) throws IOException {
    if (value.isMemberOnly.isPresent()) {
      writer.name("isMemberOnly");
      new OptionalAdapter<>(OptionalAdapters.OptionalBooleanAdapter).toJson(writer, customScalarAdapters, value.isMemberOnly);
    }
    if (value.isMobileUserOnly.isPresent()) {
      writer.name("isMobileUserOnly");
      new OptionalAdapter<>(OptionalAdapters.OptionalBooleanAdapter).toJson(writer, customScalarAdapters, value.isMobileUserOnly);
    }
    if (value.minLengthOfStay.isPresent()) {
      writer.name("minLengthOfStay");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.minLengthOfStay);
    }
    if (value.maxLengthOfStay.isPresent()) {
      writer.name("maxLengthOfStay");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.maxLengthOfStay);
    }
    if (value.minAdvanceBookingDays.isPresent()) {
      writer.name("minAdvanceBookingDays");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.minAdvanceBookingDays);
    }
    if (value.maxAdvanceBookingDays.isPresent()) {
      writer.name("maxAdvanceBookingDays");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.maxAdvanceBookingDays);
    }
    writer.name("bookingLocalDateTimeFrom");
    com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.bookingLocalDateTimeFrom);
    writer.name("bookingLocalDateTimeTo");
    com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.bookingLocalDateTimeTo);
    writer.name("travelDateFrom");
    com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateFrom);
    writer.name("travelDateTo");
    com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateTo);
    if (value.sameDayBookingStartTime.isPresent()) {
      writer.name("sameDayBookingStartTime");
      new OptionalAdapter<>(new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalTimeAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.sameDayBookingStartTime);
    }
  }
}
