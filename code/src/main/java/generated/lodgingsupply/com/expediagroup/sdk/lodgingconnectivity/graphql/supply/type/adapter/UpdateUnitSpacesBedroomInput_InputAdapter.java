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
    if (value.bedGroups instanceof Optional.Present) {
      writer.name("bedGroups");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<BedGroupInput>(BedGroupInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.bedGroups);
    }
    writer.name("id");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    if (value.order instanceof Optional.Present) {
      writer.name("order");
      new ApolloOptionalAdapter<>(Adapters.NullableIntAdapter).toJson(writer, customScalarAdapters, value.order);
    }
    if (value.text instanceof Optional.Present) {
      writer.name("text");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<TextInput>(TextInput_InputAdapter.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.text);
    }
  }
}
