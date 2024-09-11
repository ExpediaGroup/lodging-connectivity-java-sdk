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
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.NotificationProfileQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class NotificationProfileQuery_ResponseAdapter {
  public enum Data implements Adapter<NotificationProfileQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("notificationProfile");

    @Override
    public NotificationProfileQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      NotificationProfileQuery.NotificationProfile _notificationProfile = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _notificationProfile = new NullableAdapter<>(new ObjectAdapter<NotificationProfileQuery.NotificationProfile>(NotificationProfile.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new NotificationProfileQuery.Data(
        _notificationProfile
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.Data value) throws IOException {
      writer.name("notificationProfile");
      new NullableAdapter<>(new ObjectAdapter<NotificationProfileQuery.NotificationProfile>(NotificationProfile.INSTANCE, false)).toJson(writer, customScalarAdapters, value.notificationProfile);
    }
  }

  public enum NotificationProfile implements Adapter<NotificationProfileQuery.NotificationProfile> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackConfigs", "subscriptions");

    @Override
    public NotificationProfileQuery.NotificationProfile fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<NotificationProfileQuery.CallbackConfig> _callbackConfigs = null;
      List<NotificationProfileQuery.Subscription> _subscriptions = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _callbackConfigs = new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.CallbackConfig>(CallbackConfig.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _subscriptions = new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.Subscription>(Subscription.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_callbackConfigs, "callbackConfigs");
      Assertions.checkFieldNotMissing(_subscriptions, "subscriptions");

      return new NotificationProfileQuery.NotificationProfile(
        _callbackConfigs,
        _subscriptions
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.NotificationProfile value) throws IOException {
      writer.name("callbackConfigs");
      new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.CallbackConfig>(CallbackConfig.INSTANCE, false)).toJson(writer, customScalarAdapters, value.callbackConfigs);

      writer.name("subscriptions");
      new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.Subscription>(Subscription.INSTANCE, false)).toJson(writer, customScalarAdapters, value.subscriptions);
    }
  }

  public enum CallbackConfig implements Adapter<NotificationProfileQuery.CallbackConfig> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackUrl", "contactEmail", "id", "requestTimeoutSeconds", "secretExpirationDateTime");

    @Override
    public NotificationProfileQuery.CallbackConfig fromJson(JsonReader reader,
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

      return new NotificationProfileQuery.CallbackConfig(
        _callbackUrl,
        _contactEmail,
        _id,
        _requestTimeoutSeconds,
        _secretExpirationDateTime
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.CallbackConfig value) throws IOException {
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

  public enum Subscription implements Adapter<NotificationProfileQuery.Subscription> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("eventTypeSubscriptions", "product");

    @Override
    public NotificationProfileQuery.Subscription fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<NotificationProfileQuery.EventTypeSubscription> _eventTypeSubscriptions = null;
      String _product = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _eventTypeSubscriptions = new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.EventTypeSubscription>(EventTypeSubscription.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _product = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_eventTypeSubscriptions, "eventTypeSubscriptions");
      Assertions.checkFieldNotMissing(_product, "product");

      return new NotificationProfileQuery.Subscription(
        _eventTypeSubscriptions,
        _product
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.Subscription value) throws IOException {
      writer.name("eventTypeSubscriptions");
      new ListAdapter<>(new ObjectAdapter<NotificationProfileQuery.EventTypeSubscription>(EventTypeSubscription.INSTANCE, false)).toJson(writer, customScalarAdapters, value.eventTypeSubscriptions);

      writer.name("product");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.product);
    }
  }

  public enum EventTypeSubscription implements Adapter<NotificationProfileQuery.EventTypeSubscription> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackConfig", "eventType");

    @Override
    public NotificationProfileQuery.EventTypeSubscription fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      NotificationProfileQuery.CallbackConfig1 _callbackConfig = null;
      String _eventType = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _callbackConfig = new ObjectAdapter<NotificationProfileQuery.CallbackConfig1>(CallbackConfig1.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _eventType = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_callbackConfig, "callbackConfig");
      Assertions.checkFieldNotMissing(_eventType, "eventType");

      return new NotificationProfileQuery.EventTypeSubscription(
        _callbackConfig,
        _eventType
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.EventTypeSubscription value) throws IOException {
      writer.name("callbackConfig");
      new ObjectAdapter<NotificationProfileQuery.CallbackConfig1>(CallbackConfig1.INSTANCE, false).toJson(writer, customScalarAdapters, value.callbackConfig);

      writer.name("eventType");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.eventType);
    }
  }

  public enum CallbackConfig1 implements Adapter<NotificationProfileQuery.CallbackConfig1> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("callbackUrl", "contactEmail", "id", "requestTimeoutSeconds", "secretExpirationDateTime");

    @Override
    public NotificationProfileQuery.CallbackConfig1 fromJson(JsonReader reader,
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

      return new NotificationProfileQuery.CallbackConfig1(
        _callbackUrl,
        _contactEmail,
        _id,
        _requestTimeoutSeconds,
        _secretExpirationDateTime
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationProfileQuery.CallbackConfig1 value) throws IOException {
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
