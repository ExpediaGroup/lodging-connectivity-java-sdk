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
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.GraphQLString;
import java.util.Arrays;
import java.util.List;

public class SandboxDeletePropertyMutationSelections {
  private static List<CompiledSelection> __deleteProperty = Arrays.asList(
    new CompiledField.Builder("clientMutationId", GraphQLString.type).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("deleteProperty", new CompiledNotNullType(DeletePropertyPayload.type)).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build())).selections(__deleteProperty).build()
  );
}
