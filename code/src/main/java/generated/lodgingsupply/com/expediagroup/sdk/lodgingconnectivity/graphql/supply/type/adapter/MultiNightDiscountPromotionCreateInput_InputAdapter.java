//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BlackoutDateRangeInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EligibleRatePlanInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountCreateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MultiNightDiscountPromotionCreateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RestrictionsCreateInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum MultiNightDiscountPromotionCreateInput_InputAdapter implements Adapter<MultiNightDiscountPromotionCreateInput> {
  INSTANCE;

  @Override
  public MultiNightDiscountPromotionCreateInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      MultiNightDiscountPromotionCreateInput value) throws IOException {
    writer.name("name");
    PromotionName_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.name);
    writer.name("status");
    PromotionStatus_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.status);
    writer.name("category");
    PromotionCategory_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.category);
    writer.name("code");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.code);
    writer.name("restrictions");
    new ObjectAdapter<RestrictionsCreateInput>(RestrictionsCreateInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.restrictions);
    writer.name("eligibleRatePlans");
    new ListAdapter<>(new ObjectAdapter<EligibleRatePlanInput>(EligibleRatePlanInput_InputAdapter.INSTANCE, false)).toJson(writer, customScalarAdapters, value.eligibleRatePlans);
    writer.name("blackoutDates");
    new ListAdapter<>(new ObjectAdapter<BlackoutDateRangeInput>(BlackoutDateRangeInput_InputAdapter.INSTANCE, false)).toJson(writer, customScalarAdapters, value.blackoutDates);
    writer.name("discount");
    new ObjectAdapter<MultiNightDiscountCreateInput>(MultiNightDiscountCreateInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.discount);
  }
}
