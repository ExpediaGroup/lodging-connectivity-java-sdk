//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.Property;
import java.util.Arrays;
import java.util.List;

public class SandboxCreatePropertyMutationSelections {
  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __createProperty = Arrays.asList(
    new CompiledField.Builder("clientMutationId", GraphQLString.type).build(),
    new CompiledField.Builder("property", new CompiledNotNullType(Property.type)).selections(__property).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("createProperty", new CompiledNotNullType(CreatePropertyPayload.type)).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build())).selections(__createProperty).build()
  );
}
