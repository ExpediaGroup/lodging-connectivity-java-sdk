//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public class CreateMaxOccupancyPolicyInput {
  public final Optional<Optional<Integer>> adultCount;

  public final Optional<Optional<List<LocalizedStringInput>>> note;

  public final Integer totalGuestCount;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateMaxOccupancyPolicyInput(Optional<Optional<Integer>> adultCount,
      Optional<Optional<List<LocalizedStringInput>>> note, Integer totalGuestCount) {
    this.adultCount = adultCount;
    this.note = note;
    this.totalGuestCount = totalGuestCount;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateMaxOccupancyPolicyInput) {
      CreateMaxOccupancyPolicyInput that = (CreateMaxOccupancyPolicyInput) o;
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
      $toString = "CreateMaxOccupancyPolicyInput{"
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
    private Optional<Optional<Integer>> adultCount = Optional.empty();

    private Optional<Optional<List<LocalizedStringInput>>> note = Optional.empty();

    private Integer totalGuestCount;

    Builder() {
    }

    public Builder adultCount(@NotNull Optional<Integer> adultCount) {
      this.adultCount = Optional.of(adultCount);
      return this;
    }

    public Builder note(@NotNull Optional<List<LocalizedStringInput>> note) {
      this.note = Optional.of(note);
      return this;
    }

    public Builder totalGuestCount(Integer totalGuestCount) {
      this.totalGuestCount = totalGuestCount;
      return this;
    }

    public CreateMaxOccupancyPolicyInput build() {
      return new CreateMaxOccupancyPolicyInput(adultCount, note, totalGuestCount);
    }
  }
}
