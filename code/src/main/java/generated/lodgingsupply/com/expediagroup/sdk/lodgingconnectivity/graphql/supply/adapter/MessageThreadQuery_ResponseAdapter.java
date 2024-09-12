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
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.MessageThreadQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageReviewStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadParticipantRole;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.MessageReviewStatus_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.MessageThreadParticipantRole_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.OptionalAdapters;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MessageThreadQuery_ResponseAdapter {
  public enum Data implements Adapter<MessageThreadQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("messageThread");

    @Override
    public MessageThreadQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<MessageThreadQuery.MessageThread> _messageThread = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _messageThread = new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.MessageThread>(MessageThread.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new MessageThreadQuery.Data(
        _messageThread
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Data value) throws IOException {
      writer.name("messageThread");
      new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.MessageThread>(MessageThread.INSTANCE, false)).toJson(writer, customScalarAdapters, value.messageThread);
    }
  }

  public enum MessageThread implements Adapter<MessageThreadQuery.MessageThread> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "creationDateTimeUtc", "bookingInquiry", "property", "primaryTraveler", "reservationSummary", "messages");

    @Override
    public MessageThreadQuery.MessageThread fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      Optional<OffsetDateTime> _creationDateTimeUtc = null;
      Optional<MessageThreadQuery.BookingInquiry> _bookingInquiry = null;
      MessageThreadQuery.Property _property = null;
      Optional<MessageThreadQuery.PrimaryTraveler> _primaryTraveler = null;
      Optional<MessageThreadQuery.ReservationSummary> _reservationSummary = null;
      MessageThreadQuery.Messages _messages = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _creationDateTimeUtc = new OptionalAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _bookingInquiry = new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.BookingInquiry>(BookingInquiry.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 3: _property = new ObjectAdapter<MessageThreadQuery.Property>(Property.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 4: _primaryTraveler = new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.PrimaryTraveler>(PrimaryTraveler.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 5: _reservationSummary = new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.ReservationSummary>(ReservationSummary.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 6: _messages = new ObjectAdapter<MessageThreadQuery.Messages>(Messages.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_property, "property");
      Assertions.checkFieldNotMissing(_messages, "messages");

      return new MessageThreadQuery.MessageThread(
        _id,
        _creationDateTimeUtc,
        _bookingInquiry,
        _property,
        _primaryTraveler,
        _reservationSummary,
        _messages
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.MessageThread value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("creationDateTimeUtc");
      new OptionalAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.creationDateTimeUtc);

      writer.name("bookingInquiry");
      new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.BookingInquiry>(BookingInquiry.INSTANCE, false)).toJson(writer, customScalarAdapters, value.bookingInquiry);

      writer.name("property");
      new ObjectAdapter<MessageThreadQuery.Property>(Property.INSTANCE, false).toJson(writer, customScalarAdapters, value.property);

      writer.name("primaryTraveler");
      new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.PrimaryTraveler>(PrimaryTraveler.INSTANCE, false)).toJson(writer, customScalarAdapters, value.primaryTraveler);

      writer.name("reservationSummary");
      new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.ReservationSummary>(ReservationSummary.INSTANCE, false)).toJson(writer, customScalarAdapters, value.reservationSummary);

      writer.name("messages");
      new ObjectAdapter<MessageThreadQuery.Messages>(Messages.INSTANCE, false).toJson(writer, customScalarAdapters, value.messages);
    }
  }

  public enum BookingInquiry implements Adapter<MessageThreadQuery.BookingInquiry> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("adultCount", "checkInDate", "checkOutDate", "childCount", "hasPets", "id");

    @Override
    public MessageThreadQuery.BookingInquiry fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Integer _adultCount = null;
      Optional<LocalDate> _checkInDate = null;
      Optional<LocalDate> _checkOutDate = null;
      Integer _childCount = null;
      Boolean _hasPets = null;
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _adultCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _checkInDate = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 2: _checkOutDate = new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
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

      return new MessageThreadQuery.BookingInquiry(
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
        MessageThreadQuery.BookingInquiry value) throws IOException {
      writer.name("adultCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.adultCount);

      writer.name("checkInDate");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      new OptionalAdapter<>(com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.checkOutDate);

      writer.name("childCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.childCount);

      writer.name("hasPets");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.hasPets);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }

  public enum Property implements Adapter<MessageThreadQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public MessageThreadQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new MessageThreadQuery.Property(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Property value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }

  public enum PrimaryTraveler implements Adapter<MessageThreadQuery.PrimaryTraveler> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("firstName", "lastName");

    @Override
    public MessageThreadQuery.PrimaryTraveler fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _firstName = null;
      Optional<String> _lastName = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _firstName = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _lastName = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new MessageThreadQuery.PrimaryTraveler(
        _firstName,
        _lastName
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.PrimaryTraveler value) throws IOException {
      writer.name("firstName");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.firstName);

      writer.name("lastName");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.lastName);
    }
  }

  public enum ReservationSummary implements Adapter<MessageThreadQuery.ReservationSummary> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("adultCount", "alternativeIds", "checkInDate", "checkOutDate", "childCount", "id", "petCount");

    @Override
    public MessageThreadQuery.ReservationSummary fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Integer _adultCount = null;
      MessageThreadQuery.AlternativeIds _alternativeIds = null;
      LocalDate _checkInDate = null;
      LocalDate _checkOutDate = null;
      Integer _childCount = null;
      String _id = null;
      Integer _petCount = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _adultCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _alternativeIds = new ObjectAdapter<MessageThreadQuery.AlternativeIds>(AlternativeIds.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 2: _checkInDate = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 3: _checkOutDate = com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
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

      return new MessageThreadQuery.ReservationSummary(
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
        MessageThreadQuery.ReservationSummary value) throws IOException {
      writer.name("adultCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.adultCount);

      writer.name("alternativeIds");
      new ObjectAdapter<MessageThreadQuery.AlternativeIds>(AlternativeIds.INSTANCE, false).toJson(writer, customScalarAdapters, value.alternativeIds);

      writer.name("checkInDate");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkInDate);

      writer.name("checkOutDate");
      com.apollographql.adapter.core.JavaLocalDateAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.checkOutDate);

      writer.name("childCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.childCount);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("petCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.petCount);
    }
  }

  public enum AlternativeIds implements Adapter<MessageThreadQuery.AlternativeIds> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("supplierId");

    @Override
    public MessageThreadQuery.AlternativeIds fromJson(JsonReader reader,
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

      return new MessageThreadQuery.AlternativeIds(
        _supplierId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.AlternativeIds value) throws IOException {
      writer.name("supplierId");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.supplierId);
    }
  }

  public enum Messages implements Adapter<MessageThreadQuery.Messages> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("cursor", "totalCount", "elements");

    @Override
    public MessageThreadQuery.Messages fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Optional<String> _cursor = null;
      Integer _totalCount = null;
      List<MessageThreadQuery.Element> _elements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _cursor = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _totalCount = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _elements = new ListAdapter<>(new ObjectAdapter<MessageThreadQuery.Element>(Element.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_totalCount, "totalCount");
      Assertions.checkFieldNotMissing(_elements, "elements");

      return new MessageThreadQuery.Messages(
        _cursor,
        _totalCount,
        _elements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Messages value) throws IOException {
      writer.name("cursor");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.cursor);

      writer.name("totalCount");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.totalCount);

      writer.name("elements");
      new ListAdapter<>(new ObjectAdapter<MessageThreadQuery.Element>(Element.INSTANCE, false)).toJson(writer, customScalarAdapters, value.elements);
    }
  }

  public enum Element implements Adapter<MessageThreadQuery.Element> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "type", "creationDateTimeUtc", "fromRole", "reviewStatus", "attachments", "body");

    @Override
    public MessageThreadQuery.Element fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      Optional<String> _type = null;
      Optional<OffsetDateTime> _creationDateTimeUtc = null;
      Optional<MessageThreadParticipantRole> _fromRole = null;
      Optional<MessageReviewStatus> _reviewStatus = null;
      List<MessageThreadQuery.Attachment> _attachments = null;
      Optional<MessageThreadQuery.Body> _body = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = OptionalAdapters.OptionalStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _creationDateTimeUtc = new OptionalAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 3: _fromRole = new OptionalAdapter<>(MessageThreadParticipantRole_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 4: _reviewStatus = new OptionalAdapter<>(MessageReviewStatus_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 5: _attachments = new ListAdapter<>(new ObjectAdapter<MessageThreadQuery.Attachment>(Attachment.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 6: _body = new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.Body>(Body.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_attachments, "attachments");

      return new MessageThreadQuery.Element(
        _id,
        _type,
        _creationDateTimeUtc,
        _fromRole,
        _reviewStatus,
        _attachments,
        _body
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Element value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("type");
      OptionalAdapters.OptionalStringAdapter.toJson(writer, customScalarAdapters, value.type);

      writer.name("creationDateTimeUtc");
      new OptionalAdapter<>(com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.creationDateTimeUtc);

      writer.name("fromRole");
      new OptionalAdapter<>(MessageThreadParticipantRole_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.fromRole);

      writer.name("reviewStatus");
      new OptionalAdapter<>(MessageReviewStatus_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.reviewStatus);

      writer.name("attachments");
      new ListAdapter<>(new ObjectAdapter<MessageThreadQuery.Attachment>(Attachment.INSTANCE, false)).toJson(writer, customScalarAdapters, value.attachments);

      writer.name("body");
      new OptionalAdapter<>(new ObjectAdapter<MessageThreadQuery.Body>(Body.INSTANCE, false)).toJson(writer, customScalarAdapters, value.body);
    }
  }

  public enum Attachment implements Adapter<MessageThreadQuery.Attachment> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "name", "uploadDateTimeUtc", "url");

    @Override
    public MessageThreadQuery.Attachment fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _name = null;
      OffsetDateTime _uploadDateTimeUtc = null;
      URL _url = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _uploadDateTimeUtc = com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 3: _url = com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_name, "name");
      Assertions.checkFieldNotMissing(_uploadDateTimeUtc, "uploadDateTimeUtc");
      Assertions.checkFieldNotMissing(_url, "url");

      return new MessageThreadQuery.Attachment(
        _id,
        _name,
        _uploadDateTimeUtc,
        _url
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Attachment value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("name");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.name);

      writer.name("uploadDateTimeUtc");
      com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.DateTimeAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.uploadDateTimeUtc);

      writer.name("url");
      com.expediagroup.sdk.lodgingconnectivity.graphql.adapter.URLAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.url);
    }
  }

  public enum Body implements Adapter<MessageThreadQuery.Body> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("value");

    @Override
    public MessageThreadQuery.Body fromJson(JsonReader reader,
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

      return new MessageThreadQuery.Body(
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        MessageThreadQuery.Body value) throws IOException {
      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }
}
