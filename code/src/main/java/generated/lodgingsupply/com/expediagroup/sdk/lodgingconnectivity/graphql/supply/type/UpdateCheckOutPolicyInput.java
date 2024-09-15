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

public class UpdateCheckOutPolicyInput {
  public final Optional<ExactOrApproximateTimeInput> checkOutTime;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateCheckOutPolicyInput(Optional<ExactOrApproximateTimeInput> checkOutTime) {
    this.checkOutTime = checkOutTime;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateCheckOutPolicyInput) {
      UpdateCheckOutPolicyInput that = (UpdateCheckOutPolicyInput) o;
      return ((this.checkOutTime == null) ? (that.checkOutTime == null) : this.checkOutTime.equals(that.checkOutTime));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (checkOutTime == null) ? 0 : checkOutTime.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateCheckOutPolicyInput{"
        + "checkOutTime=" + checkOutTime
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<ExactOrApproximateTimeInput> checkOutTime = Optional.absent();

    Builder() {
    }

    public Builder checkOutTime(ExactOrApproximateTimeInput checkOutTime) {
      this.checkOutTime = Optional.present(checkOutTime);
      return this;
    }

    public UpdateCheckOutPolicyInput build() {
      return new UpdateCheckOutPolicyInput(checkOutTime);
    }
  }
}