//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo.api.CompiledArgument;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CompiledNotNullType;
import com.apollographql.apollo.api.CompiledSelection;
import com.apollographql.apollo.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SendMessagePayload;
import java.util.Arrays;
import java.util.List;

public class SendMessageMutationSelections {
  private static List<CompiledSelection> __sendMessage = Arrays.asList(
    new CompiledField.Builder("clientMutationId", GraphQLString.type).build(),
    new CompiledField.Builder("messageId", new CompiledNotNullType(GraphQLID.type)).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("sendMessage", SendMessagePayload.type).arguments(Arrays.asList(new CompiledArgument.Builder(Mutation.__sendMessage_input).value(new CompiledVariable("input")).build())).selections(__sendMessage).build()
  );
}
