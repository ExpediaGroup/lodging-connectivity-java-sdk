//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class IntRangeInput {
  public final Integer max;

  public final Integer min;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public IntRangeInput(Integer max, Integer min) {
    this.max = max;
    this.min = min;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof IntRangeInput) {
      IntRangeInput that = (IntRangeInput) o;
      return ((this.max == null) ? (that.max == null) : this.max.equals(that.max))
       &&((this.min == null) ? (that.min == null) : this.min.equals(that.min));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (max == null) ? 0 : max.hashCode();
      __h *= 1000003;
      __h ^= (min == null) ? 0 : min.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "IntRangeInput{"
        + "max=" + max + ", "
        + "min=" + min
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Integer max;

    private Integer min;

    Builder() {
    }

    public Builder max(Integer max) {
      this.max = max;
      return this;
    }

    public Builder min(Integer min) {
      this.min = min;
      return this;
    }

    public IntRangeInput build() {
      return new IntRangeInput(max, min);
    }
  }
}