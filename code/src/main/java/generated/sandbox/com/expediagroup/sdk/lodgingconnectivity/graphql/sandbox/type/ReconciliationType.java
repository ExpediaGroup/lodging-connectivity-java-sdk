//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import com.apollographql.apollo.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Objects;

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

  private ReconciliationType(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the ReconciliationType that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static ReconciliationType safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
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
