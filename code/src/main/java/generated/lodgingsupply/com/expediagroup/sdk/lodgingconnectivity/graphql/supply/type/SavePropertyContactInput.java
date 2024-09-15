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
import java.util.List;

public class SavePropertyContactInput {
  public final Optional<List<String>> emailAddresses;

  public final Optional<String> name;

  public final Optional<List<PhoneNumberInput>> phoneNumbers;

  public final ContactType type;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SavePropertyContactInput(Optional<List<String>> emailAddresses, Optional<String> name,
      Optional<List<PhoneNumberInput>> phoneNumbers, ContactType type) {
    this.emailAddresses = emailAddresses;
    this.name = name;
    this.phoneNumbers = phoneNumbers;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SavePropertyContactInput) {
      SavePropertyContactInput that = (SavePropertyContactInput) o;
      return ((this.emailAddresses == null) ? (that.emailAddresses == null) : this.emailAddresses.equals(that.emailAddresses))
       &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       &&((this.phoneNumbers == null) ? (that.phoneNumbers == null) : this.phoneNumbers.equals(that.phoneNumbers))
       &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (emailAddresses == null) ? 0 : emailAddresses.hashCode();
      __h *= 1000003;
      __h ^= (name == null) ? 0 : name.hashCode();
      __h *= 1000003;
      __h ^= (phoneNumbers == null) ? 0 : phoneNumbers.hashCode();
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
      $toString = "SavePropertyContactInput{"
        + "emailAddresses=" + emailAddresses + ", "
        + "name=" + name + ", "
        + "phoneNumbers=" + phoneNumbers + ", "
        + "type=" + type
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Optional<List<String>> emailAddresses = Optional.absent();

    private Optional<String> name = Optional.absent();

    private Optional<List<PhoneNumberInput>> phoneNumbers = Optional.absent();

    private ContactType type;

    Builder() {
    }

    public Builder emailAddresses(List<String> emailAddresses) {
      this.emailAddresses = Optional.present(emailAddresses);
      return this;
    }

    public Builder name(String name) {
      this.name = Optional.present(name);
      return this;
    }

    public Builder phoneNumbers(List<PhoneNumberInput> phoneNumbers) {
      this.phoneNumbers = Optional.present(phoneNumbers);
      return this;
    }

    public Builder type(ContactType type) {
      this.type = type;
      return this;
    }

    public SavePropertyContactInput build() {
      return new SavePropertyContactInput(emailAddresses, name, phoneNumbers, type);
    }
  }
}