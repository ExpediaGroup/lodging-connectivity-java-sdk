//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateRatePlanInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateRatePlanRestrictionsInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RatePlanDistributionRuleInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CreateRatePlanInput_InputAdapter implements Adapter<CreateRatePlanInput> {
  INSTANCE;

  @Override
  public CreateRatePlanInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreateRatePlanInput value) throws IOException {
    if (value.baseRateGuestCount instanceof Optional.Present) {
      writer.name("baseRateGuestCount");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.baseRateGuestCount);
    }
    writer.name("cancellationPolicyConfigId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.cancellationPolicyConfigId);
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    writer.name("distributionRules");
    new ListAdapter<>(new ObjectAdapter<RatePlanDistributionRuleInput>(RatePlanDistributionRuleInput_InputAdapter.INSTANCE, false)).toJson(writer, customScalarAdapters, value.distributionRules);
    if (value.feeSetId instanceof Optional.Present) {
      writer.name("feeSetId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.feeSetId);
    }
    writer.name("name");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);
    if (value.paymentScheduleApplicable instanceof Optional.Present) {
      writer.name("paymentScheduleApplicable");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.paymentScheduleApplicable);
    }
    writer.name("pricingModel");
    PricingModel_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.pricingModel);
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.restrictions instanceof Optional.Present) {
      writer.name("restrictions");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<CreateRatePlanRestrictionsInput>(CreateRatePlanRestrictionsInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.restrictions);
    }
    if (value.taxInclusive instanceof Optional.Present) {
      writer.name("taxInclusive");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.taxInclusive);
    }
    writer.name("type");
    RatePlanType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
    writer.name("unitId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.unitId);
    writer.name("valueAdds");
    new ListAdapter<>(Adapters.StringAdapter).toJson(writer, customScalarAdapters, value.valueAdds);
  }
}