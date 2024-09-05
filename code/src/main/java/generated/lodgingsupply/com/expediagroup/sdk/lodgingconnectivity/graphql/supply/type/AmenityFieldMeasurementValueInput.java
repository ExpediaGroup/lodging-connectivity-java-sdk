//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class AmenityFieldMeasurementValueInput {
  public final String unitOfMeasure;

  public final String value;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public AmenityFieldMeasurementValueInput(String unitOfMeasure, String value) {
    this.unitOfMeasure = unitOfMeasure;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AmenityFieldMeasurementValueInput) {
      AmenityFieldMeasurementValueInput that = (AmenityFieldMeasurementValueInput) o;
      return ((this.unitOfMeasure == null) ? (that.unitOfMeasure == null) : this.unitOfMeasure.equals(that.unitOfMeasure))
       &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (unitOfMeasure == null) ? 0 : unitOfMeasure.hashCode();
      __h *= 1000003;
      __h ^= (value == null) ? 0 : value.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "AmenityFieldMeasurementValueInput{"
        + "unitOfMeasure=" + unitOfMeasure + ", "
        + "value=" + value
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String unitOfMeasure;

    private String value;

    Builder() {
    }

    public Builder unitOfMeasure(String unitOfMeasure) {
      this.unitOfMeasure = unitOfMeasure;
      return this;
    }

    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public AmenityFieldMeasurementValueInput build() {
      return new AmenityFieldMeasurementValueInput(unitOfMeasure, value);
    }
  }
}
