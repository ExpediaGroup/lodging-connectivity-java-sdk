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
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter.SandboxUpdateReservationMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.adapter.SandboxUpdateReservationMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationFragment;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.selections.SandboxUpdateReservationMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class SandboxUpdateReservationMutation implements Mutation<SandboxUpdateReservationMutation.Data> {
  public static final String OPERATION_ID = "9e41b028f71b077dae72b8da92ac9f5fac940c0e56f5d80818cbfbe646569742";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation SandboxUpdateReservation($input: UpdateReservationInput!) {
   *   updateReservation(input: $input) {
   *     clientMutationId
   *     reservation {
   *       __typename
   *       ...SandboxReservationFragment
   *     }
   *   }
   * }
   *
   * fragment SandboxReservationFragment on Reservation {
   *   accessibilityText
   *   adultCount
   *   amounts {
   *     nightlyPayments {
   *       cancellationAmounts {
   *         amount {
   *           amount
   *           currencyCode
   *         }
   *         description
   *         percent
   *         type
   *       }
   *       dailyAmounts {
   *         amount {
   *           amount
   *           currencyCode
   *         }
   *         date
   *         description
   *         percent
   *         type
   *       }
   *       perStayAmounts {
   *         amount {
   *           amount
   *           currencyCode
   *         }
   *         description
   *         percent
   *         type
   *       }
   *     }
   *   }
   *   bedTypes
   *   bookingSource
   *   businessModel
   *   checkInDate
   *   checkOutDate
   *   childAges
   *   childCount
   *   creationDateTime
   *   id
   *   isReconciled
   *   lastUpdatedDateTime
   *   multiRoomText
   *   payment {
   *     cardNumber
   *     issuerName
   *     paymentInstrumentType
   *     verificationNumber
   *   }
   *   petCount
   *   primaryGuest {
   *     emailAddress
   *     firstName
   *     lastName
   *     loyaltyTier
   *     phoneNumbers {
   *       areaCode
   *       countryCode
   *       number
   *     }
   *     supplierLoyaltyPlanInfo {
   *       membershipNumber
   *       planCode
   *     }
   *   }
   *   propertyId
   *   rateIds {
   *     id
   *     idSource
   *   }
   *   reconciliationType
   *   reservationIds {
   *     id
   *     idSource
   *   }
   *   smokingType
   *   specialRequest
   *   status
   *   subStatus
   *   tidsCode
   *   totalGuestCount
   *   unitIds {
   *     id
   *     idSource
   *   }
   *   valueAddedPromotions {
   *     description
   *     id
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation SandboxUpdateReservation($input: UpdateReservationInput!) { updateReservation(input: $input) { clientMutationId reservation { __typename ...SandboxReservationFragment } } }  fragment SandboxReservationFragment on Reservation { accessibilityText adultCount amounts { nightlyPayments { cancellationAmounts { amount { amount currencyCode } description percent type } dailyAmounts { amount { amount currencyCode } date description percent type } perStayAmounts { amount { amount currencyCode } description percent type } } } bedTypes bookingSource businessModel checkInDate checkOutDate childAges childCount creationDateTime id isReconciled lastUpdatedDateTime multiRoomText payment { cardNumber issuerName paymentInstrumentType verificationNumber } petCount primaryGuest { emailAddress firstName lastName loyaltyTier phoneNumbers { areaCode countryCode number } supplierLoyaltyPlanInfo { membershipNumber planCode } } propertyId rateIds { id idSource } reconciliationType reservationIds { id idSource } smokingType specialRequest status subStatus tidsCode totalGuestCount unitIds { id idSource } valueAddedPromotions { description id } }";

  public static final String OPERATION_NAME = "SandboxUpdateReservation";

  public final UpdateReservationInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SandboxUpdateReservationMutation(UpdateReservationInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SandboxUpdateReservationMutation) {
      SandboxUpdateReservationMutation that = (SandboxUpdateReservationMutation) o;
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
      $toString = "SandboxUpdateReservationMutation{"
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
    SandboxUpdateReservationMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(SandboxUpdateReservationMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.Mutation.type
    )
    .selections(SandboxUpdateReservationMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private UpdateReservationInput input;

    Builder() {
    }

    public Builder input(UpdateReservationInput input) {
      this.input = input;
      return this;
    }

    public SandboxUpdateReservationMutation build() {
      return new SandboxUpdateReservationMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Updates a reservation in the sandbox environment.
     *
     * The mutation accepts the reservation ID, new check-in date, new check-out date,
     * new status, new special request text, new adult count, and new child count as parameters.
     * The check-out date must be after the check-in date.
     * An optional parameter is provided to send a notification upon the change of the reservation dates.
     * The mutation returns the updated reservation details.
     */
    public UpdateReservation updateReservation;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(UpdateReservation updateReservation) {
      this.updateReservation = updateReservation;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateReservation == null) ? (that.updateReservation == null) : this.updateReservation.equals(that.updateReservation));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (updateReservation == null) ? 0 : updateReservation.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateReservation=" + updateReservation
          + "}";
      }
      return $toString;
    }
  }

  public static class UpdateReservation {
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

    public UpdateReservation(String clientMutationId, Reservation reservation) {
      this.clientMutationId = clientMutationId;
      this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateReservation) {
        UpdateReservation that = (UpdateReservation) o;
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
        $toString = "UpdateReservation{"
          + "clientMutationId=" + clientMutationId + ", "
          + "reservation=" + reservation
          + "}";
      }
      return $toString;
    }
  }

  public static class Reservation {
    public String __typename;

    /**
     * Synthetic field for 'SandboxReservationFragment'
     */
    public SandboxReservationFragment sandboxReservationFragment;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Reservation(String __typename, SandboxReservationFragment sandboxReservationFragment) {
      this.__typename = __typename;
      this.sandboxReservationFragment = sandboxReservationFragment;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Reservation) {
        Reservation that = (Reservation) o;
        return ((this.__typename == null) ? (that.__typename == null) : this.__typename.equals(that.__typename))
         &&((this.sandboxReservationFragment == null) ? (that.sandboxReservationFragment == null) : this.sandboxReservationFragment.equals(that.sandboxReservationFragment));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (__typename == null) ? 0 : __typename.hashCode();
        __h *= 1000003;
        __h ^= (sandboxReservationFragment == null) ? 0 : sandboxReservationFragment.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Reservation{"
          + "__typename=" + __typename + ", "
          + "sandboxReservationFragment=" + sandboxReservationFragment
          + "}";
      }
      return $toString;
    }
  }
}
