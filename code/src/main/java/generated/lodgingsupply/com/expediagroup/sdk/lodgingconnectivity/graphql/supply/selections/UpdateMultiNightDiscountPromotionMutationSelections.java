//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo.api.CompiledArgument;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CompiledFragment;
import com.apollographql.apollo.api.CompiledListType;
import com.apollographql.apollo.api.CompiledNotNullType;
import com.apollographql.apollo.api.CompiledSelection;
import com.apollographql.apollo.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BlackoutDateRange;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Discount;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DiscountUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EligibleRatePlan;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLFloat;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Promotion;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionName;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionSellStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PromotionStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Restrictions;
import java.util.Arrays;
import java.util.List;

public class UpdateMultiNightDiscountPromotionMutationSelections {
  private static List<CompiledSelection> __restrictions = Arrays.asList(
    new CompiledField.Builder("isMemberOnly", GraphQLBoolean.type).build(),
    new CompiledField.Builder("isMobileUserOnly", GraphQLBoolean.type).build(),
    new CompiledField.Builder("minLengthOfStay", GraphQLInt.type).build(),
    new CompiledField.Builder("maxLengthOfStay", GraphQLInt.type).build(),
    new CompiledField.Builder("minAdvanceBookingDays", GraphQLInt.type).build(),
    new CompiledField.Builder("maxAdvanceBookingDays", GraphQLInt.type).build(),
    new CompiledField.Builder("bookingLocalDateTimeFrom", LocalDateTime.type).build(),
    new CompiledField.Builder("bookingLocalDateTimeTo", LocalDateTime.type).build(),
    new CompiledField.Builder("travelDateFrom", LocalDate.type).build(),
    new CompiledField.Builder("travelDateTo", LocalDate.type).build(),
    new CompiledField.Builder("sameDayBookingStartTime", LocalTime.type).build()
  );

  private static List<CompiledSelection> __eligibleRatePlans = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __blackoutDates = Arrays.asList(
    new CompiledField.Builder("travelDateFrom", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("travelDateTo", new CompiledNotNullType(LocalDate.type)).build()
  );

  private static List<CompiledSelection> __onMultiNightDiscount = Arrays.asList(
    new CompiledField.Builder("type", new CompiledNotNullType(DiscountType.type)).build(),
    new CompiledField.Builder("unit", new CompiledNotNullType(DiscountUnit.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLFloat.type)).build(),
    new CompiledField.Builder("memberOnlyAdditionalValue", GraphQLFloat.type).build(),
    new CompiledField.Builder("applicableNight", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("isRecurring", GraphQLBoolean.type).build()
  );

  private static List<CompiledSelection> __discount = Arrays.asList(
    new CompiledField.Builder("__typename", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledFragment.Builder("MultiNightDiscount", Arrays.asList("MultiNightDiscount")).selections(__onMultiNightDiscount).build()
  );

  private static List<CompiledSelection> __onDiscountPromotion = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(PromotionName.type)).build(),
    new CompiledField.Builder("category", new CompiledNotNullType(PromotionCategory.type)).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(PromotionStatus.type)).build(),
    new CompiledField.Builder("code", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("restrictions", Restrictions.type).selections(__restrictions).build(),
    new CompiledField.Builder("eligibleRatePlans", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(EligibleRatePlan.type)))).selections(__eligibleRatePlans).build(),
    new CompiledField.Builder("blackoutDates", new CompiledListType(new CompiledNotNullType(BlackoutDateRange.type))).selections(__blackoutDates).build(),
    new CompiledField.Builder("discount", Discount.type).selections(__discount).build(),
    new CompiledField.Builder("sellStatus", PromotionSellStatus.type).build(),
    new CompiledField.Builder("isContractedPromotion", GraphQLBoolean.type).build()
  );

  private static List<CompiledSelection> __updateMultiNightDiscountPromotion = Arrays.asList(
    new CompiledField.Builder("__typename", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("category", new CompiledNotNullType(PromotionCategory.type)).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("isContractedPromotion", GraphQLBoolean.type).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(PromotionName.type)).build(),
    new CompiledField.Builder("sellStatus", PromotionSellStatus.type).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(PromotionStatus.type)).build(),
    new CompiledFragment.Builder("DiscountPromotion", Arrays.asList("DiscountPromotion")).selections(__onDiscountPromotion).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("updateMultiNightDiscountPromotion", new CompiledNotNullType(Promotion.type)).arguments(Arrays.asList(new CompiledArgument.Builder(Mutation.__updateMultiNightDiscountPromotion_promotion).value(new CompiledVariable("promotion")).build(), new CompiledArgument.Builder(Mutation.__updateMultiNightDiscountPromotion_propertyId).value(new CompiledVariable("propertyId")).build(), new CompiledArgument.Builder(Mutation.__updateMultiNightDiscountPromotion_propertyIdSource).value(new CompiledVariable("propertyIdSource")).build())).selections(__updateMultiNightDiscountPromotion).build()
  );
}
