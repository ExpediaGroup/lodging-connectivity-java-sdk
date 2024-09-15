//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class UpdateImageInput {
  public final Optional<Boolean> active;

  public final Optional<List<LocalizedStringInput>> captions;

  public final Optional<String> clientMutationId;

  public final Optional<Boolean> featured;

  public final String id;

  public final Optional<Integer> order;

  public final Optional<Integer> rotation;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateImageInput(Optional<Boolean> active, Optional<List<LocalizedStringInput>> captions,
      Optional<String> clientMutationId, Optional<Boolean> featured, String id,
      Optional<Integer> order, Optional<Integer> rotation) {
    this.active = active;
    this.captions = captions;
    this.clientMutationId = clientMutationId;
    this.featured = featured;
    this.id = id;
    this.order = order;
    this.rotation = rotation;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateImageInput) {
      UpdateImageInput that = (UpdateImageInput) o;
      return ((this.active == null) ? (that.active == null) : this.active.equals(that.active))
       &&((this.captions == null) ? (that.captions == null) : this.captions.equals(that.captions))
       &&((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.featured == null) ? (that.featured == null) : this.featured.equals(that.featured))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
       &&((this.order == null) ? (that.order == null) : this.order.equals(that.order))
       &&((this.rotation == null) ? (that.rotation == null) : this.rotation.equals(that.rotation));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (active == null) ? 0 : active.hashCode();
      __h *= 1000003;
      __h ^= (captions == null) ? 0 : captions.hashCode();
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (featured == null) ? 0 : featured.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      __h *= 1000003;
      __h ^= (order == null) ? 0 : order.hashCode();
      __h *= 1000003;
      __h ^= (rotation == null) ? 0 : rotation.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateImageInput{"
        + "active=" + active + ", "
        + "captions=" + captions + ", "
        + "clientMutationId=" + clientMutationId + ", "
        + "featured=" + featured + ", "
        + "id=" + id + ", "
        + "order=" + order + ", "
        + "rotation=" + rotation
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Boolean> active = Optional.absent();

    private Optional<List<LocalizedStringInput>> captions = Optional.absent();

    private Optional<String> clientMutationId = Optional.absent();

    private Optional<Boolean> featured = Optional.absent();

    private String id;

    private Optional<Integer> order = Optional.absent();

    private Optional<Integer> rotation = Optional.absent();

    Builder() {
    }

    public Builder active(Boolean active) {
      this.active = Optional.present(active);
      return this;
    }

    public Builder captions(List<LocalizedStringInput> captions) {
      this.captions = Optional.present(captions);
      return this;
    }

    public Builder clientMutationId(String clientMutationId) {
      this.clientMutationId = Optional.present(clientMutationId);
      return this;
    }

    public Builder featured(Boolean featured) {
      this.featured = Optional.present(featured);
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder order(Integer order) {
      this.order = Optional.present(order);
      return this;
    }

    public Builder rotation(Integer rotation) {
      this.rotation = Optional.present(rotation);
      return this;
    }

    public UpdateImageInput build() {
      return new UpdateImageInput(active, captions, clientMutationId, featured, id, order, rotation);
    }
  }
}