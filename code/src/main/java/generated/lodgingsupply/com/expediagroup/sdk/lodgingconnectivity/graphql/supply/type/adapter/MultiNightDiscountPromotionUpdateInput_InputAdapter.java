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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BlackoutDateRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EligibleRatePlanInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountPromotionUpdateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountUpdateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RestrictionsUpdateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum MultiNightDiscountPromotionUpdateInput_InputAdapter implements Adapter<MultiNightDiscountPromotionUpdateInput> {
  INSTANCE;

  @Override
  public MultiNightDiscountPromotionUpdateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      MultiNightDiscountPromotionUpdateInput value) throws IOException {
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.name instanceof Optional.Present) {
      writer.name("name");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(PromotionName_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.name);
    }
    if (value.status instanceof Optional.Present) {
      writer.name("status");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(PromotionStatus_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.status);
    }
    if (value.category instanceof Optional.Present) {
      writer.name("category");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(PromotionCategory_ResponseAdapter.INSTANCE)).toJson(writer, customScalarAdapters, value.category);
    }
    if (value.code instanceof Optional.Present) {
      writer.name("code");
      new ApolloOptionalAdapter<>(Adapters.NullableStringAdapter).toJson(writer, customScalarAdapters, value.code);
    }
    if (value.restrictions instanceof Optional.Present) {
      writer.name("restrictions");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<RestrictionsUpdateInput>(RestrictionsUpdateInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.restrictions);
    }
    if (value.eligibleRatePlans instanceof Optional.Present) {
      writer.name("eligibleRatePlans");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<EligibleRatePlanInput>(EligibleRatePlanInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.eligibleRatePlans);
    }
    if (value.blackoutDates instanceof Optional.Present) {
      writer.name("blackoutDates");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<BlackoutDateRangeInput>(BlackoutDateRangeInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.blackoutDates);
    }
    if (value.discount instanceof Optional.Present) {
      writer.name("discount");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<MultiNightDiscountUpdateInput>(MultiNightDiscountUpdateInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.discount);
    }
  }
}
