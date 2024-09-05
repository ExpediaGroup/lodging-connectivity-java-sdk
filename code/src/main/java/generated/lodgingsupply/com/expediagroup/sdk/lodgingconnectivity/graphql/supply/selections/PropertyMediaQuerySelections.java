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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Image;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ImageSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ImagesResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Locale;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LocalizedString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Media;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Status;
import java.util.Arrays;
import java.util.List;

public class PropertyMediaQuerySelections {
  private static List<CompiledSelection> __captions = Arrays.asList(
    new CompiledField.Builder("locale", new CompiledNotNullType(Locale.type)).build(),
    new CompiledField.Builder("value", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __status = Arrays.asList(
    new CompiledField.Builder("reason", GraphQLString.type).build(),
    new CompiledField.Builder("type", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __elements = Arrays.asList(
    new CompiledField.Builder("active", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("captions", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(LocalizedString.type)))).selections(__captions).build(),
    new CompiledField.Builder("featured", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("fileName", GraphQLString.type).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("order", GraphQLInt.type).build(),
    new CompiledField.Builder("originalUrl", GraphQLString.type).build(),
    new CompiledField.Builder("publishedUrl", GraphQLString.type).build(),
    new CompiledField.Builder("rotation", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("source", new CompiledNotNullType(ImageSource.type)).build(),
    new CompiledField.Builder("status", new CompiledNotNullType(Status.type)).selections(__status).build(),
    new CompiledField.Builder("updatedDate", new CompiledNotNullType(DateTime.type)).build()
  );

  private static List<CompiledSelection> __images = Arrays.asList(
    new CompiledField.Builder("elements", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(Image.type)))).selections(__elements).build(),
    new CompiledField.Builder("totalCount", new CompiledNotNullType(GraphQLInt.type)).build()
  );

  private static List<CompiledSelection> __media = Arrays.asList(
    new CompiledField.Builder("images", ImagesResponse.type).arguments(Arrays.asList(new CompiledArgument.Builder("filters", new CompiledVariable("filters")).build())).selections(__images).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("media", new CompiledNotNullType(Media.type)).selections(__media).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}
