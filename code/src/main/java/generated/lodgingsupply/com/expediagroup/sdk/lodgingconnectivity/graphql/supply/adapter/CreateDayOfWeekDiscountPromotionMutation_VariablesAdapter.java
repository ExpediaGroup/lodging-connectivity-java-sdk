//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.CreateDayOfWeekDiscountPromotionMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DayOfWeekDiscountPromotionCreateInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DayOfWeekDiscountPromotionCreateInput_InputAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.IdSource_ResponseAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum CreateDayOfWeekDiscountPromotionMutation_VariablesAdapter implements Adapter<CreateDayOfWeekDiscountPromotionMutation> {
  INSTANCE;

  @Override
  public CreateDayOfWeekDiscountPromotionMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CreateDayOfWeekDiscountPromotionMutation value) throws IOException {
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
    writer.name("propertyIdSource");
    IdSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.propertyIdSource);
    writer.name("promotion");
    new ObjectAdapter<DayOfWeekDiscountPromotionCreateInput>(DayOfWeekDiscountPromotionCreateInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.promotion);
  }
}
