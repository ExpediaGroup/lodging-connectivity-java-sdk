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

public class DeleteUnitSpaceInput {
  public final Optional<String> clientMutationId;

  public final String propertyId;

  public final String spaceId;

  public final String unitId;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public DeleteUnitSpaceInput(Optional<String> clientMutationId, String propertyId, String spaceId,
      String unitId) {
    this.clientMutationId = clientMutationId;
    this.propertyId = propertyId;
    this.spaceId = spaceId;
    this.unitId = unitId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DeleteUnitSpaceInput) {
      DeleteUnitSpaceInput that = (DeleteUnitSpaceInput) o;
      return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.spaceId == null) ? (that.spaceId == null) : this.spaceId.equals(that.spaceId))
       &&((this.unitId == null) ? (that.unitId == null) : this.unitId.equals(that.unitId));
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
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (spaceId == null) ? 0 : spaceId.hashCode();
      __h *= 1000003;
      __h ^= (unitId == null) ? 0 : unitId.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "DeleteUnitSpaceInput{"
        + "clientMutationId=" + clientMutationId + ", "
        + "propertyId=" + propertyId + ", "
        + "spaceId=" + spaceId + ", "
        + "unitId=" + unitId
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<String> clientMutationId = Optional.absent();

    private String propertyId;

    private String spaceId;

    private String unitId;

    Builder() {
    }

    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder spaceId(String spaceId) {
      this.spaceId = spaceId;
      return this;
    }

    public Builder unitId(String unitId) {
      this.unitId = unitId;
      return this;
    }

    public DeleteUnitSpaceInput build() {
      return new DeleteUnitSpaceInput(clientMutationId, propertyId, spaceId, unitId);
    }
  }
}