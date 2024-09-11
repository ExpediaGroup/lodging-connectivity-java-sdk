//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.Assertions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyMessagesQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageReviewStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadParticipantRole;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.MessageReviewStatus_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.MessageThreadParticipantRole_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PropertyMessagesQuery_ResponseAdapter {
  public enum Data implements Adapter<PropertyMessagesQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("property");

    @Override
    public PropertyMessagesQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyMessagesQuery.Property _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _property = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyMessagesQuery.Data(
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Data value) throws IOException {
      writer.name("property");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<PropertyMessagesQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("messages");

    @Override
    public PropertyMessagesQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyMessagesQuery.Messages _messages = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _messages = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Messages>(Messages.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyMessagesQuery.Property(
        _messages
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Property value) throws IOException {
      writer.name("messages");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Messages>(Messages.INSTANCE, false)).toJson(writer, customScalarAdapters, value.messages);
    }
  }

  public enum Messages implements Adapter<PropertyMessagesQuery.Messages> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cursor", "totalCount", "elements");

    @Override
    public PropertyMessagesQuery.Messages fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _cursor = null;
      Integer _totalCount = null;
      List<PropertyMessagesQuery.Element> _elements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cursor = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _totalCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _elements = new ListAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Element>(Element.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_totalCount, "totalCount");
      Assertions.checkFieldNotMissing(_elements, "elements");

      return new PropertyMessagesQuery.Messages(
        _cursor,
        _totalCount,
        _elements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Messages value) throws IOException {
      writer.name("cursor");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.cursor);

      writer.name("totalCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalCount);

      writer.name("elements");
      new ListAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Element>(Element.INSTANCE, false)).toJson(writer, customScalarAdapters, value.elements);
    }
  }

  public enum Element implements Adapter<PropertyMessagesQuery.Element> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("attachments", "body", "creationDateTimeUtc", "fromRole", "id", "reviewStatus", "type", "messageThread");

    @Override
    public PropertyMessagesQuery.Element fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<PropertyMessagesQuery.Attachment> _attachments = null;
      PropertyMessagesQuery.Body _body = null;
      Object _creationDateTimeUtc = null;
      MessageThreadParticipantRole _fromRole = null;
      String _id = null;
      MessageReviewStatus _reviewStatus = null;
      String _type = null;
      PropertyMessagesQuery.MessageThread _messageThread = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _attachments = new ListAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Attachment>(Attachment.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _body = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Body>(Body.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 2: _creationDateTimeUtc = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _fromRole = new NullableAdapter<>(MessageThreadParticipantRole_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 4: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _reviewStatus = new NullableAdapter<>(MessageReviewStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 6: _type = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 7: _messageThread = new ObjectAdapter<PropertyMessagesQuery.MessageThread>(MessageThread.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_attachments, "attachments");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_messageThread, "messageThread");

      return new PropertyMessagesQuery.Element(
        _attachments,
        _body,
        _creationDateTimeUtc,
        _fromRole,
        _id,
        _reviewStatus,
        _type,
        _messageThread
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Element value) throws IOException {
      writer.name("attachments");
      new ListAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Attachment>(Attachment.INSTANCE, false)).toJson(writer, customScalarAdapters, value.attachments);

      writer.name("body");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.Body>(Body.INSTANCE, false)).toJson(writer, customScalarAdapters, value.body);

      writer.name("creationDateTimeUtc");
      Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.creationDateTimeUtc);

      writer.name("fromRole");
      new NullableAdapter<>(MessageThreadParticipantRole_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.fromRole);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("reviewStatus");
      new NullableAdapter<>(MessageReviewStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.reviewStatus);

      writer.name("type");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.type);

      writer.name("messageThread");
      new ObjectAdapter<PropertyMessagesQuery.MessageThread>(MessageThread.INSTANCE, false).toJson(writer, customScalarAdapters, value.messageThread);
    }
  }

  public enum Attachment implements Adapter<PropertyMessagesQuery.Attachment> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "uploadDateTimeUtc", "url");

    @Override
    public PropertyMessagesQuery.Attachment fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _name = null;
      Object _uploadDateTimeUtc = null;
      URL _url = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _uploadDateTimeUtc = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _url = com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_uploadDateTimeUtc, "uploadDateTimeUtc");
      Assertions.checkFieldNotMissing(_url, "url");

      return new PropertyMessagesQuery.Attachment(
        _id,
        _name,
        _uploadDateTimeUtc,
        _url
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Attachment value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);

      writer.name("uploadDateTimeUtc");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.uploadDateTimeUtc);

      writer.name("url");
      com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.url);
    }
  }

  public enum Body implements Adapter<PropertyMessagesQuery.Body> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("value");

    @Override
    public PropertyMessagesQuery.Body fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyMessagesQuery.Body(
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.Body value) throws IOException {
      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum MessageThread implements Adapter<PropertyMessagesQuery.MessageThread> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("bookingInquiry", "creationDateTimeUtc", "id", "primaryTraveler", "reservationSummary");

    @Override
    public PropertyMessagesQuery.MessageThread fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyMessagesQuery.BookingInquiry _bookingInquiry = null;
      Object _creationDateTimeUtc = null;
      String _id = null;
      PropertyMessagesQuery.PrimaryTraveler _primaryTraveler = null;
      PropertyMessagesQuery.ReservationSummary _reservationSummary = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _bookingInquiry = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.BookingInquiry>(BookingInquiry.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _creationDateTimeUtc = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _primaryTraveler = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.PrimaryTraveler>(PrimaryTraveler.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 4: _reservationSummary = new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.ReservationSummary>(ReservationSummary.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new PropertyMessagesQuery.MessageThread(
        _bookingInquiry,
        _creationDateTimeUtc,
        _id,
        _primaryTraveler,
        _reservationSummary
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.MessageThread value) throws IOException {
      writer.name("bookingInquiry");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.BookingInquiry>(BookingInquiry.INSTANCE, false)).toJson(writer, customScalarAdapters, value.bookingInquiry);

      writer.name("creationDateTimeUtc");
      Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.creationDateTimeUtc);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("primaryTraveler");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.PrimaryTraveler>(PrimaryTraveler.INSTANCE, false)).toJson(writer, customScalarAdapters, value.primaryTraveler);

      writer.name("reservationSummary");
      new NullableAdapter<>(new ObjectAdapter<PropertyMessagesQuery.ReservationSummary>(ReservationSummary.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservationSummary);
    }
  }

  public enum BookingInquiry implements Adapter<PropertyMessagesQuery.BookingInquiry> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("adultCount", "checkInDate", "checkOutDate", "childCount", "hasPets", "id");

    @Override
    public PropertyMessagesQuery.BookingInquiry fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Integer _adultCount = null;
      LocalDate _checkInDate = null;
      LocalDate _checkOutDate = null;
      Integer _childCount = null;
      Boolean _hasPets = null;
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _adultCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _checkInDate = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _checkOutDate = new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 3: _childCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _hasPets = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_adultCount, "adultCount");
      Assertions.checkFieldNotMissing(_childCount, "childCount");
      Assertions.checkFieldNotMissing(_hasPets, "hasPets");
      Assertions.checkFieldNotMissing(_id, "id");

      return new PropertyMessagesQuery.BookingInquiry(
        _adultCount,
        _checkInDate,
        _checkOutDate,
        _childCount,
        _hasPets,
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.BookingInquiry value) throws IOException {
      writer.name("adultCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.adultCount);

      writer.name("checkInDate");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      new NullableAdapter<>(com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkOutDate);

      writer.name("childCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.childCount);

      writer.name("hasPets");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.hasPets);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }

  public enum PrimaryTraveler implements Adapter<PropertyMessagesQuery.PrimaryTraveler> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("firstName", "lastName");

    @Override
    public PropertyMessagesQuery.PrimaryTraveler fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _firstName = null;
      String _lastName = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _firstName = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _lastName = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyMessagesQuery.PrimaryTraveler(
        _firstName,
        _lastName
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.PrimaryTraveler value) throws IOException {
      writer.name("firstName");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.firstName);

      writer.name("lastName");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.lastName);
    }
  }

  public enum ReservationSummary implements Adapter<PropertyMessagesQuery.ReservationSummary> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("adultCount", "alternativeIds", "checkInDate", "checkOutDate", "childCount", "id", "petCount");

    @Override
    public PropertyMessagesQuery.ReservationSummary fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Integer _adultCount = null;
      PropertyMessagesQuery.AlternativeIds _alternativeIds = null;
      LocalDate _checkInDate = null;
      LocalDate _checkOutDate = null;
      Integer _childCount = null;
      String _id = null;
      Integer _petCount = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _adultCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _alternativeIds = new ObjectAdapter<PropertyMessagesQuery.AlternativeIds>(AlternativeIds.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 2: _checkInDate = com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 3: _checkOutDate = com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 4: _childCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _petCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_adultCount, "adultCount");
      Assertions.checkFieldNotMissing(_alternativeIds, "alternativeIds");
      Assertions.checkFieldNotMissing(_checkInDate, "checkInDate");
      Assertions.checkFieldNotMissing(_checkOutDate, "checkOutDate");
      Assertions.checkFieldNotMissing(_childCount, "childCount");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_petCount, "petCount");

      return new PropertyMessagesQuery.ReservationSummary(
        _adultCount,
        _alternativeIds,
        _checkInDate,
        _checkOutDate,
        _childCount,
        _id,
        _petCount
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.ReservationSummary value) throws IOException {
      writer.name("adultCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.adultCount);

      writer.name("alternativeIds");
      new ObjectAdapter<PropertyMessagesQuery.AlternativeIds>(AlternativeIds.INSTANCE, false).toJson(writer, customScalarAdapters, value.alternativeIds);

      writer.name("checkInDate");
      com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      com.apollographql.apollo3.adapter.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkOutDate);

      writer.name("childCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.childCount);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("petCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.petCount);
    }
  }

  public enum AlternativeIds implements Adapter<PropertyMessagesQuery.AlternativeIds> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("supplierId");

    @Override
    public PropertyMessagesQuery.AlternativeIds fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _supplierId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _supplierId = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_supplierId, "supplierId");

      return new PropertyMessagesQuery.AlternativeIds(
        _supplierId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyMessagesQuery.AlternativeIds value) throws IOException {
      writer.name("supplierId");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.supplierId);
    }
  }
}
