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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreateNotificationCallbackConfigMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CreateNotificationCallbackConfigMutation_ResponseAdapter {
  public enum Data implements Adapter<CreateNotificationCallbackConfigMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("createNotificationCallbackConfig");

    @Override
    public CreateNotificationCallbackConfigMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig _createNotificationCallbackConfig = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _createNotificationCallbackConfig = new NullableAdapter<>(new ObjectAdapter<CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig>(CreateNotificationCallbackConfig.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new CreateNotificationCallbackConfigMutation.Data(
        _createNotificationCallbackConfig
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateNotificationCallbackConfigMutation.Data value) throws IOException {
      writer.name("createNotificationCallbackConfig");
      new NullableAdapter<>(new ObjectAdapter<CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig>(CreateNotificationCallbackConfig.INSTANCE, false)).toJson(writer, customScalarAdapters, value.createNotificationCallbackConfig);
    }
  }

  public enum CreateNotificationCallbackConfig implements Adapter<CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackConfig", "secret");

    @Override
    public CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      CreateNotificationCallbackConfigMutation.CallbackConfig _callbackConfig = null;
      String _secret = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _callbackConfig = new ObjectAdapter<CreateNotificationCallbackConfigMutation.CallbackConfig>(CallbackConfig.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _secret = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_callbackConfig, "callbackConfig");
      Assertions.checkFieldNotMissing(_secret, "secret");

      return new CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig(
        _callbackConfig,
        _secret
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateNotificationCallbackConfigMutation.CreateNotificationCallbackConfig value) throws
        IOException {
      writer.name("callbackConfig");
      new ObjectAdapter<CreateNotificationCallbackConfigMutation.CallbackConfig>(CallbackConfig.INSTANCE, false).toJson(writer, customScalarAdapters, value.callbackConfig);

      writer.name("secret");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.secret);
    }
  }

  public enum CallbackConfig implements Adapter<CreateNotificationCallbackConfigMutation.CallbackConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackUrl", "contactEmail", "id", "requestTimeoutSeconds", "secretExpirationDateTime");

    @Override
    public CreateNotificationCallbackConfigMutation.CallbackConfig fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      URL _callbackUrl = null;
      String _contactEmail = null;
      String _id = null;
      Integer _requestTimeoutSeconds = null;
      LocalDateTime _secretExpirationDateTime = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _callbackUrl = com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 1: _contactEmail = new NullableAdapter<>((customScalarAdapters.<String>responseAdapterFor(EmailAddress.type))).fromJson(reader, customScalarAdapters); break;
          case 2: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _requestTimeoutSeconds = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _secretExpirationDateTime = com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_callbackUrl, "callbackUrl");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_requestTimeoutSeconds, "requestTimeoutSeconds");
      Assertions.checkFieldNotMissing(_secretExpirationDateTime, "secretExpirationDateTime");

      return new CreateNotificationCallbackConfigMutation.CallbackConfig(
        _callbackUrl,
        _contactEmail,
        _id,
        _requestTimeoutSeconds,
        _secretExpirationDateTime
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateNotificationCallbackConfigMutation.CallbackConfig value) throws IOException {
      writer.name("callbackUrl");
      com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.callbackUrl);

      writer.name("contactEmail");
      new NullableAdapter<>((customScalarAdapters.<String>responseAdapterFor(EmailAddress.type))).toJson(writer, customScalarAdapters, value.contactEmail);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("requestTimeoutSeconds");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.requestTimeoutSeconds);

      writer.name("secretExpirationDateTime");
      com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.secretExpirationDateTime);
    }
  }
}
