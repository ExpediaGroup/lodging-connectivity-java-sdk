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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ArchivePropertyIdsMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.ArchivePropertyIdsMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.ArchivePropertyIdsMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ArchivePropertyIdsInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public class ArchivePropertyIdsMutation implements Mutation<ArchivePropertyIdsMutation.Data> {
  public static final String OPERATION_ID = "f6f77fcafa1140234f50eaed73abe42b7e41c01842baa09292bd9f3ec5d16a3b";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation ArchivePropertyIds($input: ArchivePropertyIdsInput!) {
   *   archivePropertyIds(input: $input) {
   *     advertiserId
   *     propertyIdsToArchive
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation ArchivePropertyIds($input: ArchivePropertyIdsInput!) { archivePropertyIds(input: $input) { advertiserId propertyIdsToArchive } }";

  public static final String OPERATION_NAME = "ArchivePropertyIds";

  public final ArchivePropertyIdsInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public ArchivePropertyIdsMutation(ArchivePropertyIdsInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ArchivePropertyIdsMutation) {
      ArchivePropertyIdsMutation that = (ArchivePropertyIdsMutation) o;
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
      $toString = "ArchivePropertyIdsMutation{"
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
    ArchivePropertyIdsMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(ArchivePropertyIdsMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(ArchivePropertyIdsMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private ArchivePropertyIdsInput input;

    Builder() {
    }

    public Builder input(ArchivePropertyIdsInput input) {
      this.input = input;
      return this;
    }

    public ArchivePropertyIdsMutation build() {
      return new ArchivePropertyIdsMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Provide a list of Property IDs that should be archived during the Property ID mapping process.
     */
    public Optional<ArchivePropertyIds> archivePropertyIds;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(Optional<ArchivePropertyIds> archivePropertyIds) {
      this.archivePropertyIds = archivePropertyIds;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.archivePropertyIds == null) ? (that.archivePropertyIds == null) : this.archivePropertyIds.equals(that.archivePropertyIds));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (archivePropertyIds == null) ? 0 : archivePropertyIds.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "archivePropertyIds=" + archivePropertyIds
          + "}";
      }
      return $toString;
    }
  }

  public static class ArchivePropertyIds {
    /**
     * The Advertiser ID associated with the property IDs that will be archived.
     */
    public String advertiserId;

    /**
     * A playback of the EG Property IDs that the Partner indicated to archive.
     */
    public List<String> propertyIdsToArchive;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ArchivePropertyIds(String advertiserId, List<String> propertyIdsToArchive) {
      this.advertiserId = advertiserId;
      this.propertyIdsToArchive = propertyIdsToArchive;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ArchivePropertyIds) {
        ArchivePropertyIds that = (ArchivePropertyIds) o;
        return ((this.advertiserId == null) ? (that.advertiserId == null) : this.advertiserId.equals(that.advertiserId))
         &&((this.propertyIdsToArchive == null) ? (that.propertyIdsToArchive == null) : this.propertyIdsToArchive.equals(that.propertyIdsToArchive));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (advertiserId == null) ? 0 : advertiserId.hashCode();
        __h *= 1000003;
        __h ^= (propertyIdsToArchive == null) ? 0 : propertyIdsToArchive.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ArchivePropertyIds{"
          + "advertiserId=" + advertiserId + ", "
          + "propertyIdsToArchive=" + propertyIdsToArchive
          + "}";
      }
      return $toString;
    }
  }
}
