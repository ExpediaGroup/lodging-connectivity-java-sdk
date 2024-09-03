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

public class DisablePropertyInput {
  public final Optional<String> clientMutationId;

  public final String id;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public DisablePropertyInput(Optional<String> clientMutationId, String id) {
    this.clientMutationId = clientMutationId;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DisablePropertyInput) {
      DisablePropertyInput that = (DisablePropertyInput) o;
      return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "DisablePropertyInput{"
        + "clientMutationId=" + clientMutationId + ", "
        + "id=" + id
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> clientMutationId = Optional.absent();

    private String id;

    Builder() {
    }

    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public DisablePropertyInput build() {
      return new DisablePropertyInput(clientMutationId, id);
    }
  }
}
