//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ChangeReservationReconciliationMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ChangeReservationReconciliationMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.ChangeReservationReconciliationMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ChangeReservationReconciliationInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

public class ChangeReservationReconciliationMutation implements Mutation<ChangeReservationReconciliationMutation.Data> {
  public static final String OPERATION_ID = "bd3842520fe752168ba1cad948367ca8f3cd17a0ad3f01f9ff8de69233e183cf";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation ChangeReservationReconciliation($input: ChangeReservationReconciliationInput!) {
   *   changeReservationReconciliation(input: $input) {
   *     reservation {
   *       id
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation ChangeReservationReconciliation($input: ChangeReservationReconciliationInput!) { changeReservationReconciliation(input: $input) { reservation { id } } }";

  public static final String OPERATION_NAME = "ChangeReservationReconciliation";

  public final ChangeReservationReconciliationInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ChangeReservationReconciliationMutation(ChangeReservationReconciliationInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ChangeReservationReconciliationMutation) {
      ChangeReservationReconciliationMutation that = (ChangeReservationReconciliationMutation) o;
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
      $toString = "ChangeReservationReconciliationMutation{"
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
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      boolean withDefaultValues) throws IOException {
    ChangeReservationReconciliationMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(ChangeReservationReconciliationMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(ChangeReservationReconciliationMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private ChangeReservationReconciliationInput input;

    Builder() {
    }

    public Builder input(ChangeReservationReconciliationInput input) {
      this.input = input;
      return this;
    }

    public ChangeReservationReconciliationMutation build() {
      return new ChangeReservationReconciliationMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Update reservation reconciliation
     */
    public ChangeReservationReconciliation changeReservationReconciliation;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(ChangeReservationReconciliation changeReservationReconciliation) {
      this.changeReservationReconciliation = changeReservationReconciliation;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.changeReservationReconciliation == null) ? (that.changeReservationReconciliation == null) : this.changeReservationReconciliation.equals(that.changeReservationReconciliation));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (changeReservationReconciliation == null) ? 0 : changeReservationReconciliation.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "changeReservationReconciliation=" + changeReservationReconciliation
          + "}";
      }
      return $toString;
    }
  }

  public static class ChangeReservationReconciliation {
    /**
     * Identifier associated with the reservation changed
     */
    public Optional<Reservation> reservation;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ChangeReservationReconciliation(Optional<Reservation> reservation) {
      this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ChangeReservationReconciliation) {
        ChangeReservationReconciliation that = (ChangeReservationReconciliation) o;
        return ((this.reservation == null) ? (that.reservation == null) : this.reservation.equals(that.reservation));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
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
        $toString = "ChangeReservationReconciliation{"
          + "reservation=" + reservation
          + "}";
      }
      return $toString;
    }
  }

  public static class Reservation {
    /**
     * Expedia id of the reservation
     */
    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Reservation(String id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Reservation) {
        Reservation that = (Reservation) o;
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
        $toString = "Reservation{"
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }
}
