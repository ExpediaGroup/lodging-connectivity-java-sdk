//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class UpdateSmokingPolicyInput {
  public final Optional<Boolean> allowed;

  public final Optional<UpdateSmokingLocationPolicyInput> indoorPolicy;

  public final Optional<List<LocalizedStringInput>> note;

  public final Optional<UpdateSmokingLocationPolicyInput> outdoorPolicy;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateSmokingPolicyInput(Optional<Boolean> allowed,
      Optional<UpdateSmokingLocationPolicyInput> indoorPolicy,
      Optional<List<LocalizedStringInput>> note,
      Optional<UpdateSmokingLocationPolicyInput> outdoorPolicy) {
    this.allowed = allowed;
    this.indoorPolicy = indoorPolicy;
    this.note = note;
    this.outdoorPolicy = outdoorPolicy;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateSmokingPolicyInput) {
      UpdateSmokingPolicyInput that = (UpdateSmokingPolicyInput) o;
      return ((this.allowed == null) ? (that.allowed == null) : this.allowed.equals(that.allowed))
       &&((this.indoorPolicy == null) ? (that.indoorPolicy == null) : this.indoorPolicy.equals(that.indoorPolicy))
       &&((this.note == null) ? (that.note == null) : this.note.equals(that.note))
       &&((this.outdoorPolicy == null) ? (that.outdoorPolicy == null) : this.outdoorPolicy.equals(that.outdoorPolicy));
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
      __h ^= (indoorPolicy == null) ? 0 : indoorPolicy.hashCode();
      __h *= 1000003;
      __h ^= (note == null) ? 0 : note.hashCode();
      __h *= 1000003;
      __h ^= (outdoorPolicy == null) ? 0 : outdoorPolicy.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateSmokingPolicyInput{"
        + "allowed=" + allowed + ", "
        + "indoorPolicy=" + indoorPolicy + ", "
        + "note=" + note + ", "
        + "outdoorPolicy=" + outdoorPolicy
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Boolean> allowed = Optional.absent();

    private Optional<UpdateSmokingLocationPolicyInput> indoorPolicy = Optional.absent();

    private Optional<List<LocalizedStringInput>> note = Optional.absent();

    private Optional<UpdateSmokingLocationPolicyInput> outdoorPolicy = Optional.absent();

    Builder() {
    }

    public Builder allowed(Boolean allowed) {
      this.allowed = Optional.present(allowed);
      return this;
    }

    public Builder indoorPolicy(UpdateSmokingLocationPolicyInput indoorPolicy) {
      this.indoorPolicy = Optional.present(indoorPolicy);
      return this;
    }

    public Builder note(List<LocalizedStringInput> note) {
      this.note = Optional.present(note);
      return this;
    }

    public Builder outdoorPolicy(UpdateSmokingLocationPolicyInput outdoorPolicy) {
      this.outdoorPolicy = Optional.present(outdoorPolicy);
      return this;
    }

    public UpdateSmokingPolicyInput build() {
      return new UpdateSmokingPolicyInput(allowed, indoorPolicy, note, outdoorPolicy);
    }
  }
}
