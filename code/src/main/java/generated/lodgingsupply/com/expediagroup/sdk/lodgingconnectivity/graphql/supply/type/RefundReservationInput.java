//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class RefundReservationInput {
  public final String propertyId;

  public final String reservationId;

  public final ReservationRefundReason reason;

  public final MoneyInput refund;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public RefundReservationInput(String propertyId, String reservationId,
      ReservationRefundReason reason, MoneyInput refund) {
    this.propertyId = propertyId;
    this.reservationId = reservationId;
    this.reason = reason;
    this.refund = refund;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RefundReservationInput) {
      RefundReservationInput that = (RefundReservationInput) o;
      return ((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.reservationId == null) ? (that.reservationId == null) : this.reservationId.equals(that.reservationId))
       &&((this.reason == null) ? (that.reason == null) : this.reason.equals(that.reason))
       &&((this.refund == null) ? (that.refund == null) : this.refund.equals(that.refund));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (reservationId == null) ? 0 : reservationId.hashCode();
      __h *= 1000003;
      __h ^= (reason == null) ? 0 : reason.hashCode();
      __h *= 1000003;
      __h ^= (refund == null) ? 0 : refund.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "RefundReservationInput{"
        + "propertyId=" + propertyId + ", "
        + "reservationId=" + reservationId + ", "
        + "reason=" + reason + ", "
        + "refund=" + refund
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String propertyId;

    private String reservationId;

    private ReservationRefundReason reason;

    private MoneyInput refund;

    Builder() {
    }

    /**
     * The ID of the property where the change has been requested.
     */
    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    /**
     * Identifier associated with the reservation to be changed.
     */
    public Builder reservationId(String reservationId) {
      this.reservationId = reservationId;
      return this;
    }

    /**
     * Reason for cancelling the reservation
     */
    public Builder reason(ReservationRefundReason reason) {
      this.reason = reason;
      return this;
    }

    /**
     * Amount & currencyCode
     */
    public Builder refund(MoneyInput refund) {
      this.refund = refund;
      return this;
    }

    public RefundReservationInput build() {
      return new RefundReservationInput(propertyId, reservationId, reason, refund);
    }
  }
}
