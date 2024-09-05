//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Input to delete all reservations for a specified property.
 */
public class DeletePropertyReservationsInput {
  public final Optional<String> clientMutationId;

  public final String propertyId;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public DeletePropertyReservationsInput(Optional<String> clientMutationId, String propertyId) {
    this.clientMutationId = clientMutationId;
    this.propertyId = propertyId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeletePropertyReservationsInput) {
      DeletePropertyReservationsInput that = (DeletePropertyReservationsInput) o;
      return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId));
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
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "DeletePropertyReservationsInput{"
        + "clientMutationId=" + clientMutationId + ", "
        + "propertyId=" + propertyId
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> clientMutationId = Optional.absent();

    private String propertyId;

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
     * ID of the property for which to delete all reservations.
     */
    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public DeletePropertyReservationsInput build() {
      return new DeletePropertyReservationsInput(clientMutationId, propertyId);
    }
  }
}
