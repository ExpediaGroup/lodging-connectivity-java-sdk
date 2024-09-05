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
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.SetReviewResponseMutation;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class SetReviewResponseMutation_ResponseAdapter {
  public enum Data implements Adapter<SetReviewResponseMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("setReviewResponse");

    @Override
    public SetReviewResponseMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SetReviewResponseMutation.SetReviewResponse _setReviewResponse = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _setReviewResponse = new ObjectAdapter<SetReviewResponseMutation.SetReviewResponse>(SetReviewResponse.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_setReviewResponse, "setReviewResponse");

      return new SetReviewResponseMutation.Data(
        _setReviewResponse
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SetReviewResponseMutation.Data value) throws IOException {
      writer.name("setReviewResponse");
      new ObjectAdapter<SetReviewResponseMutation.SetReviewResponse>(SetReviewResponse.INSTANCE, false).toJson(writer, customScalarAdapters, value.setReviewResponse);
    }
  }

  public enum SetReviewResponse implements Adapter<SetReviewResponseMutation.SetReviewResponse> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("body", "createdDateTime", "status");

    @Override
    public SetReviewResponseMutation.SetReviewResponse fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SetReviewResponseMutation.Body _body = null;
      String _createdDateTime = null;
      String _status = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _body = new ObjectAdapter<SetReviewResponseMutation.Body>(Body.INSTANCE, false).fromJson(reader, customScalarAdapters); break;
          case 1: _createdDateTime = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _status = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_body, "body");
      Assertions.checkFieldNotMissing(_createdDateTime, "createdDateTime");
      Assertions.checkFieldNotMissing(_status, "status");

      return new SetReviewResponseMutation.SetReviewResponse(
        _body,
        _createdDateTime,
        _status
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SetReviewResponseMutation.SetReviewResponse value) throws IOException {
      writer.name("body");
      new ObjectAdapter<SetReviewResponseMutation.Body>(Body.INSTANCE, false).toJson(writer, customScalarAdapters, value.body);

      writer.name("createdDateTime");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.createdDateTime);

      writer.name("status");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.status);
    }
  }

  public enum Body implements Adapter<SetReviewResponseMutation.Body> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("locale", "value");

    @Override
    public SetReviewResponseMutation.Body fromJson(JsonReader reader,
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

      return new SetReviewResponseMutation.Body(
        _locale,
        _value
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SetReviewResponseMutation.Body value) throws IOException {
      writer.name("locale");
      Adapters.AnyAdapter.toJson(writer, customScalarAdapters, value.locale);

      writer.name("value");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.value);
    }
  }
}
