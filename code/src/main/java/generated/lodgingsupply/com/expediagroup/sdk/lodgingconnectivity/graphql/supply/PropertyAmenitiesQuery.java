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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.PropertyAmenitiesQuery_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.PropertyAmenitiesQuery_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.PropertyAmenitiesQuerySelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenitiesFiltersInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenityFieldFeeType;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class PropertyAmenitiesQuery implements Query<PropertyAmenitiesQuery.Data> {
  public static final String OPERATION_ID = "e853ecdf37369c14485d1fb4c80c19f9fb588ea75b976f2452278c4bfd08eb0c";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * query PropertyAmenities($propertyId: String!, $filters: AmenitiesFiltersInput) {
   *   property(id: $propertyId) {
   *     amenities(filters: $filters) {
   *       key
   *       value {
   *         available
   *         fields {
   *           key
   *           type
   *           value {
   *             feeValue {
   *               type
   *             }
   *             measurementValue {
   *               unitOfMeasure
   *               value
   *             }
   *             textValue {
   *               locale
   *               value
   *             }
   *             value
   *           }
   *         }
   *       }
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "query PropertyAmenities($propertyId: String!, $filters: AmenitiesFiltersInput) { property(id: $propertyId) { amenities(filters: $filters) { key value { available fields { key type value { feeValue { type } measurementValue { unitOfMeasure value } textValue { locale value } value } } } } } }";

  public static final String OPERATION_NAME = "PropertyAmenities";

  public final String propertyId;

  public final Optional<AmenitiesFiltersInput> filters;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public PropertyAmenitiesQuery(String propertyId, Optional<AmenitiesFiltersInput> filters) {
    this.propertyId = propertyId;
    this.filters = filters;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PropertyAmenitiesQuery) {
      PropertyAmenitiesQuery that = (PropertyAmenitiesQuery) o;
      return ((this.propertyId == null) ? (that.propertyId == null) : this.propertyId.equals(that.propertyId))
       &&((this.filters == null) ? (that.filters == null) : this.filters.equals(that.filters));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (propertyId == null) ? 0 : propertyId.hashCode();
      __h *= 1000003;
      __h ^= (filters == null) ? 0 : filters.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "PropertyAmenitiesQuery{"
        + "propertyId=" + propertyId + ", "
        + "filters=" + filters
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
    PropertyAmenitiesQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(PropertyAmenitiesQuery_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query.type
    )
    .selections(PropertyAmenitiesQuerySelections.__root)
    .build();
  }

  public static final class Builder {
    private String propertyId;

    private Optional<AmenitiesFiltersInput> filters = Optional.absent();

    Builder() {
    }

    public Builder propertyId(String propertyId) {
      this.propertyId = propertyId;
      return this;
    }

    public Builder filters(AmenitiesFiltersInput filters) {
      this.filters = Optional.present(filters);
      return this;
    }

    public PropertyAmenitiesQuery build() {
      return new PropertyAmenitiesQuery(propertyId, filters);
    }
  }

  public static class Data implements Query.Data {
    public Property property;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(Property property) {
      this.property = property;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.property == null) ? (that.property == null) : this.property.equals(that.property));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (property == null) ? 0 : property.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "property=" + property
          + "}";
      }
      return $toString;
    }
  }

  public static class Property {
    public List<Amenity> amenities;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Property(List<Amenity> amenities) {
      this.amenities = amenities;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Property) {
        Property that = (Property) o;
        return ((this.amenities == null) ? (that.amenities == null) : this.amenities.equals(that.amenities));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (amenities == null) ? 0 : amenities.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Property{"
          + "amenities=" + amenities
          + "}";
      }
      return $toString;
    }
  }

  public static class Amenity {
    public String key;

    public Value value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Amenity(String key, Value value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Amenity) {
        Amenity that = (Amenity) o;
        return ((this.key == null) ? (that.key == null) : this.key.equals(that.key))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (key == null) ? 0 : key.hashCode();
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
        $toString = "Amenity{"
          + "key=" + key + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class Value {
    public Boolean available;

    public List<Field> fields;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Value(Boolean available, List<Field> fields) {
      this.available = available;
      this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Value) {
        Value that = (Value) o;
        return ((this.available == null) ? (that.available == null) : this.available.equals(that.available))
         &&((this.fields == null) ? (that.fields == null) : this.fields.equals(that.fields));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (available == null) ? 0 : available.hashCode();
        __h *= 1000003;
        __h ^= (fields == null) ? 0 : fields.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Value{"
          + "available=" + available + ", "
          + "fields=" + fields
          + "}";
      }
      return $toString;
    }
  }

  public static class Field {
    public String key;

    public String type;

    public Value1 value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Field(String key, String type, Value1 value) {
      this.key = key;
      this.type = type;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Field) {
        Field that = (Field) o;
        return ((this.key == null) ? (that.key == null) : this.key.equals(that.key))
         &&((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (key == null) ? 0 : key.hashCode();
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
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
        $toString = "Field{"
          + "key=" + key + ", "
          + "type=" + type + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class Value1 {
    /**
     * Used for field type: fee.
     */
    public FeeValue feeValue;

    /**
     * Used for field type: measurement.
     */
    public MeasurementValue measurementValue;

    /**
     * Used for field type: text.
     */
    public List<TextValue> textValue;

    /**
     * Used for field types: enum, string, trilean, int, and decimal.
     */
    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Value1(FeeValue feeValue, MeasurementValue measurementValue, List<TextValue> textValue,
        String value) {
      this.feeValue = feeValue;
      this.measurementValue = measurementValue;
      this.textValue = textValue;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Value1) {
        Value1 that = (Value1) o;
        return ((this.feeValue == null) ? (that.feeValue == null) : this.feeValue.equals(that.feeValue))
         &&((this.measurementValue == null) ? (that.measurementValue == null) : this.measurementValue.equals(that.measurementValue))
         &&((this.textValue == null) ? (that.textValue == null) : this.textValue.equals(that.textValue))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (feeValue == null) ? 0 : feeValue.hashCode();
        __h *= 1000003;
        __h ^= (measurementValue == null) ? 0 : measurementValue.hashCode();
        __h *= 1000003;
        __h ^= (textValue == null) ? 0 : textValue.hashCode();
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
        $toString = "Value1{"
          + "feeValue=" + feeValue + ", "
          + "measurementValue=" + measurementValue + ", "
          + "textValue=" + textValue + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class FeeValue {
    public AmenityFieldFeeType type;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public FeeValue(AmenityFieldFeeType type) {
      this.type = type;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FeeValue) {
        FeeValue that = (FeeValue) o;
        return ((this.type == null) ? (that.type == null) : this.type.equals(that.type));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FeeValue{"
          + "type=" + type
          + "}";
      }
      return $toString;
    }
  }

  public static class MeasurementValue {
    public String unitOfMeasure;

    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public MeasurementValue(String unitOfMeasure, String value) {
      this.unitOfMeasure = unitOfMeasure;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof MeasurementValue) {
        MeasurementValue that = (MeasurementValue) o;
        return ((this.unitOfMeasure == null) ? (that.unitOfMeasure == null) : this.unitOfMeasure.equals(that.unitOfMeasure))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (unitOfMeasure == null) ? 0 : unitOfMeasure.hashCode();
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
        $toString = "MeasurementValue{"
          + "unitOfMeasure=" + unitOfMeasure + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class TextValue {
    public Object locale;

    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public TextValue(Object locale, String value) {
      this.locale = locale;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof TextValue) {
        TextValue that = (TextValue) o;
        return ((this.locale == null) ? (that.locale == null) : this.locale.equals(that.locale))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (locale == null) ? 0 : locale.hashCode();
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
        $toString = "TextValue{"
          + "locale=" + locale + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }
}
