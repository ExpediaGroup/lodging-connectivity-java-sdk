//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class CreatePropertyLocationInput {
  public final CoordinatesInput coordinates;

  public final Optional<Boolean> hideExactLocation;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreatePropertyLocationInput(CoordinatesInput coordinates,
      Optional<Boolean> hideExactLocation) {
    this.coordinates = coordinates;
    this.hideExactLocation = hideExactLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreatePropertyLocationInput) {
      CreatePropertyLocationInput that = (CreatePropertyLocationInput) o;
      return ((this.coordinates == null) ? (that.coordinates == null) : this.coordinates.equals(that.coordinates))
       &&((this.hideExactLocation == null) ? (that.hideExactLocation == null) : this.hideExactLocation.equals(that.hideExactLocation));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (coordinates == null) ? 0 : coordinates.hashCode();
      __h *= 1000003;
      __h ^= (hideExactLocation == null) ? 0 : hideExactLocation.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreatePropertyLocationInput{"
        + "coordinates=" + coordinates + ", "
        + "hideExactLocation=" + hideExactLocation
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private CoordinatesInput coordinates;

    private Optional<Boolean> hideExactLocation = Optional.absent();

    Builder() {
    }

    public Builder coordinates(CoordinatesInput coordinates) {
      this.coordinates = coordinates;
      return this;
    }

    public Builder hideExactLocation(Boolean hideExactLocation) {
      this.hideExactLocation = Optional.present(hideExactLocation);
      return this;
    }

    public CreatePropertyLocationInput build() {
      return new CreatePropertyLocationInput(coordinates, hideExactLocation);
    }
  }
}
