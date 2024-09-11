//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyReviewsQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ReviewBrand;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.IdSource_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ReviewBrand_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PropertyReviewsQuery_ResponseAdapter {
  public enum Data implements Adapter<PropertyReviewsQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("property");

    @Override
    public PropertyReviewsQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyReviewsQuery.Property _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _property = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyReviewsQuery.Data(
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Data value) throws IOException {
      writer.name("property");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<PropertyReviewsQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("reviews");

    @Override
    public PropertyReviewsQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyReviewsQuery.Reviews _reviews = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _reviews = new ObjectAdapter<PropertyReviewsQuery.Reviews>(Reviews.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_reviews, "reviews");

      return new PropertyReviewsQuery.Property(
        _reviews
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Property value) throws IOException {
      writer.name("reviews");
      new ObjectAdapter<PropertyReviewsQuery.Reviews>(Reviews.INSTANCE, false).toJson(writer, customScalarAdapters, value.reviews);
    }
  }

  public enum Reviews implements Adapter<PropertyReviewsQuery.Reviews> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cursor", "reviews", "totalCount");

    @Override
    public PropertyReviewsQuery.Reviews fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _cursor = null;
      List<PropertyReviewsQuery.Review> _reviews = null;
      Integer _totalCount = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cursor = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _reviews = new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Review>(Review.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 2: _totalCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_reviews, "reviews");
      Assertions.checkFieldNotMissing(_totalCount, "totalCount");

      return new PropertyReviewsQuery.Reviews(
        _cursor,
        _reviews,
        _totalCount
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Reviews value) throws IOException {
      writer.name("cursor");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.cursor);

      writer.name("reviews");
      new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Review>(Review.INSTANCE, false))).toJson(writer, customScalarAdapters, value.reviews);

      writer.name("totalCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalCount);
    }
  }

  public enum Review implements Adapter<PropertyReviewsQuery.Review> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("body", "brandNameV2", "createdDateTime", "id", "isEligibleForResponse", "lastUpdatedDateTime", "media", "propertyId", "reservation", "response", "source", "starRatings", "status", "title");

    @Override
    public PropertyReviewsQuery.Review fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyReviewsQuery.Body _body = null;
      ReviewBrand _brandNameV2 = null;
      String _createdDateTime = null;
      String _id = null;
      Boolean _isEligibleForResponse = null;
      String _lastUpdatedDateTime = null;
      PropertyReviewsQuery.Media _media = null;
      List<PropertyReviewsQuery.PropertyId> _propertyId = null;
      PropertyReviewsQuery.Reservation _reservation = null;
      PropertyReviewsQuery.Response _response = null;
      String _source = null;
      List<PropertyReviewsQuery.StarRating> _starRatings = null;
      String _status = null;
      PropertyReviewsQuery.Title _title = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _body = new ObjectAdapter<PropertyReviewsQuery.Body>(Body.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _brandNameV2 = new NullableAdapter<>(ReviewBrand_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _createdDateTime = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _isEligibleForResponse = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _lastUpdatedDateTime = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _media = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Media>(Media.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 7: _propertyId = new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.PropertyId>(PropertyId.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          case 8: _reservation = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Reservation>(Reservation.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 9: _response = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Response>(Response.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 10: _source = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 11: _starRatings = new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.StarRating>(StarRating.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 12: _status = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 13: _title = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Title>(Title.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_body, "body");
      Assertions.checkFieldNotMissing(_createdDateTime, "createdDateTime");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_lastUpdatedDateTime, "lastUpdatedDateTime");
      Assertions.checkFieldNotMissing(_starRatings, "starRatings");
      Assertions.checkFieldNotMissing(_status, "status");

      return new PropertyReviewsQuery.Review(
        _body,
        _brandNameV2,
        _createdDateTime,
        _id,
        _isEligibleForResponse,
        _lastUpdatedDateTime,
        _media,
        _propertyId,
        _reservation,
        _response,
        _source,
        _starRatings,
        _status,
        _title
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Review value) throws IOException {
      writer.name("body");
      new ObjectAdapter<PropertyReviewsQuery.Body>(Body.INSTANCE, false).toJson(writer, customScalarAdapters, value.body);

      writer.name("brandNameV2");
      new NullableAdapter<>(ReviewBrand_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.brandNameV2);

      writer.name("createdDateTime");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.createdDateTime);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("isEligibleForResponse");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isEligibleForResponse);

      writer.name("lastUpdatedDateTime");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.lastUpdatedDateTime);

      writer.name("media");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Media>(Media.INSTANCE, false)).toJson(writer, customScalarAdapters, value.media);

      writer.name("propertyId");
      new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.PropertyId>(PropertyId.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.propertyId);

      writer.name("reservation");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Reservation>(Reservation.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservation);

      writer.name("response");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Response>(Response.INSTANCE, false)).toJson(writer, customScalarAdapters, value.response);

      writer.name("source");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.source);

      writer.name("starRatings");
      new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.StarRating>(StarRating.INSTANCE, false))).toJson(writer, customScalarAdapters, value.starRatings);

      writer.name("status");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.status);

      writer.name("title");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Title>(Title.INSTANCE, false)).toJson(writer, customScalarAdapters, value.title);
    }
  }

  public enum Body implements Adapter<PropertyReviewsQuery.Body> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public PropertyReviewsQuery.Body fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _locale = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_locale, "locale");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyReviewsQuery.Body(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Body value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum Media implements Adapter<PropertyReviewsQuery.Media> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("caption", "highResolutionUrl", "thumbnailUrl");

    @Override
    public PropertyReviewsQuery.Media fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyReviewsQuery.Caption _caption = null;
      String _highResolutionUrl = null;
      String _thumbnailUrl = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _caption = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Caption>(Caption.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _highResolutionUrl = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _thumbnailUrl = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyReviewsQuery.Media(
        _caption,
        _highResolutionUrl,
        _thumbnailUrl
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Media value) throws IOException {
      writer.name("caption");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.Caption>(Caption.INSTANCE, false)).toJson(writer, customScalarAdapters, value.caption);

      writer.name("highResolutionUrl");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.highResolutionUrl);

      writer.name("thumbnailUrl");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.thumbnailUrl);
    }
  }

  public enum Caption implements Adapter<PropertyReviewsQuery.Caption> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public PropertyReviewsQuery.Caption fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _locale = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_locale, "locale");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyReviewsQuery.Caption(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Caption value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum PropertyId implements Adapter<PropertyReviewsQuery.PropertyId> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "idSource");

    @Override
    public PropertyReviewsQuery.PropertyId fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      IdSource _idSource = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _idSource = IdSource_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_idSource, "idSource");

      return new PropertyReviewsQuery.PropertyId(
        _id,
        _idSource
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.PropertyId value) throws IOException {
      writer.name("id");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("idSource");
      IdSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.idSource);
    }
  }

  public enum Reservation implements Adapter<PropertyReviewsQuery.Reservation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("checkInDate", "checkOutDate", "primaryGuest", "reservationIds", "status");

    @Override
    public PropertyReviewsQuery.Reservation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      LocalDate _checkInDate = null;
      LocalDate _checkOutDate = null;
      PropertyReviewsQuery.PrimaryGuest _primaryGuest = null;
      List<PropertyReviewsQuery.ReservationId> _reservationIds = null;
      String _status = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _checkInDate = new NullableAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 1: _checkOutDate = new NullableAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _primaryGuest = new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.PrimaryGuest>(PrimaryGuest.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 3: _reservationIds = new ListAdapter<>(new ObjectAdapter<PropertyReviewsQuery.ReservationId>(ReservationId.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 4: _status = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_reservationIds, "reservationIds");

      return new PropertyReviewsQuery.Reservation(
        _checkInDate,
        _checkOutDate,
        _primaryGuest,
        _reservationIds,
        _status
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Reservation value) throws IOException {
      writer.name("checkInDate");
      new NullableAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      new NullableAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkOutDate);

      writer.name("primaryGuest");
      new NullableAdapter<>(new ObjectAdapter<PropertyReviewsQuery.PrimaryGuest>(PrimaryGuest.INSTANCE, false)).toJson(writer, customScalarAdapters, value.primaryGuest);

      writer.name("reservationIds");
      new ListAdapter<>(new ObjectAdapter<PropertyReviewsQuery.ReservationId>(ReservationId.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservationIds);

      writer.name("status");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.status);
    }
  }

  public enum PrimaryGuest implements Adapter<PropertyReviewsQuery.PrimaryGuest> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("firstName", "lastName");

    @Override
    public PropertyReviewsQuery.PrimaryGuest fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _firstName = null;
      String _lastName = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _firstName = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _lastName = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_firstName, "firstName");
      Assertions.checkFieldNotMissing(_lastName, "lastName");

      return new PropertyReviewsQuery.PrimaryGuest(
        _firstName,
        _lastName
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.PrimaryGuest value) throws IOException {
      writer.name("firstName");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.firstName);

      writer.name("lastName");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.lastName);
    }
  }

  public enum ReservationId implements Adapter<PropertyReviewsQuery.ReservationId> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "idSource");

    @Override
    public PropertyReviewsQuery.ReservationId fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      IdSource _idSource = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _idSource = IdSource_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_idSource, "idSource");

      return new PropertyReviewsQuery.ReservationId(
        _id,
        _idSource
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.ReservationId value) throws IOException {
      writer.name("id");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("idSource");
      IdSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.idSource);
    }
  }

  public enum Response implements Adapter<PropertyReviewsQuery.Response> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("body", "createdDateTime", "lastUpdatedDateTime", "status");

    @Override
    public PropertyReviewsQuery.Response fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyReviewsQuery.Body1 _body = null;
      String _createdDateTime = null;
      String _lastUpdatedDateTime = null;
      String _status = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _body = new ObjectAdapter<PropertyReviewsQuery.Body1>(Body1.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _createdDateTime = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _lastUpdatedDateTime = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _status = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_body, "body");
      Assertions.checkFieldNotMissing(_createdDateTime, "createdDateTime");
      Assertions.checkFieldNotMissing(_lastUpdatedDateTime, "lastUpdatedDateTime");
      Assertions.checkFieldNotMissing(_status, "status");

      return new PropertyReviewsQuery.Response(
        _body,
        _createdDateTime,
        _lastUpdatedDateTime,
        _status
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Response value) throws IOException {
      writer.name("body");
      new ObjectAdapter<PropertyReviewsQuery.Body1>(Body1.INSTANCE, false).toJson(writer, customScalarAdapters, value.body);

      writer.name("createdDateTime");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.createdDateTime);

      writer.name("lastUpdatedDateTime");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.lastUpdatedDateTime);

      writer.name("status");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.status);
    }
  }

  public enum Body1 implements Adapter<PropertyReviewsQuery.Body1> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public PropertyReviewsQuery.Body1 fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _locale = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_locale, "locale");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyReviewsQuery.Body1(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Body1 value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum StarRating implements Adapter<PropertyReviewsQuery.StarRating> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("category", "value");

    @Override
    public PropertyReviewsQuery.StarRating fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _category = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _category = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_category, "category");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyReviewsQuery.StarRating(
        _category,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.StarRating value) throws IOException {
      writer.name("category");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.category);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum Title implements Adapter<PropertyReviewsQuery.Title> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public PropertyReviewsQuery.Title fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _locale = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_locale, "locale");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyReviewsQuery.Title(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyReviewsQuery.Title value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }
}
