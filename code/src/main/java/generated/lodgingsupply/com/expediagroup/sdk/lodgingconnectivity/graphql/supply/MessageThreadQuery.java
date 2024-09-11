//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.MessageThreadQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.MessageThreadQuery_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.MessageThreadQuerySelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageReviewStatus;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadMessagesOrderByInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MessageThreadParticipantRole;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MessageThreadQuery implements Query<MessageThreadQuery.Data> {
  public static final String OPERATION_ID = "c0ca74cf357f310c247566b493af5cd98abe642dde7fde225c5a032ca9f9b860";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query MessageThread($messageThreadId: ID!, $messagesLimit: Int, $messagesCursor: String, $orderMessagesBy: MessageThreadMessagesOrderByInput) {
   *   messageThread(id: $messageThreadId) {
   *     id
   *     creationDateTimeUtc
   *     bookingInquiry {
   *       adultCount
   *       checkInDate
   *       checkOutDate
   *       childCount
   *       hasPets
   *       id
   *     }
   *     property {
   *       id
   *     }
   *     primaryTraveler {
   *       firstName
   *       lastName
   *     }
   *     reservationSummary {
   *       adultCount
   *       alternativeIds {
   *         supplierId
   *       }
   *       checkInDate
   *       checkOutDate
   *       childCount
   *       id
   *       petCount
   *     }
   *     messages(limit: $messagesLimit, cursor: $messagesCursor, orderBy: $orderMessagesBy) {
   *       cursor
   *       totalCount
   *       elements {
   *         id
   *         type
   *         creationDateTimeUtc
   *         fromRole
   *         reviewStatus
   *         attachments {
   *           id
   *           name
   *           uploadDateTimeUtc
   *           url
   *         }
   *         body {
   *           value
   *         }
   *       }
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query MessageThread($messageThreadId: ID!, $messagesLimit: Int, $messagesCursor: String, $orderMessagesBy: MessageThreadMessagesOrderByInput) { messageThread(id: $messageThreadId) { id creationDateTimeUtc bookingInquiry { adultCount checkInDate checkOutDate childCount hasPets id } property { id } primaryTraveler { firstName lastName } reservationSummary { adultCount alternativeIds { supplierId } checkInDate checkOutDate childCount id petCount } messages(limit: $messagesLimit, cursor: $messagesCursor, orderBy: $orderMessagesBy) { cursor totalCount elements { id type creationDateTimeUtc fromRole reviewStatus attachments { id name uploadDateTimeUtc url } body { value } } } } }";

  public static final String OPERATION_NAME = "MessageThread";

  public final String messageThreadId;

  public final Optional<Integer> messagesLimit;

  public final Optional<String> messagesCursor;

  public final Optional<MessageThreadMessagesOrderByInput> orderMessagesBy;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public MessageThreadQuery(String messageThreadId, Optional<Integer> messagesLimit,
      Optional<String> messagesCursor,
      Optional<MessageThreadMessagesOrderByInput> orderMessagesBy) {
    this.messageThreadId = messageThreadId;
    this.messagesLimit = messagesLimit;
    this.messagesCursor = messagesCursor;
    this.orderMessagesBy = orderMessagesBy;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MessageThreadQuery) {
      MessageThreadQuery that = (MessageThreadQuery) o;
      return ((this.messageThreadId == null) ? (that.messageThreadId == null) : this.messageThreadId.equals(that.messageThreadId))
       &&((this.messagesLimit == null) ? (that.messagesLimit == null) : this.messagesLimit.equals(that.messagesLimit))
       &&((this.messagesCursor == null) ? (that.messagesCursor == null) : this.messagesCursor.equals(that.messagesCursor))
       &&((this.orderMessagesBy == null) ? (that.orderMessagesBy == null) : this.orderMessagesBy.equals(that.orderMessagesBy));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (messageThreadId == null) ? 0 : messageThreadId.hashCode();
      __h *= 1000003;
      __h ^= (messagesLimit == null) ? 0 : messagesLimit.hashCode();
      __h *= 1000003;
      __h ^= (messagesCursor == null) ? 0 : messagesCursor.hashCode();
      __h *= 1000003;
      __h ^= (orderMessagesBy == null) ? 0 : orderMessagesBy.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "MessageThreadQuery{"
        + "messageThreadId=" + messageThreadId + ", "
        + "messagesLimit=" + messagesLimit + ", "
        + "messagesCursor=" + messagesCursor + ", "
        + "orderMessagesBy=" + orderMessagesBy
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String id() {
    return OPERATION_ID;
  }

  @Override
  public String document() {
    return OPERATION_DOCUMENT;
  }

  @Override
  public String name() {
    return OPERATION_NAME;
  }

  @Override
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    MessageThreadQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(MessageThreadQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query.type
    )
    .selections(MessageThreadQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    private String messageThreadId;

    private Optional<Integer> messagesLimit = Optional.absent();

    private Optional<String> messagesCursor = Optional.absent();

    private Optional<MessageThreadMessagesOrderByInput> orderMessagesBy = Optional.absent();

    Builder() {
    }

    public Builder messageThreadId(String messageThreadId) {
      this.messageThreadId = messageThreadId;
      return this;
    }

    public Builder messagesLimit(Integer messagesLimit) {
      this.messagesLimit = Optional.present(messagesLimit);
      return this;
    }

    public Builder messagesCursor(String messagesCursor) {
      this.messagesCursor = Optional.present(messagesCursor);
      return this;
    }

    public Builder orderMessagesBy(MessageThreadMessagesOrderByInput orderMessagesBy) {
      this.orderMessagesBy = Optional.present(orderMessagesBy);
      return this;
    }

    public MessageThreadQuery build() {
      return new MessageThreadQuery(messageThreadId, messagesLimit, messagesCursor, orderMessagesBy);
    }
  }

  public static class Data implements Query.Data {
    /**
     * Retrieves a single message thread using its unique identifier.
     */
    public MessageThread messageThread;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(MessageThread messageThread) {
      this.messageThread = messageThread;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.messageThread == null) ? (that.messageThread == null) : this.messageThread.equals(that.messageThread));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (messageThread == null) ? 0 : messageThread.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "messageThread=" + messageThread
          + "}";
      }
      return $toString;
    }
  }

  public static class MessageThread {
    /**
     *  The message thread id 
     */
    public String id;

    /**
     *  Message creation date time in ISO format and UTC timezone
     */
    public Object creationDateTimeUtc;

    /**
     *  Booking Inquiry associated to MessageThread 
     */
    public BookingInquiry bookingInquiry;

    /**
     *  Property Details 
     */
    public Property property;

    /**
     *  Primary Traveler 
     */
    public PrimaryTraveler primaryTraveler;

    /**
     *  Reservation associated to MessageThread 
     */
    public ReservationSummary reservationSummary;

    /**
     *  List of messages 
     */
    public Messages messages;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public MessageThread(String id, Object creationDateTimeUtc, BookingInquiry bookingInquiry,
        Property property, PrimaryTraveler primaryTraveler, ReservationSummary reservationSummary,
        Messages messages) {
      this.id = id;
      this.creationDateTimeUtc = creationDateTimeUtc;
      this.bookingInquiry = bookingInquiry;
      this.property = property;
      this.primaryTraveler = primaryTraveler;
      this.reservationSummary = reservationSummary;
      this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof MessageThread) {
        MessageThread that = (MessageThread) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.creationDateTimeUtc == null) ? (that.creationDateTimeUtc == null) : this.creationDateTimeUtc.equals(that.creationDateTimeUtc))
         &&((this.bookingInquiry == null) ? (that.bookingInquiry == null) : this.bookingInquiry.equals(that.bookingInquiry))
         &&((this.property == null) ? (that.property == null) : this.property.equals(that.property))
         &&((this.primaryTraveler == null) ? (that.primaryTraveler == null) : this.primaryTraveler.equals(that.primaryTraveler))
         &&((this.reservationSummary == null) ? (that.reservationSummary == null) : this.reservationSummary.equals(that.reservationSummary))
         &&((this.messages == null) ? (that.messages == null) : this.messages.equals(that.messages));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (creationDateTimeUtc == null) ? 0 : creationDateTimeUtc.hashCode();
        __h *= 1000003;
        __h ^= (bookingInquiry == null) ? 0 : bookingInquiry.hashCode();
        __h *= 1000003;
        __h ^= (property == null) ? 0 : property.hashCode();
        __h *= 1000003;
        __h ^= (primaryTraveler == null) ? 0 : primaryTraveler.hashCode();
        __h *= 1000003;
        __h ^= (reservationSummary == null) ? 0 : reservationSummary.hashCode();
        __h *= 1000003;
        __h ^= (messages == null) ? 0 : messages.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "MessageThread{"
          + "id=" + id + ", "
          + "creationDateTimeUtc=" + creationDateTimeUtc + ", "
          + "bookingInquiry=" + bookingInquiry + ", "
          + "property=" + property + ", "
          + "primaryTraveler=" + primaryTraveler + ", "
          + "reservationSummary=" + reservationSummary + ", "
          + "messages=" + messages
          + "}";
      }
      return $toString;
    }
  }

  public static class BookingInquiry {
    public Integer adultCount;

    public LocalDate checkInDate;

    public LocalDate checkOutDate;

    public Integer childCount;

    public Boolean hasPets;

    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public BookingInquiry(Integer adultCount, LocalDate checkInDate, LocalDate checkOutDate,
        Integer childCount, Boolean hasPets, String id) {
      this.adultCount = adultCount;
      this.checkInDate = checkInDate;
      this.checkOutDate = checkOutDate;
      this.childCount = childCount;
      this.hasPets = hasPets;
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof BookingInquiry) {
        BookingInquiry that = (BookingInquiry) o;
        return ((this.adultCount == null) ? (that.adultCount == null) : this.adultCount.equals(that.adultCount))
         &&((this.checkInDate == null) ? (that.checkInDate == null) : this.checkInDate.equals(that.checkInDate))
         &&((this.checkOutDate == null) ? (that.checkOutDate == null) : this.checkOutDate.equals(that.checkOutDate))
         &&((this.childCount == null) ? (that.childCount == null) : this.childCount.equals(that.childCount))
         &&((this.hasPets == null) ? (that.hasPets == null) : this.hasPets.equals(that.hasPets))
         &&((this.id == null) ? (that.id == null) : this.id.equals(that.id));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (adultCount == null) ? 0 : adultCount.hashCode();
        __h *= 1000003;
        __h ^= (checkInDate == null) ? 0 : checkInDate.hashCode();
        __h *= 1000003;
        __h ^= (checkOutDate == null) ? 0 : checkOutDate.hashCode();
        __h *= 1000003;
        __h ^= (childCount == null) ? 0 : childCount.hashCode();
        __h *= 1000003;
        __h ^= (hasPets == null) ? 0 : hasPets.hashCode();
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "BookingInquiry{"
          + "adultCount=" + adultCount + ", "
          + "checkInDate=" + checkInDate + ", "
          + "checkOutDate=" + checkOutDate + ", "
          + "childCount=" + childCount + ", "
          + "hasPets=" + hasPets + ", "
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }

  public static class Property {
    /**
     * the ID of the property whose reservations you want to retrieve
     */
    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Property(String id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Property) {
        Property that = (Property) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Property{"
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }

  public static class PrimaryTraveler {
    public String firstName;

    public String lastName;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public PrimaryTraveler(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PrimaryTraveler) {
        PrimaryTraveler that = (PrimaryTraveler) o;
        return ((this.firstName == null) ? (that.firstName == null) : this.firstName.equals(that.firstName))
         &&((this.lastName == null) ? (that.lastName == null) : this.lastName.equals(that.lastName));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (firstName == null) ? 0 : firstName.hashCode();
        __h *= 1000003;
        __h ^= (lastName == null) ? 0 : lastName.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PrimaryTraveler{"
          + "firstName=" + firstName + ", "
          + "lastName=" + lastName
          + "}";
      }
      return $toString;
    }
  }

  public static class ReservationSummary {
    public Integer adultCount;

    public AlternativeIds alternativeIds;

    public LocalDate checkInDate;

    public LocalDate checkOutDate;

    public Integer childCount;

    public String id;

    public Integer petCount;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ReservationSummary(Integer adultCount, AlternativeIds alternativeIds,
        LocalDate checkInDate, LocalDate checkOutDate, Integer childCount, String id,
        Integer petCount) {
      this.adultCount = adultCount;
      this.alternativeIds = alternativeIds;
      this.checkInDate = checkInDate;
      this.checkOutDate = checkOutDate;
      this.childCount = childCount;
      this.id = id;
      this.petCount = petCount;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ReservationSummary) {
        ReservationSummary that = (ReservationSummary) o;
        return ((this.adultCount == null) ? (that.adultCount == null) : this.adultCount.equals(that.adultCount))
         &&((this.alternativeIds == null) ? (that.alternativeIds == null) : this.alternativeIds.equals(that.alternativeIds))
         &&((this.checkInDate == null) ? (that.checkInDate == null) : this.checkInDate.equals(that.checkInDate))
         &&((this.checkOutDate == null) ? (that.checkOutDate == null) : this.checkOutDate.equals(that.checkOutDate))
         &&((this.childCount == null) ? (that.childCount == null) : this.childCount.equals(that.childCount))
         &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.petCount == null) ? (that.petCount == null) : this.petCount.equals(that.petCount));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (adultCount == null) ? 0 : adultCount.hashCode();
        __h *= 1000003;
        __h ^= (alternativeIds == null) ? 0 : alternativeIds.hashCode();
        __h *= 1000003;
        __h ^= (checkInDate == null) ? 0 : checkInDate.hashCode();
        __h *= 1000003;
        __h ^= (checkOutDate == null) ? 0 : checkOutDate.hashCode();
        __h *= 1000003;
        __h ^= (childCount == null) ? 0 : childCount.hashCode();
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (petCount == null) ? 0 : petCount.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ReservationSummary{"
          + "adultCount=" + adultCount + ", "
          + "alternativeIds=" + alternativeIds + ", "
          + "checkInDate=" + checkInDate + ", "
          + "checkOutDate=" + checkOutDate + ", "
          + "childCount=" + childCount + ", "
          + "id=" + id + ", "
          + "petCount=" + petCount
          + "}";
      }
      return $toString;
    }
  }

  public static class AlternativeIds {
    /**
     * Supplier Id for the Reservation
     */
    public String supplierId;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public AlternativeIds(String supplierId) {
      this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AlternativeIds) {
        AlternativeIds that = (AlternativeIds) o;
        return ((this.supplierId == null) ? (that.supplierId == null) : this.supplierId.equals(that.supplierId));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (supplierId == null) ? 0 : supplierId.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "AlternativeIds{"
          + "supplierId=" + supplierId
          + "}";
      }
      return $toString;
    }
  }

  public static class Messages {
    /**
     *  Represents the next page cursor in the list, Empty if no more pages available
     */
    public String cursor;

    /**
     *  Total number of message returned that meet the search criteria 
     */
    public Integer totalCount;

    /**
     *  list of messages 
     */
    public List<Element> elements;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Messages(String cursor, Integer totalCount, List<Element> elements) {
      this.cursor = cursor;
      this.totalCount = totalCount;
      this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Messages) {
        Messages that = (Messages) o;
        return ((this.cursor == null) ? (that.cursor == null) : this.cursor.equals(that.cursor))
         &&((this.totalCount == null) ? (that.totalCount == null) : this.totalCount.equals(that.totalCount))
         &&((this.elements == null) ? (that.elements == null) : this.elements.equals(that.elements));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (cursor == null) ? 0 : cursor.hashCode();
        __h *= 1000003;
        __h ^= (totalCount == null) ? 0 : totalCount.hashCode();
        __h *= 1000003;
        __h ^= (elements == null) ? 0 : elements.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Messages{"
          + "cursor=" + cursor + ", "
          + "totalCount=" + totalCount + ", "
          + "elements=" + elements
          + "}";
      }
      return $toString;
    }
  }

  public static class Element {
    /**
     *  The message id
     */
    public String id;

    /**
     *  Message type 
     */
    public String type;

    /**
     *  Time at which the message was created. ISO format (yyyy-MM-dd'T'HH:mm:ss.SSSZ) and UTC timezone
     */
    public Object creationDateTimeUtc;

    /**
     *  Message identifier from the client perspective. This value is set by the client in addMessage mutation.
     */
    public MessageThreadParticipantRole fromRole;

    /**
     *  Review status of a Message. 
     */
    public MessageReviewStatus reviewStatus;

    /**
     *  List of attachments associated with this message 
     */
    public List<Attachment> attachments;

    /**
     *  Message body (only plaintext allowed; should not contain any HTML tags)
     */
    public Body body;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Element(String id, String type, Object creationDateTimeUtc,
        MessageThreadParticipantRole fromRole, MessageReviewStatus reviewStatus,
        List<Attachment> attachments, Body body) {
      this.id = id;
      this.type = type;
      this.creationDateTimeUtc = creationDateTimeUtc;
      this.fromRole = fromRole;
      this.reviewStatus = reviewStatus;
      this.attachments = attachments;
      this.body = body;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Element) {
        Element that = (Element) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         &&((this.creationDateTimeUtc == null) ? (that.creationDateTimeUtc == null) : this.creationDateTimeUtc.equals(that.creationDateTimeUtc))
         &&((this.fromRole == null) ? (that.fromRole == null) : this.fromRole.equals(that.fromRole))
         &&((this.reviewStatus == null) ? (that.reviewStatus == null) : this.reviewStatus.equals(that.reviewStatus))
         &&((this.attachments == null) ? (that.attachments == null) : this.attachments.equals(that.attachments))
         &&((this.body == null) ? (that.body == null) : this.body.equals(that.body));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        __h *= 1000003;
        __h ^= (creationDateTimeUtc == null) ? 0 : creationDateTimeUtc.hashCode();
        __h *= 1000003;
        __h ^= (fromRole == null) ? 0 : fromRole.hashCode();
        __h *= 1000003;
        __h ^= (reviewStatus == null) ? 0 : reviewStatus.hashCode();
        __h *= 1000003;
        __h ^= (attachments == null) ? 0 : attachments.hashCode();
        __h *= 1000003;
        __h ^= (body == null) ? 0 : body.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Element{"
          + "id=" + id + ", "
          + "type=" + type + ", "
          + "creationDateTimeUtc=" + creationDateTimeUtc + ", "
          + "fromRole=" + fromRole + ", "
          + "reviewStatus=" + reviewStatus + ", "
          + "attachments=" + attachments + ", "
          + "body=" + body
          + "}";
      }
      return $toString;
    }
  }

  public static class Attachment {
    /**
     *  The attachment Id
     */
    public String id;

    /**
     *  attachment name 
     */
    public String name;

    /**
     *  attachment upload date time in ISO format and UTC timezone
     */
    public Object uploadDateTimeUtc;

    /**
     *  The attachment location 
     */
    public URL url;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Attachment(String id, String name, Object uploadDateTimeUtc, URL url) {
      this.id = id;
      this.name = name;
      this.uploadDateTimeUtc = uploadDateTimeUtc;
      this.url = url;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Attachment) {
        Attachment that = (Attachment) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         &&((this.uploadDateTimeUtc == null) ? (that.uploadDateTimeUtc == null) : this.uploadDateTimeUtc.equals(that.uploadDateTimeUtc))
         &&((this.url == null) ? (that.url == null) : this.url.equals(that.url));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (name == null) ? 0 : name.hashCode();
        __h *= 1000003;
        __h ^= (uploadDateTimeUtc == null) ? 0 : uploadDateTimeUtc.hashCode();
        __h *= 1000003;
        __h ^= (url == null) ? 0 : url.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Attachment{"
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "uploadDateTimeUtc=" + uploadDateTimeUtc + ", "
          + "url=" + url
          + "}";
      }
      return $toString;
    }
  }

  public static class Body {
    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Body(String value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Body) {
        Body that = (Body) o;
        return ((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (value == null) ? 0 : value.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Body{"
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }
}
