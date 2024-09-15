//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Value added promotion(s) used to book the reservation.
 */
public class ReservationValueAddedPromotionInput {
  public final String description;

  public final String id;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ReservationValueAddedPromotionInput(String description, String id) {
    this.description = description;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReservationValueAddedPromotionInput) {
      ReservationValueAddedPromotionInput that = (ReservationValueAddedPromotionInput) o;
      return ((this.description == null) ? (that.description == null) : this.description.equals(that.description))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (description == null) ? 0 : description.hashCode();
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
      $toString = "ReservationValueAddedPromotionInput{"
        + "description=" + description + ", "
        + "id=" + id
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String description;

    private String id;

    Builder() {
    }

    /**
     * Description of the promotion.
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * ID of the promotion.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public ReservationValueAddedPromotionInput build() {
      return new ReservationValueAddedPromotionInput(description, id);
    }
  }
}