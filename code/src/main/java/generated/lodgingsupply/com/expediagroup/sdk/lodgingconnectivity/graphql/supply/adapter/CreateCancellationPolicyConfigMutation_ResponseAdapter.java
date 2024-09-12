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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreateCancellationPolicyConfigMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CreateCancellationPolicyConfigMutation_ResponseAdapter {
  public enum Data implements Adapter<CreateCancellationPolicyConfigMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("createCancellationPolicyConfig");

    @Override
    public CreateCancellationPolicyConfigMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig> _createCancellationPolicyConfig = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _createCancellationPolicyConfig = new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig>(CreateCancellationPolicyConfig.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new CreateCancellationPolicyConfigMutation.Data(
        _createCancellationPolicyConfig
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateCancellationPolicyConfigMutation.Data value) throws IOException {
      writer.name("createCancellationPolicyConfig");
      new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig>(CreateCancellationPolicyConfig.INSTANCE, false)).toJson(writer, customScalarAdapters, value.createCancellationPolicyConfig);
    }
  }

  public enum CreateCancellationPolicyConfig implements Adapter<CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cancellationPolicyConfig", "clientMutationId");

    @Override
    public CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<CreateCancellationPolicyConfigMutation.CancellationPolicyConfig> _cancellationPolicyConfig = null;
      Optional<String> _clientMutationId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cancellationPolicyConfig = new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.CancellationPolicyConfig>(CancellationPolicyConfig.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _clientMutationId = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig(
        _cancellationPolicyConfig,
        _clientMutationId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateCancellationPolicyConfigMutation.CreateCancellationPolicyConfig value) throws
        IOException {
      writer.name("cancellationPolicyConfig");
      new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.CancellationPolicyConfig>(CancellationPolicyConfig.INSTANCE, false)).toJson(writer, customScalarAdapters, value.cancellationPolicyConfig);

      writer.name("clientMutationId");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);
    }
  }

  public enum CancellationPolicyConfig implements Adapter<CreateCancellationPolicyConfigMutation.CancellationPolicyConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "property");

    @Override
    public CreateCancellationPolicyConfigMutation.CancellationPolicyConfig fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _name = null;
      Optional<CreateCancellationPolicyConfigMutation.Property> _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _property = new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");

      return new CreateCancellationPolicyConfigMutation.CancellationPolicyConfig(
        _id,
        _name,
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateCancellationPolicyConfigMutation.CancellationPolicyConfig value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);

      writer.name("property");
      new OptionalAdapter<>(new ObjectAdapter<CreateCancellationPolicyConfigMutation.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<CreateCancellationPolicyConfigMutation.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public CreateCancellationPolicyConfigMutation.Property fromJson(JsonReader reader,
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

      return new CreateCancellationPolicyConfigMutation.Property(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateCancellationPolicyConfigMutation.Property value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }
}
