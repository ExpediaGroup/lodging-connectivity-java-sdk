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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLID;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PropertiesByAdvertiserResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query;
import java.util.Arrays;
import java.util.List;

public class PropertiesByAdvertiserQuerySelections {
  private static List<CompiledSelection> __elements = Arrays.asList(
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLID.type)).build(),
    new CompiledField.Builder("name", new CompiledNotNullType(GraphQLString.type)).build()
  );

  private static List<CompiledSelection> __propertiesByAdvertiser = Arrays.asList(
    new CompiledField.Builder("cursor", GraphQLString.type).build(),
    new CompiledField.Builder("totalCount", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("elements", new CompiledNotNullType(new CompiledListType(new CompiledNotNullType(Property.type)))).selections(__elements).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("propertiesByAdvertiser", PropertiesByAdvertiserResponse.type).arguments(Arrays.asList(new CompiledArgument.Builder(Query.__propertiesByAdvertiser_cursor).value(new CompiledVariable("cursor")).build(), new CompiledArgument.Builder(Query.__propertiesByAdvertiser_id).value(new CompiledVariable("id")).build(), new CompiledArgument.Builder(Query.__propertiesByAdvertiser_idSource).value(new CompiledVariable("idSource")).build(), new CompiledArgument.Builder(Query.__propertiesByAdvertiser_pageSize).value(new CompiledVariable("pageSize")).build())).selections(__propertiesByAdvertiser).build()
  );
}
