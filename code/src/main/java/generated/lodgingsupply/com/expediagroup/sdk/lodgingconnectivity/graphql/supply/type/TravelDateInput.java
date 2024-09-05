//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;

public class TravelDateInput {
  public final Optional<LocalDate> from;

  public final Optional<LocalDate> to;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public TravelDateInput(Optional<LocalDate> from, Optional<LocalDate> to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TravelDateInput) {
      TravelDateInput that = (TravelDateInput) o;
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
      $toString = "TravelDateInput{"
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
    private Optional<LocalDate> from = Optional.absent();

    private Optional<LocalDate> to = Optional.absent();

    Builder() {
    }

    public Builder from(LocalDate from) {
      this.from = Optional.present(from);
      return this;
    }

    public Builder to(LocalDate to) {
      this.to = Optional.present(to);
      return this;
    }

    public TravelDateInput build() {
      return new TravelDateInput(from, to);
    }
  }
}
