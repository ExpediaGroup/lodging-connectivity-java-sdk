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

public class CreateEventsPolicyInput {
  public final Boolean allowed;

  public final Optional<AllowedEventsInput> allowedEvents;

  public final Optional<List<LocalizedStringInput>> note;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateEventsPolicyInput(Boolean allowed, Optional<AllowedEventsInput> allowedEvents,
      Optional<List<LocalizedStringInput>> note) {
    this.allowed = allowed;
    this.allowedEvents = allowedEvents;
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateEventsPolicyInput) {
      CreateEventsPolicyInput that = (CreateEventsPolicyInput) o;
      return ((this.allowed == null) ? (that.allowed == null) : this.allowed.equals(that.allowed))
       &&((this.allowedEvents == null) ? (that.allowedEvents == null) : this.allowedEvents.equals(that.allowedEvents))
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
      __h ^= (allowedEvents == null) ? 0 : allowedEvents.hashCode();
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
      $toString = "CreateEventsPolicyInput{"
        + "allowed=" + allowed + ", "
        + "allowedEvents=" + allowedEvents + ", "
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

    private Optional<AllowedEventsInput> allowedEvents = Optional.absent();

    private Optional<List<LocalizedStringInput>> note = Optional.absent();

    Builder() {
    }

    public Builder allowed(Boolean allowed) {
      this.allowed = allowed;
      return this;
    }

    public Builder allowedEvents(AllowedEventsInput allowedEvents) {
      this.allowedEvents = Optional.present(allowedEvents);
      return this;
    }

    public Builder note(List<LocalizedStringInput> note) {
      this.note = Optional.present(note);
      return this;
    }

    public CreateEventsPolicyInput build() {
      return new CreateEventsPolicyInput(allowed, allowedEvents, note);
    }
  }
}
