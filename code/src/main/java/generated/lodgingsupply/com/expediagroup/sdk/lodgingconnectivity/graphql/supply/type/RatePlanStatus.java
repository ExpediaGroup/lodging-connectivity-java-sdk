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

public class RatePlanStatus {
  public static EnumType type = new EnumType("RatePlanStatus", Arrays.asList("ACTIVE", "INACTIVE"));

  public static RatePlanStatus ACTIVE = new RatePlanStatus("ACTIVE");

  public static RatePlanStatus INACTIVE = new RatePlanStatus("INACTIVE");

  public String rawValue;

  private RatePlanStatus(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the RatePlanStatus that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static RatePlanStatus safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
      case "ACTIVE": return RatePlanStatus.ACTIVE;
      case "INACTIVE": return RatePlanStatus.INACTIVE;
      default: return new RatePlanStatus.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends RatePlanStatus {
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
