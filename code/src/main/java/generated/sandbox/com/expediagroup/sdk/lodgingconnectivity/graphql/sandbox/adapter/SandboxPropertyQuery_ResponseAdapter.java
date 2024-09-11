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
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertyQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationFragment;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class SandboxPropertyQuery_ResponseAdapter {
  public enum Data implements Adapter<SandboxPropertyQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("property");

    @Override
    public SandboxPropertyQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SandboxPropertyQuery.Property _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _property = new ObjectAdapter<SandboxPropertyQuery.Property>(Property.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_property, "property");

      return new SandboxPropertyQuery.Data(
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxPropertyQuery.Data value) throws IOException {
      writer.name("property");
      new ObjectAdapter<SandboxPropertyQuery.Property>(Property.INSTANCE, false).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<SandboxPropertyQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "reservations");

    @Override
    public SandboxPropertyQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _name = null;
      SandboxPropertyQuery.Reservations _reservations = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _reservations = new NullableAdapter<>(new ObjectAdapter<SandboxPropertyQuery.Reservations>(Reservations.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");

      return new SandboxPropertyQuery.Property(
        _id,
        _name,
        _reservations
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxPropertyQuery.Property value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);

      writer.name("reservations");
      new NullableAdapter<>(new ObjectAdapter<SandboxPropertyQuery.Reservations>(Reservations.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservations);
    }
  }

  public enum Reservations implements Adapter<SandboxPropertyQuery.Reservations> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cursor", "totalCount", "elements");

    @Override
    public SandboxPropertyQuery.Reservations fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _cursor = null;
      Integer _totalCount = null;
      List<SandboxPropertyQuery.Element> _elements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cursor = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _totalCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _elements = new ListAdapter<>(new ObjectAdapter<SandboxPropertyQuery.Element>(Element.INSTANCE, true)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_totalCount, "totalCount");
      Assertions.checkFieldNotMissing(_elements, "elements");

      return new SandboxPropertyQuery.Reservations(
        _cursor,
        _totalCount,
        _elements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxPropertyQuery.Reservations value) throws IOException {
      writer.name("cursor");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.cursor);

      writer.name("totalCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalCount);

      writer.name("elements");
      new ListAdapter<>(new ObjectAdapter<SandboxPropertyQuery.Element>(Element.INSTANCE, true)).toJson(writer, customScalarAdapters, value.elements);
    }
  }

  public enum Element implements Adapter<SandboxPropertyQuery.Element> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename");

    @Override
    public SandboxPropertyQuery.Element fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String __typename = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: __typename = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      reader.rewind();
      SandboxReservationFragment _sandboxReservationFragment = com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationFragmentImpl_ResponseAdapter.SandboxReservationFragment.INSTANCE.fromJson(reader, customScalarAdapters);

      Assertions.checkFieldNotMissing(__typename, "__typename");

      return new SandboxPropertyQuery.Element(
        __typename,
        _sandboxReservationFragment
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxPropertyQuery.Element value) throws IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationFragmentImpl_ResponseAdapter.SandboxReservationFragment.INSTANCE.toJson(writer, customScalarAdapters, value.sandboxReservationFragment);
    }
  }
}
