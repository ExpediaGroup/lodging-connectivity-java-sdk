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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GuestRating;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Rating;
import java.util.Arrays;
import java.util.List;

public class RateGuestMutationSelections {
  private static List<CompiledSelection> __starRatings = Arrays.asList(
    new CompiledField.Builder("category", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __rateGuest = Arrays.asList(
    new CompiledField.Builder("recommendGuest", GraphQLBoolean.type).build(),
    new CompiledField.Builder("starRatings", new CompiledNotNullType(new CompiledListType(Rating.type))).selections(__starRatings).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("rateGuest", GuestRating.type).arguments(Arrays.asList(new CompiledArgument.Builder("input", new CompiledVariable("input")).build(), new CompiledArgument.Builder("propertyId", new CompiledVariable("propertyId")).build(), new CompiledArgument.Builder("propertyIdSource", new CompiledVariable("propertyIdSource")).build())).selections(__rateGuest).build()
  );
}
