//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledCondition;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BusinessModel;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPenaltyRuleType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyCancellationWindow;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationWindowTemporalUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CurrencyCode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Decimal;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DistributionChannel;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EffectivePolicy;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLFloat;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Guest;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GuestContactPhoneNumber;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdNode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Installment;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.InstallmentDistribution;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.InstallmentPaymentStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.InvalidScenario;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.InventoryType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MerchantOfRecord;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Money;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PageInfo;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Payment;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PaymentInstrument;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PaymentInstrumentType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PaymentToken;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RateTimeUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RateType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReconEligibility;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RemittanceType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Reservation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationAlternativeIds;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationAmounts;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationAudit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationCancellation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationCancellationPenaltyRule;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationCancellationPolicy;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationCancellationPolicyTier;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationDailyAmount;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationDistribution;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationEdge;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationGuest;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationGuests;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationNightlyPayments;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationPaymentStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationPerStayAmount;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationPets;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationPolicies;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationStatuses;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationStayDates;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationValueAddedPromotion;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationsConnection;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierAmount;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierAmountCompensation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierFeeType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierLoyaltyPlanInfo;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierOperatingModel;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierRate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierRateItem;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SupplierTotal;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TravelPurpose;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboCancellationReason;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboReservationAmount;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.VrboReservationAmounts;
import java.util.Arrays;
import java.util.List;

public class PropertyReservationsQuerySelections {
  private static List<CompiledSelection> __pageInfo = Arrays.asList(
    new CompiledField.Builder("endCursor", GraphQLString.type).build(),
    new CompiledField.Builder("hasNextPage", new CompiledNotNullType(GraphQLBoolean.type)).build()
  );

