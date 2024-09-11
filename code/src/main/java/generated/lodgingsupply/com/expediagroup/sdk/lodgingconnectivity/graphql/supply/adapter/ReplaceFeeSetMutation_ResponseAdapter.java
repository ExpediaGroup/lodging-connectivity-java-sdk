//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.Adapters;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.NullableAdapter;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonReader;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.ReplaceFeeSetMutation;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class ReplaceFeeSetMutation_ResponseAdapter {
  public enum Data implements Adapter<ReplaceFeeSetMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("replaceFeeSet");

    @Override
    public ReplaceFeeSetMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      ReplaceFeeSetMutation.ReplaceFeeSet _replaceFeeSet = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _replaceFeeSet = new NullableAdapter<>(new ObjectAdapter<ReplaceFeeSetMutation.ReplaceFeeSet>(ReplaceFeeSet.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new ReplaceFeeSetMutation.Data(
        _replaceFeeSet
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        ReplaceFeeSetMutation.Data value) throws IOException {
      writer.name("replaceFeeSet");
      new NullableAdapter<>(new ObjectAdapter<ReplaceFeeSetMutation.ReplaceFeeSet>(ReplaceFeeSet.INSTANCE, false)).toJson(writer, customScalarAdapters, value.replaceFeeSet);
    }
  }

  public enum ReplaceFeeSet implements Adapter<ReplaceFeeSetMutation.ReplaceFeeSet> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("clientMutationId");

    @Override
    public ReplaceFeeSetMutation.ReplaceFeeSet fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _clientMutationId = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _clientMutationId = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new ReplaceFeeSetMutation.ReplaceFeeSet(
        _clientMutationId
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        ReplaceFeeSetMutation.ReplaceFeeSet value) throws IOException {
      writer.name("clientMutationId");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.clientMutationId);
    }
  }
}
