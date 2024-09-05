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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UndeliveredNotificationsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.JSON;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class UndeliveredNotificationsQuery_ResponseAdapter {
  public enum Data implements Adapter<UndeliveredNotificationsQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("undeliveredNotifications");

    @Override
    public UndeliveredNotificationsQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UndeliveredNotificationsQuery.UndeliveredNotifications _undeliveredNotifications = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _undeliveredNotifications = new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.UndeliveredNotifications>(UndeliveredNotifications.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UndeliveredNotificationsQuery.Data(
        _undeliveredNotifications
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UndeliveredNotificationsQuery.Data value) throws IOException {
      writer.name("undeliveredNotifications");
      new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.UndeliveredNotifications>(UndeliveredNotifications.INSTANCE, false)).toJson(writer, customScalarAdapters, value.undeliveredNotifications);
    }
  }

  public enum UndeliveredNotifications implements Adapter<UndeliveredNotificationsQuery.UndeliveredNotifications> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cursor", "totalCount", "elements");

    @Override
    public UndeliveredNotificationsQuery.UndeliveredNotifications fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _cursor = null;
      Integer _totalCount = null;
      List<UndeliveredNotificationsQuery.Element> _elements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cursor = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _totalCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _elements = new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.Element>(Element.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_totalCount, "totalCount");
      Assertions.checkFieldNotMissing(_elements, "elements");

      return new UndeliveredNotificationsQuery.UndeliveredNotifications(
        _cursor,
        _totalCount,
        _elements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UndeliveredNotificationsQuery.UndeliveredNotifications value) throws IOException {
      writer.name("cursor");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.cursor);

      writer.name("totalCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalCount);

      writer.name("elements");
      new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.Element>(Element.INSTANCE, false))).toJson(writer, customScalarAdapters, value.elements);
    }
  }

  public enum Element implements Adapter<UndeliveredNotificationsQuery.Element> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("error", "notification");

    @Override
    public UndeliveredNotificationsQuery.Element fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UndeliveredNotificationsQuery.Error _error = null;
      UndeliveredNotificationsQuery.Notification _notification = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _error = new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.Error>(Error.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _notification = new ObjectAdapter<UndeliveredNotificationsQuery.Notification>(Notification.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_notification, "notification");

      return new UndeliveredNotificationsQuery.Element(
        _error,
        _notification
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UndeliveredNotificationsQuery.Element value) throws IOException {
      writer.name("error");
      new NullableAdapter<>(new ObjectAdapter<UndeliveredNotificationsQuery.Error>(Error.INSTANCE, false)).toJson(writer, customScalarAdapters, value.error);

      writer.name("notification");
      new ObjectAdapter<UndeliveredNotificationsQuery.Notification>(Notification.INSTANCE, false).toJson(writer, customScalarAdapters, value.notification);
    }
  }

  public enum Error implements Adapter<UndeliveredNotificationsQuery.Error> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("code", "message");

    @Override
    public UndeliveredNotificationsQuery.Error fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _code = null;
      String _message = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _code = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _message = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_code, "code");
      Assertions.checkFieldNotMissing(_message, "message");

      return new UndeliveredNotificationsQuery.Error(
        _code,
        _message
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UndeliveredNotificationsQuery.Error value) throws IOException {
      writer.name("code");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.code);

      writer.name("message");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.message);
    }
  }

  public enum Notification implements Adapter<UndeliveredNotificationsQuery.Notification> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("creationDateTime", "eventType", "notificationId", "payload");

    @Override
    public UndeliveredNotificationsQuery.Notification fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _creationDateTime = null;
      String _eventType = null;
      String _notificationId = null;
      String _payload = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _creationDateTime = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _eventType = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _notificationId = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _payload = (customScalarAdapters.<String>responseAdapterFor(JSON.type)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_creationDateTime, "creationDateTime");
      Assertions.checkFieldNotMissing(_eventType, "eventType");
      Assertions.checkFieldNotMissing(_notificationId, "notificationId");
      Assertions.checkFieldNotMissing(_payload, "payload");

      return new UndeliveredNotificationsQuery.Notification(
        _creationDateTime,
        _eventType,
        _notificationId,
        _payload
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UndeliveredNotificationsQuery.Notification value) throws IOException {
      writer.name("creationDateTime");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.creationDateTime);

      writer.name("eventType");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.eventType);

      writer.name("notificationId");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.notificationId);

      writer.name("payload");
      (customScalarAdapters.<String>responseAdapterFor(JSON.type)).toJson(writer, customScalarAdapters, value.payload);
    }
  }
}
