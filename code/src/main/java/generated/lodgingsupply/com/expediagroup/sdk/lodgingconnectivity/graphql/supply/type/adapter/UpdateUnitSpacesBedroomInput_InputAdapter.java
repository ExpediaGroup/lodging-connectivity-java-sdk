//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BedGroupInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TextInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateUnitSpacesBedroomInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateUnitSpacesBedroomInput_InputAdapter implements Adapter<UpdateUnitSpacesBedroomInput> {
  INSTANCE;

  @Override
  public UpdateUnitSpacesBedroomInput fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateUnitSpacesBedroomInput value) throws IOException {
    if (value.bedGroups.isPresent()) {
      writer.name("bedGroups");
      new OptionalAdapter<>(new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<BedGroupInput>(BedGroupInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.bedGroups);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.order.isPresent()) {
      writer.name("order");
      new OptionalAdapter<>(OptionalAdapters.OptionalIntAdapter).toJson(writer, customScalarAdapters, value.order);
    }
    if (value.text.isPresent()) {
      writer.name("text");
      new OptionalAdapter<>(new OptionalAdapter<>(new ListAdapter<>(new ObjectAdapter<TextInput>(TextInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.text);
    }
  }
}
