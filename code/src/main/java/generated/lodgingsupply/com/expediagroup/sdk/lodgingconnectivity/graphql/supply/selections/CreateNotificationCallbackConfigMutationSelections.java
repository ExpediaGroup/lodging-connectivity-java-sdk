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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CreateNotificationCallbackConfigPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.NotificationCallbackConfig;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Url;
import java.util.Arrays;
import java.util.List;

public class CreateNotificationCallbackConfigMutationSelections {
  private static List<CompiledSelection> __callbackConfig = Arrays.asList(
    new CompiledField.Builder("callbackUrl", new CompiledNotNullType(Url.type)).build(),
    new CompiledField.Builder("contactEmail", EmailAddress.type).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("requestTimeoutSeconds", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("secretExpirationDateTime", new CompiledNotNullType(LocalDateTime.type)).build()
  );

  private static List<CompiledSelection> __createNotificationCallbackConfig = Arrays.asList(
    new CompiledField.Builder("callbackConfig", new CompiledNotNullType(NotificationCallbackConfig.type)).selections(__callbackConfig).build(),
    new CompiledField.Builder("secret", new CompiledNotNullType(GraphQLString.type)).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("createNotificationCallbackConfig", CreateNotificationCallbackConfigPayload.type).arguments(Arrays.asList(new CompiledArgument.Builder(Mutation.__createNotificationCallbackConfig_input).value(new CompiledVariable("input")).build())).selections(__createNotificationCallbackConfig).build()
  );
}
