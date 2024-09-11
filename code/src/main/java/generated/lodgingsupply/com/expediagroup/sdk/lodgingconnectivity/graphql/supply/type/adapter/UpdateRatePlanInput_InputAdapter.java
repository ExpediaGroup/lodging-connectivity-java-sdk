//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.ApolloOptionalAdapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.Optional;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RatePlanDistributionRuleInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateRatePlanInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateRatePlanRestrictionsInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateRatePlanInput_InputAdapter implements Adapter<UpdateRatePlanInput> {
  INSTANCE;

  @Override
  public UpdateRatePlanInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateRatePlanInput value) throws IOException {
    if (value.baseRateGuestCount instanceof Optional.Present) {
      writer.name("baseRateGuestCount");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.baseRateGuestCount);
    }
    if (value.cancellationPolicyConfigId instanceof Optional.Present) {
      writer.name("cancellationPolicyConfigId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.cancellationPolicyConfigId);
    }
    if (value.clientMutationId instanceof Optional.Present) {
      writer.name("clientMutationId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.clientMutationId);
    }
    if (value.distributionRules instanceof Optional.Present) {
      writer.name("distributionRules");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<RatePlanDistributionRuleInput>(RatePlanDistributionRuleInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.distributionRules);
    }
    if (value.feeSetId instanceof Optional.Present) {
      writer.name("feeSetId");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.feeSetId);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.name instanceof Optional.Present) {
      writer.name("name");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.name);
    }
    if (value.paymentScheduleApplicable instanceof Optional.Present) {
      writer.name("paymentScheduleApplicable");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.paymentScheduleApplicable);
    }
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    if (value.restrictions instanceof Optional.Present) {
      writer.name("restrictions");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<UpdateRatePlanRestrictionsInput>(UpdateRatePlanRestrictionsInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.restrictions);
    }
    if (value.status instanceof Optional.Present) {
      writer.name("status");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(RatePlanStatus_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.status);
    }
    if (value.taxInclusive instanceof Optional.Present) {
      writer.name("taxInclusive");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.taxInclusive);
    }
    writer.name("unitId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.unitId);
  }
}
