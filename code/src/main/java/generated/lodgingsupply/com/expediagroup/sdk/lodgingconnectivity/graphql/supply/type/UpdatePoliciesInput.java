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

public class UpdatePoliciesInput {
  public final Optional<BookingPolicyInput> bookingPolicy;

  public final Optional<UpdateStayPolicyInput> stayPolicy;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdatePoliciesInput(Optional<BookingPolicyInput> bookingPolicy,
      Optional<UpdateStayPolicyInput> stayPolicy) {
    this.bookingPolicy = bookingPolicy;
    this.stayPolicy = stayPolicy;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdatePoliciesInput) {
      UpdatePoliciesInput that = (UpdatePoliciesInput) o;
      return ((this.bookingPolicy == null) ? (that.bookingPolicy == null) : this.bookingPolicy.equals(that.bookingPolicy))
       &&((this.stayPolicy == null) ? (that.stayPolicy == null) : this.stayPolicy.equals(that.stayPolicy));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (bookingPolicy == null) ? 0 : bookingPolicy.hashCode();
      __h *= 1000003;
      __h ^= (stayPolicy == null) ? 0 : stayPolicy.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdatePoliciesInput{"
        + "bookingPolicy=" + bookingPolicy + ", "
        + "stayPolicy=" + stayPolicy
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<BookingPolicyInput> bookingPolicy = Optional.absent();

    private Optional<UpdateStayPolicyInput> stayPolicy = Optional.absent();

    Builder() {
    }

    public Builder bookingPolicy(BookingPolicyInput bookingPolicy) {
      this.bookingPolicy = Optional.present(bookingPolicy);
      return this;
    }

    public Builder stayPolicy(UpdateStayPolicyInput stayPolicy) {
      this.stayPolicy = Optional.present(stayPolicy);
      return this;
    }

    public UpdatePoliciesInput build() {
      return new UpdatePoliciesInput(bookingPolicy, stayPolicy);
    }
  }
}
