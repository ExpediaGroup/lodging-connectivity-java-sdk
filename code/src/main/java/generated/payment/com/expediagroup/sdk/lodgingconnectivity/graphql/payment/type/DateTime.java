//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.payment.type;

import com.apollographql.apollo.api.CustomScalarType;

/**
 * Uses format "YYYY-MM-DD'T'HH:MM:SS.SSS±HH:MM", where timezone information is expressed as an offset, as defined in RFC 3339
 */
public class DateTime {
  public static CustomScalarType type = new CustomScalarType("DateTime", "java.time.OffsetDateTime");
}
