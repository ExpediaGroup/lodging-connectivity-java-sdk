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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ConfirmReservationNotificationMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ConfirmReservationNotificationMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.ConfirmReservationNotificationMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ConfirmReservationNotificationInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class ConfirmReservationNotificationMutation implements Mutation<ConfirmReservationNotificationMutation.Data> {
  public static final String OPERATION_ID = "efe89d1059a24ea786822bf2646058a3d44363686d0a1369148dd69058fce07c";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation ConfirmReservationNotification($input: ConfirmReservationNotificationInput!) {
   *   confirmReservationNotification(input: $input) {
   *     clientMutationId
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation ConfirmReservationNotification($input: ConfirmReservationNotificationInput!) { confirmReservationNotification(input: $input) { clientMutationId } }";

  public static final String OPERATION_NAME = "ConfirmReservationNotification";

  public final ConfirmReservationNotificationInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ConfirmReservationNotificationMutation(ConfirmReservationNotificationInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ConfirmReservationNotificationMutation) {
      ConfirmReservationNotificationMutation that = (ConfirmReservationNotificationMutation) o;
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
      $toString = "ConfirmReservationNotificationMutation{"
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
    ConfirmReservationNotificationMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(ConfirmReservationNotificationMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(ConfirmReservationNotificationMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private ConfirmReservationNotificationInput input;

    Builder() {
    }

    public Builder input(ConfirmReservationNotificationInput input) {
      this.input = input;
      return this;
    }

    public ConfirmReservationNotificationMutation build() {
      return new ConfirmReservationNotificationMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Confirm Reservation sent via Webhook
     */
    public ConfirmReservationNotification confirmReservationNotification;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(ConfirmReservationNotification confirmReservationNotification) {
      this.confirmReservationNotification = confirmReservationNotification;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.confirmReservationNotification == null) ? (that.confirmReservationNotification == null) : this.confirmReservationNotification.equals(that.confirmReservationNotification));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (confirmReservationNotification == null) ? 0 : confirmReservationNotification.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "confirmReservationNotification=" + confirmReservationNotification
          + "}";
      }
      return $toString;
    }
  }

  public static class ConfirmReservationNotification {
    /**
     * Partner supplied Unique mutation identifier
     */
    public String clientMutationId;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ConfirmReservationNotification(String clientMutationId) {
      this.clientMutationId = clientMutationId;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ConfirmReservationNotification) {
        ConfirmReservationNotification that = (ConfirmReservationNotification) o;
        return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ConfirmReservationNotification{"
          + "clientMutationId=" + clientMutationId
          + "}";
      }
      return $toString;
    }
  }
}
