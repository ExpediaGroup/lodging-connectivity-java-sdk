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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.RateGuestMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.RateGuestMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.RateGuestMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RateGuestInput;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class RateGuestMutation implements Mutation<RateGuestMutation.Data> {
  public static final String OPERATION_ID = "0867bea3c6913ef7b1650b533cadb9856a13a254a88e745644a20dd7d6f4ea44";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation RateGuest($input: RateGuestInput!, $propertyId: ID!, $propertyIdSource: IdSource!) {
   *   rateGuest(input: $input, propertyId: $propertyId, propertyIdSource: $propertyIdSource) {
   *     recommendGuest
   *     starRatings {
   *       category
   *       value
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation RateGuest($input: RateGuestInput!, $propertyId: ID!, $propertyIdSource: IdSource!) { rateGuest(input: $input, propertyId: $propertyId, propertyIdSource: $propertyIdSource) { recommendGuest starRatings { category value } } }";

  public static final String OPERATION_NAME = "RateGuest";

  public final RateGuestInput input;

  public final String propertyId;

  public final IdSource propertyIdSource;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public RateGuestMutation(RateGuestInput input, String propertyId, IdSource propertyIdSource) {
    this.input = input;
    this.propertyId = propertyId;
    this.propertyIdSource = propertyIdSource;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RateGuestMutation) {
      RateGuestMutation that = (RateGuestMutation) o;
      return ((this.input == null) ? (that.input == null) : this.input.equals(that.input))
       &&((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.propertyIdSource == null) ? (that.propertyIdSource == null) : this.propertyIdSource.equals(that.propertyIdSource));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (input == null) ? 0 : input.hashCode();
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (propertyIdSource == null) ? 0 : propertyIdSource.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "RateGuestMutation{"
        + "input=" + input + ", "
        + "propertyId=" + propertyId + ", "
        + "propertyIdSource=" + propertyIdSource
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
    RateGuestMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(RateGuestMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(RateGuestMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private RateGuestInput input;

    private String propertyId;

    private IdSource propertyIdSource;

    Builder() {
    }

    public Builder input(RateGuestInput input) {
      this.input = input;
      return this;
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder propertyIdSource(IdSource propertyIdSource) {
      this.propertyIdSource = propertyIdSource;
      return this;
    }

    public RateGuestMutation build() {
      return new RateGuestMutation(input, propertyId, propertyIdSource);
    }
  }

  public static class Data implements Mutation.Data {
    public RateGuest rateGuest;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(RateGuest rateGuest) {
      this.rateGuest = rateGuest;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.rateGuest == null) ? (that.rateGuest == null) : this.rateGuest.equals(that.rateGuest));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (rateGuest == null) ? 0 : rateGuest.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "rateGuest=" + rateGuest
          + "}";
      }
      return $toString;
    }
  }

  public static class RateGuest {
    /**
     * will consider Guest for future reservations
     */
    public Boolean recommendGuest;

    /**
     * categorized ratings
     */
    public List<StarRating> starRatings;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public RateGuest(Boolean recommendGuest, List<StarRating> starRatings) {
      this.recommendGuest = recommendGuest;
      this.starRatings = starRatings;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof RateGuest) {
        RateGuest that = (RateGuest) o;
        return ((this.recommendGuest == null) ? (that.recommendGuest == null) : this.recommendGuest.equals(that.recommendGuest))
         &&((this.starRatings == null) ? (that.starRatings == null) : this.starRatings.equals(that.starRatings));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (recommendGuest == null) ? 0 : recommendGuest.hashCode();
        __h *= 1000003;
        __h ^= (starRatings == null) ? 0 : starRatings.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "RateGuest{"
          + "recommendGuest=" + recommendGuest + ", "
          + "starRatings=" + starRatings
          + "}";
      }
      return $toString;
    }
  }

  public static class StarRating {
    /**
     * rating category
     */
    public String category;

    /**
     * value of the rating
     */
    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public StarRating(String category, String value) {
      this.category = category;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof StarRating) {
        StarRating that = (StarRating) o;
        return ((this.category == null) ? (that.category == null) : this.category.equals(that.category))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (category == null) ? 0 : category.hashCode();
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
        $toString = "StarRating{"
          + "category=" + category + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }
}
