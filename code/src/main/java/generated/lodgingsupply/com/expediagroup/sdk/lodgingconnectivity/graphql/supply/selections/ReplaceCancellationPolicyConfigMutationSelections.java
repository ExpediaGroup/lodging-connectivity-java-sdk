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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancellationPolicyConfig;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReplaceCancellationPolicyConfigPayload;
import java.util.Arrays;
import java.util.List;

public class ReplaceCancellationPolicyConfigMutationSelections {
  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __cancellationPolicyConfig = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("property", Property.type).selections(__property).build()
  );

  private static List<CompiledSelection> __replaceCancellationPolicyConfig = Arrays.asList(
    new CompiledField.Builder("clientMutationId", GraphQLString.type).build(),
    new CompiledField.Builder("cancellationPolicyConfig", CancellationPolicyConfig.type).selections(__cancellationPolicyConfig).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("replaceCancellationPolicyConfig", ReplaceCancellationPolicyConfigPayload.type).arguments(Arrays.asList(new CompiledArgument.Builder(Mutation.__replaceCancellationPolicyConfig_input).value(new CompiledVariable("input")).build())).selections(__replaceCancellationPolicyConfig).build()
  );
}
