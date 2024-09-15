//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import com.apollographql.apollo3.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;

/**
 * Type of reconciliation that has been performed on the reservation.
 */
public class ReconciliationType {
  public static EnumType type = new EnumType("ReconciliationType", Arrays.asList("CANCEL", "MODIFY", "NO_SHOW", "REFUND"));

  public static ReconciliationType CANCEL = new ReconciliationType("CANCEL");

  public static ReconciliationType MODIFY = new ReconciliationType("MODIFY");

  public static ReconciliationType NO_SHOW = new ReconciliationType("NO_SHOW");

  public static ReconciliationType REFUND = new ReconciliationType("REFUND");

  public String rawValue;

  public ReconciliationType(String rawValue) {
    this.rawValue = rawValue;
  }

  public static ReconciliationType safeValueOf(String rawValue) {
    switch(rawValue) {
      case "CANCEL": return ReconciliationType.CANCEL;
      case "MODIFY": return ReconciliationType.MODIFY;
      case "NO_SHOW": return ReconciliationType.NO_SHOW;
      case "REFUND": return ReconciliationType.REFUND;
      default: return new ReconciliationType.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends ReconciliationType {
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