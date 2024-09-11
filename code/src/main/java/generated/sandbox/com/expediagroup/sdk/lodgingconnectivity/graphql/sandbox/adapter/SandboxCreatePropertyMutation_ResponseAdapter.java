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
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCreatePropertyMutation;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class SandboxCreatePropertyMutation_ResponseAdapter {
  public enum Data implements Adapter<SandboxCreatePropertyMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("createProperty");

    @Override
    public SandboxCreatePropertyMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SandboxCreatePropertyMutation.CreateProperty _createProperty = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _createProperty = new ObjectAdapter<SandboxCreatePropertyMutation.CreateProperty>(CreateProperty.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_createProperty, "createProperty");

      return new SandboxCreatePropertyMutation.Data(
        _createProperty
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxCreatePropertyMutation.Data value) throws IOException {
      writer.name("createProperty");
      new ObjectAdapter<SandboxCreatePropertyMutation.CreateProperty>(CreateProperty.INSTANCE, false).toJson(writer, customScalarAdapters, value.createProperty);
    }
  }

  public enum CreateProperty implements Adapter<SandboxCreatePropertyMutation.CreateProperty> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "property");

    @Override
    public SandboxCreatePropertyMutation.CreateProperty fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _clientMutationId = null;
      SandboxCreatePropertyMutation.Property _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _property = new ObjectAdapter<SandboxCreatePropertyMutation.Property>(Property.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_property, "property");

      return new SandboxCreatePropertyMutation.CreateProperty(
        _clientMutationId,
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxCreatePropertyMutation.CreateProperty value) throws IOException {
      writer.name("clientMutationId");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("property");
      new ObjectAdapter<SandboxCreatePropertyMutation.Property>(Property.INSTANCE, false).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<SandboxCreatePropertyMutation.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name");

    @Override
    public SandboxCreatePropertyMutation.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _name = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");

      return new SandboxCreatePropertyMutation.Property(
        _id,
        _name
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SandboxCreatePropertyMutation.Property value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);
    }
  }
}
