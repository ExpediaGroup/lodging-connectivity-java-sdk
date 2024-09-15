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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateNotificationCallbackConfigMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateNotificationCallbackConfigMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.CreateNotificationCallbackConfigMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateNotificationCallbackConfigInput;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDateTime;

public class CreateNotificationCallbackConfigMutation implements Mutation<CreateNotificationCallbackConfigMutation.Data> {
  public static final String OPERATION_ID = "4168c4886f934dbba7573288a4b21b06147d6ccb3fb7a3b9b64dbdf3d7837652";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation CreateNotificationCallbackConfig($input: CreateNotificationCallbackConfigInput!) {
   *   createNotificationCallbackConfig(input: $input) {
   *     callbackConfig {
   *       callbackUrl
   *       contactEmail
   *       id
   *       requestTimeoutSeconds
   *       secretExpirationDateTime
   *     }
   *     secret
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation CreateNotificationCallbackConfig($input: CreateNotificationCallbackConfigInput!) { createNotificationCallbackConfig(input: $input) { callbackConfig { callbackUrl contactEmail id requestTimeoutSeconds secretExpirationDateTime } secret } }";

  public static final String OPERATION_NAME = "CreateNotificationCallbackConfig";

  public final CreateNotificationCallbackConfigInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateNotificationCallbackConfigMutation(CreateNotificationCallbackConfigInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateNotificationCallbackConfigMutation) {
      CreateNotificationCallbackConfigMutation that = (CreateNotificationCallbackConfigMutation) o;
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
      $toString = "CreateNotificationCallbackConfigMutation{"
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
    CreateNotificationCallbackConfigMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(CreateNotificationCallbackConfigMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(CreateNotificationCallbackConfigMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private CreateNotificationCallbackConfigInput input;

    Builder() {
    }

    public Builder input(CreateNotificationCallbackConfigInput input) {
      this.input = input;
      return this;
    }

    public CreateNotificationCallbackConfigMutation build() {
      return new CreateNotificationCallbackConfigMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Create callback configuration for notification profile.
     */
    public CreateNotificationCallbackConfig createNotificationCallbackConfig;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(CreateNotificationCallbackConfig createNotificationCallbackConfig) {
      this.createNotificationCallbackConfig = createNotificationCallbackConfig;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.createNotificationCallbackConfig == null) ? (that.createNotificationCallbackConfig == null) : this.createNotificationCallbackConfig.equals(that.createNotificationCallbackConfig));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (createNotificationCallbackConfig == null) ? 0 : createNotificationCallbackConfig.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "createNotificationCallbackConfig=" + createNotificationCallbackConfig
          + "}";
      }
      return $toString;
    }
  }

  public static class CreateNotificationCallbackConfig {
    /**
     * Information about the created Callback configuration
     */
    public CallbackConfig callbackConfig;

    /**
     * Callback Configuration secret string
     */
    public String secret;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public CreateNotificationCallbackConfig(CallbackConfig callbackConfig, String secret) {
      this.callbackConfig = callbackConfig;
      this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CreateNotificationCallbackConfig) {
        CreateNotificationCallbackConfig that = (CreateNotificationCallbackConfig) o;
        return ((this.callbackConfig == null) ? (that.callbackConfig == null) : this.callbackConfig.equals(that.callbackConfig))
         &&((this.secret == null) ? (that.secret == null) : this.secret.equals(that.secret));
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
        __h ^= (secret == null) ? 0 : secret.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CreateNotificationCallbackConfig{"
          + "callbackConfig=" + callbackConfig + ", "
          + "secret=" + secret
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