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

public class VrboCancellationPolicyPenalty {
  public final VrboCancellationPolicyPenaltyType type;

  public final Optional<Double> percent;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public VrboCancellationPolicyPenalty(VrboCancellationPolicyPenaltyType type,
      Optional<Double> percent) {
    this.type = type;
    this.percent = percent;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VrboCancellationPolicyPenalty) {
      VrboCancellationPolicyPenalty that = (VrboCancellationPolicyPenalty) o;
      return ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
       &&((this.percent == null) ? (that.percent == null) : this.percent.equals(that.percent));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (type == null) ? 0 : type.hashCode();
      __h *= 1000003;
      __h ^= (percent == null) ? 0 : percent.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "VrboCancellationPolicyPenalty{"
        + "type=" + type + ", "
        + "percent=" + percent
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private VrboCancellationPolicyPenaltyType type;

    private Optional<Double> percent = Optional.absent();

    Builder() {
    }

    /**
     * The penalty type for the cancellation
     */
    public Builder type(VrboCancellationPolicyPenaltyType type) {
      this.type = type;
      return this;
    }

    /**
     * The percentage of the penalty for the cancellation
     */
    public Builder percent(Double percent) {
      this.percent = Optional.present(percent);
      return this;
    }

    public VrboCancellationPolicyPenalty build() {
      return new VrboCancellationPolicyPenalty(type, percent);
    }
  }
}
