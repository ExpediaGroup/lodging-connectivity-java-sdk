//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;

public class ReservationCancellationReason {
  public static EnumType type = new EnumType("ReservationCancellationReason", Arrays.asList("GUEST_REQUESTED_CANCEL", "NO_SHOW", "EXTENUATING_CIRCUMSTANCE", "NATURAL_DISASTER"));

  public static ReservationCancellationReason GUEST_REQUESTED_CANCEL = new ReservationCancellationReason("GUEST_REQUESTED_CANCEL");

  public static ReservationCancellationReason NO_SHOW = new ReservationCancellationReason("NO_SHOW");

  public static ReservationCancellationReason EXTENUATING_CIRCUMSTANCE = new ReservationCancellationReason("EXTENUATING_CIRCUMSTANCE");

  public static ReservationCancellationReason NATURAL_DISASTER = new ReservationCancellationReason("NATURAL_DISASTER");

  public String rawValue;

  public ReservationCancellationReason(String rawValue) {
    this.rawValue = rawValue;
  }

  public static ReservationCancellationReason safeValueOf(String rawValue) {
    switch(rawValue) {
      case "GUEST_REQUESTED_CANCEL": return ReservationCancellationReason.GUEST_REQUESTED_CANCEL;
      case "NO_SHOW": return ReservationCancellationReason.NO_SHOW;
      case "EXTENUATING_CIRCUMSTANCE": return ReservationCancellationReason.EXTENUATING_CIRCUMSTANCE;
      case "NATURAL_DISASTER": return ReservationCancellationReason.NATURAL_DISASTER;
      default: return new ReservationCancellationReason.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends ReservationCancellationReason {
    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UNKNOWN__(String rawValue) {
      super(rawValue);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UNKNOWN__) {
        return true;
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UNKNOWN__{"
          + "}";
      }
      return $toString;
    }
  }
}