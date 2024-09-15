//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.JoinNewListingDiscountMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.JoinNewListingDiscountMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.JoinNewListingDiscountMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.IdSource;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class JoinNewListingDiscountMutation implements Mutation<JoinNewListingDiscountMutation.Data> {
  public static final String OPERATION_ID = "9d2a440cd21e72fb194322656a7a77f1053c8bbbb6a8a163c89667da6793835f";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation JoinNewListingDiscount($joinNewListingDiscountId: String!, $idSource: IdSource!) {
   *   joinNewListingDiscount(id: $joinNewListingDiscountId, idSource: $idSource)
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation JoinNewListingDiscount($joinNewListingDiscountId: String!, $idSource: IdSource!) { joinNewListingDiscount(id: $joinNewListingDiscountId, idSource: $idSource) }";

  public static final String OPERATION_NAME = "JoinNewListingDiscount";

  public final String joinNewListingDiscountId;

  public final IdSource idSource;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public JoinNewListingDiscountMutation(String joinNewListingDiscountId, IdSource idSource) {
    this.joinNewListingDiscountId = joinNewListingDiscountId;
    this.idSource = idSource;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JoinNewListingDiscountMutation) {
      JoinNewListingDiscountMutation that = (JoinNewListingDiscountMutation) o;
      return ((this.joinNewListingDiscountId == null) ? (that.joinNewListingDiscountId == null) : this.joinNewListingDiscountId.equals(that.joinNewListingDiscountId))
       &&((this.idSource == null) ? (that.idSource == null) : this.idSource.equals(that.idSource));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (joinNewListingDiscountId == null) ? 0 : joinNewListingDiscountId.hashCode();
      __h *= 1000003;
      __h ^= (idSource == null) ? 0 : idSource.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "JoinNewListingDiscountMutation{"
        + "joinNewListingDiscountId=" + joinNewListingDiscountId + ", "
        + "idSource=" + idSource
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
    JoinNewListingDiscountMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(JoinNewListingDiscountMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(JoinNewListingDiscountMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private String joinNewListingDiscountId;

    private IdSource idSource;

    Builder() {
    }

    public Builder joinNewListingDiscountId(String joinNewListingDiscountId) {
      this.joinNewListingDiscountId = joinNewListingDiscountId;
      return this;
    }

    public Builder idSource(IdSource idSource) {
      this.idSource = idSource;
      return this;
    }

    public JoinNewListingDiscountMutation build() {
      return new JoinNewListingDiscountMutation(joinNewListingDiscountId, idSource);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Add new listing discount
     */
    public Boolean joinNewListingDiscount;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(Boolean joinNewListingDiscount) {
      this.joinNewListingDiscount = joinNewListingDiscount;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.joinNewListingDiscount == null) ? (that.joinNewListingDiscount == null) : this.joinNewListingDiscount.equals(that.joinNewListingDiscount));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (joinNewListingDiscount == null) ? 0 : joinNewListingDiscount.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "joinNewListingDiscount=" + joinNewListingDiscount
          + "}";
      }
      return $toString;
    }
  }
}