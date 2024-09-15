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

public class ExactOrApproximateTimeRangeInput {
  public final Optional<ExactOrApproximateTimeInput> end;

  public final ExactOrApproximateTimeInput start;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ExactOrApproximateTimeRangeInput(Optional<ExactOrApproximateTimeInput> end,
      ExactOrApproximateTimeInput start) {
    this.end = end;
    this.start = start;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExactOrApproximateTimeRangeInput) {
      ExactOrApproximateTimeRangeInput that = (ExactOrApproximateTimeRangeInput) o;
      return ((this.end == null) ? (that.end == null) : this.end.equals(that.end))
       &&((this.start == null) ? (that.start == null) : this.start.equals(that.start));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (end == null) ? 0 : end.hashCode();
      __h *= 1000003;
      __h ^= (start == null) ? 0 : start.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "ExactOrApproximateTimeRangeInput{"
        + "end=" + end + ", "
        + "start=" + start
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<ExactOrApproximateTimeInput> end = Optional.absent();

    private ExactOrApproximateTimeInput start;

    Builder() {
    }

    public Builder end(ExactOrApproximateTimeInput end) {
      this.end = Optional.present(end);
      return this;
    }

    public Builder start(ExactOrApproximateTimeInput start) {
      this.start = start;
      return this;
    }

    public ExactOrApproximateTimeRangeInput build() {
      return new ExactOrApproximateTimeRangeInput(end, start);
    }
  }
}