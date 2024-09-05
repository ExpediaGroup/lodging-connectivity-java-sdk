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

public class DayOfWeekDiscountUpdateInput {
  public final Optional<DiscountUnit> unit;

  public final Optional<Double> monday;

  public final Optional<Double> tuesday;

  public final Optional<Double> wednesday;

  public final Optional<Double> thursday;

  public final Optional<Double> friday;

  public final Optional<Double> saturday;

  public final Optional<Double> sunday;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public DayOfWeekDiscountUpdateInput(Optional<DiscountUnit> unit, Optional<Double> monday,
      Optional<Double> tuesday, Optional<Double> wednesday, Optional<Double> thursday,
      Optional<Double> friday, Optional<Double> saturday, Optional<Double> sunday) {
    this.unit = unit;
    this.monday = monday;
    this.tuesday = tuesday;
    this.wednesday = wednesday;
    this.thursday = thursday;
    this.friday = friday;
    this.saturday = saturday;
    this.sunday = sunday;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DayOfWeekDiscountUpdateInput) {
      DayOfWeekDiscountUpdateInput that = (DayOfWeekDiscountUpdateInput) o;
      return ((this.unit == null) ? (that.unit == null) : this.unit.equals(that.unit))
       &&((this.monday == null) ? (that.monday == null) : this.monday.equals(that.monday))
       &&((this.tuesday == null) ? (that.tuesday == null) : this.tuesday.equals(that.tuesday))
       &&((this.wednesday == null) ? (that.wednesday == null) : this.wednesday.equals(that.wednesday))
       &&((this.thursday == null) ? (that.thursday == null) : this.thursday.equals(that.thursday))
       &&((this.friday == null) ? (that.friday == null) : this.friday.equals(that.friday))
       &&((this.saturday == null) ? (that.saturday == null) : this.saturday.equals(that.saturday))
       &&((this.sunday == null) ? (that.sunday == null) : this.sunday.equals(that.sunday));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (unit == null) ? 0 : unit.hashCode();
      __h *= 1000003;
      __h ^= (monday == null) ? 0 : monday.hashCode();
      __h *= 1000003;
      __h ^= (tuesday == null) ? 0 : tuesday.hashCode();
      __h *= 1000003;
      __h ^= (wednesday == null) ? 0 : wednesday.hashCode();
      __h *= 1000003;
      __h ^= (thursday == null) ? 0 : thursday.hashCode();
      __h *= 1000003;
      __h ^= (friday == null) ? 0 : friday.hashCode();
      __h *= 1000003;
      __h ^= (saturday == null) ? 0 : saturday.hashCode();
      __h *= 1000003;
      __h ^= (sunday == null) ? 0 : sunday.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "DayOfWeekDiscountUpdateInput{"
        + "unit=" + unit + ", "
        + "monday=" + monday + ", "
        + "tuesday=" + tuesday + ", "
        + "wednesday=" + wednesday + ", "
        + "thursday=" + thursday + ", "
        + "friday=" + friday + ", "
        + "saturday=" + saturday + ", "
        + "sunday=" + sunday
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<DiscountUnit> unit = Optional.absent();

    private Optional<Double> monday = Optional.absent();

    private Optional<Double> tuesday = Optional.absent();

    private Optional<Double> wednesday = Optional.absent();

    private Optional<Double> thursday = Optional.absent();

    private Optional<Double> friday = Optional.absent();

    private Optional<Double> saturday = Optional.absent();

    private Optional<Double> sunday = Optional.absent();

    Builder() {
    }

    /**
     * Unit of the discount. Currently only PERCENT is supported for MVP for Create and Update. AMOUNT promotions are supported only for Read.
     */
    public Builder unit(DiscountUnit unit) {
      this.unit = Optional.present(unit);
      return this;
    }

    public Builder monday(Double monday) {
      this.monday = Optional.present(monday);
      return this;
    }

    public Builder tuesday(Double tuesday) {
      this.tuesday = Optional.present(tuesday);
      return this;
    }

    public Builder wednesday(Double wednesday) {
      this.wednesday = Optional.present(wednesday);
      return this;
    }

    public Builder thursday(Double thursday) {
      this.thursday = Optional.present(thursday);
      return this;
    }

    public Builder friday(Double friday) {
      this.friday = Optional.present(friday);
      return this;
    }

    public Builder saturday(Double saturday) {
      this.saturday = Optional.present(saturday);
      return this;
    }

    public Builder sunday(Double sunday) {
      this.sunday = Optional.present(sunday);
      return this;
    }

    public DayOfWeekDiscountUpdateInput build() {
      return new DayOfWeekDiscountUpdateInput(unit, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }
  }
}
