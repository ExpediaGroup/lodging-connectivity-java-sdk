//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo.api.Optional;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class CreatePetsPolicyInput {
  public final Boolean allowed;

  public final Optional<AllowedPetsInput> allowedPets;

  public final Optional<List<LocalizedStringInput>> note;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreatePetsPolicyInput(Boolean allowed, Optional<AllowedPetsInput> allowedPets,
      Optional<List<LocalizedStringInput>> note) {
    this.allowed = allowed;
    this.allowedPets = allowedPets;
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreatePetsPolicyInput) {
      CreatePetsPolicyInput that = (CreatePetsPolicyInput) o;
      return ((this.allowed == null) ? (that.allowed == null) : this.allowed.equals(that.allowed))
       &&((this.allowedPets == null) ? (that.allowedPets == null) : this.allowedPets.equals(that.allowedPets))
       &&((this.note == null) ? (that.note == null) : this.note.equals(that.note));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (allowed == null) ? 0 : allowed.hashCode();
      __h *= 1000003;
      __h ^= (allowedPets == null) ? 0 : allowedPets.hashCode();
      __h *= 1000003;
      __h ^= (note == null) ? 0 : note.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreatePetsPolicyInput{"
        + "allowed=" + allowed + ", "
        + "allowedPets=" + allowedPets + ", "
        + "note=" + note
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Boolean allowed;

    private Optional<AllowedPetsInput> allowedPets = Optional.absent();

    private Optional<List<LocalizedStringInput>> note = Optional.absent();

    Builder() {
    }

    public Builder allowed(Boolean allowed) {
      this.allowed = allowed;
      return this;
    }

    public Builder allowedPets(AllowedPetsInput allowedPets) {
      this.allowedPets = Optional.present(allowedPets);
      return this;
    }

    public Builder note(List<LocalizedStringInput> note) {
      this.note = Optional.present(note);
      return this;
    }

    public CreatePetsPolicyInput build() {
      return new CreatePetsPolicyInput(allowed, allowedPets, note);
    }
  }
}
