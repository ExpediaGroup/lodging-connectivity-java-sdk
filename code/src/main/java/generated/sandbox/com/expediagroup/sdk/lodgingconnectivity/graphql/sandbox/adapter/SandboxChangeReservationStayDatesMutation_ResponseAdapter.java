//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxChangeReservationStayDatesMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SandboxChangeReservationStayDatesMutation_ResponseAdapter {
  public enum Data implements Adapter<SandboxChangeReservationStayDatesMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("changeReservationStayDates");

    @Override
    public SandboxChangeReservationStayDatesMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates _changeReservationStayDates = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _changeReservationStayDates = new ObjectAdapter<SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates>(ChangeReservationStayDates.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_changeReservationStayDates, "changeReservationStayDates");

      return new SandboxChangeReservationStayDatesMutation.Data(
        _changeReservationStayDates
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxChangeReservationStayDatesMutation.Data value) throws IOException {
      writer.name("changeReservationStayDates");
      new ObjectAdapter<SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates>(ChangeReservationStayDates.INSTANCE, false).toJson(writer, customScalarAdapters, value.changeReservationStayDates);
    }
  }

  public enum ChangeReservationStayDates implements Adapter<SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "reservation");

    @Override
    public SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _clientMutationId = null;
      SandboxChangeReservationStayDatesMutation.Reservation _reservation = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _reservation = new ObjectAdapter<SandboxChangeReservationStayDatesMutation.Reservation>(Reservation.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_reservation, "reservation");

      return new SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates(
        _clientMutationId,
        _reservation
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxChangeReservationStayDatesMutation.ChangeReservationStayDates value) throws
        IOException {
      writer.name("clientMutationId");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("reservation");
      new ObjectAdapter<SandboxChangeReservationStayDatesMutation.Reservation>(Reservation.INSTANCE, false).toJson(writer, customScalarAdapters, value.reservation);
    }
  }

  public enum Reservation implements Adapter<SandboxChangeReservationStayDatesMutation.Reservation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "checkInDate", "checkOutDate");

    @Override
    public SandboxChangeReservationStayDatesMutation.Reservation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      LocalDate _checkInDate = null;
      LocalDate _checkOutDate = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _checkInDate = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _checkOutDate = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_checkInDate, "checkInDate");
      Assertions.checkFieldNotMissing(_checkOutDate, "checkOutDate");

      return new SandboxChangeReservationStayDatesMutation.Reservation(
        _id,
        _checkInDate,
        _checkOutDate
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxChangeReservationStayDatesMutation.Reservation value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("checkInDate");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkOutDate);
    }
  }
}
