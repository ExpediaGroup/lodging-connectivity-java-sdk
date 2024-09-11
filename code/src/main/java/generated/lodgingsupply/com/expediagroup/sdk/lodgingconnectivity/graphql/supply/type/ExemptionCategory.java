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
 * Exemption categories.
 */
public class ExemptionCategory {
  public static EnumType type = new EnumType("ExemptionCategory", Arrays.asList("MAX_NIGHT_CAP"));

  public static ExemptionCategory MAX_NIGHT_CAP = new ExemptionCategory("MAX_NIGHT_CAP");

  public String rawValue;

  public ExemptionCategory(String rawValue) {
    this.rawValue = rawValue;
  }

  public static ExemptionCategory safeValueOf(String rawValue) {
    switch(rawValue) {
      case "MAX_NIGHT_CAP": return ExemptionCategory.MAX_NIGHT_CAP;
      default: return new ExemptionCategory.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends ExemptionCategory {
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
