//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyReservationsMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SandboxDeletePropertyReservationsMutation_ResponseAdapter {
  public enum Data implements Adapter<SandboxDeletePropertyReservationsMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("deletePropertyReservations");

    @Override
    public SandboxDeletePropertyReservationsMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SandboxDeletePropertyReservationsMutation.DeletePropertyReservations _deletePropertyReservations = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _deletePropertyReservations = new ObjectAdapter<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations>(DeletePropertyReservations.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_deletePropertyReservations, "deletePropertyReservations");

      return new SandboxDeletePropertyReservationsMutation.Data(
        _deletePropertyReservations
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxDeletePropertyReservationsMutation.Data value) throws IOException {
      writer.name("deletePropertyReservations");
      new ObjectAdapter<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations>(DeletePropertyReservations.INSTANCE, false).toJson(writer, customScalarAdapters, value.deletePropertyReservations);
    }
  }

  public enum DeletePropertyReservations implements Adapter<SandboxDeletePropertyReservationsMutation.DeletePropertyReservations> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId");

    @Override
    public SandboxDeletePropertyReservationsMutation.DeletePropertyReservations fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _clientMutationId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new SandboxDeletePropertyReservationsMutation.DeletePropertyReservations(
        _clientMutationId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxDeletePropertyReservationsMutation.DeletePropertyReservations value) throws
        IOException {
      writer.name("clientMutationId");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);
    }
  }
}
