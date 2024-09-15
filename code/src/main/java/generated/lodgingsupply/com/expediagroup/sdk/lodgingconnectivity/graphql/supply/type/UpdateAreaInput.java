//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class UpdateAreaInput {
  public final Optional<AreaUnit> unit;

  public final Optional<Integer> value;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateAreaInput(Optional<AreaUnit> unit, Optional<Integer> value) {
    this.unit = unit;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateAreaInput) {
      UpdateAreaInput that = (UpdateAreaInput) o;
      return ((this.unit == null) ? (that.unit == null) : this.unit.equals(that.unit))
       &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
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
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateAreaInput{"
        + "unit=" + unit + ", "
        + "value=" + value
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<AreaUnit> unit = Optional.absent();

    private Optional<Integer> value = Optional.absent();

    Builder() {
    }

    public Builder unit(AreaUnit unit) {
      this.unit = Optional.present(unit);
      return this;
    }

    public Builder value(Integer value) {
      this.value = Optional.present(value);
      return this;
    }

    public UpdateAreaInput build() {
      return new UpdateAreaInput(unit, value);
    }
  }
}