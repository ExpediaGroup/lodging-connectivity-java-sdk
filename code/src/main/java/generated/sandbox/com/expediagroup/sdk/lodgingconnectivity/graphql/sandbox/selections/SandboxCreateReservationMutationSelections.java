//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.selections.SandboxReservationFragmentSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.Reservation;
import java.util.Arrays;
import java.util.List;

public class SandboxCreateReservationMutationSelections {
  private static List<CompiledSelection> __reservation = Arrays.asList(
    new CompiledField.Builder("__typename", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledFragment.Builder("Reservation", Arrays.asList("Reservation")).selections(SandboxReservationFragmentSelections.__root).build()
  );

  private static List<CompiledSelection> __createReservation = Arrays.asList(
    new CompiledField.Builder("reservation", new CompiledNotNullType(Reservation.type)).selections(__reservation).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("createReservation", new CompiledNotNullType(CreateReservationPayload.type)).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build())).selections(__createReservation).build()
  );
}
