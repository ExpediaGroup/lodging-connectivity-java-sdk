//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.payment;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter.PaymentInstrumentQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter.PaymentInstrumentQuery_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.selections.PaymentInstrumentQuerySelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.ExpediaVirtualCardChargeStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.PaymentType;
import java.io.IOException;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.OffsetDateTime;
import java.util.List;

public class PaymentInstrumentQuery implements Query<PaymentInstrumentQuery.Data> {
  public static final String OPERATION_ID = "ed89679b729fab5bdc3ece4748c249a823ece9c2c8a3aa462df32735015ccd09";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query PaymentInstrument($token: String!) {
   *   paymentInstrument(token: $token) {
   *     __typename
   *     ... on BankIssuedCard {
   *       activationDate
   *       customer {
   *         address {
   *           addressLines
   *           administrativeArea
   *           administrativeAreaCode
   *           countryCode
   *           locality
   *           postalCode
   *           subLocality
   *         }
   *         fullName
   *       }
   *       expediaVirtualCardActivity {
   *         availableBalance {
   *           amount
   *           currency
   *         }
   *         chargeStatus
   *         chargedAmount {
   *           amount
   *           currency
   *         }
   *       }
   *       expirationDate
   *       issuerName
   *       number
   *       type
   *       verificationNumber
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query PaymentInstrument($token: String!) { paymentInstrument(token: $token) { __typename ... on BankIssuedCard { activationDate customer { address { addressLines administrativeArea administrativeAreaCode countryCode locality postalCode subLocality } fullName } expediaVirtualCardActivity { availableBalance { amount currency } chargeStatus chargedAmount { amount currency } } expirationDate issuerName number type verificationNumber } } }";

  public static final String OPERATION_NAME = "PaymentInstrument";

  public final String token;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public PaymentInstrumentQuery(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PaymentInstrumentQuery) {
      PaymentInstrumentQuery that = (PaymentInstrumentQuery) o;
      return ((this.token == null) ? (that.token == null) : this.token.equals(that.token));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (token == null) ? 0 : token.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "PaymentInstrumentQuery{"
        + "token=" + token
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String id() {
    return OPERATION_ID;
  }

  @Override
  public String document() {
    return OPERATION_DOCUMENT;
  }

  @Override
  public String name() {
    return OPERATION_NAME;
  }

  @Override
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    PaymentInstrumentQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(PaymentInstrumentQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.Query.type
    )
    .selections(PaymentInstrumentQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    private String token;

    Builder() {
    }

    public Builder token(String token) {
      this.token = token;
      return this;
    }

    public PaymentInstrumentQuery build() {
      return new PaymentInstrumentQuery(token);
    }
  }

  public static class Data implements Query.Data {
    /**
     * Retrieve Payment instrument from external payment instrument token
     */
    public PaymentInstrument paymentInstrument;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(PaymentInstrument paymentInstrument) {
      this.paymentInstrument = paymentInstrument;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.paymentInstrument == null) ? (that.paymentInstrument == null) : this.paymentInstrument.equals(that.paymentInstrument));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (paymentInstrument == null) ? 0 : paymentInstrument.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "paymentInstrument=" + paymentInstrument
          + "}";
      }
      return $toString;
    }
  }

  public static class PaymentInstrument {
    public String __typename;

    /**
     * Synthetic field for inline fragment on BankIssuedCard
     */
    public OnBankIssuedCard onBankIssuedCard;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public PaymentInstrument(String __typename, OnBankIssuedCard onBankIssuedCard) {
      this.__typename = __typename;
      this.onBankIssuedCard = onBankIssuedCard;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PaymentInstrument) {
        PaymentInstrument that = (PaymentInstrument) o;
        return ((this.__typename == null) ? (that.__typename == null) : this.__typename.equals(that.__typename))
         &&((this.onBankIssuedCard == null) ? (that.onBankIssuedCard == null) : this.onBankIssuedCard.equals(that.onBankIssuedCard));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (__typename == null) ? 0 : __typename.hashCode();
        __h *= 1000003;
        __h ^= (onBankIssuedCard == null) ? 0 : onBankIssuedCard.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PaymentInstrument{"
          + "__typename=" + __typename + ", "
          + "onBankIssuedCard=" + onBankIssuedCard
          + "}";
      }
      return $toString;
    }
  }

  public static class OnBankIssuedCard {
    /**
     * DateTime when the EVC card is active.
     */
    public OffsetDateTime activationDate;

    /**
     * Customer information.
     */
    public Customer customer;

    /**
     * Expedia virtual card activity.
     */
    public ExpediaVirtualCardActivity expediaVirtualCardActivity;

    /**
     * Card expiration date.
     */
    public String expirationDate;

    /**
     * Credit Card brand issuer name. i.e Visa, Mastercard...
     */
    public String issuerName;

    /**
     * Card number.
     */
    public String number;

    /**
     * Card type.
     */
    public PaymentType type;

    /**
     * CVV/CSV code.
     */
    public String verificationNumber;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public OnBankIssuedCard(OffsetDateTime activationDate, Customer customer,
        ExpediaVirtualCardActivity expediaVirtualCardActivity, String expirationDate,
        String issuerName, String number, PaymentType type, String verificationNumber) {
      this.activationDate = activationDate;
      this.customer = customer;
      this.expediaVirtualCardActivity = expediaVirtualCardActivity;
      this.expirationDate = expirationDate;
      this.issuerName = issuerName;
      this.number = number;
      this.type = type;
      this.verificationNumber = verificationNumber;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OnBankIssuedCard) {
        OnBankIssuedCard that = (OnBankIssuedCard) o;
        return ((this.activationDate == null) ? (that.activationDate == null) : this.activationDate.equals(that.activationDate))
         &&((this.customer == null) ? (that.customer == null) : this.customer.equals(that.customer))
         &&((this.expediaVirtualCardActivity == null) ? (that.expediaVirtualCardActivity == null) : this.expediaVirtualCardActivity.equals(that.expediaVirtualCardActivity))
         &&((this.expirationDate == null) ? (that.expirationDate == null) : this.expirationDate.equals(that.expirationDate))
         &&((this.issuerName == null) ? (that.issuerName == null) : this.issuerName.equals(that.issuerName))
         &&((this.number == null) ? (that.number == null) : this.number.equals(that.number))
         &&((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         &&((this.verificationNumber == null) ? (that.verificationNumber == null) : this.verificationNumber.equals(that.verificationNumber));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (activationDate == null) ? 0 : activationDate.hashCode();
        __h *= 1000003;
        __h ^= (customer == null) ? 0 : customer.hashCode();
        __h *= 1000003;
        __h ^= (expediaVirtualCardActivity == null) ? 0 : expediaVirtualCardActivity.hashCode();
        __h *= 1000003;
        __h ^= (expirationDate == null) ? 0 : expirationDate.hashCode();
        __h *= 1000003;
        __h ^= (issuerName == null) ? 0 : issuerName.hashCode();
        __h *= 1000003;
        __h ^= (number == null) ? 0 : number.hashCode();
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        __h *= 1000003;
        __h ^= (verificationNumber == null) ? 0 : verificationNumber.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OnBankIssuedCard{"
          + "activationDate=" + activationDate + ", "
          + "customer=" + customer + ", "
          + "expediaVirtualCardActivity=" + expediaVirtualCardActivity + ", "
          + "expirationDate=" + expirationDate + ", "
          + "issuerName=" + issuerName + ", "
          + "number=" + number + ", "
          + "type=" + type + ", "
          + "verificationNumber=" + verificationNumber
          + "}";
      }
      return $toString;
    }
  }

  public static class Customer {
    /**
     * Address of the customer.
     */
    public Address address;

    /**
     * Full name of the customer
     */
    public String fullName;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Customer(Address address, String fullName) {
      this.address = address;
      this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Customer) {
        Customer that = (Customer) o;
        return ((this.address == null) ? (that.address == null) : this.address.equals(that.address))
         &&((this.fullName == null) ? (that.fullName == null) : this.fullName.equals(that.fullName));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (address == null) ? 0 : address.hashCode();
        __h *= 1000003;
        __h ^= (fullName == null) ? 0 : fullName.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Customer{"
          + "address=" + address + ", "
          + "fullName=" + fullName
          + "}";
      }
      return $toString;
    }
  }

  public static class Address {
    /**
     * Each line represents one physical or logical line of the address, typically containing undifferentiated portions such as street name and number, post box numbers, building numbers, etc. They are called "lines" and declared as an array because addresses are frequently divided onto multiple lines and this encoding allows that fact to be preserved.
     */
    public List<String> addressLines;

    /**
     * The name of the state, province, or region.
     */
    public String administrativeArea;

    /**
     * The short code for the administrative area.
     */
    public String administrativeAreaCode;

    /**
     * The country code.
     */
    public String countryCode;

    /**
     * The name of the city, town or commune.
     */
    public String locality;

    /**
     * The postal code.
     */
    public String postalCode;

    /**
     * The name of the neighborhood, borough, or district.
     */
    public String subLocality;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Address(List<String> addressLines, String administrativeArea,
        String administrativeAreaCode, String countryCode, String locality, String postalCode,
        String subLocality) {
      this.addressLines = addressLines;
      this.administrativeArea = administrativeArea;
      this.administrativeAreaCode = administrativeAreaCode;
      this.countryCode = countryCode;
      this.locality = locality;
      this.postalCode = postalCode;
      this.subLocality = subLocality;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Address) {
        Address that = (Address) o;
        return ((this.addressLines == null) ? (that.addressLines == null) : this.addressLines.equals(that.addressLines))
         &&((this.administrativeArea == null) ? (that.administrativeArea == null) : this.administrativeArea.equals(that.administrativeArea))
         &&((this.administrativeAreaCode == null) ? (that.administrativeAreaCode == null) : this.administrativeAreaCode.equals(that.administrativeAreaCode))
         &&((this.countryCode == null) ? (that.countryCode == null) : this.countryCode.equals(that.countryCode))
         &&((this.locality == null) ? (that.locality == null) : this.locality.equals(that.locality))
         &&((this.postalCode == null) ? (that.postalCode == null) : this.postalCode.equals(that.postalCode))
         &&((this.subLocality == null) ? (that.subLocality == null) : this.subLocality.equals(that.subLocality));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (addressLines == null) ? 0 : addressLines.hashCode();
        __h *= 1000003;
        __h ^= (administrativeArea == null) ? 0 : administrativeArea.hashCode();
        __h *= 1000003;
        __h ^= (administrativeAreaCode == null) ? 0 : administrativeAreaCode.hashCode();
        __h *= 1000003;
        __h ^= (countryCode == null) ? 0 : countryCode.hashCode();
        __h *= 1000003;
        __h ^= (locality == null) ? 0 : locality.hashCode();
        __h *= 1000003;
        __h ^= (postalCode == null) ? 0 : postalCode.hashCode();
        __h *= 1000003;
        __h ^= (subLocality == null) ? 0 : subLocality.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Address{"
          + "addressLines=" + addressLines + ", "
          + "administrativeArea=" + administrativeArea + ", "
          + "administrativeAreaCode=" + administrativeAreaCode + ", "
          + "countryCode=" + countryCode + ", "
          + "locality=" + locality + ", "
          + "postalCode=" + postalCode + ", "
          + "subLocality=" + subLocality
          + "}";
      }
      return $toString;
    }
  }

  public static class ExpediaVirtualCardActivity {
    public AvailableBalance availableBalance;

    public ExpediaVirtualCardChargeStatus chargeStatus;

    public ChargedAmount chargedAmount;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ExpediaVirtualCardActivity(AvailableBalance availableBalance,
        ExpediaVirtualCardChargeStatus chargeStatus, ChargedAmount chargedAmount) {
      this.availableBalance = availableBalance;
      this.chargeStatus = chargeStatus;
      this.chargedAmount = chargedAmount;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ExpediaVirtualCardActivity) {
        ExpediaVirtualCardActivity that = (ExpediaVirtualCardActivity) o;
        return ((this.availableBalance == null) ? (that.availableBalance == null) : this.availableBalance.equals(that.availableBalance))
         &&((this.chargeStatus == null) ? (that.chargeStatus == null) : this.chargeStatus.equals(that.chargeStatus))
         &&((this.chargedAmount == null) ? (that.chargedAmount == null) : this.chargedAmount.equals(that.chargedAmount));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (availableBalance == null) ? 0 : availableBalance.hashCode();
        __h *= 1000003;
        __h ^= (chargeStatus == null) ? 0 : chargeStatus.hashCode();
        __h *= 1000003;
        __h ^= (chargedAmount == null) ? 0 : chargedAmount.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ExpediaVirtualCardActivity{"
          + "availableBalance=" + availableBalance + ", "
          + "chargeStatus=" + chargeStatus + ", "
          + "chargedAmount=" + chargedAmount
          + "}";
      }
      return $toString;
    }
  }

  public static class AvailableBalance {
    public Double amount;

    public Object currency;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public AvailableBalance(Double amount, Object currency) {
      this.amount = amount;
      this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AvailableBalance) {
        AvailableBalance that = (AvailableBalance) o;
        return ((this.amount == null) ? (that.amount == null) : this.amount.equals(that.amount))
         &&((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (amount == null) ? 0 : amount.hashCode();
        __h *= 1000003;
        __h ^= (currency == null) ? 0 : currency.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AvailableBalance{"
          + "amount=" + amount + ", "
          + "currency=" + currency
          + "}";
      }
      return $toString;
    }
  }

  public static class ChargedAmount {
    public Double amount;

    public Object currency;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ChargedAmount(Double amount, Object currency) {
      this.amount = amount;
      this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ChargedAmount) {
        ChargedAmount that = (ChargedAmount) o;
        return ((this.amount == null) ? (that.amount == null) : this.amount.equals(that.amount))
         &&((this.currency == null) ? (that.currency == null) : this.currency.equals(that.currency));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (amount == null) ? 0 : amount.hashCode();
        __h *= 1000003;
        __h ^= (currency == null) ? 0 : currency.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ChargedAmount{"
          + "amount=" + amount + ", "
          + "currency=" + currency
          + "}";
      }
      return $toString;
    }
  }
}