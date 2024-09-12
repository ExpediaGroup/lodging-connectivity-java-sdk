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

public class UpdateUnitSpacesBathroomInput {
  public final Optional<Optional<List<AmenityInput>>> amenities;

  public final String id;

  public final Optional<Optional<Integer>> order;

  public final Optional<Optional<List<TextInput>>> text;

  public final Optional<Optional<String>> type;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateUnitSpacesBathroomInput(Optional<Optional<List<AmenityInput>>> amenities, String id,
      Optional<Optional<Integer>> order, Optional<Optional<List<TextInput>>> text,
      Optional<Optional<String>> type) {
    this.amenities = amenities;
    this.id = id;
    this.order = order;
    this.text = text;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateUnitSpacesBathroomInput) {
      UpdateUnitSpacesBathroomInput that = (UpdateUnitSpacesBathroomInput) o;
      return ((this.amenities == null) ? (that.amenities == null) : this.amenities.equals(that.amenities))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
       &&((this.order == null) ? (that.order == null) : this.order.equals(that.order))
       &&((this.text == null) ? (that.text == null) : this.text.equals(that.text))
       &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (amenities == null) ? 0 : amenities.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      __h *= 1000003;
      __h ^= (order == null) ? 0 : order.hashCode();
      __h *= 1000003;
      __h ^= (text == null) ? 0 : text.hashCode();
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
      $toString = "UpdateUnitSpacesBathroomInput{"
        + "amenities=" + amenities + ", "
        + "id=" + id + ", "
        + "order=" + order + ", "
        + "text=" + text + ", "
        + "type=" + type
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Optional<List<AmenityInput>>> amenities = Optional.empty();

    private String id;

    private Optional<Optional<Integer>> order = Optional.empty();

    private Optional<Optional<List<TextInput>>> text = Optional.empty();

    private Optional<Optional<String>> type = Optional.empty();

    Builder() {
    }

    public Builder amenities(@NotNull Optional<List<AmenityInput>> amenities) {
      this.amenities = Optional.of(amenities);
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder order(@NotNull Optional<Integer> order) {
      this.order = Optional.of(order);
      return this;
    }

    public Builder text(@NotNull Optional<List<TextInput>> text) {
      this.text = Optional.of(text);
      return this;
    }

    public Builder type(@NotNull Optional<String> type) {
      this.type = Optional.of(type);
      return this;
    }

    public UpdateUnitSpacesBathroomInput build() {
      return new UpdateUnitSpacesBathroomInput(amenities, id, order, text, type);
    }
  }
}
