//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreateDayOfWeekDiscountPromotionMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionName;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionSellStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DiscountType_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DiscountUnit_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionCategory_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionName_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionSellStatus_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionStatus_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CreateDayOfWeekDiscountPromotionMutation_ResponseAdapter {
  public enum Data implements Adapter<CreateDayOfWeekDiscountPromotionMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("createDayOfWeekDiscountPromotion");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion _createDayOfWeekDiscountPromotion = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _createDayOfWeekDiscountPromotion = new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion>(CreateDayOfWeekDiscountPromotion.INSTANCE, true).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_createDayOfWeekDiscountPromotion, "createDayOfWeekDiscountPromotion");

      return new CreateDayOfWeekDiscountPromotionMutation.Data(
        _createDayOfWeekDiscountPromotion
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.Data value) throws IOException {
      writer.name("createDayOfWeekDiscountPromotion");
      new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion>(CreateDayOfWeekDiscountPromotion.INSTANCE, true).toJson(writer, customScalarAdapters, value.createDayOfWeekDiscountPromotion);
    }
  }

  public enum CreateDayOfWeekDiscountPromotion implements Adapter<CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename", "category", "id", "isContractedPromotion", "name", "sellStatus", "status");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      String __typename = null;
      PromotionCategory _category = null;
      String _id = null;
      Boolean _isContractedPromotion = null;
      PromotionName _name = null;
      PromotionSellStatus _sellStatus = null;
      PromotionStatus _status = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: __typename = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _category = PromotionCategory_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _isContractedPromotion = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _name = PromotionName_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 5: _sellStatus = new NullableAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 6: _status = PromotionStatus_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(__typename, "__typename");
      CreateDayOfWeekDiscountPromotionMutation.OnDiscountPromotion _onDiscountPromotion = null;
      if (BooleanExpressions.evaluate(new BooleanExpression.Element<BTerm>(new BPossibleTypes("DiscountPromotion")), customScalarAdapters.getAdapterContext().variables(), __typename, customScalarAdapters.getAdapterContext(), null)) {
        reader.rewind();
        _onDiscountPromotion = com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateDayOfWeekDiscountPromotionMutation_ResponseAdapter.OnDiscountPromotion.INSTANCE.fromJson(reader, customScalarAdapters);
      }

      Assertions.checkFieldNotMissing(_category, "category");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_status, "status");

      return new CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion(
        __typename,
        _category,
        _id,
        _isContractedPromotion,
        _name,
        _sellStatus,
        _status,
        _onDiscountPromotion
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.CreateDayOfWeekDiscountPromotion value) throws
        IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      writer.name("category");
      PromotionCategory_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.category);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("isContractedPromotion");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isContractedPromotion);

      writer.name("name");
      PromotionName_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.name);

      writer.name("sellStatus");
      new NullableAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.sellStatus);

      writer.name("status");
      PromotionStatus_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.status);

      if (value.onDiscountPromotion != null) {
        com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateDayOfWeekDiscountPromotionMutation_ResponseAdapter.OnDiscountPromotion.INSTANCE.toJson(writer, customScalarAdapters, value.onDiscountPromotion);
      }
    }
  }

  public enum OnDiscountPromotion implements Adapter<CreateDayOfWeekDiscountPromotionMutation.OnDiscountPromotion> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "category", "status", "code", "restrictions", "eligibleRatePlans", "blackoutDates", "discount", "sellStatus", "isContractedPromotion");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.OnDiscountPromotion fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      PromotionName _name = null;
      PromotionCategory _category = null;
      PromotionStatus _status = null;
      String _code = null;
      CreateDayOfWeekDiscountPromotionMutation.Restrictions _restrictions = null;
      List<CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan> _eligibleRatePlans = null;
      List<CreateDayOfWeekDiscountPromotionMutation.BlackoutDate> _blackoutDates = null;
      CreateDayOfWeekDiscountPromotionMutation.Discount _discount = null;
      PromotionSellStatus _sellStatus = null;
      Boolean _isContractedPromotion = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = PromotionName_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _category = PromotionCategory_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 3: _status = PromotionStatus_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 4: _code = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _restrictions = new NullableAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.Restrictions>(Restrictions.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 6: _eligibleRatePlans = new ListAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan>(EligibleRatePlan.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 7: _blackoutDates = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.BlackoutDate>(BlackoutDate.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 8: _discount = new NullableAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.Discount>(Discount.INSTANCE, true)).fromJson(reader, customScalarAdapters); break;
          case 9: _sellStatus = new NullableAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 10: _isContractedPromotion = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_category, "category");
      Assertions.checkFieldNotMissing(_status, "status");
      Assertions.checkFieldNotMissing(_code, "code");
      Assertions.checkFieldNotMissing(_eligibleRatePlans, "eligibleRatePlans");

      return new CreateDayOfWeekDiscountPromotionMutation.OnDiscountPromotion(
        _id,
        _name,
        _category,
        _status,
        _code,
        _restrictions,
        _eligibleRatePlans,
        _blackoutDates,
        _discount,
        _sellStatus,
        _isContractedPromotion
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.OnDiscountPromotion value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      PromotionName_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.name);

      writer.name("category");
      PromotionCategory_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.category);

      writer.name("status");
      PromotionStatus_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.status);

      writer.name("code");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.code);

      writer.name("restrictions");
      new NullableAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.Restrictions>(Restrictions.INSTANCE, false)).toJson(writer, customScalarAdapters, value.restrictions);

      writer.name("eligibleRatePlans");
      new ListAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan>(EligibleRatePlan.INSTANCE, false)).toJson(writer, customScalarAdapters, value.eligibleRatePlans);

      writer.name("blackoutDates");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.BlackoutDate>(BlackoutDate.INSTANCE, false))).toJson(writer, customScalarAdapters, value.blackoutDates);

      writer.name("discount");
      new NullableAdapter<>(new ObjectAdapter<CreateDayOfWeekDiscountPromotionMutation.Discount>(Discount.INSTANCE, true)).toJson(writer, customScalarAdapters, value.discount);

      writer.name("sellStatus");
      new NullableAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.sellStatus);

      writer.name("isContractedPromotion");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isContractedPromotion);
    }
  }

  public enum Restrictions implements Adapter<CreateDayOfWeekDiscountPromotionMutation.Restrictions> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("isMemberOnly", "isMobileUserOnly", "minLengthOfStay", "maxLengthOfStay", "minAdvanceBookingDays", "maxAdvanceBookingDays", "bookingLocalDateTimeFrom", "bookingLocalDateTimeTo", "travelDateFrom", "travelDateTo", "sameDayBookingStartTime");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.Restrictions fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Boolean _isMemberOnly = null;
      Boolean _isMobileUserOnly = null;
      Integer _minLengthOfStay = null;
      Integer _maxLengthOfStay = null;
      Integer _minAdvanceBookingDays = null;
      Integer _maxAdvanceBookingDays = null;
      LocalDateTime _bookingLocalDateTimeFrom = null;
      LocalDateTime _bookingLocalDateTimeTo = null;
      LocalDate _travelDateFrom = null;
      LocalDate _travelDateTo = null;
      Object _sameDayBookingStartTime = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _isMemberOnly = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _isMobileUserOnly = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _minLengthOfStay = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _maxLengthOfStay = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _minAdvanceBookingDays = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _maxAdvanceBookingDays = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _bookingLocalDateTimeFrom = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 7: _bookingLocalDateTimeTo = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 8: _travelDateFrom = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 9: _travelDateTo = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 10: _sameDayBookingStartTime = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new CreateDayOfWeekDiscountPromotionMutation.Restrictions(
        _isMemberOnly,
        _isMobileUserOnly,
        _minLengthOfStay,
        _maxLengthOfStay,
        _minAdvanceBookingDays,
        _maxAdvanceBookingDays,
        _bookingLocalDateTimeFrom,
        _bookingLocalDateTimeTo,
        _travelDateFrom,
        _travelDateTo,
        _sameDayBookingStartTime
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.Restrictions value) throws IOException {
      writer.name("isMemberOnly");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isMemberOnly);

      writer.name("isMobileUserOnly");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isMobileUserOnly);

      writer.name("minLengthOfStay");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.minLengthOfStay);

      writer.name("maxLengthOfStay");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.maxLengthOfStay);

      writer.name("minAdvanceBookingDays");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.minAdvanceBookingDays);

      writer.name("maxAdvanceBookingDays");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.maxAdvanceBookingDays);

      writer.name("bookingLocalDateTimeFrom");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.bookingLocalDateTimeFrom);

      writer.name("bookingLocalDateTimeTo");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.bookingLocalDateTimeTo);

      writer.name("travelDateFrom");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.travelDateFrom);

      writer.name("travelDateTo");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.travelDateTo);

      writer.name("sameDayBookingStartTime");
      Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.sameDayBookingStartTime);
    }
  }

  public enum EligibleRatePlan implements Adapter<CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.EligibleRatePlan value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }

  public enum BlackoutDate implements Adapter<CreateDayOfWeekDiscountPromotionMutation.BlackoutDate> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("travelDateFrom", "travelDateTo");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.BlackoutDate fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      LocalDate _travelDateFrom = null;
      LocalDate _travelDateTo = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _travelDateFrom = com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 1: _travelDateTo = com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_travelDateFrom, "travelDateFrom");
      Assertions.checkFieldNotMissing(_travelDateTo, "travelDateTo");

      return new CreateDayOfWeekDiscountPromotionMutation.BlackoutDate(
        _travelDateFrom,
        _travelDateTo
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.BlackoutDate value) throws IOException {
      writer.name("travelDateFrom");
      com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateFrom);

      writer.name("travelDateTo");
      com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateTo);
    }
  }

  public enum Discount implements Adapter<CreateDayOfWeekDiscountPromotionMutation.Discount> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename", "type", "unit");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.Discount fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String __typename = null;
      DiscountType _type = null;
      DiscountUnit _unit = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: __typename = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = DiscountType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _unit = DiscountUnit_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(__typename, "__typename");
      CreateDayOfWeekDiscountPromotionMutation.OnDayOfWeekDiscount _onDayOfWeekDiscount = null;
      if (BooleanExpressions.evaluate(new BooleanExpression.Element<BTerm>(new BPossibleTypes("DayOfWeekDiscount")), customScalarAdapters.getAdapterContext().variables(), __typename, customScalarAdapters.getAdapterContext(), null)) {
        reader.rewind();
        _onDayOfWeekDiscount = com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateDayOfWeekDiscountPromotionMutation_ResponseAdapter.OnDayOfWeekDiscount.INSTANCE.fromJson(reader, customScalarAdapters);
      }

      Assertions.checkFieldNotMissing(_type, "type");
      Assertions.checkFieldNotMissing(_unit, "unit");

      return new CreateDayOfWeekDiscountPromotionMutation.Discount(
        __typename,
        _type,
        _unit,
        _onDayOfWeekDiscount
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.Discount value) throws IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      writer.name("type");
      DiscountType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);

      writer.name("unit");
      DiscountUnit_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.unit);

      if (value.onDayOfWeekDiscount != null) {
        com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.CreateDayOfWeekDiscountPromotionMutation_ResponseAdapter.OnDayOfWeekDiscount.INSTANCE.toJson(writer, customScalarAdapters, value.onDayOfWeekDiscount);
      }
    }
  }

  public enum OnDayOfWeekDiscount implements Adapter<CreateDayOfWeekDiscountPromotionMutation.OnDayOfWeekDiscount> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("type", "unit", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday");

    @Override
    public CreateDayOfWeekDiscountPromotionMutation.OnDayOfWeekDiscount fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      DiscountType _type = null;
      DiscountUnit _unit = null;
      Double _monday = null;
      Double _tuesday = null;
      Double _wednesday = null;
      Double _thursday = null;
      Double _friday = null;
      Double _saturday = null;
      Double _sunday = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _type = DiscountType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 1: _unit = DiscountUnit_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _monday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _tuesday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _wednesday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _thursday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _friday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 7: _saturday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 8: _sunday = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_type, "type");
      Assertions.checkFieldNotMissing(_unit, "unit");
      Assertions.checkFieldNotMissing(_monday, "monday");
      Assertions.checkFieldNotMissing(_tuesday, "tuesday");
      Assertions.checkFieldNotMissing(_wednesday, "wednesday");
      Assertions.checkFieldNotMissing(_thursday, "thursday");
      Assertions.checkFieldNotMissing(_friday, "friday");
      Assertions.checkFieldNotMissing(_saturday, "saturday");
      Assertions.checkFieldNotMissing(_sunday, "sunday");

      return new CreateDayOfWeekDiscountPromotionMutation.OnDayOfWeekDiscount(
        _type,
        _unit,
        _monday,
        _tuesday,
        _wednesday,
        _thursday,
        _friday,
        _saturday,
        _sunday
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        CreateDayOfWeekDiscountPromotionMutation.OnDayOfWeekDiscount value) throws IOException {
      writer.name("type");
      DiscountType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);

      writer.name("unit");
      DiscountUnit_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.unit);

      writer.name("monday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.monday);

      writer.name("tuesday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.tuesday);

      writer.name("wednesday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.wednesday);

      writer.name("thursday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.thursday);

      writer.name("friday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.friday);

      writer.name("saturday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.saturday);

      writer.name("sunday");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.sunday);
    }
  }
}
