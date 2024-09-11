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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.SavePropertyContactMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ContactType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.PhoneNumberType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ContactType_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.PhoneNumberType_ResponseAdapter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class SavePropertyContactMutation_ResponseAdapter {
  public enum Data implements Adapter<SavePropertyContactMutation.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("savePropertyContact");

    @Override
    public SavePropertyContactMutation.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      SavePropertyContactMutation.SavePropertyContact _savePropertyContact = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _savePropertyContact = new NullableAdapter<>(new ObjectAdapter<SavePropertyContactMutation.SavePropertyContact>(SavePropertyContact.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new SavePropertyContactMutation.Data(
        _savePropertyContact
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SavePropertyContactMutation.Data value) throws IOException {
      writer.name("savePropertyContact");
      new NullableAdapter<>(new ObjectAdapter<SavePropertyContactMutation.SavePropertyContact>(SavePropertyContact.INSTANCE, false)).toJson(writer, customScalarAdapters, value.savePropertyContact);
    }
  }

  public enum SavePropertyContact implements Adapter<SavePropertyContactMutation.SavePropertyContact> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("emailAddresses", "name", "phoneNumbers", "type");

    @Override
    public SavePropertyContactMutation.SavePropertyContact fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<String> _emailAddresses = null;
      String _name = null;
      List<SavePropertyContactMutation.PhoneNumber> _phoneNumbers = null;
      ContactType _type = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _emailAddresses = new NullableAdapter<>(new ListAdapter<>(Adapters.StringAdapter)).fromJson(reader, customScalarAdapters); break;
          case 1: _name = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _phoneNumbers = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<SavePropertyContactMutation.PhoneNumber>(PhoneNumber.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 3: _type = ContactType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_type, "type");

      return new SavePropertyContactMutation.SavePropertyContact(
        _emailAddresses,
        _name,
        _phoneNumbers,
        _type
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SavePropertyContactMutation.SavePropertyContact value) throws IOException {
      writer.name("emailAddresses");
      new NullableAdapter<>(new ListAdapter<>(Adapters.StringAdapter)).toJson(writer, customScalarAdapters, value.emailAddresses);

      writer.name("name");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.name);

      writer.name("phoneNumbers");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<SavePropertyContactMutation.PhoneNumber>(PhoneNumber.INSTANCE, false))).toJson(writer, customScalarAdapters, value.phoneNumbers);

      writer.name("type");
      ContactType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.type);
    }
  }

  public enum PhoneNumber implements Adapter<SavePropertyContactMutation.PhoneNumber> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("areaCode", "countryCode", "extension", "number", "phoneNumberType");

    @Override
    public SavePropertyContactMutation.PhoneNumber fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _areaCode = null;
      String _countryCode = null;
      String _extension = null;
      String _number = null;
      PhoneNumberType _phoneNumberType = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _areaCode = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _countryCode = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _extension = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _number = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _phoneNumberType = PhoneNumberType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_number, "number");
      Assertions.checkFieldNotMissing(_phoneNumberType, "phoneNumberType");

      return new SavePropertyContactMutation.PhoneNumber(
        _areaCode,
        _countryCode,
        _extension,
        _number,
        _phoneNumberType
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        SavePropertyContactMutation.PhoneNumber value) throws IOException {
      writer.name("areaCode");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.areaCode);

      writer.name("countryCode");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.countryCode);

      writer.name("extension");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.extension);

      writer.name("number");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.number);

      writer.name("phoneNumberType");
      PhoneNumberType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.phoneNumberType);
    }
  }
}
