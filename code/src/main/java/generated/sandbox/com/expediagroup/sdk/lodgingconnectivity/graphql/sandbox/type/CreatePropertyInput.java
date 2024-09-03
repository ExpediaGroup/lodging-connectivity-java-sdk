//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Input object for creating a property.
 */
public class CreatePropertyInput {
  public final Optional<String> clientMutationId;

  public final Optional<String> name;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreatePropertyInput(Optional<String> clientMutationId, Optional<String> name) {
    this.clientMutationId = clientMutationId;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreatePropertyInput) {
      CreatePropertyInput that = (CreatePropertyInput) o;
      return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.name == null) ? (that.name == null) : this.name.equals(that.name));
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
      __h ^= (name == null) ? 0 : name.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreatePropertyInput{"
        + "clientMutationId=" + clientMutationId + ", "
        + "name=" + name
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> clientMutationId = Optional.absent();

    private Optional<String> name = Optional.absent();

    Builder() {
    }

    /**
     * Client mutation ID. Optional value that is echoed back in the response.
     */
    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    /**
     * Optional name for the property.
     */
    public Builder name(String name) {
      this.name = Optional.present(name);
      return this;
    }

    public CreatePropertyInput build() {
      return new CreatePropertyInput(clientMutationId, name);
    }
  }
}
