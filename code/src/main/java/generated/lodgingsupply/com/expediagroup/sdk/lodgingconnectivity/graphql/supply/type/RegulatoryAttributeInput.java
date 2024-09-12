//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * Key/value pair representing an individual attribute of a tax record
 */
public class RegulatoryAttributeInput {
  public final String name;

  public final Optional<Optional<RegulatoryAttributeValueInput>> value;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public RegulatoryAttributeInput(String name,
      Optional<Optional<RegulatoryAttributeValueInput>> value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegulatoryAttributeInput) {
      RegulatoryAttributeInput that = (RegulatoryAttributeInput) o;
      return ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (name == null) ? 0 : name.hashCode();
      __h *= 1000003;
      __h ^= (value == null) ? 0 : value.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "RegulatoryAttributeInput{"
        + "name=" + name + ", "
        + "value=" + value
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String name;

    private Optional<Optional<RegulatoryAttributeValueInput>> value = Optional.empty();

    Builder() {
    }

    /**
     * Key identifying an individual attribute of a tax record
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Value for the given key in the attribute
     */
    public Builder value(@NotNull Optional<RegulatoryAttributeValueInput> value) {
      this.value = Optional.of(value);
      return this;
    }

    public RegulatoryAttributeInput build() {
      return new RegulatoryAttributeInput(name, value);
    }
  }
}
