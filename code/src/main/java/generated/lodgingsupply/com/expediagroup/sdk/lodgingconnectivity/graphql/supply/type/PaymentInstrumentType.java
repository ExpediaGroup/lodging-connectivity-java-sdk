//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;

/**
 * Type for Payment Reservation
 */
public class PaymentInstrumentType {
  public static EnumType type = new EnumType("PaymentInstrumentType", Arrays.asList("GUEST_CREDIT_CARD", "EXPEDIA_VIRTUAL_CARD", "BANK_TRANSFER", "CASH", "NONE"));

  public static PaymentInstrumentType GUEST_CREDIT_CARD = new PaymentInstrumentType("GUEST_CREDIT_CARD");

  public static PaymentInstrumentType EXPEDIA_VIRTUAL_CARD = new PaymentInstrumentType("EXPEDIA_VIRTUAL_CARD");

  public static PaymentInstrumentType BANK_TRANSFER = new PaymentInstrumentType("BANK_TRANSFER");

  public static PaymentInstrumentType CASH = new PaymentInstrumentType("CASH");

  public static PaymentInstrumentType NONE = new PaymentInstrumentType("NONE");

  public String rawValue;

  public PaymentInstrumentType(String rawValue) {
    this.rawValue = rawValue;
  }

  public static PaymentInstrumentType safeValueOf(String rawValue) {
    switch(rawValue) {
      case "GUEST_CREDIT_CARD": return PaymentInstrumentType.GUEST_CREDIT_CARD;
      case "EXPEDIA_VIRTUAL_CARD": return PaymentInstrumentType.EXPEDIA_VIRTUAL_CARD;
      case "BANK_TRANSFER": return PaymentInstrumentType.BANK_TRANSFER;
      case "CASH": return PaymentInstrumentType.CASH;
      case "NONE": return PaymentInstrumentType.NONE;
      default: return new PaymentInstrumentType.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends PaymentInstrumentType {
    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UNKNOWN__(String rawValue) {
      super(rawValue);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UNKNOWN__) {
        return true;
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UNKNOWN__{"
          + "}";
      }
      return $toString;
    }
  }
}