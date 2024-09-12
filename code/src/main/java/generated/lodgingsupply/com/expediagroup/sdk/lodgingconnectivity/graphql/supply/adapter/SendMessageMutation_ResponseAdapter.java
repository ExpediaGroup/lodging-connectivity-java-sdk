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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.SendMessageMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SendMessageMutation_ResponseAdapter {
  public enum Data implements Adapter<SendMessageMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("sendMessage");

    @Override
    public SendMessageMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<SendMessageMutation.SendMessage> _sendMessage = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _sendMessage = new OptionalAdapter<>(new ObjectAdapter<SendMessageMutation.SendMessage>(SendMessage.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new SendMessageMutation.Data(
        _sendMessage
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SendMessageMutation.Data value) throws IOException {
      writer.name("sendMessage");
      new OptionalAdapter<>(new ObjectAdapter<SendMessageMutation.SendMessage>(SendMessage.INSTANCE, false)).toJson(writer, customScalarAdapters, value.sendMessage);
    }
  }

  public enum SendMessage implements Adapter<SendMessageMutation.SendMessage> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "messageId");

    @Override
    public SendMessageMutation.SendMessage fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _clientMutationId = null;
      String _messageId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _messageId = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_messageId, "messageId");

      return new SendMessageMutation.SendMessage(
        _clientMutationId,
        _messageId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SendMessageMutation.SendMessage value) throws IOException {
      writer.name("clientMutationId");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("messageId");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.messageId);
    }
  }
}
