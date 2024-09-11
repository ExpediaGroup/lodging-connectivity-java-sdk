//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class BedGroupInput {
  public final List<BedTypeInput> beds;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public BedGroupInput(List<BedTypeInput> beds) {
    this.beds = beds;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BedGroupInput) {
      BedGroupInput that = (BedGroupInput) o;
      return ((this.beds == null) ? (that.beds == null) : this.beds.equals(that.beds));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (beds == null) ? 0 : beds.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "BedGroupInput{"
        + "beds=" + beds
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private List<BedTypeInput> beds;

    Builder() {
    }

    public Builder beds(List<BedTypeInput> beds) {
      this.beds = beds;
      return this;
    }

    public BedGroupInput build() {
      return new BedGroupInput(beds);
    }
  }
}
