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
 * Time frame to which the cancellation policy is applied.
 */
public class CancellationWindowTemporalUnit {
  public static EnumType type = new EnumType("CancellationWindowTemporalUnit", Arrays.asList("DAY", "HOUR", "WEEK"));

  public static CancellationWindowTemporalUnit DAY = new CancellationWindowTemporalUnit("DAY");

  public static CancellationWindowTemporalUnit HOUR = new CancellationWindowTemporalUnit("HOUR");

  public static CancellationWindowTemporalUnit WEEK = new CancellationWindowTemporalUnit("WEEK");

  public String rawValue;

  public CancellationWindowTemporalUnit(String rawValue) {
    this.rawValue = rawValue;
  }

  public static CancellationWindowTemporalUnit safeValueOf(String rawValue) {
    switch(rawValue) {
      case "DAY": return CancellationWindowTemporalUnit.DAY;
      case "HOUR": return CancellationWindowTemporalUnit.HOUR;
      case "WEEK": return CancellationWindowTemporalUnit.WEEK;
      default: return new CancellationWindowTemporalUnit.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends CancellationWindowTemporalUnit {
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