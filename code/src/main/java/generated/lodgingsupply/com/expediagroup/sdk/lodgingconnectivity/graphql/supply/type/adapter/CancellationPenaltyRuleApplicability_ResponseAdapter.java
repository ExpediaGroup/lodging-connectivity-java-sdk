//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPenaltyRuleApplicability;
import java.io.IOException;
import java.lang.Override;

public enum CancellationPenaltyRuleApplicability_ResponseAdapter implements Adapter<CancellationPenaltyRuleApplicability> {
  INSTANCE;

  @Override
  public CancellationPenaltyRuleApplicability fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    String rawValue = reader.nextString();
    return CancellationPenaltyRuleApplicability.safeValueOf(rawValue);
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      CancellationPenaltyRuleApplicability value) throws IOException {
    writer.value(value.rawValue);
  }
}
