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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.CancelReservationReconciliationPayload;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Reservation;
import java.util.Arrays;
import java.util.List;

public class CancelReservationReconciliationMutationSelections {
  private static List<CompiledSelection> __reservation = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __cancelReservationReconciliation = Arrays.asList(
    new CompiledField.Builder("reservation", Reservation.type).selections(__reservation).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("cancelReservationReconciliation", new CompiledNotNullType(CancelReservationReconciliationPayload.type)).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build())).selections(__cancelReservationReconciliation).build()
  );
}
