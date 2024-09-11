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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.AddMessageMutation;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class AddMessageMutation_ResponseAdapter {
  public enum Data implements Adapter<AddMessageMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("addMessage");

    @Override
    public AddMessageMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      AddMessageMutation.AddMessage _addMessage = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _addMessage = new ObjectAdapter<AddMessageMutation.AddMessage>(AddMessage.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_addMessage, "addMessage");

      return new AddMessageMutation.Data(
        _addMessage
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        AddMessageMutation.Data value) throws IOException {
      writer.name("addMessage");
      new ObjectAdapter<AddMessageMutation.AddMessage>(AddMessage.INSTANCE, false).toJson(writer, customScalarAdapters, value.addMessage);
    }
  }

  public enum AddMessage implements Adapter<AddMessageMutation.AddMessage> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public AddMessageMutation.AddMessage fromJson(JsonReader reader,
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

      return new AddMessageMutation.AddMessage(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        AddMessageMutation.AddMessage value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }
}
