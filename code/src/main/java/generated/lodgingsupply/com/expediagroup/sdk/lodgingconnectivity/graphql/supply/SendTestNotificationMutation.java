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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.SendTestNotificationMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.SendTestNotificationMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.SendTestNotificationMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SendTestNotificationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TestNotificationOutcome;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class SendTestNotificationMutation implements Mutation<SendTestNotificationMutation.Data> {
  public static final String OPERATION_ID = "5dc525622b1277a697da3295f460d0c32d16dd69d400f1c4c8612bd28b6e2e95";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation SendTestNotification($input: SendTestNotificationInput!) {
   *   sendTestNotification(input: $input) {
   *     error {
   *       code
   *       message
   *     }
   *     httpStatusCode
   *     outcome
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation SendTestNotification($input: SendTestNotificationInput!) { sendTestNotification(input: $input) { error { code message } httpStatusCode outcome } }";

  public static final String OPERATION_NAME = "SendTestNotification";

  public final SendTestNotificationInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SendTestNotificationMutation(SendTestNotificationInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SendTestNotificationMutation) {
      SendTestNotificationMutation that = (SendTestNotificationMutation) o;
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
      $toString = "SendTestNotificationMutation{"
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
    SendTestNotificationMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(SendTestNotificationMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(SendTestNotificationMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private SendTestNotificationInput input;

    Builder() {
    }

    public Builder input(SendTestNotificationInput input) {
      this.input = input;
      return this;
    }

    public SendTestNotificationMutation build() {
      return new SendTestNotificationMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Send test notification using a given eventType and Payload
     */
    public SendTestNotification sendTestNotification;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(SendTestNotification sendTestNotification) {
      this.sendTestNotification = sendTestNotification;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.sendTestNotification == null) ? (that.sendTestNotification == null) : this.sendTestNotification.equals(that.sendTestNotification));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (sendTestNotification == null) ? 0 : sendTestNotification.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "sendTestNotification=" + sendTestNotification
          + "}";
      }
      return $toString;
    }
  }

  public static class SendTestNotification {
    /**
     * In the case of a failed test, this contains human readable description of any errors encountered when attempting to deliver the notification.
     */
    public Error error;

    /**
     * The HTTP status code returned by the endpoint to which the notification was delivered to.
     */
    public Integer httpStatusCode;

    /**
     * Outcome of the test payload sent
     */
    public TestNotificationOutcome outcome;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public SendTestNotification(Error error, Integer httpStatusCode,
        TestNotificationOutcome outcome) {
      this.error = error;
      this.httpStatusCode = httpStatusCode;
      this.outcome = outcome;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof SendTestNotification) {
        SendTestNotification that = (SendTestNotification) o;
        return ((this.error == null) ? (that.error == null) : this.error.equals(that.error))
         &&((this.httpStatusCode == null) ? (that.httpStatusCode == null) : this.httpStatusCode.equals(that.httpStatusCode))
         &&((this.outcome == null) ? (that.outcome == null) : this.outcome.equals(that.outcome));
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
        __h ^= (httpStatusCode == null) ? 0 : httpStatusCode.hashCode();
        __h *= 1000003;
        __h ^= (outcome == null) ? 0 : outcome.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "SendTestNotification{"
          + "error=" + error + ", "
          + "httpStatusCode=" + httpStatusCode + ", "
          + "outcome=" + outcome
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
}
