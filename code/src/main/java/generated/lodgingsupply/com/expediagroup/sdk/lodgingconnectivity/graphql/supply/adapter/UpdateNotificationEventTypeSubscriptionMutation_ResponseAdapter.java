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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UpdateNotificationEventTypeSubscriptionMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class UpdateNotificationEventTypeSubscriptionMutation_ResponseAdapter {
  public enum Data implements Adapter<UpdateNotificationEventTypeSubscriptionMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("updateNotificationEventTypeSubscription");

    @Override
    public UpdateNotificationEventTypeSubscriptionMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription _updateNotificationEventTypeSubscription = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _updateNotificationEventTypeSubscription = new NullableAdapter<>(new ObjectAdapter<UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription>(UpdateNotificationEventTypeSubscription.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UpdateNotificationEventTypeSubscriptionMutation.Data(
        _updateNotificationEventTypeSubscription
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateNotificationEventTypeSubscriptionMutation.Data value) throws IOException {
      writer.name("updateNotificationEventTypeSubscription");
      new NullableAdapter<>(new ObjectAdapter<UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription>(UpdateNotificationEventTypeSubscription.INSTANCE, false)).toJson(writer, customScalarAdapters, value.updateNotificationEventTypeSubscription);
    }
  }

  public enum UpdateNotificationEventTypeSubscription implements Adapter<UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackConfig", "eventType");

    @Override
    public UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig _callbackConfig = null;
      String _eventType = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _callbackConfig = new ObjectAdapter<UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig>(CallbackConfig.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _eventType = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_callbackConfig, "callbackConfig");
      Assertions.checkFieldNotMissing(_eventType, "eventType");

      return new UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription(
        _callbackConfig,
        _eventType
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateNotificationEventTypeSubscriptionMutation.UpdateNotificationEventTypeSubscription value)
        throws IOException {
      writer.name("callbackConfig");
      new ObjectAdapter<UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig>(CallbackConfig.INSTANCE, false).toJson(writer, customScalarAdapters, value.callbackConfig);

      writer.name("eventType");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.eventType);
    }
  }

  public enum CallbackConfig implements Adapter<UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackUrl", "contactEmail", "id", "requestTimeoutSeconds", "secretExpirationDateTime");

    @Override
    public UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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

      return new UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig(
        _callbackUrl,
        _contactEmail,
        _id,
        _requestTimeoutSeconds,
        _secretExpirationDateTime
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateNotificationEventTypeSubscriptionMutation.CallbackConfig value) throws IOException {
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