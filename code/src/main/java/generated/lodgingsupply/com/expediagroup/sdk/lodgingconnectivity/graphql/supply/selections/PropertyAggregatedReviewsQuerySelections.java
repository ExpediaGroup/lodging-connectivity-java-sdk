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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AggregatedReviewBrandScore;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AggregatedReviewsResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLFloat;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewAggregatedScore;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewBrand;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewCategoryScore;
import java.util.Arrays;
import java.util.List;

public class PropertyAggregatedReviewsQuerySelections {
  private static List<CompiledSelection> __value = Arrays.asList(
    new CompiledField.Builder("reviewsCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("score", new CompiledNotNullType(GraphQLFloat.type)).build()
  );

  private static List<CompiledSelection> __categoriesWithScore = Arrays.asList(
    new CompiledField.Builder("category", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(ReviewAggregatedScore.type)).selections(__value).build()
  );

  private static List<CompiledSelection> __brandsWithScores = Arrays.asList(
    new CompiledField.Builder("brandName", new CompiledNotNullType(ReviewBrand.type)).build(),
    new CompiledField.Builder("categoriesWithScore", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(ReviewCategoryScore.type)))).selections(__categoriesWithScore).build(),
    new CompiledField.Builder("totalReviewsCount", new CompiledNotNullType(GraphQLInt.type)).build()
  );

  private static List<CompiledSelection> __aggregatedReviews = Arrays.asList(
    new CompiledField.Builder("brandsWithScores", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(AggregatedReviewBrandScore.type)))).selections(__brandsWithScores).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("aggregatedReviews", AggregatedReviewsResponse.type).arguments(Arrays.asList(new CompiledArgument.Builder(Property.__aggregatedReviews_filters).value(new CompiledVariable("filters")).build())).selections(__aggregatedReviews).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder(Query.__property_id).value(new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}
