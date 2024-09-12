//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public class UpdateRatePlanInput {
  public final Optional<Optional<Integer>> baseRateGuestCount;

  public final Optional<Optional<String>> cancellationPolicyConfigId;

  public final Optional<Optional<String>> clientMutationId;

  public final Optional<Optional<List<RatePlanDistributionRuleInput>>> distributionRules;

  public final Optional<Optional<String>> feeSetId;

  public final String id;

  public final Optional<Optional<String>> name;

  public final Optional<Optional<Boolean>> paymentScheduleApplicable;

  public final String propertyId;

  public final Optional<Optional<UpdateRatePlanRestrictionsInput>> restrictions;

  public final Optional<Optional<RatePlanStatus>> status;

  public final Optional<Optional<Boolean>> taxInclusive;

  public final String unitId;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateRatePlanInput(Optional<Optional<Integer>> baseRateGuestCount,
      Optional<Optional<String>> cancellationPolicyConfigId,
      Optional<Optional<String>> clientMutationId,
      Optional<Optional<List<RatePlanDistributionRuleInput>>> distributionRules,
      Optional<Optional<String>> feeSetId, String id, Optional<Optional<String>> name,
      Optional<Optional<Boolean>> paymentScheduleApplicable, String propertyId,
      Optional<Optional<UpdateRatePlanRestrictionsInput>> restrictions,
      Optional<Optional<RatePlanStatus>> status, Optional<Optional<Boolean>> taxInclusive,
      String unitId) {
    this.baseRateGuestCount = baseRateGuestCount;
    this.cancellationPolicyConfigId = cancellationPolicyConfigId;
    this.clientMutationId = clientMutationId;
    this.distributionRules = distributionRules;
    this.feeSetId = feeSetId;
    this.id = id;
    this.name = name;
    this.paymentScheduleApplicable = paymentScheduleApplicable;
    this.propertyId = propertyId;
    this.restrictions = restrictions;
    this.status = status;
    this.taxInclusive = taxInclusive;
    this.unitId = unitId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateRatePlanInput) {
      UpdateRatePlanInput that = (UpdateRatePlanInput) o;
      return ((this.baseRateGuestCount == null) ? (that.baseRateGuestCount == null) : this.baseRateGuestCount.equals(that.baseRateGuestCount))
       &&((this.cancellationPolicyConfigId == null) ? (that.cancellationPolicyConfigId == null) : this.cancellationPolicyConfigId.equals(that.cancellationPolicyConfigId))
       &&((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.distributionRules == null) ? (that.distributionRules == null) : this.distributionRules.equals(that.distributionRules))
       &&((this.feeSetId == null) ? (that.feeSetId == null) : this.feeSetId.equals(that.feeSetId))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
       &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       &&((this.paymentScheduleApplicable == null) ? (that.paymentScheduleApplicable == null) : this.paymentScheduleApplicable.equals(that.paymentScheduleApplicable))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.restrictions == null) ? (that.restrictions == null) : this.restrictions.equals(that.restrictions))
       &&((this.status == null) ? (that.status == null) : this.status.equals(that.status))
       &&((this.taxInclusive == null) ? (that.taxInclusive == null) : this.taxInclusive.equals(that.taxInclusive))
       &&((this.unitId == null) ? (that.unitId == null) : this.unitId.equals(that.unitId));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (baseRateGuestCount == null) ? 0 : baseRateGuestCount.hashCode();
      __h *= 1000003;
      __h ^= (cancellationPolicyConfigId == null) ? 0 : cancellationPolicyConfigId.hashCode();
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (distributionRules == null) ? 0 : distributionRules.hashCode();
      __h *= 1000003;
      __h ^= (feeSetId == null) ? 0 : feeSetId.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      __h *= 1000003;
      __h ^= (name == null) ? 0 : name.hashCode();
      __h *= 1000003;
      __h ^= (paymentScheduleApplicable == null) ? 0 : paymentScheduleApplicable.hashCode();
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (restrictions == null) ? 0 : restrictions.hashCode();
      __h *= 1000003;
      __h ^= (status == null) ? 0 : status.hashCode();
      __h *= 1000003;
      __h ^= (taxInclusive == null) ? 0 : taxInclusive.hashCode();
      __h *= 1000003;
      __h ^= (unitId == null) ? 0 : unitId.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateRatePlanInput{"
        + "baseRateGuestCount=" + baseRateGuestCount + ", "
        + "cancellationPolicyConfigId=" + cancellationPolicyConfigId + ", "
        + "clientMutationId=" + clientMutationId + ", "
        + "distributionRules=" + distributionRules + ", "
        + "feeSetId=" + feeSetId + ", "
        + "id=" + id + ", "
        + "name=" + name + ", "
        + "paymentScheduleApplicable=" + paymentScheduleApplicable + ", "
        + "propertyId=" + propertyId + ", "
        + "restrictions=" + restrictions + ", "
        + "status=" + status + ", "
        + "taxInclusive=" + taxInclusive + ", "
        + "unitId=" + unitId
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Optional<Integer>> baseRateGuestCount = Optional.empty();

    private Optional<Optional<String>> cancellationPolicyConfigId = Optional.empty();

    private Optional<Optional<String>> clientMutationId = Optional.empty();

    private Optional<Optional<List<RatePlanDistributionRuleInput>>> distributionRules = Optional.empty();

    private Optional<Optional<String>> feeSetId = Optional.empty();

    private String id;

    private Optional<Optional<String>> name = Optional.empty();

    private Optional<Optional<Boolean>> paymentScheduleApplicable = Optional.empty();

    private String propertyId;

    private Optional<Optional<UpdateRatePlanRestrictionsInput>> restrictions = Optional.empty();

    private Optional<Optional<RatePlanStatus>> status = Optional.empty();

    private Optional<Optional<Boolean>> taxInclusive = Optional.empty();

    private String unitId;

    Builder() {
    }

    public Builder baseRateGuestCount(@NotNull Optional<Integer> baseRateGuestCount) {
      this.baseRateGuestCount = Optional.of(baseRateGuestCount);
      return this;
    }

    public Builder cancellationPolicyConfigId(
        @NotNull Optional<String> cancellationPolicyConfigId) {
      this.cancellationPolicyConfigId = Optional.of(cancellationPolicyConfigId);
      return this;
    }

    public Builder clientMutationId(@NotNull Optional<String> clientMutationId) {
      this.clientMutationId = Optional.of(clientMutationId);
      return this;
    }

    public Builder distributionRules(
        @NotNull Optional<List<RatePlanDistributionRuleInput>> distributionRules) {
      this.distributionRules = Optional.of(distributionRules);
      return this;
    }

    public Builder feeSetId(@NotNull Optional<String> feeSetId) {
      this.feeSetId = Optional.of(feeSetId);
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(@NotNull Optional<String> name) {
      this.name = Optional.of(name);
      return this;
    }

    public Builder paymentScheduleApplicable(@NotNull Optional<Boolean> paymentScheduleApplicable) {
      this.paymentScheduleApplicable = Optional.of(paymentScheduleApplicable);
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder restrictions(@NotNull Optional<UpdateRatePlanRestrictionsInput> restrictions) {
      this.restrictions = Optional.of(restrictions);
      return this;
    }

    public Builder status(@NotNull Optional<RatePlanStatus> status) {
      this.status = Optional.of(status);
      return this;
    }

    public Builder taxInclusive(@NotNull Optional<Boolean> taxInclusive) {
      this.taxInclusive = Optional.of(taxInclusive);
      return this;
    }

    public Builder unitId(String unitId) {
      this.unitId = unitId;
      return this;
    }

    public UpdateRatePlanInput build() {
      return new UpdateRatePlanInput(baseRateGuestCount, cancellationPolicyConfigId, clientMutationId, distributionRules, feeSetId, id, name, paymentScheduleApplicable, propertyId, restrictions, status, taxInclusive, unitId);
    }
  }
}
