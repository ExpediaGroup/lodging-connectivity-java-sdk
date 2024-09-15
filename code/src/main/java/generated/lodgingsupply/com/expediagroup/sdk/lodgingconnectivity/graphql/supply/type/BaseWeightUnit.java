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

public class BaseWeightUnit {
  public static EnumType type = new EnumType("BaseWeightUnit", Arrays.asList("KILOGRAMS", "POUNDS"));

  public static BaseWeightUnit KILOGRAMS = new BaseWeightUnit("KILOGRAMS");

  public static BaseWeightUnit POUNDS = new BaseWeightUnit("POUNDS");

  public String rawValue;

  public BaseWeightUnit(String rawValue) {
    this.rawValue = rawValue;
  }

  public static BaseWeightUnit safeValueOf(String rawValue) {
    switch(rawValue) {
      case "KILOGRAMS": return BaseWeightUnit.KILOGRAMS;
      case "POUNDS": return BaseWeightUnit.POUNDS;
      default: return new BaseWeightUnit.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends BaseWeightUnit {
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