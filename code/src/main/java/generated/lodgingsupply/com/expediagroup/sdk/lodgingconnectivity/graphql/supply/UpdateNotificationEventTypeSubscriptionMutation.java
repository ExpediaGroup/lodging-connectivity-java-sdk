//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateNotificationEventTypeSubscriptionMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateNotificationEventTypeSubscriptionMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.UpdateNotificationEventTypeSubscriptionMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateNotificationEventTypeSubscriptionInput;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDateTime;

public class UpdateNotificationEventTypeSubscriptionMutation implements Mutation<UpdateNotificationEventTypeSubscriptionMutation.Data> {
  public static final String OPERATION_ID = "fa4094e45a6c0a6c4e4eea7719b69fb97ca432a9a35a4b9666c3486d43c18512";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation UpdateNotificationEventTypeSubscription($input: UpdateNotificationEventTypeSubscriptionInput!) {
   *   updateNotificationEventTypeSubscription(input: $input) {
   *     callbackConfig {
   *       callbackUrl
   *       contactEmail
   *       id
   *       requestTimeoutSeconds
   *       secretExpirationDateTime
   *     }
   *     eventType
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation UpdateNotificationEventTypeSubscription($input: UpdateNotificationEventTypeSubscriptionInput!) { updateNotificationEventTypeSubscription(input: $input) { callbackConfig { callbackUrl contactEmail id requestTimeoutSeconds secretExpirationDateTime } eventType } }";

  public static final String OPERATION_NAME = "UpdateNotificationEventTypeSubscription";

  public final UpdateNotificationEventTypeSubscriptionInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateNotificationEventTypeSubscriptionMutation(
      UpdateNotificationEventTypeSubscriptionInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateNotificationEventTypeSubscriptionMutation) {
      UpdateNotificationEventTypeSubscriptionMutation that = (UpdateNotificationEventTypeSubscriptionMutation) o;
      return ((this.input == null) ? (that.input == null) : this.input.equals(that.input));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (input == null) ? 0 : input.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateNotificationEventTypeSubscriptionMutation{"
        + "input=" + input
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
    UpdateNotificationEventTypeSubscriptionMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(UpdateNotificationEventTypeSubscriptionMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(UpdateNotificationEventTypeSubscriptionMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private UpdateNotificationEventTypeSubscriptionInput input;

    Builder() {
    }

    public Builder input(UpdateNotificationEventTypeSubscriptionInput input) {
      this.input = input;
      return this;
    }

    public UpdateNotificationEventTypeSubscriptionMutation build() {
      return new UpdateNotificationEventTypeSubscriptionMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Update notification callback configuration for a subscribed notification event type
     */
    public UpdateNotificationEventTypeSubscription updateNotificationEventTypeSubscription;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(UpdateNotificationEventTypeSubscription updateNotificationEventTypeSubscription) {
      this.updateNotificationEventTypeSubscription = updateNotificationEventTypeSubscription;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateNotificationEventTypeSubscription == null) ? (that.updateNotificationEventTypeSubscription == null) : this.updateNotificationEventTypeSubscription.equals(that.updateNotificationEventTypeSubscription));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (updateNotificationEventTypeSubscription == null) ? 0 : updateNotificationEventTypeSubscription.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateNotificationEventTypeSubscription=" + updateNotificationEventTypeSubscription
          + "}";
      }
      return $toString;
    }
  }

  public static class UpdateNotificationEventTypeSubscription {
    /**
     * Callback configuration information for the event type subscription
     */
    public CallbackConfig callbackConfig;

    /**
     * Name of the event type
     */
    public String eventType;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UpdateNotificationEventTypeSubscription(CallbackConfig callbackConfig,
        String eventType) {
      this.callbackConfig = callbackConfig;
      this.eventType = eventType;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateNotificationEventTypeSubscription) {
        UpdateNotificationEventTypeSubscription that = (UpdateNotificationEventTypeSubscription) o;
        return ((this.callbackConfig == null) ? (that.callbackConfig == null) : this.callbackConfig.equals(that.callbackConfig))
         &&((this.eventType == null) ? (that.eventType == null) : this.eventType.equals(that.eventType));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (callbackConfig == null) ? 0 : callbackConfig.hashCode();
        __h *= 1000003;
        __h ^= (eventType == null) ? 0 : eventType.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateNotificationEventTypeSubscription{"
          + "callbackConfig=" + callbackConfig + ", "
          + "eventType=" + eventType
          + "}";
      }
      return $toString;
    }
  }

  public static class CallbackConfig {
    /**
     * Callback url where the notification will be delivered
     */
    public URL callbackUrl;

    /**
     * Email address for correspondence
     */
    public String contactEmail;

    /**
     * Id of the callback configuration object
     */
    public String id;

    /**
     * Request timeout when sending a notification on the callback url
     */
    public Integer requestTimeoutSeconds;

    /**
     * Secret expiration date time
     */
    public LocalDateTime secretExpirationDateTime;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public CallbackConfig(URL callbackUrl, String contactEmail, String id,
        Integer requestTimeoutSeconds, LocalDateTime secretExpirationDateTime) {
      this.callbackUrl = callbackUrl;
      this.contactEmail = contactEmail;
      this.id = id;
      this.requestTimeoutSeconds = requestTimeoutSeconds;
      this.secretExpirationDateTime = secretExpirationDateTime;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CallbackConfig) {
        CallbackConfig that = (CallbackConfig) o;
        return ((this.callbackUrl == null) ? (that.callbackUrl == null) : this.callbackUrl.equals(that.callbackUrl))
         &&((this.contactEmail == null) ? (that.contactEmail == null) : this.contactEmail.equals(that.contactEmail))
         &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.requestTimeoutSeconds == null) ? (that.requestTimeoutSeconds == null) : this.requestTimeoutSeconds.equals(that.requestTimeoutSeconds))
         &&((this.secretExpirationDateTime == null) ? (that.secretExpirationDateTime == null) : this.secretExpirationDateTime.equals(that.secretExpirationDateTime));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (callbackUrl == null) ? 0 : callbackUrl.hashCode();
        __h *= 1000003;
        __h ^= (contactEmail == null) ? 0 : contactEmail.hashCode();
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (requestTimeoutSeconds == null) ? 0 : requestTimeoutSeconds.hashCode();
        __h *= 1000003;
        __h ^= (secretExpirationDateTime == null) ? 0 : secretExpirationDateTime.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CallbackConfig{"
          + "callbackUrl=" + callbackUrl + ", "
          + "contactEmail=" + contactEmail + ", "
          + "id=" + id + ", "
          + "requestTimeoutSeconds=" + requestTimeoutSeconds + ", "
          + "secretExpirationDateTime=" + secretExpirationDateTime
          + "}";
      }
      return $toString;
    }
  }
}
