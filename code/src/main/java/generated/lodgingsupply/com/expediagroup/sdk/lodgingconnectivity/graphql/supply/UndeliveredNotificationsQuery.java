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
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UndeliveredNotificationsQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UndeliveredNotificationsQuery_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.UndeliveredNotificationsQuerySelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UndeliveredNotificationsFiltersInput;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class UndeliveredNotificationsQuery implements Query<UndeliveredNotificationsQuery.Data> {
  public static final String OPERATION_ID = "82d5b682ceb4e96b615945789f1f89351638305166cea96bffe327058e805318";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query UndeliveredNotifications($filters: UndeliveredNotificationsFiltersInput!, $cursor: String, $limit: Int) {
   *   undeliveredNotifications(filters: $filters, cursor: $cursor, limit: $limit) {
   *     cursor
   *     totalCount
   *     elements {
   *       error {
   *         code
   *         message
   *       }
   *       notification {
   *         creationDateTime
   *         eventType
   *         notificationId
   *         payload
   *       }
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query UndeliveredNotifications($filters: UndeliveredNotificationsFiltersInput!, $cursor: String, $limit: Int) { undeliveredNotifications(filters: $filters, cursor: $cursor, limit: $limit) { cursor totalCount elements { error { code message } notification { creationDateTime eventType notificationId payload } } } }";

  public static final String OPERATION_NAME = "UndeliveredNotifications";

  public final UndeliveredNotificationsFiltersInput filters;

  public final Optional<String> cursor;

  public final Optional<Integer> limit;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UndeliveredNotificationsQuery(UndeliveredNotificationsFiltersInput filters,
      Optional<String> cursor, Optional<Integer> limit) {
    this.filters = filters;
    this.cursor = cursor;
    this.limit = limit;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UndeliveredNotificationsQuery) {
      UndeliveredNotificationsQuery that = (UndeliveredNotificationsQuery) o;
      return ((this.filters == null) ? (that.filters == null) : this.filters.equals(that.filters))
       &&((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor))
       &&((this.limit == null) ? (that.limit == null) : this.limit.equals(that.limit));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (filters == null) ? 0 : filters.hashCode();
      __h *= 1000003;
      __h ^= (cursor == null) ? 0 : cursor.hashCode();
      __h *= 1000003;
      __h ^= (limit == null) ? 0 : limit.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UndeliveredNotificationsQuery{"
        + "filters=" + filters + ", "
        + "cursor=" + cursor + ", "
        + "limit=" + limit
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
    UndeliveredNotificationsQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(UndeliveredNotificationsQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query.type
    )
    .selections(UndeliveredNotificationsQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    private UndeliveredNotificationsFiltersInput filters;

    private Optional<String> cursor = Optional.absent();

    private Optional<Integer> limit = Optional.absent();

    Builder() {
    }

    public Builder filters(UndeliveredNotificationsFiltersInput filters) {
      this.filters = filters;
      return this;
    }

    public Builder cursor(String cursor) {
      this.cursor = Optional.present(cursor);
      return this;
    }

    public Builder limit(Integer limit) {
      this.limit = Optional.present(limit);
      return this;
    }

    public UndeliveredNotificationsQuery build() {
      return new UndeliveredNotificationsQuery(filters, cursor, limit);
    }
  }

  public static class Data implements Query.Data {
    /**
     * Retrieves failed notifications
     */
    public UndeliveredNotifications undeliveredNotifications;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(UndeliveredNotifications undeliveredNotifications) {
      this.undeliveredNotifications = undeliveredNotifications;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.undeliveredNotifications == null) ? (that.undeliveredNotifications == null) : this.undeliveredNotifications.equals(that.undeliveredNotifications));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (undeliveredNotifications == null) ? 0 : undeliveredNotifications.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "undeliveredNotifications=" + undeliveredNotifications
          + "}";
      }
      return $toString;
    }
  }

  public static class UndeliveredNotifications {
    /**
     *  Represents the next page cursor in the list, Empty if no more pages available
     */
    public String cursor;

    /**
     *  Total number of notifications failed to deliver 
     */
    public Integer totalCount;

    /**
     *  List of undelivered notifications 
     */
    public List<Element> elements;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UndeliveredNotifications(String cursor, Integer totalCount, List<Element> elements) {
      this.cursor = cursor;
      this.totalCount = totalCount;
      this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UndeliveredNotifications) {
        UndeliveredNotifications that = (UndeliveredNotifications) o;
        return ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor))
         &&((this.totalCount == null) ? (that.totalCount == null) : this.totalCount.equals(that.totalCount))
         &&((this.elements == null) ? (that.elements == null) : this.elements.equals(that.elements));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (cursor == null) ? 0 : cursor.hashCode();
        __h *= 1000003;
        __h ^= (totalCount == null) ? 0 : totalCount.hashCode();
        __h *= 1000003;
        __h ^= (elements == null) ? 0 : elements.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UndeliveredNotifications{"
          + "cursor=" + cursor + ", "
          + "totalCount=" + totalCount + ", "
          + "elements=" + elements
          + "}";
      }
      return $toString;
    }
  }

  public static class Element {
    /**
     * This contains human readable description of any errors encountered when attempting to deliver the notification.
     */
    public Error error;

    /**
     * Payload of the notification
     */
    public Notification notification;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Element(Error error, Notification notification) {
      this.error = error;
      this.notification = notification;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Element) {
        Element that = (Element) o;
        return ((this.error == null) ? (that.error == null) : this.error.equals(that.error))
         &&((this.notification == null) ? (that.notification == null) : this.notification.equals(that.notification));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (error == null) ? 0 : error.hashCode();
        __h *= 1000003;
        __h ^= (notification == null) ? 0 : notification.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Element{"
          + "error=" + error + ", "
          + "notification=" + notification
          + "}";
      }
      return $toString;
    }
  }

  public static class Error {
    /**
     * Code that reflects the specific error encountered during the test
     */
    public String code;

    /**
     * Human readable message describing the error encountered
     */
    public String message;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Error(String code, String message) {
      this.code = code;
      this.message = message;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Error) {
        Error that = (Error) o;
        return ((this.code == null) ? (that.code == null) : this.code.equals(that.code))
         &&((this.message == null) ? (that.message == null) : this.message.equals(that.message));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (code == null) ? 0 : code.hashCode();
        __h *= 1000003;
        __h ^= (message == null) ? 0 : message.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Error{"
          + "code=" + code + ", "
          + "message=" + message
          + "}";
      }
      return $toString;
    }
  }

  public static class Notification {
    /**
     *  creation date time of the notification 
     */
    public Object creationDateTime;

    /**
     *  The event type 
     */
    public String eventType;

    /**
     *  notification identifier 
     */
    public String notificationId;

    /**
     *  notification payload 
     */
    public String payload;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Notification(Object creationDateTime, String eventType, String notificationId,
        String payload) {
      this.creationDateTime = creationDateTime;
      this.eventType = eventType;
      this.notificationId = notificationId;
      this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Notification) {
        Notification that = (Notification) o;
        return ((this.creationDateTime == null) ? (that.creationDateTime == null) : this.creationDateTime.equals(that.creationDateTime))
         &&((this.eventType == null) ? (that.eventType == null) : this.eventType.equals(that.eventType))
         &&((this.notificationId == null) ? (that.notificationId == null) : this.notificationId.equals(that.notificationId))
         &&((this.payload == null) ? (that.payload == null) : this.payload.equals(that.payload));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (creationDateTime == null) ? 0 : creationDateTime.hashCode();
        __h *= 1000003;
        __h ^= (eventType == null) ? 0 : eventType.hashCode();
        __h *= 1000003;
        __h ^= (notificationId == null) ? 0 : notificationId.hashCode();
        __h *= 1000003;
        __h ^= (payload == null) ? 0 : payload.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Notification{"
          + "creationDateTime=" + creationDateTime + ", "
          + "eventType=" + eventType + ", "
          + "notificationId=" + notificationId + ", "
          + "payload=" + payload
          + "}";
      }
      return $toString;
    }
  }
}