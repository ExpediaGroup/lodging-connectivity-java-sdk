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

/**
 * Secondary reasons for vrbo cancellation. Only valid if CancellationReason is GUEST_REQUESTED_CANCEL
 */
public class VrboCancellationSecondaryReason {
  public static EnumType type = new EnumType("VrboCancellationSecondaryReason", Arrays.asList("CHANGED_DESTINATION", "BOOKING_MISTAKE", "CHANGE_OF_PLANS", "CHANGE_DATES", "CHANGE_GUESTS", "OWNER_REQUEST", "AMENITY_NOT_AVAILABLE", "OWNER_DISAGREE", "PAYMENT", "OTHER"));

  public static VrboCancellationSecondaryReason CHANGED_DESTINATION = new VrboCancellationSecondaryReason("CHANGED_DESTINATION");

  public static VrboCancellationSecondaryReason BOOKING_MISTAKE = new VrboCancellationSecondaryReason("BOOKING_MISTAKE");

  public static VrboCancellationSecondaryReason CHANGE_OF_PLANS = new VrboCancellationSecondaryReason("CHANGE_OF_PLANS");

  public static VrboCancellationSecondaryReason CHANGE_DATES = new VrboCancellationSecondaryReason("CHANGE_DATES");

  public static VrboCancellationSecondaryReason CHANGE_GUESTS = new VrboCancellationSecondaryReason("CHANGE_GUESTS");

  public static VrboCancellationSecondaryReason OWNER_REQUEST = new VrboCancellationSecondaryReason("OWNER_REQUEST");

  public static VrboCancellationSecondaryReason AMENITY_NOT_AVAILABLE = new VrboCancellationSecondaryReason("AMENITY_NOT_AVAILABLE");

  public static VrboCancellationSecondaryReason OWNER_DISAGREE = new VrboCancellationSecondaryReason("OWNER_DISAGREE");

  public static VrboCancellationSecondaryReason PAYMENT = new VrboCancellationSecondaryReason("PAYMENT");

  public static VrboCancellationSecondaryReason OTHER = new VrboCancellationSecondaryReason("OTHER");

  public String rawValue;

  public VrboCancellationSecondaryReason(String rawValue) {
    this.rawValue = rawValue;
  }

  public static VrboCancellationSecondaryReason safeValueOf(String rawValue) {
    switch(rawValue) {
      case "CHANGED_DESTINATION": return VrboCancellationSecondaryReason.CHANGED_DESTINATION;
      case "BOOKING_MISTAKE": return VrboCancellationSecondaryReason.BOOKING_MISTAKE;
      case "CHANGE_OF_PLANS": return VrboCancellationSecondaryReason.CHANGE_OF_PLANS;
      case "CHANGE_DATES": return VrboCancellationSecondaryReason.CHANGE_DATES;
      case "CHANGE_GUESTS": return VrboCancellationSecondaryReason.CHANGE_GUESTS;
      case "OWNER_REQUEST": return VrboCancellationSecondaryReason.OWNER_REQUEST;
      case "AMENITY_NOT_AVAILABLE": return VrboCancellationSecondaryReason.AMENITY_NOT_AVAILABLE;
      case "OWNER_DISAGREE": return VrboCancellationSecondaryReason.OWNER_DISAGREE;
      case "PAYMENT": return VrboCancellationSecondaryReason.PAYMENT;
      case "OTHER": return VrboCancellationSecondaryReason.OTHER;
      default: return new VrboCancellationSecondaryReason.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends VrboCancellationSecondaryReason {
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
