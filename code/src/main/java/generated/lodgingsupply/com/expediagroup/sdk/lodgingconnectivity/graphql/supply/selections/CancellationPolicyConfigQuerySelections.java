//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPenaltyRule;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPenaltyRuleApplicability;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPenaltyRuleType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicy;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyCancellationWindow;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyConfig;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyDateRange;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyOverride;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyTier;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationWindowTemporalUnit;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CurrencyCode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Date;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Decimal;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Money;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import java.util.Arrays;
import java.util.List;

public class CancellationPolicyConfigQuerySelections {
  private static List<CompiledSelection> __additionalCancellationFee = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __cancellationWindow = Arrays.asList(
    new CompiledField.Builder("cutoff", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("temporalUnit", new CompiledNotNullType(CancellationWindowTemporalUnit.type)).build()
  );

  private static List<CompiledSelection> __flatAmount = Arrays.asList(
    new CompiledField.Builder("amount", new CompiledNotNullType(Decimal.type)).build(),
    new CompiledField.Builder("currencyCode", new CompiledNotNullType(CurrencyCode.type)).build()
  );

  private static List<CompiledSelection> __penaltyRules = Arrays.asList(
    new CompiledField.Builder("applicability", new CompiledNotNullType(CancellationPenaltyRuleApplicability.type)).build(),
    new CompiledField.Builder("flatAmount", Money.type).selections(__flatAmount).build(),
    new CompiledField.Builder("numberOfNights", GraphQLInt.type).build(),
    new CompiledField.Builder("percentage", Decimal.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(CancellationPenaltyRuleType.type)).build()
  );

  private static List<CompiledSelection> __tiers = Arrays.asList(
    new CompiledField.Builder("cancellationWindow", new CompiledNotNullType(CancellationPolicyCancellationWindow.type)).selections(__cancellationWindow).build(),
    new CompiledField.Builder("penaltyRules", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(CancellationPenaltyRule.type)))).selections(__penaltyRules).build()
  );

  private static List<CompiledSelection> __defaultPolicies = Arrays.asList(
    new CompiledField.Builder("type", new CompiledNotNullType(CancellationPolicyType.type)).build(),
    new CompiledField.Builder("tiers", new CompiledListType(new CompiledNotNullType(CancellationPolicyTier.type))).selections(__tiers).build()
  );

  private static List<CompiledSelection> __cancellationWindow1 = Arrays.asList(
    new CompiledField.Builder("cutoff", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("temporalUnit", new CompiledNotNullType(CancellationWindowTemporalUnit.type)).build()
  );

  private static List<CompiledSelection> __tiers1 = Arrays.asList(
    new CompiledField.Builder("cancellationWindow", new CompiledNotNullType(CancellationPolicyCancellationWindow.type)).selections(__cancellationWindow1).build()
  );

  private static List<CompiledSelection> __cancellationPolicy = Arrays.asList(
    new CompiledField.Builder("type", new CompiledNotNullType(CancellationPolicyType.type)).build(),
    new CompiledField.Builder("tiers", new CompiledListType(new CompiledNotNullType(CancellationPolicyTier.type))).selections(__tiers1).build()
  );

  private static List<CompiledSelection> __dateRanges = Arrays.asList(
    new CompiledField.Builder("from", new CompiledNotNullType(Date.type)).build(),
    new CompiledField.Builder("to", new CompiledNotNullType(Date.type)).build()
  );

  private static List<CompiledSelection> __overridePolicies = Arrays.asList(
    new CompiledField.Builder("cancellationPolicy", new CompiledNotNullType(CancellationPolicy.type)).selections(__cancellationPolicy).build(),
    new CompiledField.Builder("dateRanges", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(CancellationPolicyDateRange.type)))).selections(__dateRanges).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __cancellationPolicyConfig = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("additionalCancellationFee", Money.type).selections(__additionalCancellationFee).build(),
    new CompiledField.Builder("defaultPolicies", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(CancellationPolicy.type)))).selections(__defaultPolicies).build(),
    new CompiledField.Builder("overridePolicies", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(CancellationPolicyOverride.type)))).selections(__overridePolicies).build(),
    new CompiledField.Builder("property", Property.type).selections(__property).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("cancellationPolicyConfig", CancellationPolicyConfig.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("id")).build())).selections(__cancellationPolicyConfig).build()
  );
}
