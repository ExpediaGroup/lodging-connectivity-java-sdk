//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.DeleteNotificationCallbackConfigMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.DeleteNotificationCallbackConfigMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.DeleteNotificationCallbackConfigMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DeleteNotificationCallbackConfigInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

public class DeleteNotificationCallbackConfigMutation implements Mutation<DeleteNotificationCallbackConfigMutation.Data> {
  public static final String OPERATION_ID = "3c7e3111787bc967089f2a47a0029b98b4687253bc6e2dfb91b68d6d9bc92e41";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation DeleteNotificationCallbackConfig($input: DeleteNotificationCallbackConfigInput!) {
   *   deleteNotificationCallbackConfig(input: $input) {
   *     callbackConfigId
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation DeleteNotificationCallbackConfig($input: DeleteNotificationCallbackConfigInput!) { deleteNotificationCallbackConfig(input: $input) { callbackConfigId } }";

  public static final String OPERATION_NAME = "DeleteNotificationCallbackConfig";

  public final DeleteNotificationCallbackConfigInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public DeleteNotificationCallbackConfigMutation(DeleteNotificationCallbackConfigInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeleteNotificationCallbackConfigMutation) {
      DeleteNotificationCallbackConfigMutation that = (DeleteNotificationCallbackConfigMutation) o;
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
      $toString = "DeleteNotificationCallbackConfigMutation{"
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
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      boolean withDefaultValues) throws IOException {
    DeleteNotificationCallbackConfigMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(DeleteNotificationCallbackConfigMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(DeleteNotificationCallbackConfigMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private DeleteNotificationCallbackConfigInput input;

    Builder() {
    }

    public Builder input(DeleteNotificationCallbackConfigInput input) {
      this.input = input;
      return this;
    }

    public DeleteNotificationCallbackConfigMutation build() {
      return new DeleteNotificationCallbackConfigMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Delete callback configuration from notification profile.
     */
    public Optional<DeleteNotificationCallbackConfig> deleteNotificationCallbackConfig;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(Optional<DeleteNotificationCallbackConfig> deleteNotificationCallbackConfig) {
      this.deleteNotificationCallbackConfig = deleteNotificationCallbackConfig;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.deleteNotificationCallbackConfig == null) ? (that.deleteNotificationCallbackConfig == null) : this.deleteNotificationCallbackConfig.equals(that.deleteNotificationCallbackConfig));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (deleteNotificationCallbackConfig == null) ? 0 : deleteNotificationCallbackConfig.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "deleteNotificationCallbackConfig=" + deleteNotificationCallbackConfig
          + "}";
      }
      return $toString;
    }
  }

  public static class DeleteNotificationCallbackConfig {
    /**
     * Id of callback configuration deleted
     */
    public String callbackConfigId;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public DeleteNotificationCallbackConfig(String callbackConfigId) {
      this.callbackConfigId = callbackConfigId;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof DeleteNotificationCallbackConfig) {
        DeleteNotificationCallbackConfig that = (DeleteNotificationCallbackConfig) o;
        return ((this.callbackConfigId == null) ? (that.callbackConfigId == null) : this.callbackConfigId.equals(that.callbackConfigId));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (callbackConfigId == null) ? 0 : callbackConfigId.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "DeleteNotificationCallbackConfig{"
          + "callbackConfigId=" + callbackConfigId
          + "}";
      }
      return $toString;
    }
  }
}
