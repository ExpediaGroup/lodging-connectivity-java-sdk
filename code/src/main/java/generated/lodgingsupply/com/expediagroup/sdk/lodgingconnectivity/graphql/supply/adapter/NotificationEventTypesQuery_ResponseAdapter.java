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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.NotificationEventTypesQuery;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class NotificationEventTypesQuery_ResponseAdapter {
  public enum Data implements Adapter<NotificationEventTypesQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("notificationEventTypes");

    @Override
    public NotificationEventTypesQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<NotificationEventTypesQuery.NotificationEventType> _notificationEventTypes = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _notificationEventTypes = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<NotificationEventTypesQuery.NotificationEventType>(NotificationEventType.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new NotificationEventTypesQuery.Data(
        _notificationEventTypes
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationEventTypesQuery.Data value) throws IOException {
      writer.name("notificationEventTypes");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<NotificationEventTypesQuery.NotificationEventType>(NotificationEventType.INSTANCE, false))).toJson(writer, customScalarAdapters, value.notificationEventTypes);
    }
  }

  public enum NotificationEventType implements Adapter<NotificationEventTypesQuery.NotificationEventType> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("description", "name");

    @Override
    public NotificationEventTypesQuery.NotificationEventType fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _description = null;
      String _name = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _description = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_description, "description");
      Assertions.checkFieldNotMissing(_name, "name");

      return new NotificationEventTypesQuery.NotificationEventType(
        _description,
        _name
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        NotificationEventTypesQuery.NotificationEventType value) throws IOException {
      writer.name("description");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.description);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);
    }
  }
}
