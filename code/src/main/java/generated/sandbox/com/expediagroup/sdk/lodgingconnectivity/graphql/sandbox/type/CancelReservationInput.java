//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import com.apollographql.apollo.api.Optional;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Input to cancel a reservation.
 */
public class CancelReservationInput {
  public final Optional<String> clientMutationId;

  public final String id;

  public final Optional<Boolean> sendNotification;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CancelReservationInput(Optional<String> clientMutationId, String id,
      Optional<Boolean> sendNotification) {
    this.clientMutationId = clientMutationId;
    this.id = id;
    this.sendNotification = sendNotification;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CancelReservationInput) {
      CancelReservationInput that = (CancelReservationInput) o;
      return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
       &&((this.sendNotification == null) ? (that.sendNotification == null) : this.sendNotification.equals(that.sendNotification));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      __h *= 1000003;
      __h ^= (sendNotification == null) ? 0 : sendNotification.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CancelReservationInput{"
        + "clientMutationId=" + clientMutationId + ", "
        + "id=" + id + ", "
        + "sendNotification=" + sendNotification
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> clientMutationId = Optional.absent();

    private String id;

    private Optional<Boolean> sendNotification = Optional.absent();

    Builder() {
    }

    /**
     * Client mutation ID. Optional value that is echoed back in the response.
     */
    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    /**
     * ID of the reservation to cancel.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Whether to send a notification upon the cancellation of the reservation.
     */
    public Builder sendNotification(Boolean sendNotification) {
      this.sendNotification = Optional.present(sendNotification);
      return this;
    }

    public CancelReservationInput build() {
      return new CancelReservationInput(clientMutationId, id, sendNotification);
    }
  }
}
