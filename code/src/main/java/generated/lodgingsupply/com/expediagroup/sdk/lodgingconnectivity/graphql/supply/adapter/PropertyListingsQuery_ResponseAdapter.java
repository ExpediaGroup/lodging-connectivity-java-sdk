//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyListingsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PropertyListingsQuery_ResponseAdapter {
  public enum Data implements Adapter<PropertyListingsQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("property");

    @Override
    public PropertyListingsQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<PropertyListingsQuery.Property> _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _property = new OptionalAdapter<>(new ObjectAdapter<PropertyListingsQuery.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyListingsQuery.Data(
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyListingsQuery.Data value) throws IOException {
      writer.name("property");
      new OptionalAdapter<>(new ObjectAdapter<PropertyListingsQuery.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<PropertyListingsQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("listings");

    @Override
    public PropertyListingsQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<List<Optional<PropertyListingsQuery.Listing>>> _listings = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _listings = new OptionalAdapter<>(new ListAdapter<>(new OptionalAdapter<>(new ObjectAdapter<PropertyListingsQuery.Listing>(Listing.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyListingsQuery.Property(
        _listings
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyListingsQuery.Property value) throws IOException {
      writer.name("listings");
      new OptionalAdapter<>(new ListAdapter<>(new OptionalAdapter<>(new ObjectAdapter<PropertyListingsQuery.Listing>(Listing.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.listings);
    }
  }

  public enum Listing implements Adapter<PropertyListingsQuery.Listing> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "url");

    @Override
    public PropertyListingsQuery.Listing fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _locale = null;
      Optional<String> _url = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _url = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyListingsQuery.Listing(
        _locale,
        _url
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyListingsQuery.Listing value) throws IOException {
      writer.name("locale");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("url");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.url);
    }
  }
}
