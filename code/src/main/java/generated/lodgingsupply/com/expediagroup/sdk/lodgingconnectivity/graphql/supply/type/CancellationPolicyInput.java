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
import java.util.List;

public class CancellationPolicyInput {
  public final Optional<List<CancellationPolicyTierInput>> tiers;

  public final CancellationPolicyType type;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CancellationPolicyInput(Optional<List<CancellationPolicyTierInput>> tiers,
      CancellationPolicyType type) {
    this.tiers = tiers;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CancellationPolicyInput) {
      CancellationPolicyInput that = (CancellationPolicyInput) o;
      return ((this.tiers == null) ? (that.tiers == null) : this.tiers.equals(that.tiers))
       &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (tiers == null) ? 0 : tiers.hashCode();
      __h *= 1000003;
      __h ^= (type == null) ? 0 : type.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CancellationPolicyInput{"
        + "tiers=" + tiers + ", "
        + "type=" + type
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<List<CancellationPolicyTierInput>> tiers = Optional.absent();

    private CancellationPolicyType type;

    Builder() {
    }

    public Builder tiers(List<CancellationPolicyTierInput> tiers) {
      this.tiers = Optional.present(tiers);
      return this;
    }

    public Builder type(CancellationPolicyType type) {
      this.type = type;
      return this;
    }

    public CancellationPolicyInput build() {
      return new CancellationPolicyInput(tiers, type);
    }
  }
}
