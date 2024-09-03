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

public class CreateCancellationPolicyConfigInput {
  public final Optional<MoneyInput> additionalCancellationFee;

  public final Optional<String> clientMutationId;

  public final List<CancellationPolicyInput> defaultPolicies;

  public final String name;

  public final Optional<List<CancellationPolicyOverrideInput>> overridePolicies;

  public final String propertyId;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateCancellationPolicyConfigInput(Optional<MoneyInput> additionalCancellationFee,
      Optional<String> clientMutationId, List<CancellationPolicyInput> defaultPolicies, String name,
      Optional<List<CancellationPolicyOverrideInput>> overridePolicies, String propertyId) {
    this.additionalCancellationFee = additionalCancellationFee;
    this.clientMutationId = clientMutationId;
    this.defaultPolicies = defaultPolicies;
    this.name = name;
    this.overridePolicies = overridePolicies;
    this.propertyId = propertyId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateCancellationPolicyConfigInput) {
      CreateCancellationPolicyConfigInput that = (CreateCancellationPolicyConfigInput) o;
      return ((this.additionalCancellationFee == null) ? (that.additionalCancellationFee == null) : this.additionalCancellationFee.equals(that.additionalCancellationFee))
       &&((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.defaultPolicies == null) ? (that.defaultPolicies == null) : this.defaultPolicies.equals(that.defaultPolicies))
       &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       &&((this.overridePolicies == null) ? (that.overridePolicies == null) : this.overridePolicies.equals(that.overridePolicies))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (additionalCancellationFee == null) ? 0 : additionalCancellationFee.hashCode();
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (defaultPolicies == null) ? 0 : defaultPolicies.hashCode();
      __h *= 1000003;
      __h ^= (name == null) ? 0 : name.hashCode();
      __h *= 1000003;
      __h ^= (overridePolicies == null) ? 0 : overridePolicies.hashCode();
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreateCancellationPolicyConfigInput{"
        + "additionalCancellationFee=" + additionalCancellationFee + ", "
        + "clientMutationId=" + clientMutationId + ", "
        + "defaultPolicies=" + defaultPolicies + ", "
        + "name=" + name + ", "
        + "overridePolicies=" + overridePolicies + ", "
        + "propertyId=" + propertyId
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<MoneyInput> additionalCancellationFee = Optional.absent();

    private Optional<String> clientMutationId = Optional.absent();

    private List<CancellationPolicyInput> defaultPolicies;

    private String name;

    private Optional<List<CancellationPolicyOverrideInput>> overridePolicies = Optional.absent();

    private String propertyId;

    Builder() {
    }

    public Builder additionalCancellationFee(MoneyInput additionalCancellationFee) {
      this.additionalCancellationFee = Optional.present(additionalCancellationFee);
      return this;
    }

    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    public Builder defaultPolicies(List<CancellationPolicyInput> defaultPolicies) {
      this.defaultPolicies = defaultPolicies;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder overridePolicies(List<CancellationPolicyOverrideInput> overridePolicies) {
      this.overridePolicies = Optional.present(overridePolicies);
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public CreateCancellationPolicyConfigInput build() {
      return new CreateCancellationPolicyConfigInput(additionalCancellationFee, clientMutationId, defaultPolicies, name, overridePolicies, propertyId);
    }
  }
}
