//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo.api.Optional;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class UpdateMaxOccupancyPolicyInput {
  public final Optional<Integer> adultCount;

  public final Optional<List<LocalizedStringInput>> note;

  public final Optional<Integer> totalGuestCount;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateMaxOccupancyPolicyInput(Optional<Integer> adultCount,
      Optional<List<LocalizedStringInput>> note, Optional<Integer> totalGuestCount) {
    this.adultCount = adultCount;
    this.note = note;
    this.totalGuestCount = totalGuestCount;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateMaxOccupancyPolicyInput) {
      UpdateMaxOccupancyPolicyInput that = (UpdateMaxOccupancyPolicyInput) o;
      return ((this.adultCount == null) ? (that.adultCount == null) : this.adultCount.equals(that.adultCount))
       &&((this.note == null) ? (that.note == null) : this.note.equals(that.note))
       &&((this.totalGuestCount == null) ? (that.totalGuestCount == null) : this.totalGuestCount.equals(that.totalGuestCount));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (adultCount == null) ? 0 : adultCount.hashCode();
      __h *= 1000003;
      __h ^= (note == null) ? 0 : note.hashCode();
      __h *= 1000003;
      __h ^= (totalGuestCount == null) ? 0 : totalGuestCount.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateMaxOccupancyPolicyInput{"
        + "adultCount=" + adultCount + ", "
        + "note=" + note + ", "
        + "totalGuestCount=" + totalGuestCount
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Integer> adultCount = Optional.absent();

    private Optional<List<LocalizedStringInput>> note = Optional.absent();

    private Optional<Integer> totalGuestCount = Optional.absent();

    Builder() {
    }

    public Builder adultCount(Integer adultCount) {
      this.adultCount = Optional.present(adultCount);
      return this;
    }

    public Builder note(List<LocalizedStringInput> note) {
      this.note = Optional.present(note);
      return this;
    }

    public Builder totalGuestCount(Integer totalGuestCount) {
      this.totalGuestCount = Optional.present(totalGuestCount);
      return this;
    }

    public UpdateMaxOccupancyPolicyInput build() {
      return new UpdateMaxOccupancyPolicyInput(adultCount, note, totalGuestCount);
    }
  }
}
