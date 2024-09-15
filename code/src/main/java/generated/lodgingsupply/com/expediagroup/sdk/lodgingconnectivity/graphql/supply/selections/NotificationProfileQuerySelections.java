//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.EmailAddress;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.NotificationCallbackConfig;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.NotificationEventTypeSubscription;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.NotificationProfile;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.NotificationSubscription;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Url;
import java.util.Arrays;
import java.util.List;

public class NotificationProfileQuerySelections {
  private static List<CompiledSelection> __callbackConfigs = Arrays.asList(
    new CompiledField.Builder("callbackUrl", new CompiledNotNullType(Url.type)).build(),
    new CompiledField.Builder("contactEmail", EmailAddress.type).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("requestTimeoutSeconds", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("secretExpirationDateTime", new CompiledNotNullType(LocalDateTime.type)).build()
  );

  private static List<CompiledSelection> __callbackConfig = Arrays.asList(
    new CompiledField.Builder("callbackUrl", new CompiledNotNullType(Url.type)).build(),
    new CompiledField.Builder("contactEmail", EmailAddress.type).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("requestTimeoutSeconds", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("secretExpirationDateTime", new CompiledNotNullType(LocalDateTime.type)).build()
  );

  private static List<CompiledSelection> __eventTypeSubscriptions = Arrays.asList(
    new CompiledField.Builder("callbackConfig", new CompiledNotNullType(NotificationCallbackConfig.type)).selections(__callbackConfig).build(),
    new CompiledField.Builder("eventType", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __subscriptions = Arrays.asList(
    new CompiledField.Builder("eventTypeSubscriptions", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(NotificationEventTypeSubscription.type)))).selections(__eventTypeSubscriptions).build(),
    new CompiledField.Builder("product", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __notificationProfile = Arrays.asList(
    new CompiledField.Builder("callbackConfigs", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(NotificationCallbackConfig.type)))).selections(__callbackConfigs).build(),
    new CompiledField.Builder("subscriptions", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(NotificationSubscription.type)))).selections(__subscriptions).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("notificationProfile", NotificationProfile.type).selections(__notificationProfile).build()
  );
}