//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo.api.CompiledArgumentDefinition;
import com.apollographql.apollo.api.ObjectType;

public class Query {
  public static final CompiledArgumentDefinition __cancellationPolicyConfig_id = new CompiledArgumentDefinition.Builder("id").build();

  public static final CompiledArgumentDefinition __ratePlan_propertyId = new CompiledArgumentDefinition.Builder("propertyId").build();

  public static final CompiledArgumentDefinition __ratePlan_ratePlanId = new CompiledArgumentDefinition.Builder("ratePlanId").build();

  public static final CompiledArgumentDefinition __message_id = new CompiledArgumentDefinition.Builder("id").build();

  public static final CompiledArgumentDefinition __messageThread_id = new CompiledArgumentDefinition.Builder("id").build();

  public static final CompiledArgumentDefinition __undeliveredNotifications_limit = new CompiledArgumentDefinition.Builder("limit").build();

  public static final CompiledArgumentDefinition __undeliveredNotifications_cursor = new CompiledArgumentDefinition.Builder("cursor").build();

  public static final CompiledArgumentDefinition __undeliveredNotifications_filters = new CompiledArgumentDefinition.Builder("filters").build();

  public static final CompiledArgumentDefinition __districtByCoordinates_latitude = new CompiledArgumentDefinition.Builder("latitude").build();

  public static final CompiledArgumentDefinition __districtByCoordinates_locale = new CompiledArgumentDefinition.Builder("locale").build();

  public static final CompiledArgumentDefinition __districtByCoordinates_longitude = new CompiledArgumentDefinition.Builder("longitude").build();

  public static final CompiledArgumentDefinition __property_id = new CompiledArgumentDefinition.Builder("id").build();

  public static final CompiledArgumentDefinition __property_idSource = new CompiledArgumentDefinition.Builder("idSource").build();

  public static final CompiledArgumentDefinition __propertiesByAdvertiser_cursor = new CompiledArgumentDefinition.Builder("cursor").build();

  public static final CompiledArgumentDefinition __propertiesByAdvertiser_id = new CompiledArgumentDefinition.Builder("id").build();

  public static final CompiledArgumentDefinition __propertiesByAdvertiser_idSource = new CompiledArgumentDefinition.Builder("idSource").build();

  public static final CompiledArgumentDefinition __propertiesByAdvertiser_pageSize = new CompiledArgumentDefinition.Builder("pageSize").build();

  public static ObjectType type = (new ObjectType.Builder("Query")).build();
}
