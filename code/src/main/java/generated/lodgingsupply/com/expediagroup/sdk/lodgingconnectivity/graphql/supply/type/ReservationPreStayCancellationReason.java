//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Objects;

/**
 * Reason for cancelling pre stay reservation.
 */
public class ReservationPreStayCancellationReason {
  public static EnumType type = new EnumType("ReservationPreStayCancellationReason", Arrays.asList("GUEST_REQUESTED_CANCEL", "INVALID_PAYMENT_METHOD"));

  public static ReservationPreStayCancellationReason GUEST_REQUESTED_CANCEL = new ReservationPreStayCancellationReason("GUEST_REQUESTED_CANCEL");

  public static ReservationPreStayCancellationReason INVALID_PAYMENT_METHOD = new ReservationPreStayCancellationReason("INVALID_PAYMENT_METHOD");

  public String rawValue;

  private ReservationPreStayCancellationReason(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the ReservationPreStayCancellationReason that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static ReservationPreStayCancellationReason safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
      case "GUEST_REQUESTED_CANCEL": return ReservationPreStayCancellationReason.GUEST_REQUESTED_CANCEL;
      case "INVALID_PAYMENT_METHOD": return ReservationPreStayCancellationReason.INVALID_PAYMENT_METHOD;
      default: return new ReservationPreStayCancellationReason.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends ReservationPreStayCancellationReason {
    private UNKNOWN__(String rawValue) {
      super(rawValue);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      if (!(other instanceof UNKNOWN__)) return false;
      return rawValue.equals(((UNKNOWN__) other).rawValue);
    }

    @Override
    public int hashCode() {
      return rawValue.hashCode();
    }

    @Override
    public String toString() {
      return "UNKNOWN__(" + rawValue + ")";
    }
  }
}
