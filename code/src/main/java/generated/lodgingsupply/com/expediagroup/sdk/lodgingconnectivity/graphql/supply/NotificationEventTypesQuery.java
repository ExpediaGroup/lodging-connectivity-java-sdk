//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.NotificationEventTypesQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.NotificationEventTypesQuerySelections;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class NotificationEventTypesQuery implements Query<NotificationEventTypesQuery.Data> {
  public static final String OPERATION_ID = "b70cbe8a88c8e186f06fea1086437b5d6cd42f6a3f7d9bed81011cba43db0585";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query NotificationEventTypes {
   *   notificationEventTypes {
   *     description
   *     name
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query NotificationEventTypes { notificationEventTypes { description name } }";

  public static final String OPERATION_NAME = "NotificationEventTypes";

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public NotificationEventTypesQuery() {

  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NotificationEventTypesQuery) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "NotificationEventTypesQuery{"
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String id() {
    return OPERATION_ID;
  }

  @Override
  public String document() {
    return OPERATION_DOCUMENT;
  }

  @Override
  public String name() {
    return OPERATION_NAME;
  }

  @Override
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    // This operation doesn't have any variable
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(NotificationEventTypesQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query.type
    )
    .selections(NotificationEventTypesQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    Builder() {
    }

    public NotificationEventTypesQuery build() {
      return new NotificationEventTypesQuery();
    }
  }

  public static class Data implements Query.Data {
    /**
     * Retrieves available event types to subscribe to
     */
    public List<NotificationEventType> notificationEventTypes;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(List<NotificationEventType> notificationEventTypes) {
      this.notificationEventTypes = notificationEventTypes;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.notificationEventTypes == null) ? (that.notificationEventTypes == null) : this.notificationEventTypes.equals(that.notificationEventTypes));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (notificationEventTypes == null) ? 0 : notificationEventTypes.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "notificationEventTypes=" + notificationEventTypes
          + "}";
      }
      return $toString;
    }
  }

  public static class NotificationEventType {
    /**
     * Description of the event type
     */
    public String description;

    /**
     * Event type name
     */
    public String name;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public NotificationEventType(String description, String name) {
      this.description = description;
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof NotificationEventType) {
        NotificationEventType that = (NotificationEventType) o;
        return ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
         &&((this.name == null) ? (that.name == null) : this.name.equals(that.name));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (description == null) ? 0 : description.hashCode();
        __h *= 1000003;
        __h ^= (name == null) ? 0 : name.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "NotificationEventType{"
          + "description=" + description + ", "
          + "name=" + name
          + "}";
      }
      return $toString;
    }
  }
}
