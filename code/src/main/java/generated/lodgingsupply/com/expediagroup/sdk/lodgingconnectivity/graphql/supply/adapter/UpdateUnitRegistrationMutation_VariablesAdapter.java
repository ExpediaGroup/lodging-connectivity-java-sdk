//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UpdateUnitRegistrationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateUnitRegistrationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.IdSource_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.UpdateUnitRegistrationInput_InputAdapter;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdateUnitRegistrationMutation_VariablesAdapter implements Adapter<UpdateUnitRegistrationMutation> {
  INSTANCE;

  @Override
  public UpdateUnitRegistrationMutation fromJson(JsonReader reader,
      CustomScalarAdapters customScalarAdapters) throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdateUnitRegistrationMutation value) throws IOException {
    writer.name("propertyIdSource");
    IdSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.propertyIdSource);
    writer.name("registration");
    new ObjectAdapter<UpdateUnitRegistrationInput>(UpdateUnitRegistrationInput_InputAdapter.INSTANCE, false).toJson(writer, customScalarAdapters, value.registration);
    if (value.forceSave instanceof Optional.Present) {
      writer.name("forceSave");
      new ApolloOptionalAdapter<>(Adapters.NullableBooleanAdapter).toJson(writer, customScalarAdapters, value.forceSave);
    }
    writer.name("propertyId");
    Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.propertyId);
  }
}
