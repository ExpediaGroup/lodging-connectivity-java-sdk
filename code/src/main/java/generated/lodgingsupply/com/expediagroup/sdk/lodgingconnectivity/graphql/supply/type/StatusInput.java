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

public class StatusInput {
  public final Optional<String> reason;

  public final String type;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public StatusInput(Optional<String> reason, String type) {
    this.reason = reason;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof StatusInput) {
      StatusInput that = (StatusInput) o;
      return ((this.reason == null) ? (that.reason == null) : this.reason.equals(that.reason))
       &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (reason == null) ? 0 : reason.hashCode();
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
      $toString = "StatusInput{"
        + "reason=" + reason + ", "
        + "type=" + type
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> reason = Optional.absent();

    private String type;

    Builder() {
    }

    public Builder reason(String reason) {
      this.reason = Optional.present(reason);
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public StatusInput build() {
      return new StatusInput(reason, type);
    }
  }
}