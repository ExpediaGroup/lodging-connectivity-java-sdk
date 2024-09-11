//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.EnumType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;

public class ReviewBrand {
  public static EnumType type = new EnumType("ReviewBrand", Arrays.asList("CHEAP_TICKETS", "EBOOKERS", "EXPEDIA", "HOTELS", "HOTWIRE", "LASTMINUTE", "MR_JET", "ORBITZ", "OTHER", "TRAVELOCITY", "VRBO", "WOTIF"));

  public static ReviewBrand CHEAP_TICKETS = new ReviewBrand("CHEAP_TICKETS");

  public static ReviewBrand EBOOKERS = new ReviewBrand("EBOOKERS");

  public static ReviewBrand EXPEDIA = new ReviewBrand("EXPEDIA");

  public static ReviewBrand HOTELS = new ReviewBrand("HOTELS");

  public static ReviewBrand HOTWIRE = new ReviewBrand("HOTWIRE");

  public static ReviewBrand LASTMINUTE = new ReviewBrand("LASTMINUTE");

  public static ReviewBrand MR_JET = new ReviewBrand("MR_JET");

  public static ReviewBrand ORBITZ = new ReviewBrand("ORBITZ");

  public static ReviewBrand OTHER = new ReviewBrand("OTHER");

  public static ReviewBrand TRAVELOCITY = new ReviewBrand("TRAVELOCITY");

  public static ReviewBrand VRBO = new ReviewBrand("VRBO");

  public static ReviewBrand WOTIF = new ReviewBrand("WOTIF");

  public String rawValue;

  public ReviewBrand(String rawValue) {
    this.rawValue = rawValue;
  }

  public static ReviewBrand safeValueOf(String rawValue) {
    switch(rawValue) {
      case "CHEAP_TICKETS": return ReviewBrand.CHEAP_TICKETS;
      case "EBOOKERS": return ReviewBrand.EBOOKERS;
      case "EXPEDIA": return ReviewBrand.EXPEDIA;
      case "HOTELS": return ReviewBrand.HOTELS;
      case "HOTWIRE": return ReviewBrand.HOTWIRE;
      case "LASTMINUTE": return ReviewBrand.LASTMINUTE;
      case "MR_JET": return ReviewBrand.MR_JET;
      case "ORBITZ": return ReviewBrand.ORBITZ;
      case "OTHER": return ReviewBrand.OTHER;
      case "TRAVELOCITY": return ReviewBrand.TRAVELOCITY;
      case "VRBO": return ReviewBrand.VRBO;
      case "WOTIF": return ReviewBrand.WOTIF;
      default: return new ReviewBrand.UNKNOWN__(rawValue);
    }
  }

  /**
   * An enum value that wasn't known at compile time.
   */
  public static class UNKNOWN__ extends ReviewBrand {
    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UNKNOWN__(String rawValue) {
      super(rawValue);
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UNKNOWN__) {
        return true;
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UNKNOWN__{"
          + "}";
      }
      return $toString;
    }
  }
}
