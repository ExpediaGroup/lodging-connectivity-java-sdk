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

public class UpdateChildrenPolicyInput {
  public final Optional<Boolean> allowed;

  public final Optional<List<AgeRangeInput>> allowedAges;

  public final Optional<List<LocalizedStringInput>> childrenAllowedNote;

  public final Optional<List<LocalizedStringInput>> childrenNotAllowedNote;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateChildrenPolicyInput(Optional<Boolean> allowed,
      Optional<List<AgeRangeInput>> allowedAges,
      Optional<List<LocalizedStringInput>> childrenAllowedNote,
      Optional<List<LocalizedStringInput>> childrenNotAllowedNote) {
    this.allowed = allowed;
    this.allowedAges = allowedAges;
    this.childrenAllowedNote = childrenAllowedNote;
    this.childrenNotAllowedNote = childrenNotAllowedNote;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateChildrenPolicyInput) {
      UpdateChildrenPolicyInput that = (UpdateChildrenPolicyInput) o;
      return ((this.allowed == null) ? (that.allowed == null) : this.allowed.equals(that.allowed))
       &&((this.allowedAges == null) ? (that.allowedAges == null) : this.allowedAges.equals(that.allowedAges))
       &&((this.childrenAllowedNote == null) ? (that.childrenAllowedNote == null) : this.childrenAllowedNote.equals(that.childrenAllowedNote))
       &&((this.childrenNotAllowedNote == null) ? (that.childrenNotAllowedNote == null) : this.childrenNotAllowedNote.equals(that.childrenNotAllowedNote));
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
      __h ^= (allowedAges == null) ? 0 : allowedAges.hashCode();
      __h *= 1000003;
      __h ^= (childrenAllowedNote == null) ? 0 : childrenAllowedNote.hashCode();
      __h *= 1000003;
      __h ^= (childrenNotAllowedNote == null) ? 0 : childrenNotAllowedNote.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateChildrenPolicyInput{"
        + "allowed=" + allowed + ", "
        + "allowedAges=" + allowedAges + ", "
        + "childrenAllowedNote=" + childrenAllowedNote + ", "
        + "childrenNotAllowedNote=" + childrenNotAllowedNote
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<Boolean> allowed = Optional.absent();

    private Optional<List<AgeRangeInput>> allowedAges = Optional.absent();

    private Optional<List<LocalizedStringInput>> childrenAllowedNote = Optional.absent();

    private Optional<List<LocalizedStringInput>> childrenNotAllowedNote = Optional.absent();

    Builder() {
    }

    public Builder allowed(Boolean allowed) {
      this.allowed = Optional.present(allowed);
      return this;
    }

    public Builder allowedAges(List<AgeRangeInput> allowedAges) {
      this.allowedAges = Optional.present(allowedAges);
      return this;
    }

    public Builder childrenAllowedNote(List<LocalizedStringInput> childrenAllowedNote) {
      this.childrenAllowedNote = Optional.present(childrenAllowedNote);
      return this;
    }

    public Builder childrenNotAllowedNote(List<LocalizedStringInput> childrenNotAllowedNote) {
      this.childrenNotAllowedNote = Optional.present(childrenNotAllowedNote);
      return this;
    }

    public UpdateChildrenPolicyInput build() {
      return new UpdateChildrenPolicyInput(allowed, allowedAges, childrenAllowedNote, childrenNotAllowedNote);
    }
  }
}
