//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CancelVrboReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CancelVrboReservationMutation_ResponseAdapter {
  public enum Data implements Adapter<CancelVrboReservationMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cancelVrboReservation");

    @Override
    public CancelVrboReservationMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      CancelVrboReservationMutation.CancelVrboReservation _cancelVrboReservation = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cancelVrboReservation = new ObjectAdapter<CancelVrboReservationMutation.CancelVrboReservation>(CancelVrboReservation.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_cancelVrboReservation, "cancelVrboReservation");

      return new CancelVrboReservationMutation.Data(
        _cancelVrboReservation
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CancelVrboReservationMutation.Data value) throws IOException {
      writer.name("cancelVrboReservation");
      new ObjectAdapter<CancelVrboReservationMutation.CancelVrboReservation>(CancelVrboReservation.INSTANCE, false).toJson(writer, customScalarAdapters, value.cancelVrboReservation);
    }
  }

  public enum CancelVrboReservation implements Adapter<CancelVrboReservationMutation.CancelVrboReservation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "reservation");

    @Override
    public CancelVrboReservationMutation.CancelVrboReservation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _clientMutationId = null;
      Optional<CancelVrboReservationMutation.Reservation> _reservation = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _reservation = new OptionalAdapter<>(new ObjectAdapter<CancelVrboReservationMutation.Reservation>(Reservation.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new CancelVrboReservationMutation.CancelVrboReservation(
        _clientMutationId,
        _reservation
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CancelVrboReservationMutation.CancelVrboReservation value) throws IOException {
      writer.name("clientMutationId");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("reservation");
      new OptionalAdapter<>(new ObjectAdapter<CancelVrboReservationMutation.Reservation>(Reservation.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservation);
    }
  }

  public enum Reservation implements Adapter<CancelVrboReservationMutation.Reservation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public CancelVrboReservationMutation.Reservation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new CancelVrboReservationMutation.Reservation(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CancelVrboReservationMutation.Reservation value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }
}
