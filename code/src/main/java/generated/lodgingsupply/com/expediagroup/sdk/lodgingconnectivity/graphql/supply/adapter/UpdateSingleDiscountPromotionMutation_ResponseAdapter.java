//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.BPossibleTypes;
import com.apollographql.apollo.api.BTerm;
import com.apollographql.apollo.api.BooleanExpression;
import com.apollographql.apollo.api.BooleanExpressions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UpdateSingleDiscountPromotionMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionName;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionSellStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DiscountType_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DiscountUnit_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionCategory_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionName_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionSellStatus_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PromotionStatus_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UpdateSingleDiscountPromotionMutation_ResponseAdapter {
  public enum Data implements Adapter<UpdateSingleDiscountPromotionMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("updateSingleDiscountPromotion");

    @Override
    public UpdateSingleDiscountPromotionMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion _updateSingleDiscountPromotion = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _updateSingleDiscountPromotion = new ObjectAdapter<UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion>(UpdateSingleDiscountPromotion.INSTANCE, true).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_updateSingleDiscountPromotion, "updateSingleDiscountPromotion");

      return new UpdateSingleDiscountPromotionMutation.Data(
        _updateSingleDiscountPromotion
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.Data value) throws IOException {
      writer.name("updateSingleDiscountPromotion");
      new ObjectAdapter<UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion>(UpdateSingleDiscountPromotion.INSTANCE, true).toJson(writer, customScalarAdapters, value.updateSingleDiscountPromotion);
    }
  }

  public enum UpdateSingleDiscountPromotion implements Adapter<UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename", "category", "id", "isContractedPromotion", "name", "sellStatus", "status");

    @Override
    public UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion fromJson(
        JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
      String __typename = null;
      PromotionCategory _category = null;
      String _id = null;
      Optional<Boolean> _isContractedPromotion = null;
      PromotionName _name = null;
      Optional<PromotionSellStatus> _sellStatus = null;
      PromotionStatus _status = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: __typename = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _category = PromotionCategory_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _isContractedPromotion = OptionalAdapters.OptionalBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _name = PromotionName_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 5: _sellStatus = new OptionalAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 6: _status = PromotionStatus_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(__typename, "__typename");
      Optional<UpdateSingleDiscountPromotionMutation.OnDiscountPromotion> _onDiscountPromotion = Optional.empty();
      if (BooleanExpressions.evaluate(new BooleanExpression.Element<BTerm>(new BPossibleTypes("DiscountPromotion")), customScalarAdapters.falseVariables, __typename, customScalarAdapters.deferredFragmentIdentifiers, null)) {
        reader.rewind();
        _onDiscountPromotion = Optional.of(com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateSingleDiscountPromotionMutation_ResponseAdapter.OnDiscountPromotion.INSTANCE.fromJson(reader, customScalarAdapters));
      }

      Assertions.checkFieldNotMissing(_category, "category");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_status, "status");

      return new UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion(
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
        UpdateSingleDiscountPromotionMutation.UpdateSingleDiscountPromotion value) throws
        IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      writer.name("category");
      PromotionCategory_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.category);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("isContractedPromotion");
      OptionalAdapters.OptionalBooleanAdapter.toJson(writer, customScalarAdapters, value.isContractedPromotion);

      writer.name("name");
      PromotionName_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.name);

      writer.name("sellStatus");
      new OptionalAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.sellStatus);

      writer.name("status");
      PromotionStatus_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.status);

      if (value.onDiscountPromotion.isPresent()) {
        com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateSingleDiscountPromotionMutation_ResponseAdapter.OnDiscountPromotion.INSTANCE.toJson(writer, customScalarAdapters, value.onDiscountPromotion.get());
      }
    }
  }

  public enum OnDiscountPromotion implements Adapter<UpdateSingleDiscountPromotionMutation.OnDiscountPromotion> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "category", "status", "code", "restrictions", "blackoutDates", "discount", "sellStatus", "isContractedPromotion", "eligibleRatePlans");

    @Override
    public UpdateSingleDiscountPromotionMutation.OnDiscountPromotion fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      PromotionName _name = null;
      PromotionCategory _category = null;
      PromotionStatus _status = null;
      String _code = null;
      Optional<UpdateSingleDiscountPromotionMutation.Restrictions> _restrictions = null;
      Optional<List<UpdateSingleDiscountPromotionMutation.BlackoutDate>> _blackoutDates = null;
      Optional<UpdateSingleDiscountPromotionMutation.Discount> _discount = null;
      Optional<PromotionSellStatus> _sellStatus = null;
      Optional<Boolean> _isContractedPromotion = null;
      List<UpdateSingleDiscountPromotionMutation.EligibleRatePlan> _eligibleRatePlans = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = PromotionName_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _category = PromotionCategory_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 3: _status = PromotionStatus_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 4: _code = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _restrictions = new OptionalAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.Restrictions>(Restrictions.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 6: _blackoutDates = new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.BlackoutDate>(BlackoutDate.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 7: _discount = new OptionalAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.Discount>(Discount.INSTANCE, true)).fromJson(reader, customScalarAdapters); break;
          case 8: _sellStatus = new OptionalAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 9: _isContractedPromotion = OptionalAdapters.OptionalBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 10: _eligibleRatePlans = new ListAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.EligibleRatePlan>(EligibleRatePlan.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_category, "category");
      Assertions.checkFieldNotMissing(_status, "status");
      Assertions.checkFieldNotMissing(_code, "code");
      Assertions.checkFieldNotMissing(_eligibleRatePlans, "eligibleRatePlans");

      return new UpdateSingleDiscountPromotionMutation.OnDiscountPromotion(
        _id,
        _name,
        _category,
        _status,
        _code,
        _restrictions,
        _blackoutDates,
        _discount,
        _sellStatus,
        _isContractedPromotion,
        _eligibleRatePlans
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.OnDiscountPromotion value) throws IOException {
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
      new OptionalAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.Restrictions>(Restrictions.INSTANCE, false)).toJson(writer, customScalarAdapters, value.restrictions);

      writer.name("blackoutDates");
      new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.BlackoutDate>(BlackoutDate.INSTANCE, false))).toJson(writer, customScalarAdapters, value.blackoutDates);

      writer.name("discount");
      new OptionalAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.Discount>(Discount.INSTANCE, true)).toJson(writer, customScalarAdapters, value.discount);

      writer.name("sellStatus");
      new OptionalAdapter<>(PromotionSellStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.sellStatus);

      writer.name("isContractedPromotion");
      OptionalAdapters.OptionalBooleanAdapter.toJson(writer, customScalarAdapters, value.isContractedPromotion);

      writer.name("eligibleRatePlans");
      new ListAdapter<>(new ObjectAdapter<UpdateSingleDiscountPromotionMutation.EligibleRatePlan>(EligibleRatePlan.INSTANCE, false)).toJson(writer, customScalarAdapters, value.eligibleRatePlans);
    }
  }

  public enum Restrictions implements Adapter<UpdateSingleDiscountPromotionMutation.Restrictions> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("isMemberOnly", "isMobileUserOnly", "minLengthOfStay", "maxLengthOfStay", "minAdvanceBookingDays", "maxAdvanceBookingDays", "bookingLocalDateTimeFrom", "bookingLocalDateTimeTo", "travelDateFrom", "travelDateTo", "sameDayBookingStartTime");

    @Override
    public UpdateSingleDiscountPromotionMutation.Restrictions fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<Boolean> _isMemberOnly = null;
      Optional<Boolean> _isMobileUserOnly = null;
      Optional<Integer> _minLengthOfStay = null;
      Optional<Integer> _maxLengthOfStay = null;
      Optional<Integer> _minAdvanceBookingDays = null;
      Optional<Integer> _maxAdvanceBookingDays = null;
      Optional<LocalDateTime> _bookingLocalDateTimeFrom = null;
      Optional<LocalDateTime> _bookingLocalDateTimeTo = null;
      Optional<LocalDate> _travelDateFrom = null;
      Optional<LocalDate> _travelDateTo = null;
      Optional<LocalTime> _sameDayBookingStartTime = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _isMemberOnly = OptionalAdapters.OptionalBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _isMobileUserOnly = OptionalAdapters.OptionalBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _minLengthOfStay = OptionalAdapters.OptionalIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _maxLengthOfStay = OptionalAdapters.OptionalIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _minAdvanceBookingDays = OptionalAdapters.OptionalIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _maxAdvanceBookingDays = OptionalAdapters.OptionalIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _bookingLocalDateTimeFrom = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 7: _bookingLocalDateTimeTo = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 8: _travelDateFrom = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 9: _travelDateTo = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 10: _sameDayBookingStartTime = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UpdateSingleDiscountPromotionMutation.Restrictions(
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
        UpdateSingleDiscountPromotionMutation.Restrictions value) throws IOException {
      writer.name("isMemberOnly");
      OptionalAdapters.OptionalBooleanAdapter.toJson(writer, customScalarAdapters, value.isMemberOnly);

      writer.name("isMobileUserOnly");
      OptionalAdapters.OptionalBooleanAdapter.toJson(writer, customScalarAdapters, value.isMobileUserOnly);

      writer.name("minLengthOfStay");
      OptionalAdapters.OptionalIntAdapter.toJson(writer, customScalarAdapters, value.minLengthOfStay);

      writer.name("maxLengthOfStay");
      OptionalAdapters.OptionalIntAdapter.toJson(writer, customScalarAdapters, value.maxLengthOfStay);

      writer.name("minAdvanceBookingDays");
      OptionalAdapters.OptionalIntAdapter.toJson(writer, customScalarAdapters, value.minAdvanceBookingDays);

      writer.name("maxAdvanceBookingDays");
      OptionalAdapters.OptionalIntAdapter.toJson(writer, customScalarAdapters, value.maxAdvanceBookingDays);

      writer.name("bookingLocalDateTimeFrom");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.bookingLocalDateTimeFrom);

      writer.name("bookingLocalDateTimeTo");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.bookingLocalDateTimeTo);

      writer.name("travelDateFrom");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.travelDateFrom);

      writer.name("travelDateTo");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.travelDateTo);

      writer.name("sameDayBookingStartTime");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.sameDayBookingStartTime);
    }
  }

  public enum BlackoutDate implements Adapter<UpdateSingleDiscountPromotionMutation.BlackoutDate> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("travelDateFrom", "travelDateTo");

    @Override
    public UpdateSingleDiscountPromotionMutation.BlackoutDate fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      LocalDate _travelDateFrom = null;
      LocalDate _travelDateTo = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _travelDateFrom = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 1: _travelDateTo = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_travelDateFrom, "travelDateFrom");
      Assertions.checkFieldNotMissing(_travelDateTo, "travelDateTo");

      return new UpdateSingleDiscountPromotionMutation.BlackoutDate(
        _travelDateFrom,
        _travelDateTo
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.BlackoutDate value) throws IOException {
      writer.name("travelDateFrom");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateFrom);

      writer.name("travelDateTo");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.travelDateTo);
    }
  }

  public enum Discount implements Adapter<UpdateSingleDiscountPromotionMutation.Discount> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("__typename");

    @Override
    public UpdateSingleDiscountPromotionMutation.Discount fromJson(JsonReader reader,
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
      Optional<UpdateSingleDiscountPromotionMutation.OnSingleDiscount> _onSingleDiscount = Optional.empty();
      if (BooleanExpressions.evaluate(new BooleanExpression.Element<BTerm>(new BPossibleTypes("SingleDiscount")), customScalarAdapters.falseVariables, __typename, customScalarAdapters.deferredFragmentIdentifiers, null)) {
        reader.rewind();
        _onSingleDiscount = Optional.of(com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateSingleDiscountPromotionMutation_ResponseAdapter.OnSingleDiscount.INSTANCE.fromJson(reader, customScalarAdapters));
      }

      return new UpdateSingleDiscountPromotionMutation.Discount(
        __typename,
        _onSingleDiscount
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.Discount value) throws IOException {
      writer.name("__typename");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.__typename);

      if (value.onSingleDiscount.isPresent()) {
        com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateSingleDiscountPromotionMutation_ResponseAdapter.OnSingleDiscount.INSTANCE.toJson(writer, customScalarAdapters, value.onSingleDiscount.get());
      }
    }
  }

  public enum OnSingleDiscount implements Adapter<UpdateSingleDiscountPromotionMutation.OnSingleDiscount> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("type", "unit", "value", "memberOnlyAdditionalValue");

    @Override
    public UpdateSingleDiscountPromotionMutation.OnSingleDiscount fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      DiscountType _type = null;
      DiscountUnit _unit = null;
      Double _value = null;
      Optional<Double> _memberOnlyAdditionalValue = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _type = DiscountType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 1: _unit = DiscountUnit_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 2: _value = Adapters.DoubleAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _memberOnlyAdditionalValue = OptionalAdapters.OptionalDoubleAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_type, "type");
      Assertions.checkFieldNotMissing(_unit, "unit");
      Assertions.checkFieldNotMissing(_value, "value");

      return new UpdateSingleDiscountPromotionMutation.OnSingleDiscount(
        _type,
        _unit,
        _value,
        _memberOnlyAdditionalValue
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.OnSingleDiscount value) throws IOException {
      writer.name("type");
      DiscountType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);

      writer.name("unit");
      DiscountUnit_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.unit);

      writer.name("value");
      Adapters.DoubleAdapter.toJson(writer, customScalarAdapters, value.value);

      writer.name("memberOnlyAdditionalValue");
      OptionalAdapters.OptionalDoubleAdapter.toJson(writer, customScalarAdapters, value.memberOnlyAdditionalValue);
    }
  }

  public enum EligibleRatePlan implements Adapter<UpdateSingleDiscountPromotionMutation.EligibleRatePlan> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public UpdateSingleDiscountPromotionMutation.EligibleRatePlan fromJson(JsonReader reader,
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

      return new UpdateSingleDiscountPromotionMutation.EligibleRatePlan(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateSingleDiscountPromotionMutation.EligibleRatePlan value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }
}
