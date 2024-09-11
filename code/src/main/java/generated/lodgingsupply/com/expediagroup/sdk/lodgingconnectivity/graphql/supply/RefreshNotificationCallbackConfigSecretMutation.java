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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.RefreshNotificationCallbackConfigSecretMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.RefreshNotificationCallbackConfigSecretMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.RefreshNotificationCallbackConfigSecretMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RefreshNotificationCallbackConfigSecretInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDateTime;

public class RefreshNotificationCallbackConfigSecretMutation implements Mutation<RefreshNotificationCallbackConfigSecretMutation.Data> {
  public static final String OPERATION_ID = "a1a51980028fbdcfa8e411dec3600c0877cb1fbe539374255970b8d79001380f";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation RefreshNotificationCallbackConfigSecret($input: RefreshNotificationCallbackConfigSecretInput!) {
   *   refreshNotificationCallbackConfigSecret(input: $input) {
   *     callbackConfigId
   *     secret
   *     secretExpirationDateTime
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation RefreshNotificationCallbackConfigSecret($input: RefreshNotificationCallbackConfigSecretInput!) { refreshNotificationCallbackConfigSecret(input: $input) { callbackConfigId secret secretExpirationDateTime } }";

  public static final String OPERATION_NAME = "RefreshNotificationCallbackConfigSecret";

  public final RefreshNotificationCallbackConfigSecretInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public RefreshNotificationCallbackConfigSecretMutation(
      RefreshNotificationCallbackConfigSecretInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RefreshNotificationCallbackConfigSecretMutation) {
      RefreshNotificationCallbackConfigSecretMutation that = (RefreshNotificationCallbackConfigSecretMutation) o;
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
      $toString = "RefreshNotificationCallbackConfigSecretMutation{"
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
    RefreshNotificationCallbackConfigSecretMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(RefreshNotificationCallbackConfigSecretMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(RefreshNotificationCallbackConfigSecretMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private RefreshNotificationCallbackConfigSecretInput input;

    Builder() {
    }

    public Builder input(RefreshNotificationCallbackConfigSecretInput input) {
      this.input = input;
      return this;
    }

    public RefreshNotificationCallbackConfigSecretMutation build() {
      return new RefreshNotificationCallbackConfigSecretMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Refresh secret for callback configuration based on callbackConfigId.
     */
    public RefreshNotificationCallbackConfigSecret refreshNotificationCallbackConfigSecret;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(RefreshNotificationCallbackConfigSecret refreshNotificationCallbackConfigSecret) {
      this.refreshNotificationCallbackConfigSecret = refreshNotificationCallbackConfigSecret;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.refreshNotificationCallbackConfigSecret == null) ? (that.refreshNotificationCallbackConfigSecret == null) : this.refreshNotificationCallbackConfigSecret.equals(that.refreshNotificationCallbackConfigSecret));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (refreshNotificationCallbackConfigSecret == null) ? 0 : refreshNotificationCallbackConfigSecret.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "refreshNotificationCallbackConfigSecret=" + refreshNotificationCallbackConfigSecret
          + "}";
      }
      return $toString;
    }
  }

  public static class RefreshNotificationCallbackConfigSecret {
    /**
     * Id of callback configuration whose secret is updated
     */
    public String callbackConfigId;

    /**
     * Callback Configuration secret string
     */
    public String secret;

    /**
     * Secret expiration date time
     */
    public LocalDateTime secretExpirationDateTime;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public RefreshNotificationCallbackConfigSecret(String callbackConfigId, String secret,
        LocalDateTime secretExpirationDateTime) {
      this.callbackConfigId = callbackConfigId;
      this.secret = secret;
      this.secretExpirationDateTime = secretExpirationDateTime;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof RefreshNotificationCallbackConfigSecret) {
        RefreshNotificationCallbackConfigSecret that = (RefreshNotificationCallbackConfigSecret) o;
        return ((this.callbackConfigId == null) ? (that.callbackConfigId == null) : this.callbackConfigId.equals(that.callbackConfigId))
         &&((this.secret == null) ? (that.secret == null) : this.secret.equals(that.secret))
         &&((this.secretExpirationDateTime == null) ? (that.secretExpirationDateTime == null) : this.secretExpirationDateTime.equals(that.secretExpirationDateTime));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (callbackConfigId == null) ? 0 : callbackConfigId.hashCode();
        __h *= 1000003;
        __h ^= (secret == null) ? 0 : secret.hashCode();
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
        $toString = "RefreshNotificationCallbackConfigSecret{"
          + "callbackConfigId=" + callbackConfigId + ", "
          + "secret=" + secret + ", "
          + "secretExpirationDateTime=" + secretExpirationDateTime
          + "}";
      }
      return $toString;
    }
  }
}
