//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.Assertions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.EnablePropertyMutation;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class EnablePropertyMutation_ResponseAdapter {
  public enum Data implements Adapter<EnablePropertyMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("enableProperty");

    @Override
    public EnablePropertyMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      EnablePropertyMutation.EnableProperty _enableProperty = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _enableProperty = new NullableAdapter<>(new ObjectAdapter<EnablePropertyMutation.EnableProperty>(EnableProperty.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new EnablePropertyMutation.Data(
        _enableProperty
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        EnablePropertyMutation.Data value) throws IOException {
      writer.name("enableProperty");
      new NullableAdapter<>(new ObjectAdapter<EnablePropertyMutation.EnableProperty>(EnableProperty.INSTANCE, false)).toJson(writer, customScalarAdapters, value.enableProperty);
    }
  }

  public enum EnableProperty implements Adapter<EnablePropertyMutation.EnableProperty> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "id");

    @Override
    public EnablePropertyMutation.EnableProperty fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _clientMutationId = null;
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new EnablePropertyMutation.EnableProperty(
        _clientMutationId,
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        EnablePropertyMutation.EnableProperty value) throws IOException {
      writer.name("clientMutationId");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }
}
