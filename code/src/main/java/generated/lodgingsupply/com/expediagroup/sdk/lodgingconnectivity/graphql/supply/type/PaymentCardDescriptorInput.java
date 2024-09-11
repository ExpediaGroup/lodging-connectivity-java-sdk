//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class PaymentCardDescriptorInput {
  public final String code;

  public final String type;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public PaymentCardDescriptorInput(String code, String type) {
    this.code = code;
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PaymentCardDescriptorInput) {
      PaymentCardDescriptorInput that = (PaymentCardDescriptorInput) o;
      return ((this.code == null) ? (that.code == null) : this.code.equals(that.code))
       &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (code == null) ? 0 : code.hashCode();
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
      $toString = "PaymentCardDescriptorInput{"
        + "code=" + code + ", "
        + "type=" + type
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String code;

    private String type;

    Builder() {
    }

    /**
     * Specifies the code associated with the provider of this card: AFFIRM, VISA, MASTERCARD, etc.
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * Specifies the type of the card: ALTERNATIVE (for Affirm payments), CREDIT, or DEBIT (debit cards used as credit cards).
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public PaymentCardDescriptorInput build() {
      return new PaymentCardDescriptorInput(code, type);
    }
  }
}
