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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdNode;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalDate;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Locale;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.OwnerResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Rating;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Review;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewBrand;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewGuest;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewMedia;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewReservation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewResponse;
import java.util.Arrays;
import java.util.List;

public class PropertyReviewsQuerySelections {
  private static List<CompiledSelection> __body = Arrays.asList(
    new CompiledField.Builder("locale", new CompiledNotNullType(Locale.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __caption = Arrays.asList(
    new CompiledField.Builder("locale", new CompiledNotNullType(Locale.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __media = Arrays.asList(
    new CompiledField.Builder("caption", LocalizedString.type).selections(__caption).build(),
    new CompiledField.Builder("highResolutionUrl", GraphQLString.type).build(),
    new CompiledField.Builder("thumbnailUrl", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __propertyId = Arrays.asList(
    new CompiledField.Builder("id", GraphQLID.type).build(),
    new CompiledField.Builder("idSource", new CompiledNotNullType(IdSource.type)).build()
  );

  private static List<CompiledSelection> __primaryGuest = Arrays.asList(
    new CompiledField.Builder("firstName", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("lastName", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __reservationIds = Arrays.asList(
    new CompiledField.Builder("id", GraphQLID.type).build(),
    new CompiledField.Builder("idSource", new CompiledNotNullType(IdSource.type)).build()
  );

  private static List<CompiledSelection> __reservation = Arrays.asList(
    new CompiledField.Builder("checkInDate", LocalDate.type).build(),
    new CompiledField.Builder("checkOutDate", LocalDate.type).build(),
    new CompiledField.Builder("primaryGuest", ReviewGuest.type).selections(__primaryGuest).build(),
    new CompiledField.Builder("reservationIds", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(IdNode.type)))).selections(__reservationIds).build(),
    new CompiledField.Builder("status", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __body1 = Arrays.asList(
    new CompiledField.Builder("locale", new CompiledNotNullType(Locale.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __response = Arrays.asList(
    new CompiledField.Builder("body", new CompiledNotNullType(LocalizedString.type)).selections(__body1).build(),
    new CompiledField.Builder("createdDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("lastUpdatedDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __starRatings = Arrays.asList(
    new CompiledField.Builder("category", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __title = Arrays.asList(
    new CompiledField.Builder("locale", new CompiledNotNullType(Locale.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __reviews1 = Arrays.asList(
    new CompiledField.Builder("body", new CompiledNotNullType(LocalizedString.type)).selections(__body).build(),
    new CompiledField.Builder("brandNameV2", ReviewBrand.type).build(),
    new CompiledField.Builder("createdDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("isEligibleForResponse", GraphQLBoolean.type).build(),
    new CompiledField.Builder("lastUpdatedDateTime", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("media", ReviewMedia.type).selections(__media).build(),
    new CompiledField.Builder("propertyId", new CompiledListType(IdNode.type)).selections(__propertyId).build(),
    new CompiledField.Builder("reservation", ReviewReservation.type).selections(__reservation).build(),
    new CompiledField.Builder("response", OwnerResponse.type).selections(__response).build(),
    new CompiledField.Builder("source", GraphQLString.type).build(),
    new CompiledField.Builder("starRatings", new CompiledNotNullType(new CompiledListType(Rating.type))).selections(__starRatings).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("title", LocalizedString.type).selections(__title).build()
  );

  private static List<CompiledSelection> __reviews = Arrays.asList(
    new CompiledField.Builder("cursor", GraphQLString.type).build(),
    new CompiledField.Builder("reviews", new CompiledNotNullType(new CompiledListType(Review.type))).selections(__reviews1).build(),
    new CompiledField.Builder("totalCount", new CompiledNotNullType(GraphQLInt.type)).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("reviews", new CompiledNotNullType(ReviewResponse.type)).arguments(Arrays.asList(new CompiledArgument.Builder("after", new CompiledVariable("after")).build(), new CompiledArgument.Builder("filter", new CompiledVariable("filter")).build(), new CompiledArgument.Builder("orderBy", new CompiledVariable("orderBy")).build(), new CompiledArgument.Builder("pageSize", new CompiledVariable("pageSize")).build())).selections(__reviews).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}
