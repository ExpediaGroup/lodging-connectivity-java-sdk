//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.ApolloOptionalAdapter;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.BookingPolicyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePoliciesInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateStayPolicyInput;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.lang.Override;

public enum UpdatePoliciesInput_InputAdapter implements Adapter<UpdatePoliciesInput> {
  INSTANCE;

  @Override
  public UpdatePoliciesInput fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    throw new IllegalStateException("Input type used in output position");
  }

  @Override
  public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      UpdatePoliciesInput value) throws IOException {
    if (value.bookingPolicy instanceof Optional.Present) {
      writer.name("bookingPolicy");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<BookingPolicyInput>(BookingPolicyInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.bookingPolicy);
    }
    if (value.stayPolicy instanceof Optional.Present) {
      writer.name("stayPolicy");
      new ApolloOptionalAdapter<>(new NullableAdapter<>(new ObjectAdapter<UpdateStayPolicyInput>(UpdateStayPolicyInput_InputAdapter.INSTANCE, false))).toJson(writer, customScalarAdapters, value.stayPolicy);
    }
  }
}