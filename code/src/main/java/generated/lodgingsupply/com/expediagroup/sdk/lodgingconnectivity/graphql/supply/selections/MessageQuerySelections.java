//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo.api.CompiledArgument;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CompiledListType;
import com.apollographql.apollo.api.CompiledNotNullType;
import com.apollographql.apollo.api.CompiledSelection;
import com.apollographql.apollo.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.DateTime;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageReviewStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThread;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadAttachment;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadBookingInquiry;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadLocalizedString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadMessage;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadParticipantRole;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadReservationSummary;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadTraveler;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReservationAlternativeIds;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Url;
import java.util.Arrays;
import java.util.List;

public class MessageQuerySelections {
  private static List<CompiledSelection> __attachments = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("uploadDateTimeUtc", new CompiledNotNullType(DateTime.type)).build(),
    new CompiledField.Builder("url", new CompiledNotNullType(Url.type)).build()
  );

  private static List<CompiledSelection> __body = Arrays.asList(
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __bookingInquiry = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("checkInDate", LocalDate.type).build(),
    new CompiledField.Builder("checkOutDate", LocalDate.type).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("hasPets", new CompiledNotNullType(GraphQLBoolean.type)).build()
  );

  private static List<CompiledSelection> __primaryTraveler = Arrays.asList(
    new CompiledField.Builder("firstName", GraphQLString.type).build(),
    new CompiledField.Builder("lastName", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __alternativeIds = Arrays.asList(
    new CompiledField.Builder("supplierId", new CompiledNotNullType(GraphQLID.type)).build()
  );

  private static List<CompiledSelection> __reservationSummary = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("checkInDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("checkOutDate", new CompiledNotNullType(LocalDate.type)).build(),
    new CompiledField.Builder("adultCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("childCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("petCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("alternativeIds", new CompiledNotNullType(ReservationAlternativeIds.type)).selections(__alternativeIds).build()
  );

  private static List<CompiledSelection> __messageThread = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("creationDateTimeUtc", DateTime.type).build(),
    new CompiledField.Builder("bookingInquiry", MessageThreadBookingInquiry.type).selections(__bookingInquiry).build(),
    new CompiledField.Builder("primaryTraveler", MessageThreadTraveler.type).selections(__primaryTraveler).build(),
    new CompiledField.Builder("property", new CompiledNotNullType(Property.type)).selections(__property).build(),
    new CompiledField.Builder("reservationSummary", MessageThreadReservationSummary.type).selections(__reservationSummary).build()
  );

  private static List<CompiledSelection> __message = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("creationDateTimeUtc", DateTime.type).build(),
    new CompiledField.Builder("fromRole", MessageThreadParticipantRole.type).build(),
    new CompiledField.Builder("reviewStatus", MessageReviewStatus.type).build(),
    new CompiledField.Builder("type", GraphQLString.type).build(),
    new CompiledField.Builder("attachments", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(MessageThreadAttachment.type)))).selections(__attachments).build(),
    new CompiledField.Builder("body", MessageThreadLocalizedString.type).selections(__body).build(),
    new CompiledField.Builder("messageThread", new CompiledNotNullType(MessageThread.type)).selections(__messageThread).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("message", MessageThreadMessage.type).arguments(Arrays.asList(new CompiledArgument.Builder(Query.__message_id).value(new CompiledVariable("messageId")).build())).selections(__message).build()
  );
}
