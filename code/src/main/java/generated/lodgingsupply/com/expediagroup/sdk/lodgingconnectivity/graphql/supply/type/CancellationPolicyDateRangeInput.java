//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;

/**
 * Each date range is a closed and inclusive interval.
 */
public class CancellationPolicyDateRangeInput {
  public final LocalDate from;

  public final LocalDate to;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CancellationPolicyDateRangeInput(LocalDate from, LocalDate to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CancellationPolicyDateRangeInput) {
      CancellationPolicyDateRangeInput that = (CancellationPolicyDateRangeInput) o;
      return ((this.from == null) ? (that.from == null) : this.from.equals(that.from))
       &&((this.to == null) ? (that.to == null) : this.to.equals(that.to));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (from == null) ? 0 : from.hashCode();
      __h *= 1000003;
      __h ^= (to == null) ? 0 : to.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CancellationPolicyDateRangeInput{"
        + "from=" + from + ", "
        + "to=" + to
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private LocalDate from;

    private LocalDate to;

    Builder() {
    }

    public Builder from(LocalDate from) {
      this.from = from;
      return this;
    }

    public Builder to(LocalDate to) {
      this.to = to;
      return this;
    }

    public CancellationPolicyDateRangeInput build() {
      return new CancellationPolicyDateRangeInput(from, to);
    }
  }
}