  private static List<CompiledSelection> __alternativeIds = Arrays.asList(
    new CompiledField.Builder("supplierId", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __amount = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __cancellationAmounts = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount).build(),
    new CompiledField.Builder("description", GraphQLString.type).build(),
    new CompiledField.Builder("percent", GraphQLFloat.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __amount2 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __dailyAmounts = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount2).build(),
    new CompiledField.Builder("date", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("description", GraphQLString.type).build(),
    new CompiledField.Builder("percent", GraphQLFloat.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __amount4 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __perStayAmounts = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount4).build(),
    new CompiledField.Builder("description", GraphQLString.type).build(),
    new CompiledField.Builder("percent", GraphQLFloat.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __nightlyPayments = Arrays.asList(
    new CompiledField.Builder("cancellationAmounts", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReservationPerStayAmount.type)))).selections(__cancellationAmounts).build(),
    new CompiledField.Builder("dailyAmounts", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReservationDailyAmount.type)))).selections(__dailyAmounts).build(),
    new CompiledField.Builder("perStayAmounts", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReservationPerStayAmount.type)))).selections(__perStayAmounts).build()
  );

  private static List<CompiledSelection> __amount6 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __summary = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount6).build(),
    new CompiledField.Builder("description", GraphQLString.type).build(),
    new CompiledField.Builder("percent", GraphQLFloat.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __amounts = Arrays.asList(
    new CompiledField.Builder("nightlyPayments", new CompiledNotNullType(ReservationNightlyPayments.type)).selections(__nightlyPayments).build(),
    new CompiledField.Builder("summary", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReservationPerStayAmount.type)))).selections(__summary).build()
  );

  private static List<CompiledSelection> __audit = Arrays.asList(
    new CompiledField.Builder("creationDateTimeUtc", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("lastUpdateDateTimeUtc", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __cancellation = Arrays.asList(
    new CompiledField.Builder("pendingCancellation", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("vrboPrimaryReason", VrboCancellationReason.type).build()
  );

  private static List<CompiledSelection> __effectivePolicy = Arrays.asList(
    new CompiledField.Builder("endDateTimeUtc", new CompiledNotNullType(DateTime.type)).build(),
    new CompiledField.Builder("policyType", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("startDateTimeUtc", new CompiledNotNullType(DateTime.type)).build()
  );

  private static List<CompiledSelection> __cancellationWindow = Arrays.asList(
    new CompiledField.Builder("cutoff", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("temporalUnit", new CompiledNotNullType(CancellationWindowTemporalUnit.type)).build()
  );

  private static List<CompiledSelection> __costFlatAmount = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __priceAmount = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __penaltyRule = Arrays.asList(
    new CompiledField.Builder("costFlatAmount", Money.type).selections(__costFlatAmount).build(),
    new CompiledField.Builder("numberOfNights", GraphQLInt.type).build(),
    new CompiledField.Builder("percentage", GraphQLFloat.type).build(),
    new CompiledField.Builder("priceAmount", Money.type).selections(__priceAmount).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(CancellationPenaltyRuleType.type)).build()
  );

  private static List<CompiledSelection> __tiers = Arrays.asList(
    new CompiledField.Builder("cancellationWindow", new CompiledNotNullType(CancellationPolicyCancellationWindow.type)).selections(__cancellationWindow).build(),
    new CompiledField.Builder("penaltyRule", new CompiledNotNullType(ReservationCancellationPenaltyRule.type)).selections(__penaltyRule).build()
  );

  private static List<CompiledSelection> __cancellationPolicy = Arrays.asList(
    new CompiledField.Builder("effectivePolicy", EffectivePolicy.type).selections(__effectivePolicy).build(),
    new CompiledField.Builder("tiers", new CompiledListType(new CompiledNotNullType(ReservationCancellationPolicyTier.type))).selections(__tiers).build()
  );

  private static List<CompiledSelection> __distribution = Arrays.asList(
    new CompiledField.Builder("distributionChannel", new CompiledNotNullType(DistributionChannel.type)).build(),
    new CompiledField.Builder("reservationSource", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __pets = Arrays.asList(
    new CompiledField.Builder("travelingWithPets", new CompiledNotNullType(GraphQLBoolean.type)).build()
  );

  private static List<CompiledSelection> __primaryGuest = Arrays.asList(
    new CompiledField.Builder("firstName", GraphQLString.type).build(),
    new CompiledField.Builder("lastName", GraphQLString.type).build(),
    new CompiledField.Builder("emailAddress", new CompiledNotNullType(EmailAddress.type)).build(),
    new CompiledField.Builder("fullPhoneNumber", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __guests = Arrays.asList(
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("pets", ReservationPets.type).selections(__pets).build(),
    new CompiledField.Builder("primaryGuest", new CompiledNotNullType(ReservationGuest.type)).selections(__primaryGuest).build()
  );

  private static List<CompiledSelection> __amount10 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __amount12 = Arrays.asList(
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build(),
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build()
  );

  private static List<CompiledSelection> __distributions = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount12).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __installments = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount10).build(),
    new CompiledField.Builder("distributions", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(InstallmentDistribution.type)))).selections(__distributions).build(),
    new CompiledField.Builder("dueDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("installmentId", GraphQLString.type).build(),
    new CompiledField.Builder("paymentStatus", InstallmentPaymentStatus.type).build()
  );

  private static List<CompiledSelection> __token = Arrays.asList(
    new CompiledField.Builder("expirationDateTime", GraphQLString.type).build(),
    new CompiledField.Builder("value", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __instrument = Arrays.asList(
    new CompiledField.Builder("token", new CompiledNotNullType(PaymentToken.type)).condition(Arrays.asList(new CompiledCondition("includePaymentInstrumentToken", false))).selections(__token).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(PaymentInstrumentType.type)).build()
  );

  private static List<CompiledSelection> __payment = Arrays.asList(
    new CompiledField.Builder("installments", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(Installment.type)))).selections(__installments).build(),
    new CompiledField.Builder("instructions", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("instrument", PaymentInstrument.type).selections(__instrument).build(),
    new CompiledField.Builder("status", ReservationPaymentStatus.type).build()
  );

  private static List<CompiledSelection> __effectivePolicy1 = Arrays.asList(
    new CompiledField.Builder("endDateTimeUtc", new CompiledNotNullType(DateTime.type)).build(),
    new CompiledField.Builder("policyType", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("startDateTimeUtc", new CompiledNotNullType(DateTime.type)).build()
  );

  private static List<CompiledSelection> __cancellationWindow1 = Arrays.asList(
    new CompiledField.Builder("cutoff", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("temporalUnit", new CompiledNotNullType(CancellationWindowTemporalUnit.type)).build()
  );

  private static List<CompiledSelection> __costFlatAmount1 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __priceAmount1 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __penaltyRule1 = Arrays.asList(
    new CompiledField.Builder("costFlatAmount", Money.type).selections(__costFlatAmount1).build(),
    new CompiledField.Builder("numberOfNights", GraphQLInt.type).build(),
    new CompiledField.Builder("percentage", GraphQLFloat.type).build(),
    new CompiledField.Builder("priceAmount", Money.type).selections(__priceAmount1).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(CancellationPenaltyRuleType.type)).build()
  );

  private static List<CompiledSelection> __tiers1 = Arrays.asList(
    new CompiledField.Builder("cancellationWindow", new CompiledNotNullType(CancellationPolicyCancellationWindow.type)).selections(__cancellationWindow1).build(),
    new CompiledField.Builder("penaltyRule", new CompiledNotNullType(ReservationCancellationPenaltyRule.type)).selections(__penaltyRule1).build()
  );

  private static List<CompiledSelection> __cancellationPolicy1 = Arrays.asList(
    new CompiledField.Builder("effectivePolicy", EffectivePolicy.type).selections(__effectivePolicy1).build(),
    new CompiledField.Builder("tiers", new CompiledListType(new CompiledNotNullType(ReservationCancellationPolicyTier.type))).selections(__tiers1).build()
  );

  private static List<CompiledSelection> __policies = Arrays.asList(
    new CompiledField.Builder("cancellationPolicy", new CompiledNotNullType(ReservationCancellationPolicy.type)).selections(__cancellationPolicy1).build()
  );

  private static List<CompiledSelection> __phoneNumbers = Arrays.asList(
    new CompiledField.Builder("areaCode", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("countryCode", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("number", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __supplierLoyaltyPlanInfo = Arrays.asList(
    new CompiledField.Builder("membershipNumber", GraphQLInt.type).build(),
    new CompiledField.Builder("planCode", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __primaryGuest1 = Arrays.asList(
    new CompiledField.Builder("emailAddress", EmailAddress.type).build(),
    new CompiledField.Builder("firstName", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("lastName", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("loyaltyTier", GraphQLString.type).build(),
    new CompiledField.Builder("phoneNumbers", new CompiledListType(new CompiledNotNullType(GuestContactPhoneNumber.type))).selections(__phoneNumbers).build(),
    new CompiledField.Builder("supplierLoyaltyPlanInfo", SupplierLoyaltyPlanInfo.type).selections(__supplierLoyaltyPlanInfo).build(),
    new CompiledField.Builder("travelPurpose", TravelPurpose.type).build()
  );

  private static List<CompiledSelection> __rateIds = Arrays.asList(
    new CompiledField.Builder("id", GraphQLID.type).build(),
    new CompiledField.Builder("idSource", new CompiledNotNullType(IdSource.type)).build()
  );

  private static List<CompiledSelection> __invalidScenarios = Arrays.asList(
    new CompiledField.Builder("reason", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("scenario", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __reconciliationEligibility = Arrays.asList(
    new CompiledField.Builder("invalidScenarios", new CompiledListType(new CompiledNotNullType(InvalidScenario.type))).selections(__invalidScenarios).build(),
    new CompiledField.Builder("validScenarios", new CompiledListType(new CompiledNotNullType(GraphQLString.type))).build()
  );

  private static List<CompiledSelection> __reservationIds = Arrays.asList(
    new CompiledField.Builder("id", GraphQLID.type).build(),
    new CompiledField.Builder("idSource", new CompiledNotNullType(IdSource.type)).build()
  );

  private static List<CompiledSelection> __statuses = Arrays.asList(
    new CompiledField.Builder("status", new CompiledNotNullType(ReservationStatus.type)).build()
  );

  private static List<CompiledSelection> __stayDates = Arrays.asList(
    new CompiledField.Builder("checkInDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("checkOutDate", new CompiledNotNullType(LocalDate.type)).build()
  );

  private static List<CompiledSelection> __compensation = Arrays.asList(
    new CompiledField.Builder("acceleratorPercent", GraphQLFloat.type).build(),
    new CompiledField.Builder("basePercent", GraphQLFloat.type).build()
  );

  private static List<CompiledSelection> __rateItems = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(GraphQLFloat.type)).build(),
    new CompiledField.Builder("feeType", new CompiledNotNullType(SupplierFeeType.type)).build()
  );

  private static List<CompiledSelection> __rates = Arrays.asList(
    new CompiledField.Builder("compensation", new CompiledNotNullType(SupplierAmountCompensation.type)).selections(__compensation).build(),
    new CompiledField.Builder("fromDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("rateItems", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(SupplierRateItem.type)))).selections(__rateItems).build(),
    new CompiledField.Builder("rateTimeUnit", new CompiledNotNullType(RateTimeUnit.type)).build(),
    new CompiledField.Builder("toDate", new CompiledNotNullType(LocalDate.type)).build()
  );

  private static List<CompiledSelection> __compensation1 = Arrays.asList(
    new CompiledField.Builder("acceleratorPercent", GraphQLFloat.type).build(),
    new CompiledField.Builder("basePercent", GraphQLFloat.type).build()
  );

  private static List<CompiledSelection> __total = Arrays.asList(
    new CompiledField.Builder("amountAfterTax", new CompiledNotNullType(GraphQLFloat.type)).build(),
    new CompiledField.Builder("amountBeforeTax", new CompiledNotNullType(GraphQLFloat.type)).build(),
    new CompiledField.Builder("compensation", new CompiledNotNullType(SupplierAmountCompensation.type)).selections(__compensation1).build()
  );

  private static List<CompiledSelection> __onExpediaSupplierAmount = Arrays.asList(
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("rateType", new CompiledNotNullType(RateType.type)).build(),
    new CompiledField.Builder("rates", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(SupplierRate.type)))).selections(__rates).build(),
    new CompiledField.Builder("total", new CompiledNotNullType(SupplierTotal.type)).selections(__total).build()
  );

  private static List<CompiledSelection> __supplierAmount = Arrays.asList(
    new CompiledField.Builder("__typename", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("rateType", new CompiledNotNullType(RateType.type)).build(),
    new CompiledFragment.Builder("ExpediaSupplierAmount", Arrays.asList("ExpediaSupplierAmount")).selections(__onExpediaSupplierAmount).build()
  );

  private static List<CompiledSelection> __unitIds = Arrays.asList(
    new CompiledField.Builder("id", GraphQLID.type).build(),
    new CompiledField.Builder("idSource", new CompiledNotNullType(IdSource.type)).build()
  );

  private static List<CompiledSelection> __valueAddedPromotions = Arrays.asList(
    new CompiledField.Builder("description", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __amount17 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __summary1 = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Money.type)).selections(__amount17).build(),
    new CompiledField.Builder("productCode", GraphQLString.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __vrboAmounts = Arrays.asList(
    new CompiledField.Builder("summary", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(VrboReservationAmount.type)))).selections(__summary1).build()
  );

  private static List<CompiledSelection> __node = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("alternativeIds", new CompiledNotNullType(ReservationAlternativeIds.type)).selections(__alternativeIds).build(),
    new CompiledField.Builder("accessibilityText", new CompiledListType(new CompiledNotNullType(GraphQLString.type))).build(),
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("amounts", ReservationAmounts.type).condition(Arrays.asList(new CompiledCondition("skipSummaryView", true))).selections(__amounts).build(),
    new CompiledField.Builder("audit", new CompiledNotNullType(ReservationAudit.type)).selections(__audit).build(),
    new CompiledField.Builder("bedTypes", GraphQLString.type).build(),
    new CompiledField.Builder("businessModel", new CompiledNotNullType(BusinessModel.type)).build(),
    new CompiledField.Builder("cancellation", ReservationCancellation.type).selections(__cancellation).build(),
    new CompiledField.Builder("cancellationPolicy", ReservationCancellationPolicy.type).selections(__cancellationPolicy).build(),
    new CompiledField.Builder("checkInDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("checkOutDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("childAges", new CompiledListType(GraphQLInt.type)).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("creationDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("distribution", new CompiledNotNullType(ReservationDistribution.type)).selections(__distribution).build(),
    new CompiledField.Builder("guests", new CompiledNotNullType(ReservationGuests.type)).selections(__guests).build(),
    new CompiledField.Builder("inventoryType", InventoryType.type).build(),
    new CompiledField.Builder("isReconciled", GraphQLBoolean.type).build(),
    new CompiledField.Builder("lastUpdatedDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("merchantOfRecord", new CompiledNotNullType(MerchantOfRecord.type)).build(),
    new CompiledField.Builder("messageThreadId", GraphQLID.type).build(),
    new CompiledField.Builder("multiRoomText", GraphQLString.type).build(),
    new CompiledField.Builder("payment", new CompiledNotNullType(Payment.type)).selections(__payment).build(),
    new CompiledField.Builder("paymentInstructions", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("petCount", GraphQLInt.type).build(),
    new CompiledField.Builder("policies", new CompiledNotNullType(ReservationPolicies.type)).selections(__policies).build(),
    new CompiledField.Builder("primaryGuest", new CompiledNotNullType(Guest.type)).selections(__primaryGuest1).build(),
    new CompiledField.Builder("rateIds", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(IdNode.type)))).selections(__rateIds).build(),
    new CompiledField.Builder("reconciliationEligibility", ReconEligibility.type).selections(__reconciliationEligibility).build(),
    new CompiledField.Builder("reconciliationType", GraphQLString.type).build(),
    new CompiledField.Builder("remittanceType", RemittanceType.type).build(),
    new CompiledField.Builder("reservationIds", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(IdNode.type)))).selections(__reservationIds).build(),
    new CompiledField.Builder("smokingType", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("source", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("specialRequest", GraphQLString.type).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(ReservationStatus.type)).build(),
    new CompiledField.Builder("statuses", new CompiledNotNullType(ReservationStatuses.type)).selections(__statuses).build(),
    new CompiledField.Builder("stayDates", new CompiledNotNullType(ReservationStayDates.type)).selections(__stayDates).build(),
    new CompiledField.Builder("subStatus", GraphQLString.type).build(),
    new CompiledField.Builder("supplierAmount", SupplierAmount.type).condition(Arrays.asList(new CompiledCondition("includeSupplierAmount", false))).selections(__supplierAmount).build(),
    new CompiledField.Builder("supplierOperatingModel", SupplierOperatingModel.type).build(),
    new CompiledField.Builder("tidsCode", GraphQLInt.type).build(),
    new CompiledField.Builder("totalGuestCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("unitIds", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(IdNode.type)))).selections(__unitIds).build(),
    new CompiledField.Builder("valueAddedPromotions", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReservationValueAddedPromotion.type)))).selections(__valueAddedPromotions).build(),
    new CompiledField.Builder("vrboAmounts", VrboReservationAmounts.type).condition(Arrays.asList(new CompiledCondition("skipSummaryView", true))).selections(__vrboAmounts).build()
  );

  private static List<CompiledSelection> __edges = Arrays.asList(
    new CompiledField.Builder("cursor", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("node", new CompiledNotNullType(Reservation.type)).selections(__node).build()
  );

  private static List<CompiledSelection> __reservations = Arrays.asList(
    new CompiledField.Builder("totalCount", GraphQLInt.type).build(),
    new CompiledField.Builder("pageInfo", PageInfo.type).selections(__pageInfo).build(),
    new CompiledField.Builder("edges", new CompiledNotNullType(new CompiledListType(ReservationEdge.type))).selections(__edges).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("reservations", new CompiledNotNullType(ReservationsConnection.type)).arguments(Arrays.asList(new CompiledArgument.Builder("after", new CompiledVariable("after")).build(), new CompiledArgument.Builder("checkOutDate", new CompiledVariable("checkOutDate")).build(), new CompiledArgument.Builder("filter", new CompiledVariable("filter")).build(), new CompiledArgument.Builder("pageSize", new CompiledVariable("pageSize")).build())).selections(__reservations).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}
