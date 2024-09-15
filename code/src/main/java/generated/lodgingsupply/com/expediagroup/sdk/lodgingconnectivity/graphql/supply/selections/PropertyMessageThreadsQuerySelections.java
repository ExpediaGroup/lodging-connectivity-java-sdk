//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThread;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadBookingInquiry;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadReservationSummary;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadTraveler;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadsResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationAlternativeIds;
import java.util.Arrays;
import java.util.List;

public class PropertyMessageThreadsQuerySelections {
  private static List<CompiledSelection> __primaryTraveler = Arrays.asList(
    new CompiledField.Builder("firstName", GraphQLString.type).build(),
    new CompiledField.Builder("lastName", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __alternativeIds = Arrays.asList(
    new CompiledField.Builder("supplierId", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __reservationSummary = Arrays.asList(
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("alternativeIds", new CompiledNotNullType(ReservationAlternativeIds.type)).selections(__alternativeIds).build(),
    new CompiledField.Builder("checkInDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("checkOutDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("petCount", new CompiledNotNullType(GraphQLInt.type)).build()
  );

  private static List<CompiledSelection> __bookingInquiry = Arrays.asList(
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("checkInDate", LocalDate.type).build(),
    new CompiledField.Builder("checkOutDate", LocalDate.type).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("hasPets", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __elements = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("creationDateTimeUtc", DateTime.type).build(),
    new CompiledField.Builder("primaryTraveler", MessageThreadTraveler.type).selections(__primaryTraveler).build(),
    new CompiledField.Builder("reservationSummary", MessageThreadReservationSummary.type).selections(__reservationSummary).build(),
    new CompiledField.Builder("bookingInquiry", MessageThreadBookingInquiry.type).selections(__bookingInquiry).build()
  );

  private static List<CompiledSelection> __messageThreads = Arrays.asList(
    new CompiledField.Builder("cursor", GraphQLString.type).build(),
    new CompiledField.Builder("totalCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("elements", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(MessageThread.type)))).selections(__elements).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("messageThreads", new CompiledNotNullType(MessageThreadsResponse.type)).arguments(Arrays.asList(new CompiledArgument.Builder("cursor", new CompiledVariable("cursor")).build(), new CompiledArgument.Builder("filters", new CompiledVariable("filters")).build(), new CompiledArgument.Builder("limit", new CompiledVariable("limit")).build(), new CompiledArgument.Builder("orderBy", new CompiledVariable("orderBy")).build())).selections(__messageThreads).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}