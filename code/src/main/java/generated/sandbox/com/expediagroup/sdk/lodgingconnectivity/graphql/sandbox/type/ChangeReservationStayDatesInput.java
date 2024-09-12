//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.time.LocalDate;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * Input to change the stay dates of a reservation.
 */
public class ChangeReservationStayDatesInput {
  public final LocalDate checkInDate;

  public final LocalDate checkOutDate;

  public final Optional<Optional<String>> clientMutationId;

  public final String id;

  public final Optional<Optional<Boolean>> sendNotification;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ChangeReservationStayDatesInput(LocalDate checkInDate, LocalDate checkOutDate,
      Optional<Optional<String>> clientMutationId, String id,
      Optional<Optional<Boolean>> sendNotification) {
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.clientMutationId = clientMutationId;
    this.id = id;
    this.sendNotification = sendNotification;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ChangeReservationStayDatesInput) {
      ChangeReservationStayDatesInput that = (ChangeReservationStayDatesInput) o;
      return ((this.checkInDate == null) ? (that.checkInDate == null) : this.checkInDate.equals(that.checkInDate))
       &&((this.checkOutDate == null) ? (that.checkOutDate == null) : this.checkOutDate.equals(that.checkOutDate))
       &&((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
       &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
       &&((this.sendNotification == null) ? (that.sendNotification == null) : this.sendNotification.equals(that.sendNotification));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (checkInDate == null) ? 0 : checkInDate.hashCode();
      __h *= 1000003;
      __h ^= (checkOutDate == null) ? 0 : checkOutDate.hashCode();
      __h *= 1000003;
      __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
      __h *= 1000003;
      __h ^= (id == null) ? 0 : id.hashCode();
      __h *= 1000003;
      __h ^= (sendNotification == null) ? 0 : sendNotification.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "ChangeReservationStayDatesInput{"
        + "checkInDate=" + checkInDate + ", "
        + "checkOutDate=" + checkOutDate + ", "
        + "clientMutationId=" + clientMutationId + ", "
        + "id=" + id + ", "
        + "sendNotification=" + sendNotification
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Optional<Optional<String>> clientMutationId = Optional.empty();

    private String id;

    private Optional<Optional<Boolean>> sendNotification = Optional.empty();

    Builder() {
    }

    /**
     * New check-in date of the reservation.
     */
    public Builder checkInDate(LocalDate checkInDate) {
      this.checkInDate = checkInDate;
      return this;
    }

    /**
     * New check-out date of the reservation.
     */
    public Builder checkOutDate(LocalDate checkOutDate) {
      this.checkOutDate = checkOutDate;
      return this;
    }

    /**
     * Client mutation ID. Optional value that is echoed back in the response.
     */
    public Builder clientMutationId(@NotNull Optional<String> clientMutationId) {
      this.clientMutationId = Optional.of(clientMutationId);
      return this;
    }

    /**
     * ID of the reservation to change.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Whether to send a notification upon the change of the reservation dates.
     */
    public Builder sendNotification(@NotNull Optional<Boolean> sendNotification) {
      this.sendNotification = Optional.of(sendNotification);
      return this;
    }

    public ChangeReservationStayDatesInput build() {
      return new ChangeReservationStayDatesInput(checkInDate, checkOutDate, clientMutationId, id, sendNotification);
    }
  }
}
