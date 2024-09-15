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
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.PropertyListingBundleAdoptionQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.PropertyListingBundleAdoptionQuerySelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AdoptionType;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class PropertyListingBundleAdoptionQuery implements Query<PropertyListingBundleAdoptionQuery.Data> {
  public static final String OPERATION_ID = "ab868243c4d8162f95c2cd18bfc27a4b0a268628a965722818d24da494363b04";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query PropertyListingBundleAdoption {
   *   getPropertyListingBundleAdoption {
   *     adoptionList
   *     adoptionType
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query PropertyListingBundleAdoption { getPropertyListingBundleAdoption { adoptionList adoptionType } }";

  public static final String OPERATION_NAME = "PropertyListingBundleAdoption";

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public PropertyListingBundleAdoptionQuery() {

  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PropertyListingBundleAdoptionQuery) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "PropertyListingBundleAdoptionQuery{"
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
    // This operation doesn't have any variable
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(PropertyListingBundleAdoptionQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query.type
    )
    .selections(PropertyListingBundleAdoptionQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    Builder() {
    }

    public PropertyListingBundleAdoptionQuery build() {
      return new PropertyListingBundleAdoptionQuery();
    }
  }

  public static class Data implements Query.Data {
    /**
     * Get Property Listing Bundle Adoption
     */
    public GetPropertyListingBundleAdoption getPropertyListingBundleAdoption;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(GetPropertyListingBundleAdoption getPropertyListingBundleAdoption) {
      this.getPropertyListingBundleAdoption = getPropertyListingBundleAdoption;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.getPropertyListingBundleAdoption == null) ? (that.getPropertyListingBundleAdoption == null) : this.getPropertyListingBundleAdoption.equals(that.getPropertyListingBundleAdoption));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (getPropertyListingBundleAdoption == null) ? 0 : getPropertyListingBundleAdoption.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "getPropertyListingBundleAdoption=" + getPropertyListingBundleAdoption
          + "}";
      }
      return $toString;
    }
  }

  public static class GetPropertyListingBundleAdoption {
    public List<String> adoptionList;

    public AdoptionType adoptionType;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public GetPropertyListingBundleAdoption(List<String> adoptionList, AdoptionType adoptionType) {
      this.adoptionList = adoptionList;
      this.adoptionType = adoptionType;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof GetPropertyListingBundleAdoption) {
        GetPropertyListingBundleAdoption that = (GetPropertyListingBundleAdoption) o;
        return ((this.adoptionList == null) ? (that.adoptionList == null) : this.adoptionList.equals(that.adoptionList))
         &&((this.adoptionType == null) ? (that.adoptionType == null) : this.adoptionType.equals(that.adoptionType));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (adoptionList == null) ? 0 : adoptionList.hashCode();
        __h *= 1000003;
        __h ^= (adoptionType == null) ? 0 : adoptionType.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "GetPropertyListingBundleAdoption{"
          + "adoptionList=" + adoptionList + ", "
          + "adoptionType=" + adoptionType
          + "}";
      }
      return $toString;
    }
  }
}