//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class SingleDiscountUpdateInput {
  public final Optional<DiscountUnit> unit;

  public final Optional<Double> value;

  public final Optional<Double> memberOnlyAdditionalValue;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SingleDiscountUpdateInput(Optional<DiscountUnit> unit, Optional<Double> value,
      Optional<Double> memberOnlyAdditionalValue) {
    this.unit = unit;
    this.value = value;
    this.memberOnlyAdditionalValue = memberOnlyAdditionalValue;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SingleDiscountUpdateInput) {
      SingleDiscountUpdateInput that = (SingleDiscountUpdateInput) o;
      return ((this.unit == null) ? (that.unit == null) : this.unit.equals(that.unit))
       &&((this.value == null) ? (that.value == null) : this.value.equals(that.value))
       &&((this.memberOnlyAdditionalValue == null) ? (that.memberOnlyAdditionalValue == null) : this.memberOnlyAdditionalValue.equals(that.memberOnlyAdditionalValue));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (unit == null) ? 0 : unit.hashCode();
      __h *= 1000003;
      __h ^= (value == null) ? 0 : value.hashCode();
      __h *= 1000003;
      __h ^= (memberOnlyAdditionalValue == null) ? 0 : memberOnlyAdditionalValue.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "SingleDiscountUpdateInput{"
        + "unit=" + unit + ", "
        + "value=" + value + ", "
        + "memberOnlyAdditionalValue=" + memberOnlyAdditionalValue
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<DiscountUnit> unit = Optional.absent();

    private Optional<Double> value = Optional.absent();

    private Optional<Double> memberOnlyAdditionalValue = Optional.absent();

    Builder() {
    }

    /**
     * Unit of the discount. Currently only PERCENT is supported for MVP for Create and Update. AMOUNT promotions are supported only for Read.
     */
    public Builder unit(DiscountUnit unit) {
      this.unit = Optional.present(unit);
      return this;
    }

    /**
     * Value of the discount applied.
     */
    public Builder value(Double value) {
      this.value = Optional.present(value);
      return this;
    }

    /**
     * Member only discount value applied
     */
    public Builder memberOnlyAdditionalValue(Double memberOnlyAdditionalValue) {
      this.memberOnlyAdditionalValue = Optional.present(memberOnlyAdditionalValue);
      return this;
    }

    public SingleDiscountUpdateInput build() {
      return new SingleDiscountUpdateInput(unit, value, memberOnlyAdditionalValue);
    }
  }
}
