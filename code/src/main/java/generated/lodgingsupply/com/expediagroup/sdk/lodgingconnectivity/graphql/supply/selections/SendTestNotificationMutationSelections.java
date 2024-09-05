//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SendTestNotificationPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TestNotificationError;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.TestNotificationOutcome;
import java.util.Arrays;
import java.util.List;

public class SendTestNotificationMutationSelections {
  private static List<CompiledSelection> __error = Arrays.asList(
    new CompiledField.Builder("code", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("message", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __sendTestNotification = Arrays.asList(
    new CompiledField.Builder("error", TestNotificationError.type).selections(__error).build(),
    new CompiledField.Builder("httpStatusCode", GraphQLInt.type).build(),
    new CompiledField.Builder("outcome", new CompiledNotNullType(TestNotificationOutcome.type)).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("sendTestNotification", SendTestNotificationPayload.type).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build())).selections(__sendTestNotification).build()
  );
}
