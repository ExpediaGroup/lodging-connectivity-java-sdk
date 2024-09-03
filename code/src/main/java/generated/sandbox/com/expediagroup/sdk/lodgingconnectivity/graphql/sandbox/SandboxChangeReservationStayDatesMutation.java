//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter.SandboxChangeReservationStayDatesMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter.SandboxChangeReservationStayDatesMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.selections.SandboxChangeReservationStayDatesMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;

public class SandboxChangeReservationStayDatesMutation implements Mutation<SandboxChangeReservationStayDatesMutation.Data> {
  public static final String OPERATION_ID = "406fa26080210c4b65a75297adab3cc870b28b740c847a38290396c3eebf35a9";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation SandboxChangeReservationStayDates($input: ChangeReservationStayDatesInput!) {
   *   changeReservationStayDates(input: $input) {
   *     clientMutationId
   *     reservation {
   *       id
   *       checkInDate
   *       checkOutDate
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation SandboxChangeReservationStayDates($input: ChangeReservationStayDatesInput!) { changeReservationStayDates(input: $input) { clientMutationId reservation { id checkInDate checkOutDate } } }";

  public static final String OPERATION_NAME = "SandboxChangeReservationStayDates";

  public final ChangeReservationStayDatesInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SandboxChangeReservationStayDatesMutation(ChangeReservationStayDatesInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SandboxChangeReservationStayDatesMutation) {
      SandboxChangeReservationStayDatesMutation that = (SandboxChangeReservationStayDatesMutation) o;
      return ((this.input == null) ? (that.input == null) : this.input.equals(that.input));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (input == null) ? 0 : input.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "SandboxChangeReservationStayDatesMutation{"
        + "input=" + input
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
    SandboxChangeReservationStayDatesMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(SandboxChangeReservationStayDatesMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.Mutation.type
    )
    .selections(SandboxChangeReservationStayDatesMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private ChangeReservationStayDatesInput input;

    Builder() {
    }

    public Builder input(ChangeReservationStayDatesInput input) {
      this.input = input;
      return this;
    }

    public SandboxChangeReservationStayDatesMutation build() {
      return new SandboxChangeReservationStayDatesMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Changes the stay dates of an existing reservation.
     *
     * The mutation accepts the reservation ID, new check-in date, and new check-out date as parameters.
     * The check-out date must be after the check-in date.
     * An optional parameter is provided to send a notification upon the change of the reservation dates.
     * The mutation returns the updated reservation details.
     */
    public ChangeReservationStayDates changeReservationStayDates;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(ChangeReservationStayDates changeReservationStayDates) {
      this.changeReservationStayDates = changeReservationStayDates;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.changeReservationStayDates == null) ? (that.changeReservationStayDates == null) : this.changeReservationStayDates.equals(that.changeReservationStayDates));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (changeReservationStayDates == null) ? 0 : changeReservationStayDates.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "changeReservationStayDates=" + changeReservationStayDates
          + "}";
      }
      return $toString;
    }
  }

  public static class ChangeReservationStayDates {
    /**
     * Client mutation ID. Optional value in the input that is echoed back in the response.
     */
    public String clientMutationId;

    /**
     * The reservation that was updated.
     */
    public Reservation reservation;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ChangeReservationStayDates(String clientMutationId, Reservation reservation) {
      this.clientMutationId = clientMutationId;
      this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ChangeReservationStayDates) {
        ChangeReservationStayDates that = (ChangeReservationStayDates) o;
        return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
         &&((this.reservation == null) ? (that.reservation == null) : this.reservation.equals(that.reservation));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
        __h *= 1000003;
        __h ^= (reservation == null) ? 0 : reservation.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ChangeReservationStayDates{"
          + "clientMutationId=" + clientMutationId + ", "
          + "reservation=" + reservation
          + "}";
      }
      return $toString;
    }
  }

  public static class Reservation {
    /**
     * Unique identifier for the reservation.
     */
    public String id;

    /**
     * Check-in date (format: YYYY-MM-DD) of the reservation.
     */
    public LocalDate checkInDate;

    /**
     * Check-out date (format: YYYY-MM-DD) of the reservation.
     */
    public LocalDate checkOutDate;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Reservation(String id, LocalDate checkInDate, LocalDate checkOutDate) {
      this.id = id;
      this.checkInDate = checkInDate;
      this.checkOutDate = checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Reservation) {
        Reservation that = (Reservation) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.checkInDate == null) ? (that.checkInDate == null) : this.checkInDate.equals(that.checkInDate))
         &&((this.checkOutDate == null) ? (that.checkOutDate == null) : this.checkOutDate.equals(that.checkOutDate));
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
        __h ^= (checkInDate == null) ? 0 : checkInDate.hashCode();
        __h *= 1000003;
        __h ^= (checkOutDate == null) ? 0 : checkOutDate.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Reservation{"
          + "id=" + id + ", "
          + "checkInDate=" + checkInDate + ", "
          + "checkOutDate=" + checkOutDate
          + "}";
      }
      return $toString;
    }
  }
}
