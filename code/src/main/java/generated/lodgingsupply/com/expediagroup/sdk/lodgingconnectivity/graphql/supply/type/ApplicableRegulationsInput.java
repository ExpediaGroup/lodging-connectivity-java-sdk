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

/**
 * Additional property registration information required by certain districts
 */
public class ApplicableRegulationsInput {
  public final Optional<ApplicableRegulationsKey> key;

  public final Optional<String> value;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ApplicableRegulationsInput(Optional<ApplicableRegulationsKey> key,
      Optional<String> value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ApplicableRegulationsInput) {
      ApplicableRegulationsInput that = (ApplicableRegulationsInput) o;
      return ((this.key == null) ? (that.key == null) : this.key.equals(that.key))
       &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (key == null) ? 0 : key.hashCode();
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
      $toString = "ApplicableRegulationsInput{"
        + "key=" + key + ", "
        + "value=" + value
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<ApplicableRegulationsKey> key = Optional.absent();

    private Optional<String> value = Optional.absent();

    Builder() {
    }

    /**
     * Identifier for additional information required by the district.
     */
    public Builder key(ApplicableRegulationsKey key) {
      this.key = Optional.present(key);
      return this;
    }

    /**
     * Value of the key required by the district.
     */
    public Builder value(String value) {
      this.value = Optional.present(value);
      return this;
    }

    public ApplicableRegulationsInput build() {
      return new ApplicableRegulationsInput(key, value);
    }
  }
}
