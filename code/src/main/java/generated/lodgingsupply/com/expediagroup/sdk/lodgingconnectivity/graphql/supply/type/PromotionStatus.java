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

public class PromotionStatus {
  public static EnumType type = new EnumType("PromotionStatus", Arrays.asList("ACTIVE", "INACTIVE"));

  public static PromotionStatus ACTIVE = new PromotionStatus("ACTIVE");

  public static PromotionStatus INACTIVE = new PromotionStatus("INACTIVE");

  public String rawValue;

  private PromotionStatus(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the PromotionStatus that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static PromotionStatus safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
      case "ACTIVE": return PromotionStatus.ACTIVE;
      case "INACTIVE": return PromotionStatus.INACTIVE;
      default: return new PromotionStatus.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends PromotionStatus {
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
