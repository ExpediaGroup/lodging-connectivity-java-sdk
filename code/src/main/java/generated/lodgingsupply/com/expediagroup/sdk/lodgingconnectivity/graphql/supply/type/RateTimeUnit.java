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
 * Time frame to which the rate is applied.
 */
public class RateTimeUnit {
  public static EnumType type = new EnumType("RateTimeUnit", Arrays.asList("PER_DAY", "PER_WEEK", "PER_STAY"));

  public static RateTimeUnit PER_DAY = new RateTimeUnit("PER_DAY");

  public static RateTimeUnit PER_WEEK = new RateTimeUnit("PER_WEEK");

  public static RateTimeUnit PER_STAY = new RateTimeUnit("PER_STAY");

  public String rawValue;

  private RateTimeUnit(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the RateTimeUnit that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static RateTimeUnit safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
      case "PER_DAY": return RateTimeUnit.PER_DAY;
      case "PER_WEEK": return RateTimeUnit.PER_WEEK;
      case "PER_STAY": return RateTimeUnit.PER_STAY;
      default: return new RateTimeUnit.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends RateTimeUnit {
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
