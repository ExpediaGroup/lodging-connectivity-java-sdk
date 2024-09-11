//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.Assertions;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.ListAdapter;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.PropertyAmenitiesQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AmenityFieldFeeType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.AmenityFieldFeeType_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class PropertyAmenitiesQuery_ResponseAdapter {
  public enum Data implements Adapter<PropertyAmenitiesQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("property");

    @Override
    public PropertyAmenitiesQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyAmenitiesQuery.Property _property = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _property = new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyAmenitiesQuery.Data(
        _property
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Data value) throws IOException {
      writer.name("property");
      new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);
    }
  }

  public enum Property implements Adapter<PropertyAmenitiesQuery.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("amenities");

    @Override
    public PropertyAmenitiesQuery.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<PropertyAmenitiesQuery.Amenity> _amenities = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _amenities = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Amenity>(Amenity.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyAmenitiesQuery.Property(
        _amenities
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Property value) throws IOException {
      writer.name("amenities");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Amenity>(Amenity.INSTANCE, false))).toJson(writer, customScalarAdapters, value.amenities);
    }
  }

  public enum Amenity implements Adapter<PropertyAmenitiesQuery.Amenity> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("key", "value");

    @Override
    public PropertyAmenitiesQuery.Amenity fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _key = null;
      PropertyAmenitiesQuery.Value _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _key = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = new ObjectAdapter<PropertyAmenitiesQuery.Value>(Value.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_key, "key");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyAmenitiesQuery.Amenity(
        _key,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Amenity value) throws IOException {
      writer.name("key");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.key);

      writer.name("value");
      new ObjectAdapter<PropertyAmenitiesQuery.Value>(Value.INSTANCE, false).toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum Value implements Adapter<PropertyAmenitiesQuery.Value> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("available", "fields");

    @Override
    public PropertyAmenitiesQuery.Value fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Boolean _available = null;
      List<PropertyAmenitiesQuery.Field> _fields = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _available = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _fields = new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Field>(Field.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_available, "available");
      Assertions.checkFieldNotMissing(_fields, "fields");

      return new PropertyAmenitiesQuery.Value(
        _available,
        _fields
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Value value) throws IOException {
      writer.name("available");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.available);

      writer.name("fields");
      new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.Field>(Field.INSTANCE, false)).toJson(writer, customScalarAdapters, value.fields);
    }
  }

  public enum Field implements Adapter<PropertyAmenitiesQuery.Field> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("key", "type", "value");

    @Override
    public PropertyAmenitiesQuery.Field fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _key = null;
      String _type = null;
      PropertyAmenitiesQuery.Value1 _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _key = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _value = new ObjectAdapter<PropertyAmenitiesQuery.Value1>(Value1.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_key, "key");
      Assertions.checkFieldNotMissing(_type, "type");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyAmenitiesQuery.Field(
        _key,
        _type,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Field value) throws IOException {
      writer.name("key");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.key);

      writer.name("type");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.type);

      writer.name("value");
      new ObjectAdapter<PropertyAmenitiesQuery.Value1>(Value1.INSTANCE, false).toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum Value1 implements Adapter<PropertyAmenitiesQuery.Value1> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("feeValue", "measurementValue", "textValue", "value");

    @Override
    public PropertyAmenitiesQuery.Value1 fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      PropertyAmenitiesQuery.FeeValue _feeValue = null;
      PropertyAmenitiesQuery.MeasurementValue _measurementValue = null;
      List<PropertyAmenitiesQuery.TextValue> _textValue = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _feeValue = new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.FeeValue>(FeeValue.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 1: _measurementValue = new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.MeasurementValue>(MeasurementValue.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 2: _textValue = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.TextValue>(TextValue.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 3: _value = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new PropertyAmenitiesQuery.Value1(
        _feeValue,
        _measurementValue,
        _textValue,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.Value1 value) throws IOException {
      writer.name("feeValue");
      new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.FeeValue>(FeeValue.INSTANCE, false)).toJson(writer, customScalarAdapters, value.feeValue);

      writer.name("measurementValue");
      new NullableAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.MeasurementValue>(MeasurementValue.INSTANCE, false)).toJson(writer, customScalarAdapters, value.measurementValue);

      writer.name("textValue");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<PropertyAmenitiesQuery.TextValue>(TextValue.INSTANCE, false))).toJson(writer, customScalarAdapters, value.textValue);

      writer.name("value");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum FeeValue implements Adapter<PropertyAmenitiesQuery.FeeValue> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("type");

    @Override
    public PropertyAmenitiesQuery.FeeValue fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      AmenityFieldFeeType _type = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _type = AmenityFieldFeeType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_type, "type");

      return new PropertyAmenitiesQuery.FeeValue(
        _type
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.FeeValue value) throws IOException {
      writer.name("type");
      AmenityFieldFeeType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
    }
  }

  public enum MeasurementValue implements Adapter<PropertyAmenitiesQuery.MeasurementValue> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("unitOfMeasure", "value");

    @Override
    public PropertyAmenitiesQuery.MeasurementValue fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _unitOfMeasure = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _unitOfMeasure = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_unitOfMeasure, "unitOfMeasure");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyAmenitiesQuery.MeasurementValue(
        _unitOfMeasure,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.MeasurementValue value) throws IOException {
      writer.name("unitOfMeasure");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.unitOfMeasure);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum TextValue implements Adapter<PropertyAmenitiesQuery.TextValue> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public PropertyAmenitiesQuery.TextValue fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Object _locale = null;
      String _value = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _locale = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _value = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_locale, "locale");
      Assertions.checkFieldNotMissing(_value, "value");

      return new PropertyAmenitiesQuery.TextValue(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        PropertyAmenitiesQuery.TextValue value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }
}
