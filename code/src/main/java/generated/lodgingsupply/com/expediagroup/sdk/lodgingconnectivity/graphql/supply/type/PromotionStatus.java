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

public class PromotionStatus {
  public static EnumType type = new EnumType("PromotionStatus", Arrays.asList("ACTIVE", "INACTIVE"));

  public static PromotionStatus ACTIVE = new PromotionStatus("ACTIVE");

  public static PromotionStatus INACTIVE = new PromotionStatus("INACTIVE");

  public String rawValue;

  public PromotionStatus(String rawValue) {
    this.rawValue = rawValue;
  }

  public static PromotionStatus safeValueOf(String rawValue) {
    switch(rawValue) {
      case "ACTIVE": return PromotionStatus.ACTIVE;
      case "INACTIVE": return PromotionStatus.INACTIVE;
      default: return new PromotionStatus.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends PromotionStatus {
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
