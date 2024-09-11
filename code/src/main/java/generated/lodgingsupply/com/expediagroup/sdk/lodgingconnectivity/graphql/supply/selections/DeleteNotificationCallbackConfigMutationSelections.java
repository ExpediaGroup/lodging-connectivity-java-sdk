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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DeleteNotificationCallbackConfigPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation;
import java.util.Arrays;
import java.util.List;

public class DeleteNotificationCallbackConfigMutationSelections {
  private static List<CompiledSelection> __deleteNotificationCallbackConfig = Arrays.asList(
    new CompiledField.Builder("callbackConfigId", new CompiledNotNullType(GraphQLID.type)).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("deleteNotificationCallbackConfig", DeleteNotificationCallbackConfigPayload.type).arguments(Arrays.asList(new CompiledArgument.Builder(Mutation.__deleteNotificationCallbackConfig_input).value(new CompiledVariable("input")).build())).selections(__deleteNotificationCallbackConfig).build()
  );
}
