//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.DeleteImageMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DeleteImageInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.DeleteImageInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum DeleteImageMutation_VariablesAdapter implements Adapter<DeleteImageMutation> {
  INSTANCE;

  @Override
  public DeleteImageMutation fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      DeleteImageMutation value) throws IOException {
    writer.name("input");
    new ObjectAdapter<DeleteImageInput>(DeleteImageInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.input);
  }
}