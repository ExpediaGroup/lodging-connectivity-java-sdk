//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo.api.Optional;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.util.List;

public class CreateStayPolicyInput {
  public final CreateCheckInPolicyInput checkInPolicy;

  public final CreateCheckOutPolicyInput checkOutPolicy;

  public final Optional<CreateChildrenPolicyInput> childrenPolicy;

  public final Optional<List<CreateCustomStayPolicyInput>> customPolicies;

  public final Optional<CreateEventsPolicyInput> eventsPolicy;

  public final CreateMaxOccupancyPolicyInput maxOccupancyPolicy;

  public final Optional<CreatePetsPolicyInput> petsPolicy;

  public final Optional<URL> rentalAgreementUrl;

  public final Optional<CreateSmokingPolicyInput> smokingPolicy;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateStayPolicyInput(CreateCheckInPolicyInput checkInPolicy,
      CreateCheckOutPolicyInput checkOutPolicy, Optional<CreateChildrenPolicyInput> childrenPolicy,
      Optional<List<CreateCustomStayPolicyInput>> customPolicies,
      Optional<CreateEventsPolicyInput> eventsPolicy,
      CreateMaxOccupancyPolicyInput maxOccupancyPolicy, Optional<CreatePetsPolicyInput> petsPolicy,
      Optional<URL> rentalAgreementUrl, Optional<CreateSmokingPolicyInput> smokingPolicy) {
    this.checkInPolicy = checkInPolicy;
    this.checkOutPolicy = checkOutPolicy;
    this.childrenPolicy = childrenPolicy;
    this.customPolicies = customPolicies;
    this.eventsPolicy = eventsPolicy;
    this.maxOccupancyPolicy = maxOccupancyPolicy;
    this.petsPolicy = petsPolicy;
    this.rentalAgreementUrl = rentalAgreementUrl;
    this.smokingPolicy = smokingPolicy;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateStayPolicyInput) {
      CreateStayPolicyInput that = (CreateStayPolicyInput) o;
      return ((this.checkInPolicy == null) ? (that.checkInPolicy == null) : this.checkInPolicy.equals(that.checkInPolicy))
       &&((this.checkOutPolicy == null) ? (that.checkOutPolicy == null) : this.checkOutPolicy.equals(that.checkOutPolicy))
       &&((this.childrenPolicy == null) ? (that.childrenPolicy == null) : this.childrenPolicy.equals(that.childrenPolicy))
       &&((this.customPolicies == null) ? (that.customPolicies == null) : this.customPolicies.equals(that.customPolicies))
       &&((this.eventsPolicy == null) ? (that.eventsPolicy == null) : this.eventsPolicy.equals(that.eventsPolicy))
       &&((this.maxOccupancyPolicy == null) ? (that.maxOccupancyPolicy == null) : this.maxOccupancyPolicy.equals(that.maxOccupancyPolicy))
       &&((this.petsPolicy == null) ? (that.petsPolicy == null) : this.petsPolicy.equals(that.petsPolicy))
       &&((this.rentalAgreementUrl == null) ? (that.rentalAgreementUrl == null) : this.rentalAgreementUrl.equals(that.rentalAgreementUrl))
       &&((this.smokingPolicy == null) ? (that.smokingPolicy == null) : this.smokingPolicy.equals(that.smokingPolicy));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (checkInPolicy == null) ? 0 : checkInPolicy.hashCode();
      __h *= 1000003;
      __h ^= (checkOutPolicy == null) ? 0 : checkOutPolicy.hashCode();
      __h *= 1000003;
      __h ^= (childrenPolicy == null) ? 0 : childrenPolicy.hashCode();
      __h *= 1000003;
      __h ^= (customPolicies == null) ? 0 : customPolicies.hashCode();
      __h *= 1000003;
      __h ^= (eventsPolicy == null) ? 0 : eventsPolicy.hashCode();
      __h *= 1000003;
      __h ^= (maxOccupancyPolicy == null) ? 0 : maxOccupancyPolicy.hashCode();
      __h *= 1000003;
      __h ^= (petsPolicy == null) ? 0 : petsPolicy.hashCode();
      __h *= 1000003;
      __h ^= (rentalAgreementUrl == null) ? 0 : rentalAgreementUrl.hashCode();
      __h *= 1000003;
      __h ^= (smokingPolicy == null) ? 0 : smokingPolicy.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreateStayPolicyInput{"
        + "checkInPolicy=" + checkInPolicy + ", "
        + "checkOutPolicy=" + checkOutPolicy + ", "
        + "childrenPolicy=" + childrenPolicy + ", "
        + "customPolicies=" + customPolicies + ", "
        + "eventsPolicy=" + eventsPolicy + ", "
        + "maxOccupancyPolicy=" + maxOccupancyPolicy + ", "
        + "petsPolicy=" + petsPolicy + ", "
        + "rentalAgreementUrl=" + rentalAgreementUrl + ", "
        + "smokingPolicy=" + smokingPolicy
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private CreateCheckInPolicyInput checkInPolicy;

    private CreateCheckOutPolicyInput checkOutPolicy;

    private Optional<CreateChildrenPolicyInput> childrenPolicy = Optional.absent();

    private Optional<List<CreateCustomStayPolicyInput>> customPolicies = Optional.absent();

    private Optional<CreateEventsPolicyInput> eventsPolicy = Optional.absent();

    private CreateMaxOccupancyPolicyInput maxOccupancyPolicy;

    private Optional<CreatePetsPolicyInput> petsPolicy = Optional.absent();

    private Optional<URL> rentalAgreementUrl = Optional.absent();

    private Optional<CreateSmokingPolicyInput> smokingPolicy = Optional.absent();

    Builder() {
    }

    public Builder checkInPolicy(CreateCheckInPolicyInput checkInPolicy) {
      this.checkInPolicy = checkInPolicy;
      return this;
    }

    public Builder checkOutPolicy(CreateCheckOutPolicyInput checkOutPolicy) {
      this.checkOutPolicy = checkOutPolicy;
      return this;
    }

    public Builder childrenPolicy(CreateChildrenPolicyInput childrenPolicy) {
      this.childrenPolicy = Optional.present(childrenPolicy);
      return this;
    }

    public Builder customPolicies(List<CreateCustomStayPolicyInput> customPolicies) {
      this.customPolicies = Optional.present(customPolicies);
      return this;
    }

    public Builder eventsPolicy(CreateEventsPolicyInput eventsPolicy) {
      this.eventsPolicy = Optional.present(eventsPolicy);
      return this;
    }

    public Builder maxOccupancyPolicy(CreateMaxOccupancyPolicyInput maxOccupancyPolicy) {
      this.maxOccupancyPolicy = maxOccupancyPolicy;
      return this;
    }

    public Builder petsPolicy(CreatePetsPolicyInput petsPolicy) {
      this.petsPolicy = Optional.present(petsPolicy);
      return this;
    }

    public Builder rentalAgreementUrl(URL rentalAgreementUrl) {
      this.rentalAgreementUrl = Optional.present(rentalAgreementUrl);
      return this;
    }

    public Builder smokingPolicy(CreateSmokingPolicyInput smokingPolicy) {
      this.smokingPolicy = Optional.present(smokingPolicy);
      return this;
    }

    public CreateStayPolicyInput build() {
      return new CreateStayPolicyInput(checkInPolicy, checkOutPolicy, childrenPolicy, customPolicies, eventsPolicy, maxOccupancyPolicy, petsPolicy, rentalAgreementUrl, smokingPolicy);
    }
  }
}
