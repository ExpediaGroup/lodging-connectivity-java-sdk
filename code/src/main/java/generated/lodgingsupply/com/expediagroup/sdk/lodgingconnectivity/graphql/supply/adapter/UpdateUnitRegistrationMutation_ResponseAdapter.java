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
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UpdateUnitRegistrationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ApplicableRegulationsKey;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ApplicableRegulationsKey_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UpdateUnitRegistrationMutation_ResponseAdapter {
  public enum Data implements Adapter<UpdateUnitRegistrationMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("updateUnitRegistration");

    @Override
    public UpdateUnitRegistrationMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UpdateUnitRegistrationMutation.UpdateUnitRegistration _updateUnitRegistration = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _updateUnitRegistration = new ObjectAdapter<UpdateUnitRegistrationMutation.UpdateUnitRegistration>(UpdateUnitRegistration.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_updateUnitRegistration, "updateUnitRegistration");

      return new UpdateUnitRegistrationMutation.Data(
        _updateUnitRegistration
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateUnitRegistrationMutation.Data value) throws IOException {
      writer.name("updateUnitRegistration");
      new ObjectAdapter<UpdateUnitRegistrationMutation.UpdateUnitRegistration>(UpdateUnitRegistration.INSTANCE, false).toJson(writer, customScalarAdapters, value.updateUnitRegistration);
    }
  }

  public enum UpdateUnitRegistration implements Adapter<UpdateUnitRegistrationMutation.UpdateUnitRegistration> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("district", "complete", "details", "applicableRegulations");

    @Override
    public UpdateUnitRegistrationMutation.UpdateUnitRegistration fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _district = null;
      Boolean _complete = null;
      List<UpdateUnitRegistrationMutation.Detail> _details = null;
      Optional<List<UpdateUnitRegistrationMutation.ApplicableRegulation>> _applicableRegulations = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _district = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _complete = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _details = new ListAdapter<>(new ObjectAdapter<UpdateUnitRegistrationMutation.Detail>(Detail.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 3: _applicableRegulations = new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<UpdateUnitRegistrationMutation.ApplicableRegulation>(ApplicableRegulation.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_complete, "complete");
      Assertions.checkFieldNotMissing(_details, "details");

      return new UpdateUnitRegistrationMutation.UpdateUnitRegistration(
        _district,
        _complete,
        _details,
        _applicableRegulations
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateUnitRegistrationMutation.UpdateUnitRegistration value) throws IOException {
      writer.name("district");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.district);

      writer.name("complete");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.complete);

      writer.name("details");
      new ListAdapter<>(new ObjectAdapter<UpdateUnitRegistrationMutation.Detail>(Detail.INSTANCE, false)).toJson(writer, customScalarAdapters, value.details);

      writer.name("applicableRegulations");
      new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<UpdateUnitRegistrationMutation.ApplicableRegulation>(ApplicableRegulation.INSTANCE, false))).toJson(writer, customScalarAdapters, value.applicableRegulations);
    }
  }

  public enum Detail implements Adapter<UpdateUnitRegistrationMutation.Detail> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("unitId");

    @Override
    public UpdateUnitRegistrationMutation.Detail fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _unitId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _unitId = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_unitId, "unitId");

      return new UpdateUnitRegistrationMutation.Detail(
        _unitId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateUnitRegistrationMutation.Detail value) throws IOException {
      writer.name("unitId");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.unitId);
    }
  }

  public enum ApplicableRegulation implements Adapter<UpdateUnitRegistrationMutation.ApplicableRegulation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("key", "value");

    @Override
    public UpdateUnitRegistrationMutation.ApplicableRegulation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<ApplicableRegulationsKey> _key = null;
      Optional<String> _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _key = new OptionalAdapter<>(ApplicableRegulationsKey_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 1: _value = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UpdateUnitRegistrationMutation.ApplicableRegulation(
        _key,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateUnitRegistrationMutation.ApplicableRegulation value) throws IOException {
      writer.name("key");
      new OptionalAdapter<>(ApplicableRegulationsKey_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.key);

      writer.name("value");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }
}
