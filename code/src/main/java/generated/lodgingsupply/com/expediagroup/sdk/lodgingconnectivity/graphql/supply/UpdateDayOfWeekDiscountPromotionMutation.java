//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateDayOfWeekDiscountPromotionMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateDayOfWeekDiscountPromotionMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.UpdateDayOfWeekDiscountPromotionMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DayOfWeekDiscountPromotionUpdateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionName;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionSellStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionStatus;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UpdateDayOfWeekDiscountPromotionMutation implements Mutation<UpdateDayOfWeekDiscountPromotionMutation.Data> {
  public static final String OPERATION_ID = "cfc429fb1e6855fe18189d14baa3c36af5e718407bde29c7f324244e8dee722b";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation UpdateDayOfWeekDiscountPromotion($promotion: DayOfWeekDiscountPromotionUpdateInput!, $propertyId: String!, $propertyIdSource: IdSource!) {
   *   updateDayOfWeekDiscountPromotion(promotion: $promotion, propertyId: $propertyId, propertyIdSource: $propertyIdSource) {
   *     __typename
   *     category
   *     id
   *     isContractedPromotion
   *     name
   *     sellStatus
   *     status
   *     ... on DiscountPromotion {
   *       id
   *       name
   *       category
   *       status
   *       code
   *       restrictions {
   *         isMemberOnly
   *         isMobileUserOnly
   *         minLengthOfStay
   *         maxLengthOfStay
   *         minAdvanceBookingDays
   *         maxAdvanceBookingDays
   *         bookingLocalDateTimeFrom
   *         bookingLocalDateTimeTo
   *         travelDateFrom
   *         travelDateTo
   *         sameDayBookingStartTime
   *       }
   *       eligibleRatePlans {
   *         id
   *       }
   *       blackoutDates {
   *         travelDateFrom
   *         travelDateTo
   *       }
   *       discount {
   *         __typename
   *         ... on DayOfWeekDiscount {
   *           type
   *           unit
   *           monday
   *           tuesday
   *           wednesday
   *           thursday
   *           friday
   *           saturday
   *           sunday
   *         }
   *       }
   *       sellStatus
   *       isContractedPromotion
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation UpdateDayOfWeekDiscountPromotion($promotion: DayOfWeekDiscountPromotionUpdateInput!, $propertyId: String!, $propertyIdSource: IdSource!) { updateDayOfWeekDiscountPromotion(promotion: $promotion, propertyId: $propertyId, propertyIdSource: $propertyIdSource) { __typename category id isContractedPromotion name sellStatus status ... on DiscountPromotion { id name category status code restrictions { isMemberOnly isMobileUserOnly minLengthOfStay maxLengthOfStay minAdvanceBookingDays maxAdvanceBookingDays bookingLocalDateTimeFrom bookingLocalDateTimeTo travelDateFrom travelDateTo sameDayBookingStartTime } eligibleRatePlans { id } blackoutDates { travelDateFrom travelDateTo } discount { __typename ... on DayOfWeekDiscount { type unit monday tuesday wednesday thursday friday saturday sunday } } sellStatus isContractedPromotion } } }";

  public static final String OPERATION_NAME = "UpdateDayOfWeekDiscountPromotion";

  public final DayOfWeekDiscountPromotionUpdateInput promotion;

  public final String propertyId;

  public final IdSource propertyIdSource;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateDayOfWeekDiscountPromotionMutation(DayOfWeekDiscountPromotionUpdateInput promotion,
      String propertyId, IdSource propertyIdSource) {
    this.promotion = promotion;
    this.propertyId = propertyId;
    this.propertyIdSource = propertyIdSource;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateDayOfWeekDiscountPromotionMutation) {
      UpdateDayOfWeekDiscountPromotionMutation that = (UpdateDayOfWeekDiscountPromotionMutation) o;
      return ((this.promotion == null) ? (that.promotion == null) : this.promotion.equals(that.promotion))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.propertyIdSource == null) ? (that.propertyIdSource == null) : this.propertyIdSource.equals(that.propertyIdSource));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (promotion == null) ? 0 : promotion.hashCode();
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (propertyIdSource == null) ? 0 : propertyIdSource.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdateDayOfWeekDiscountPromotionMutation{"
        + "promotion=" + promotion + ", "
        + "propertyId=" + propertyId + ", "
        + "propertyIdSource=" + propertyIdSource
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
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      boolean withDefaultValues) throws IOException {
    UpdateDayOfWeekDiscountPromotionMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(UpdateDayOfWeekDiscountPromotionMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(UpdateDayOfWeekDiscountPromotionMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private DayOfWeekDiscountPromotionUpdateInput promotion;

    private String propertyId;

    private IdSource propertyIdSource;

    Builder() {
    }

    public Builder promotion(DayOfWeekDiscountPromotionUpdateInput promotion) {
      this.promotion = promotion;
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder propertyIdSource(IdSource propertyIdSource) {
      this.propertyIdSource = propertyIdSource;
      return this;
    }

    public UpdateDayOfWeekDiscountPromotionMutation build() {
      return new UpdateDayOfWeekDiscountPromotionMutation(promotion, propertyId, propertyIdSource);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Update day of week discount promotion
     */
    public UpdateDayOfWeekDiscountPromotion updateDayOfWeekDiscountPromotion;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(UpdateDayOfWeekDiscountPromotion updateDayOfWeekDiscountPromotion) {
      this.updateDayOfWeekDiscountPromotion = updateDayOfWeekDiscountPromotion;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateDayOfWeekDiscountPromotion == null) ? (that.updateDayOfWeekDiscountPromotion == null) : this.updateDayOfWeekDiscountPromotion.equals(that.updateDayOfWeekDiscountPromotion));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (updateDayOfWeekDiscountPromotion == null) ? 0 : updateDayOfWeekDiscountPromotion.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateDayOfWeekDiscountPromotion=" + updateDayOfWeekDiscountPromotion
          + "}";
      }
      return $toString;
    }
  }

  public static class UpdateDayOfWeekDiscountPromotion {
    public String __typename;

    /**
     * Category of the promotion. Currently only DISCOUNT_PROMOTION is supported (i.e Priced Promotions).
     */
    public PromotionCategory category;

    /**
     * Id of the Promotion as stored in the Expedia platform.
     */
    public String id;

    /**
     * It indicates if the promotion is negotiated.
     */
    public Boolean isContractedPromotion;

    /**
     * Name of the promotion. Values: BASIC, EARLY_BOOKING_PROMOTION or SAME_DAY_PROMOTION.
     */
    public PromotionName name;

    /**
     * Sell status of the promotion. Values: EXPIRED, CURRENT or FUTURE. For retrieval only.
     */
    public PromotionSellStatus sellStatus;

    /**
     * Status of the promotion. Values: ACTIVE or INACTIVE.
     */
    public PromotionStatus status;

    /**
     * Synthetic field for inline fragment on DiscountPromotion
     */
    public OnDiscountPromotion onDiscountPromotion;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UpdateDayOfWeekDiscountPromotion(String __typename, PromotionCategory category,
        String id, Boolean isContractedPromotion, PromotionName name,
        PromotionSellStatus sellStatus, PromotionStatus status,
        OnDiscountPromotion onDiscountPromotion) {
      this.__typename = __typename;
      this.category = category;
      this.id = id;
      this.isContractedPromotion = isContractedPromotion;
      this.name = name;
      this.sellStatus = sellStatus;
      this.status = status;
      this.onDiscountPromotion = onDiscountPromotion;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateDayOfWeekDiscountPromotion) {
        UpdateDayOfWeekDiscountPromotion that = (UpdateDayOfWeekDiscountPromotion) o;
        return ((this.__typename == null) ? (that.__typename == null) : this.__typename.equals(that.__typename))
         &&((this.category == null) ? (that.category == null) : this.category.equals(that.category))
         &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.isContractedPromotion == null) ? (that.isContractedPromotion == null) : this.isContractedPromotion.equals(that.isContractedPromotion))
         &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         &&((this.sellStatus == null) ? (that.sellStatus == null) : this.sellStatus.equals(that.sellStatus))
         &&((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         &&((this.onDiscountPromotion == null) ? (that.onDiscountPromotion == null) : this.onDiscountPromotion.equals(that.onDiscountPromotion));
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
        __h ^= (category == null) ? 0 : category.hashCode();
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (isContractedPromotion == null) ? 0 : isContractedPromotion.hashCode();
        __h *= 1000003;
        __h ^= (name == null) ? 0 : name.hashCode();
        __h *= 1000003;
        __h ^= (sellStatus == null) ? 0 : sellStatus.hashCode();
        __h *= 1000003;
        __h ^= (status == null) ? 0 : status.hashCode();
        __h *= 1000003;
        __h ^= (onDiscountPromotion == null) ? 0 : onDiscountPromotion.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateDayOfWeekDiscountPromotion{"
          + "__typename=" + __typename + ", "
          + "category=" + category + ", "
          + "id=" + id + ", "
          + "isContractedPromotion=" + isContractedPromotion + ", "
          + "name=" + name + ", "
          + "sellStatus=" + sellStatus + ", "
          + "status=" + status + ", "
          + "onDiscountPromotion=" + onDiscountPromotion
          + "}";
      }
      return $toString;
    }
  }

  public static class OnDiscountPromotion {
    /**
     * Id of the Promotion as stored in the Expedia platform.
     */
    public String id;

    /**
     * Name of the promotion. Values: BASIC, EARLY_BOOKING_PROMOTION or SAME_DAY_PROMOTION.
     */
    public PromotionName name;

    /**
     * Category of the promotion. Currently only DISCOUNT_PROMOTION is supported (i.e Priced Promotions).
     */
    public PromotionCategory category;

    /**
     * Status of the promotion. Values: ACTIVE or INACTIVE.
     */
    public PromotionStatus status;

    /**
     * Name of the promotion as the partner wants to call it.
     */
    public String code;

    /**
     * List of restrictions that can be applied to these promotions.
     */
    public Restrictions restrictions;

    /**
     * The rate plans for which this promotion is applicable for.
     */
    public List<EligibleRatePlan> eligibleRatePlans;

    /**
     * The 'exception' dates for which the promotion should NOT apply.
     * This field will not be returned in the Query All promotions functionality and will ONLY be returned when querying for a Single Promotion (by specifying the promotion Id).
     */
    public List<BlackoutDate> blackoutDates;

    /**
     * Detail of the actual discount being applied on the promotion.
     */
    public Discount discount;

    /**
     * Sell status of the promotion. Values: EXPIRED, CURRENT or FUTURE. For retrieval only.
     */
    public PromotionSellStatus sellStatus;

    /**
     * It indicates if the promotion is negotiated.
     */
    public Boolean isContractedPromotion;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public OnDiscountPromotion(String id, PromotionName name, PromotionCategory category,
        PromotionStatus status, String code, Restrictions restrictions,
        List<EligibleRatePlan> eligibleRatePlans, List<BlackoutDate> blackoutDates,
        Discount discount, PromotionSellStatus sellStatus, Boolean isContractedPromotion) {
      this.id = id;
      this.name = name;
      this.category = category;
      this.status = status;
      this.code = code;
      this.restrictions = restrictions;
      this.eligibleRatePlans = eligibleRatePlans;
      this.blackoutDates = blackoutDates;
      this.discount = discount;
      this.sellStatus = sellStatus;
      this.isContractedPromotion = isContractedPromotion;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OnDiscountPromotion) {
        OnDiscountPromotion that = (OnDiscountPromotion) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         &&((this.category == null) ? (that.category == null) : this.category.equals(that.category))
         &&((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         &&((this.code == null) ? (that.code == null) : this.code.equals(that.code))
         &&((this.restrictions == null) ? (that.restrictions == null) : this.restrictions.equals(that.restrictions))
         &&((this.eligibleRatePlans == null) ? (that.eligibleRatePlans == null) : this.eligibleRatePlans.equals(that.eligibleRatePlans))
         &&((this.blackoutDates == null) ? (that.blackoutDates == null) : this.blackoutDates.equals(that.blackoutDates))
         &&((this.discount == null) ? (that.discount == null) : this.discount.equals(that.discount))
         &&((this.sellStatus == null) ? (that.sellStatus == null) : this.sellStatus.equals(that.sellStatus))
         &&((this.isContractedPromotion == null) ? (that.isContractedPromotion == null) : this.isContractedPromotion.equals(that.isContractedPromotion));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (name == null) ? 0 : name.hashCode();
        __h *= 1000003;
        __h ^= (category == null) ? 0 : category.hashCode();
        __h *= 1000003;
        __h ^= (status == null) ? 0 : status.hashCode();
        __h *= 1000003;
        __h ^= (code == null) ? 0 : code.hashCode();
        __h *= 1000003;
        __h ^= (restrictions == null) ? 0 : restrictions.hashCode();
        __h *= 1000003;
        __h ^= (eligibleRatePlans == null) ? 0 : eligibleRatePlans.hashCode();
        __h *= 1000003;
        __h ^= (blackoutDates == null) ? 0 : blackoutDates.hashCode();
        __h *= 1000003;
        __h ^= (discount == null) ? 0 : discount.hashCode();
        __h *= 1000003;
        __h ^= (sellStatus == null) ? 0 : sellStatus.hashCode();
        __h *= 1000003;
        __h ^= (isContractedPromotion == null) ? 0 : isContractedPromotion.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OnDiscountPromotion{"
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "category=" + category + ", "
          + "status=" + status + ", "
          + "code=" + code + ", "
          + "restrictions=" + restrictions + ", "
          + "eligibleRatePlans=" + eligibleRatePlans + ", "
          + "blackoutDates=" + blackoutDates + ", "
          + "discount=" + discount + ", "
          + "sellStatus=" + sellStatus + ", "
          + "isContractedPromotion=" + isContractedPromotion
          + "}";
      }
      return $toString;
    }
  }

  public static class Restrictions {
    /**
     * Setting this to true indicates that the promotion is targeted exclusively towards Expedia Group members whose loyalty drives bookings.
     */
    public Boolean isMemberOnly;

    /**
     * It indicates if this promotion is applicable only for travelers booking on the mobile device.
     * This field will be null in the Query All promotions functionality and will ONLY be returned when querying for a Single Promotion (by specifying the promotion Id).
     */
    public Boolean isMobileUserOnly;

    /**
     * The minimum duration of stay for which the promotion can be applicable.
     */
    public Integer minLengthOfStay;

    /**
     * The maximum duration of stay for which the promotion can be applicable. The maximum value possible here is 28.
     */
    public Integer maxLengthOfStay;

    /**
     * The minimum number of days in advance the reservation must be made for the promotion to be applicable.
     */
    public Integer minAdvanceBookingDays;

    /**
     * The maximum number of days in advance the reservation must be made for the promotion to be applicable.
     */
    public Integer maxAdvanceBookingDays;

    /**
     * The Booking Date Time from which this promotion is applicable.
     * YYYY-MM-DDThh:mm:ss . Timezone is the time with respect to the property location.
     */
    public LocalDateTime bookingLocalDateTimeFrom;

    /**
     * The Booking Date Time until which this promotion is applicable.
     * YYYY-MM-DDThh:mm:ss . Timezone is the time with respect to the property location.
     */
    public LocalDateTime bookingLocalDateTimeTo;

    /**
     * The Travel date from which this promotion is applicable in YYYY-MM-DD format.
     */
    public LocalDate travelDateFrom;

    /**
     * The Travel date until which this promotion is applicable in YYYY-MM-DD format.
     */
    public LocalDate travelDateTo;

    /**
     * Applicable only for SAME_DAY_PROMOTION. The start time for the same day from which the promotion is applicable.
     * The timezone in consideration will be the local time for the property the promotion is applied for.
     */
    public Object sameDayBookingStartTime;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Restrictions(Boolean isMemberOnly, Boolean isMobileUserOnly, Integer minLengthOfStay,
        Integer maxLengthOfStay, Integer minAdvanceBookingDays, Integer maxAdvanceBookingDays,
        LocalDateTime bookingLocalDateTimeFrom, LocalDateTime bookingLocalDateTimeTo,
        LocalDate travelDateFrom, LocalDate travelDateTo, Object sameDayBookingStartTime) {
      this.isMemberOnly = isMemberOnly;
      this.isMobileUserOnly = isMobileUserOnly;
      this.minLengthOfStay = minLengthOfStay;
      this.maxLengthOfStay = maxLengthOfStay;
      this.minAdvanceBookingDays = minAdvanceBookingDays;
      this.maxAdvanceBookingDays = maxAdvanceBookingDays;
      this.bookingLocalDateTimeFrom = bookingLocalDateTimeFrom;
      this.bookingLocalDateTimeTo = bookingLocalDateTimeTo;
      this.travelDateFrom = travelDateFrom;
      this.travelDateTo = travelDateTo;
      this.sameDayBookingStartTime = sameDayBookingStartTime;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Restrictions) {
        Restrictions that = (Restrictions) o;
        return ((this.isMemberOnly == null) ? (that.isMemberOnly == null) : this.isMemberOnly.equals(that.isMemberOnly))
         &&((this.isMobileUserOnly == null) ? (that.isMobileUserOnly == null) : this.isMobileUserOnly.equals(that.isMobileUserOnly))
         &&((this.minLengthOfStay == null) ? (that.minLengthOfStay == null) : this.minLengthOfStay.equals(that.minLengthOfStay))
         &&((this.maxLengthOfStay == null) ? (that.maxLengthOfStay == null) : this.maxLengthOfStay.equals(that.maxLengthOfStay))
         &&((this.minAdvanceBookingDays == null) ? (that.minAdvanceBookingDays == null) : this.minAdvanceBookingDays.equals(that.minAdvanceBookingDays))
         &&((this.maxAdvanceBookingDays == null) ? (that.maxAdvanceBookingDays == null) : this.maxAdvanceBookingDays.equals(that.maxAdvanceBookingDays))
         &&((this.bookingLocalDateTimeFrom == null) ? (that.bookingLocalDateTimeFrom == null) : this.bookingLocalDateTimeFrom.equals(that.bookingLocalDateTimeFrom))
         &&((this.bookingLocalDateTimeTo == null) ? (that.bookingLocalDateTimeTo == null) : this.bookingLocalDateTimeTo.equals(that.bookingLocalDateTimeTo))
         &&((this.travelDateFrom == null) ? (that.travelDateFrom == null) : this.travelDateFrom.equals(that.travelDateFrom))
         &&((this.travelDateTo == null) ? (that.travelDateTo == null) : this.travelDateTo.equals(that.travelDateTo))
         &&((this.sameDayBookingStartTime == null) ? (that.sameDayBookingStartTime == null) : this.sameDayBookingStartTime.equals(that.sameDayBookingStartTime));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (isMemberOnly == null) ? 0 : isMemberOnly.hashCode();
        __h *= 1000003;
        __h ^= (isMobileUserOnly == null) ? 0 : isMobileUserOnly.hashCode();
        __h *= 1000003;
        __h ^= (minLengthOfStay == null) ? 0 : minLengthOfStay.hashCode();
        __h *= 1000003;
        __h ^= (maxLengthOfStay == null) ? 0 : maxLengthOfStay.hashCode();
        __h *= 1000003;
        __h ^= (minAdvanceBookingDays == null) ? 0 : minAdvanceBookingDays.hashCode();
        __h *= 1000003;
        __h ^= (maxAdvanceBookingDays == null) ? 0 : maxAdvanceBookingDays.hashCode();
        __h *= 1000003;
        __h ^= (bookingLocalDateTimeFrom == null) ? 0 : bookingLocalDateTimeFrom.hashCode();
        __h *= 1000003;
        __h ^= (bookingLocalDateTimeTo == null) ? 0 : bookingLocalDateTimeTo.hashCode();
        __h *= 1000003;
        __h ^= (travelDateFrom == null) ? 0 : travelDateFrom.hashCode();
        __h *= 1000003;
        __h ^= (travelDateTo == null) ? 0 : travelDateTo.hashCode();
        __h *= 1000003;
        __h ^= (sameDayBookingStartTime == null) ? 0 : sameDayBookingStartTime.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Restrictions{"
          + "isMemberOnly=" + isMemberOnly + ", "
          + "isMobileUserOnly=" + isMobileUserOnly + ", "
          + "minLengthOfStay=" + minLengthOfStay + ", "
          + "maxLengthOfStay=" + maxLengthOfStay + ", "
          + "minAdvanceBookingDays=" + minAdvanceBookingDays + ", "
          + "maxAdvanceBookingDays=" + maxAdvanceBookingDays + ", "
          + "bookingLocalDateTimeFrom=" + bookingLocalDateTimeFrom + ", "
          + "bookingLocalDateTimeTo=" + bookingLocalDateTimeTo + ", "
          + "travelDateFrom=" + travelDateFrom + ", "
          + "travelDateTo=" + travelDateTo + ", "
          + "sameDayBookingStartTime=" + sameDayBookingStartTime
          + "}";
      }
      return $toString;
    }
  }

  public static class EligibleRatePlan {
    /**
     * Id of the rate plan as stored in the Expedia platform.
     */
    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public EligibleRatePlan(String id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof EligibleRatePlan) {
        EligibleRatePlan that = (EligibleRatePlan) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "EligibleRatePlan{"
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }

  public static class BlackoutDate {
    /**
     * The travel start date for the exception window.
     */
    public LocalDate travelDateFrom;

    /**
     * The travel end date for the exception window.
     */
    public LocalDate travelDateTo;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public BlackoutDate(LocalDate travelDateFrom, LocalDate travelDateTo) {
      this.travelDateFrom = travelDateFrom;
      this.travelDateTo = travelDateTo;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof BlackoutDate) {
        BlackoutDate that = (BlackoutDate) o;
        return ((this.travelDateFrom == null) ? (that.travelDateFrom == null) : this.travelDateFrom.equals(that.travelDateFrom))
         &&((this.travelDateTo == null) ? (that.travelDateTo == null) : this.travelDateTo.equals(that.travelDateTo));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (travelDateFrom == null) ? 0 : travelDateFrom.hashCode();
        __h *= 1000003;
        __h ^= (travelDateTo == null) ? 0 : travelDateTo.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "BlackoutDate{"
          + "travelDateFrom=" + travelDateFrom + ", "
          + "travelDateTo=" + travelDateTo
          + "}";
      }
      return $toString;
    }
  }

  public static class Discount {
    public String __typename;

    /**
     * Synthetic field for inline fragment on DayOfWeekDiscount
     */
    public OnDayOfWeekDiscount onDayOfWeekDiscount;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Discount(String __typename, OnDayOfWeekDiscount onDayOfWeekDiscount) {
      this.__typename = __typename;
      this.onDayOfWeekDiscount = onDayOfWeekDiscount;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Discount) {
        Discount that = (Discount) o;
        return ((this.__typename == null) ? (that.__typename == null) : this.__typename.equals(that.__typename))
         &&((this.onDayOfWeekDiscount == null) ? (that.onDayOfWeekDiscount == null) : this.onDayOfWeekDiscount.equals(that.onDayOfWeekDiscount));
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
        __h ^= (onDayOfWeekDiscount == null) ? 0 : onDayOfWeekDiscount.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Discount{"
          + "__typename=" + __typename + ", "
          + "onDayOfWeekDiscount=" + onDayOfWeekDiscount
          + "}";
      }
      return $toString;
    }
  }

  public static class OnDayOfWeekDiscount {
    /**
     * Type of the discount.
     */
    public DiscountType type;

    /**
     * Unit of the discount. Currently only PERCENT is supported for MVP for Create and Update. AMOUNT promotions are supported only for Read.
     */
    public DiscountUnit unit;

    public Double monday;

    public Double tuesday;

    public Double wednesday;

    public Double thursday;

    public Double friday;

    public Double saturday;

    public Double sunday;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public OnDayOfWeekDiscount(DiscountType type, DiscountUnit unit, Double monday, Double tuesday,
        Double wednesday, Double thursday, Double friday, Double saturday, Double sunday) {
      this.type = type;
      this.unit = unit;
      this.monday = monday;
      this.tuesday = tuesday;
      this.wednesday = wednesday;
      this.thursday = thursday;
      this.friday = friday;
      this.saturday = saturday;
      this.sunday = sunday;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OnDayOfWeekDiscount) {
        OnDayOfWeekDiscount that = (OnDayOfWeekDiscount) o;
        return ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         &&((this.unit == null) ? (that.unit == null) : this.unit.equals(that.unit))
         &&((this.monday == null) ? (that.monday == null) : this.monday.equals(that.monday))
         &&((this.tuesday == null) ? (that.tuesday == null) : this.tuesday.equals(that.tuesday))
         &&((this.wednesday == null) ? (that.wednesday == null) : this.wednesday.equals(that.wednesday))
         &&((this.thursday == null) ? (that.thursday == null) : this.thursday.equals(that.thursday))
         &&((this.friday == null) ? (that.friday == null) : this.friday.equals(that.friday))
         &&((this.saturday == null) ? (that.saturday == null) : this.saturday.equals(that.saturday))
         &&((this.sunday == null) ? (that.sunday == null) : this.sunday.equals(that.sunday));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        __h *= 1000003;
        __h ^= (unit == null) ? 0 : unit.hashCode();
        __h *= 1000003;
        __h ^= (monday == null) ? 0 : monday.hashCode();
        __h *= 1000003;
        __h ^= (tuesday == null) ? 0 : tuesday.hashCode();
        __h *= 1000003;
        __h ^= (wednesday == null) ? 0 : wednesday.hashCode();
        __h *= 1000003;
        __h ^= (thursday == null) ? 0 : thursday.hashCode();
        __h *= 1000003;
        __h ^= (friday == null) ? 0 : friday.hashCode();
        __h *= 1000003;
        __h ^= (saturday == null) ? 0 : saturday.hashCode();
        __h *= 1000003;
        __h ^= (sunday == null) ? 0 : sunday.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OnDayOfWeekDiscount{"
          + "type=" + type + ", "
          + "unit=" + unit + ", "
          + "monday=" + monday + ", "
          + "tuesday=" + tuesday + ", "
          + "wednesday=" + wednesday + ", "
          + "thursday=" + thursday + ", "
          + "friday=" + friday + ", "
          + "saturday=" + saturday + ", "
          + "sunday=" + sunday
          + "}";
      }
      return $toString;
    }
  }
}
