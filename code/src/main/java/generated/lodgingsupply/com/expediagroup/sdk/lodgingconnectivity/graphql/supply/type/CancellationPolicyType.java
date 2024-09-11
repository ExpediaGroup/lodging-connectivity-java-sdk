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

public class CancellationPolicyType {
  public static EnumType type = new EnumType("CancellationPolicyType", Arrays.asList("CUSTOM", "FIRM", "MODERATE", "NO_REFUND", "RELAXED", "STRICT"));

  public static CancellationPolicyType CUSTOM = new CancellationPolicyType("CUSTOM");

  public static CancellationPolicyType FIRM = new CancellationPolicyType("FIRM");

  public static CancellationPolicyType MODERATE = new CancellationPolicyType("MODERATE");

  public static CancellationPolicyType NO_REFUND = new CancellationPolicyType("NO_REFUND");

  public static CancellationPolicyType RELAXED = new CancellationPolicyType("RELAXED");

  public static CancellationPolicyType STRICT = new CancellationPolicyType("STRICT");

  public String rawValue;

  private CancellationPolicyType(String rawValue) {
    this.rawValue = rawValue;
  }

  /**
   * Returns the CancellationPolicyType that represents the specified rawValue.
   * Note: unknown values of rawValue will return UNKNOWN__. You may want to update your schema instead of calling this method directly.
   */
  public static CancellationPolicyType safeValueOf(String rawValue) {
    switch (Objects.requireNonNull(rawValue)) {
      case "CUSTOM": return CancellationPolicyType.CUSTOM;
      case "FIRM": return CancellationPolicyType.FIRM;
      case "MODERATE": return CancellationPolicyType.MODERATE;
      case "NO_REFUND": return CancellationPolicyType.NO_REFUND;
      case "RELAXED": return CancellationPolicyType.RELAXED;
      case "STRICT": return CancellationPolicyType.STRICT;
      default: return new CancellationPolicyType.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends CancellationPolicyType {
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
