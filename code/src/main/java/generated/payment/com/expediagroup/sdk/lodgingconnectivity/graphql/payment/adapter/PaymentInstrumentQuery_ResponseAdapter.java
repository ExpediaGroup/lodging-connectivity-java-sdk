//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.Assertions;
import com.apollographql.apollo3.api.BPossibleTypes;
import com.apollographql.apollo3.api.BTerm;
import com.apollographql.apollo3.api.BooleanExpression;
import com.apollographql.apollo3.api.BooleanExpressions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.PaymentInstrumentQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.CountryCode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.ExpediaVirtualCardChargeStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.PaymentType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.adapter.ExpediaVirtualCardChargeStatus_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type.adapter.PaymentType_ResponseAdapter;
import java.io.IOException;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

public class PaymentInstrumentQuery_ResponseAdapter {
  public enum Data implements Adapter<PaymentInstrumentQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("paymentInstrument");

    @Override
    public PaymentInstrumentQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PaymentInstrumentQuery.PaymentInstrument _paymentInstrument = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _paymentInstrument = new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.PaymentInstrument>(PaymentInstrument.INSTANCE, true)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PaymentInstrumentQuery.Data(
        _paymentInstrument
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.Data value) throws IOException {
      writer.name("paymentInstrument");
      new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.PaymentInstrument>(PaymentInstrument.INSTANCE, true)).toJson(writer, customScalarAdapters, value.paymentInstrument);
    }
  }

  public enum PaymentInstrument implements Adapter<PaymentInstrumentQuery.PaymentInstrument> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename");

    @Override
    public PaymentInstrumentQuery.PaymentInstrument fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String __typename = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: __typename = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(__typename, "__typename");
      PaymentInstrumentQuery.OnBankIssuedCard _onBankIssuedCard = null;
      if (BooleanExpressions.evaluate(new BooleanExpression.Element<BTerm>(new BPossibleTypes("BankIssuedCard")), customScalarAdapters.getAdapterContext().variables(), __typename, customScalarAdapters.getAdapterContext(), null)) {
        reader.rewind();
        _onBankIssuedCard = com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter.PaymentInstrumentQuery_ResponseAdapter.OnBankIssuedCard.INSTANCE.fromJson(reader, customScalarAdapters);
      }

      return new PaymentInstrumentQuery.PaymentInstrument(
        __typename,
        _onBankIssuedCard
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.PaymentInstrument value) throws IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      if (value.onBankIssuedCard != null) {
        com.expediagroup.sdk.lodgingconnectivity.graphql.payment.adapter.PaymentInstrumentQuery_ResponseAdapter.OnBankIssuedCard.INSTANCE.toJson(writer, customScalarAdapters, value.onBankIssuedCard);
      }
    }
  }

  public enum OnBankIssuedCard implements Adapter<PaymentInstrumentQuery.OnBankIssuedCard> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("activationDate", "customer", "expediaVirtualCardActivity", "expirationDate", "issuerName", "number", "type", "verificationNumber");

    @Override
    public PaymentInstrumentQuery.OnBankIssuedCard fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      OffsetDateTime _activationDate = null;
      PaymentInstrumentQuery.Customer _customer = null;
      PaymentInstrumentQuery.ExpediaVirtualCardActivity _expediaVirtualCardActivity = null;
      String _expirationDate = null;
      String _issuerName = null;
      String _number = null;
      PaymentType _type = null;
      String _verificationNumber = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _activationDate = new NullableAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 1: _customer = new ObjectAdapter<PaymentInstrumentQuery.Customer>(Customer.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 2: _expediaVirtualCardActivity = new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.ExpediaVirtualCardActivity>(ExpediaVirtualCardActivity.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 3: _expirationDate = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _issuerName = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _number = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _type = PaymentType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 7: _verificationNumber = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_customer, "customer");
      Assertions.checkFieldNotMissing(_expirationDate, "expirationDate");
      Assertions.checkFieldNotMissing(_issuerName, "issuerName");
      Assertions.checkFieldNotMissing(_number, "number");
      Assertions.checkFieldNotMissing(_type, "type");

      return new PaymentInstrumentQuery.OnBankIssuedCard(
        _activationDate,
        _customer,
        _expediaVirtualCardActivity,
        _expirationDate,
        _issuerName,
        _number,
        _type,
        _verificationNumber
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.OnBankIssuedCard value) throws IOException {
      writer.name("activationDate");
      new NullableAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.activationDate);

      writer.name("customer");
      new ObjectAdapter<PaymentInstrumentQuery.Customer>(Customer.INSTANCE, false).toJson(writer, customScalarAdapters, value.customer);

      writer.name("expediaVirtualCardActivity");
      new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.ExpediaVirtualCardActivity>(ExpediaVirtualCardActivity.INSTANCE, false)).toJson(writer, customScalarAdapters, value.expediaVirtualCardActivity);

      writer.name("expirationDate");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.expirationDate);

      writer.name("issuerName");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.issuerName);

      writer.name("number");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.number);

      writer.name("type");
      PaymentType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);

      writer.name("verificationNumber");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.verificationNumber);
    }
  }

  public enum Customer implements Adapter<PaymentInstrumentQuery.Customer> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("address", "fullName");

    @Override
    public PaymentInstrumentQuery.Customer fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PaymentInstrumentQuery.Address _address = null;
      String _fullName = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _address = new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.Address>(Address.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _fullName = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_fullName, "fullName");

      return new PaymentInstrumentQuery.Customer(
        _address,
        _fullName
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.Customer value) throws IOException {
      writer.name("address");
      new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.Address>(Address.INSTANCE, false)).toJson(writer, customScalarAdapters, value.address);

      writer.name("fullName");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.fullName);
    }
  }

  public enum Address implements Adapter<PaymentInstrumentQuery.Address> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("addressLines", "administrativeArea", "administrativeAreaCode", "countryCode", "locality", "postalCode", "subLocality");

    @Override
    public PaymentInstrumentQuery.Address fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<String> _addressLines = null;
      String _administrativeArea = null;
      String _administrativeAreaCode = null;
      String _countryCode = null;
      String _locality = null;
      String _postalCode = null;
      String _subLocality = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _addressLines = new ListAdapter<>(Adapters.StringAdapter).fromJson(reader, customScalarAdapters); break;
          case 1: _administrativeArea = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _administrativeAreaCode = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _countryCode = (customScalarAdapters.<String>responseAdapterFor(CountryCode.type)).fromJson(reader, customScalarAdapters); break;
          case 4: _locality = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _postalCode = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _subLocality = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_addressLines, "addressLines");
      Assertions.checkFieldNotMissing(_countryCode, "countryCode");
      Assertions.checkFieldNotMissing(_locality, "locality");
      Assertions.checkFieldNotMissing(_postalCode, "postalCode");

      return new PaymentInstrumentQuery.Address(
        _addressLines,
        _administrativeArea,
        _administrativeAreaCode,
        _countryCode,
        _locality,
        _postalCode,
        _subLocality
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.Address value) throws IOException {
      writer.name("addressLines");
      new ListAdapter<>(Adapters.StringAdapter).toJson(writer, customScalarAdapters, value.addressLines);

      writer.name("administrativeArea");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.administrativeArea);

      writer.name("administrativeAreaCode");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.administrativeAreaCode);

      writer.name("countryCode");
      (customScalarAdapters.<String>responseAdapterFor(CountryCode.type)).toJson(writer, customScalarAdapters, value.countryCode);

      writer.name("locality");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.locality);

      writer.name("postalCode");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.postalCode);

      writer.name("subLocality");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.subLocality);
    }
  }

  public enum ExpediaVirtualCardActivity implements Adapter<PaymentInstrumentQuery.ExpediaVirtualCardActivity> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("availableBalance", "chargeStatus", "chargedAmount");

    @Override
    public PaymentInstrumentQuery.ExpediaVirtualCardActivity fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PaymentInstrumentQuery.AvailableBalance _availableBalance = null;
      ExpediaVirtualCardChargeStatus _chargeStatus = null;
      PaymentInstrumentQuery.ChargedAmount _chargedAmount = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _availableBalance = new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.AvailableBalance>(AvailableBalance.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _chargeStatus = new NullableAdapter<>(ExpediaVirtualCardChargeStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _chargedAmount = new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.ChargedAmount>(ChargedAmount.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PaymentInstrumentQuery.ExpediaVirtualCardActivity(
        _availableBalance,
        _chargeStatus,
        _chargedAmount
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.ExpediaVirtualCardActivity value) throws IOException {
      writer.name("availableBalance");
      new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.AvailableBalance>(AvailableBalance.INSTANCE, false)).toJson(writer, customScalarAdapters, value.availableBalance);

      writer.name("chargeStatus");
      new NullableAdapter<>(ExpediaVirtualCardChargeStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.chargeStatus);

      writer.name("chargedAmount");
      new NullableAdapter<>(new ObjectAdapter<PaymentInstrumentQuery.ChargedAmount>(ChargedAmount.INSTANCE, false)).toJson(writer, customScalarAdapters, value.chargedAmount);
    }
  }

  public enum AvailableBalance implements Adapter<PaymentInstrumentQuery.AvailableBalance> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("amount", "currency");

    @Override
    public PaymentInstrumentQuery.AvailableBalance fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Double _amount = null;
      Object _currency = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _amount = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _currency = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_amount, "amount");
      Assertions.checkFieldNotMissing(_currency, "currency");

      return new PaymentInstrumentQuery.AvailableBalance(
        _amount,
        _currency
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.AvailableBalance value) throws IOException {
      writer.name("amount");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.amount);

      writer.name("currency");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.currency);
    }
  }

  public enum ChargedAmount implements Adapter<PaymentInstrumentQuery.ChargedAmount> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("amount", "currency");

    @Override
    public PaymentInstrumentQuery.ChargedAmount fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Double _amount = null;
      Object _currency = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _amount = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _currency = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_amount, "amount");
      Assertions.checkFieldNotMissing(_currency, "currency");

      return new PaymentInstrumentQuery.ChargedAmount(
        _amount,
        _currency
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PaymentInstrumentQuery.ChargedAmount value) throws IOException {
      writer.name("amount");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.amount);

      writer.name("currency");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.currency);
    }
  }
}