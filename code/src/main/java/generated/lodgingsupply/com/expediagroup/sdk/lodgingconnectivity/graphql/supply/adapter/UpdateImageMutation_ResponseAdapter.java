//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.Assertions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ListAdapter;
import com.apollographql.apollo3.api.NullableAdapter;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.UpdateImageMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ImageSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ImageSource_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class UpdateImageMutation_ResponseAdapter {
  public enum Data implements Adapter<UpdateImageMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("updateImage");

    @Override
    public UpdateImageMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      UpdateImageMutation.UpdateImage _updateImage = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _updateImage = new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.UpdateImage>(UpdateImage.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UpdateImageMutation.Data(
        _updateImage
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.Data value) throws IOException {
      writer.name("updateImage");
      new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.UpdateImage>(UpdateImage.INSTANCE, false)).toJson(writer, customScalarAdapters, value.updateImage);
    }
  }

  public enum UpdateImage implements Adapter<UpdateImageMutation.UpdateImage> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId", "image");

    @Override
    public UpdateImageMutation.UpdateImage fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _clientMutationId = null;
      UpdateImageMutation.Image _image = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _image = new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.Image>(Image.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new UpdateImageMutation.UpdateImage(
        _clientMutationId,
        _image
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.UpdateImage value) throws IOException {
      writer.name("clientMutationId");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);

      writer.name("image");
      new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.Image>(Image.INSTANCE, false)).toJson(writer, customScalarAdapters, value.image);
    }
  }

  public enum Image implements Adapter<UpdateImageMutation.Image> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("active", "captions", "featured", "fileName", "id", "order", "originalUrl", "property", "publishedUrl", "rotation", "source", "status", "updatedDate");

    @Override
    public UpdateImageMutation.Image fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Boolean _active = null;
      List<UpdateImageMutation.Caption> _captions = null;
      Boolean _featured = null;
      String _fileName = null;
      String _id = null;
      Integer _order = null;
      String _originalUrl = null;
      UpdateImageMutation.Property _property = null;
      String _publishedUrl = null;
      Integer _rotation = null;
      ImageSource _source = null;
      UpdateImageMutation.Status _status = null;
      Object _updatedDate = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _active = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _captions = new ListAdapter<>(new ObjectAdapter<UpdateImageMutation.Caption>(Caption.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 2: _featured = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _fileName = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _order = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _originalUrl = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 7: _property = new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.Property>(Property.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 8: _publishedUrl = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 9: _rotation = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 10: _source = ImageSource_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          case 11: _status = new ObjectAdapter<UpdateImageMutation.Status>(Status.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 12: _updatedDate = Adapters.AnyAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_active, "active");
      Assertions.checkFieldNotMissing(_captions, "captions");
      Assertions.checkFieldNotMissing(_featured, "featured");
      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_rotation, "rotation");
      Assertions.checkFieldNotMissing(_source, "source");
      Assertions.checkFieldNotMissing(_status, "status");
      Assertions.checkFieldNotMissing(_updatedDate, "updatedDate");

      return new UpdateImageMutation.Image(
        _active,
        _captions,
        _featured,
        _fileName,
        _id,
        _order,
        _originalUrl,
        _property,
        _publishedUrl,
        _rotation,
        _source,
        _status,
        _updatedDate
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.Image value) throws IOException {
      writer.name("active");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.active);

      writer.name("captions");
      new ListAdapter<>(new ObjectAdapter<UpdateImageMutation.Caption>(Caption.INSTANCE, false)).toJson(writer, customScalarAdapters, value.captions);

      writer.name("featured");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.featured);

      writer.name("fileName");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.fileName);

      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("order");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.order);

      writer.name("originalUrl");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.originalUrl);

      writer.name("property");
      new NullableAdapter<>(new ObjectAdapter<UpdateImageMutation.Property>(Property.INSTANCE, false)).toJson(writer, customScalarAdapters, value.property);

      writer.name("publishedUrl");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.publishedUrl);

      writer.name("rotation");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.rotation);

      writer.name("source");
      ImageSource_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.source);

      writer.name("status");
      new ObjectAdapter<UpdateImageMutation.Status>(Status.INSTANCE, false).toJson(writer, customScalarAdapters, value.status);

      writer.name("updatedDate");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.updatedDate);
    }
  }

  public enum Caption implements Adapter<UpdateImageMutation.Caption> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public UpdateImageMutation.Caption fromJson(JsonReader reader,
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

      return new UpdateImageMutation.Caption(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.Caption value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }

  public enum Property implements Adapter<UpdateImageMutation.Property> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id");

    @Override
    public UpdateImageMutation.Property fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");

      return new UpdateImageMutation.Property(
        _id
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.Property value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);
    }
  }

  public enum Status implements Adapter<UpdateImageMutation.Status> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("reason", "type");

    @Override
    public UpdateImageMutation.Status fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _reason = null;
      String _type = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _reason = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_type, "type");

      return new UpdateImageMutation.Status(
        _reason,
        _type
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        UpdateImageMutation.Status value) throws IOException {
      writer.name("reason");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.reason);

      writer.name("type");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.type);
    }
  }
}