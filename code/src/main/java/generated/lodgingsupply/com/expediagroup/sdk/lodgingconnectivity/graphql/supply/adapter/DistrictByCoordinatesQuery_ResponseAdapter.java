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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.DistrictByCoordinatesQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ExemptionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Purpose;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegistrationNumberType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegulatoryCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.ExemptionCategory_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.Purpose_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.RegistrationNumberType_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.adapter.RegulatoryCategory_ResponseAdapter;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class DistrictByCoordinatesQuery_ResponseAdapter {
  public enum Data implements Adapter<DistrictByCoordinatesQuery.Data> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("districtByCoordinates");

    @Override
    public DistrictByCoordinatesQuery.Data fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      DistrictByCoordinatesQuery.DistrictByCoordinates _districtByCoordinates = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _districtByCoordinates = new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.DistrictByCoordinates>(DistrictByCoordinates.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new DistrictByCoordinatesQuery.Data(
        _districtByCoordinates
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.Data value) throws IOException {
      writer.name("districtByCoordinates");
      new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.DistrictByCoordinates>(DistrictByCoordinates.INSTANCE, false)).toJson(writer, customScalarAdapters, value.districtByCoordinates);
    }
  }

  public enum DistrictByCoordinates implements Adapter<DistrictByCoordinatesQuery.DistrictByCoordinates> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("id", "description", "localizedName", "nativeLocale", "referenceUrls", "registrationRequired", "legalPropertyTypes", "requirements");

    @Override
    public DistrictByCoordinatesQuery.DistrictByCoordinates fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _id = null;
      String _description = null;
      String _localizedName = null;
      String _nativeLocale = null;
      List<String> _referenceUrls = null;
      Boolean _registrationRequired = null;
      List<DistrictByCoordinatesQuery.LegalPropertyType> _legalPropertyTypes = null;
      List<DistrictByCoordinatesQuery.Requirement> _requirements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _id = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _description = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _localizedName = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _nativeLocale = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _referenceUrls = new NullableAdapter<>(new ListAdapter<>(Adapters.NullableStringAdapter)).fromJson(reader, customScalarAdapters); break;
          case 5: _registrationRequired = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _legalPropertyTypes = new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.LegalPropertyType>(LegalPropertyType.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          case 7: _requirements = new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.Requirement>(Requirement.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_id, "id");
      Assertions.checkFieldNotMissing(_registrationRequired, "registrationRequired");
      Assertions.checkFieldNotMissing(_legalPropertyTypes, "legalPropertyTypes");

      return new DistrictByCoordinatesQuery.DistrictByCoordinates(
        _id,
        _description,
        _localizedName,
        _nativeLocale,
        _referenceUrls,
        _registrationRequired,
        _legalPropertyTypes,
        _requirements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.DistrictByCoordinates value) throws IOException {
      writer.name("id");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.id);

      writer.name("description");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.description);

      writer.name("localizedName");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.localizedName);

      writer.name("nativeLocale");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.nativeLocale);

      writer.name("referenceUrls");
      new NullableAdapter<>(new ListAdapter<>(Adapters.NullableStringAdapter)).toJson(writer, customScalarAdapters, value.referenceUrls);

      writer.name("registrationRequired");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.registrationRequired);

      writer.name("legalPropertyTypes");
      new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.LegalPropertyType>(LegalPropertyType.INSTANCE, false))).toJson(writer, customScalarAdapters, value.legalPropertyTypes);

      writer.name("requirements");
      new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.Requirement>(Requirement.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.requirements);
    }
  }

  public enum LegalPropertyType implements Adapter<DistrictByCoordinatesQuery.LegalPropertyType> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("subtype", "type");

    @Override
    public DistrictByCoordinatesQuery.LegalPropertyType fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _subtype = null;
      String _type = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _subtype = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new DistrictByCoordinatesQuery.LegalPropertyType(
        _subtype,
        _type
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.LegalPropertyType value) throws IOException {
      writer.name("subtype");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.subtype);

      writer.name("type");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.type);
    }
  }

  public enum Requirement implements Adapter<DistrictByCoordinatesQuery.Requirement> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("regulatoryCategory", "regulatoryCategoryLabel", "isVacationRental", "minStayNights", "additionalDataRequirements", "exemptions", "maxNightCap", "qualifiedPropertyTypes", "registrationNumberRequirements");

    @Override
    public DistrictByCoordinatesQuery.Requirement fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      RegulatoryCategory _regulatoryCategory = null;
      String _regulatoryCategoryLabel = null;
      Boolean _isVacationRental = null;
      Integer _minStayNights = null;
      List<DistrictByCoordinatesQuery.AdditionalDataRequirement> _additionalDataRequirements = null;
      List<DistrictByCoordinatesQuery.Exemption> _exemptions = null;
      DistrictByCoordinatesQuery.MaxNightCap _maxNightCap = null;
      List<DistrictByCoordinatesQuery.QualifiedPropertyType> _qualifiedPropertyTypes = null;
      List<DistrictByCoordinatesQuery.RegistrationNumberRequirement> _registrationNumberRequirements = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _regulatoryCategory = new NullableAdapter<>(RegulatoryCategory_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 1: _regulatoryCategoryLabel = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _isVacationRental = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _minStayNights = Adapters.IntAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _additionalDataRequirements = new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.AdditionalDataRequirement>(AdditionalDataRequirement.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          case 5: _exemptions = new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.Exemption>(Exemption.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          case 6: _maxNightCap = new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.MaxNightCap>(MaxNightCap.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          case 7: _qualifiedPropertyTypes = new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.QualifiedPropertyType>(QualifiedPropertyType.INSTANCE, false)))).fromJson(reader, customScalarAdapters); break;
          case 8: _registrationNumberRequirements = new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.RegistrationNumberRequirement>(RegistrationNumberRequirement.INSTANCE, false))).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_minStayNights, "minStayNights");

      return new DistrictByCoordinatesQuery.Requirement(
        _regulatoryCategory,
        _regulatoryCategoryLabel,
        _isVacationRental,
        _minStayNights,
        _additionalDataRequirements,
        _exemptions,
        _maxNightCap,
        _qualifiedPropertyTypes,
        _registrationNumberRequirements
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.Requirement value) throws IOException {
      writer.name("regulatoryCategory");
      new NullableAdapter<>(RegulatoryCategory_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.regulatoryCategory);

      writer.name("regulatoryCategoryLabel");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.regulatoryCategoryLabel);

      writer.name("isVacationRental");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isVacationRental);

      writer.name("minStayNights");
      Adapters.IntAdapter.toJson(writer, customScalarAdapters, value.minStayNights);

      writer.name("additionalDataRequirements");
      new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.AdditionalDataRequirement>(AdditionalDataRequirement.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.additionalDataRequirements);

      writer.name("exemptions");
      new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.Exemption>(Exemption.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.exemptions);

      writer.name("maxNightCap");
      new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.MaxNightCap>(MaxNightCap.INSTANCE, false)).toJson(writer, customScalarAdapters, value.maxNightCap);

      writer.name("qualifiedPropertyTypes");
      new NullableAdapter<>(new ListAdapter<>(new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.QualifiedPropertyType>(QualifiedPropertyType.INSTANCE, false)))).toJson(writer, customScalarAdapters, value.qualifiedPropertyTypes);

      writer.name("registrationNumberRequirements");
      new NullableAdapter<>(new ListAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.RegistrationNumberRequirement>(RegistrationNumberRequirement.INSTANCE, false))).toJson(writer, customScalarAdapters, value.registrationNumberRequirements);
    }
  }

  public enum AdditionalDataRequirement implements Adapter<DistrictByCoordinatesQuery.AdditionalDataRequirement> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("group", "groupLocalized", "isOptional", "key", "keyLocalized", "subtype", "subtypeLocalized", "type", "typeLocalized");

    @Override
    public DistrictByCoordinatesQuery.AdditionalDataRequirement fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _group = null;
      String _groupLocalized = null;
      String _isOptional = null;
      String _key = null;
      String _keyLocalized = null;
      String _subtype = null;
      String _subtypeLocalized = null;
      String _type = null;
      String _typeLocalized = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _group = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _groupLocalized = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _isOptional = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _key = Adapters.StringAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _keyLocalized = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _subtype = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _subtypeLocalized = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 7: _type = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 8: _typeLocalized = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_key, "key");

      return new DistrictByCoordinatesQuery.AdditionalDataRequirement(
        _group,
        _groupLocalized,
        _isOptional,
        _key,
        _keyLocalized,
        _subtype,
        _subtypeLocalized,
        _type,
        _typeLocalized
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.AdditionalDataRequirement value) throws IOException {
      writer.name("group");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.group);

      writer.name("groupLocalized");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.groupLocalized);

      writer.name("isOptional");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.isOptional);

      writer.name("key");
      Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.key);

      writer.name("keyLocalized");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.keyLocalized);

      writer.name("subtype");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.subtype);

      writer.name("subtypeLocalized");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.subtypeLocalized);

      writer.name("type");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.type);

      writer.name("typeLocalized");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.typeLocalized);
    }
  }

  public enum Exemption implements Adapter<DistrictByCoordinatesQuery.Exemption> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("category", "description");

    @Override
    public DistrictByCoordinatesQuery.Exemption fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      ExemptionCategory _category = null;
      String _description = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _category = new NullableAdapter<>(ExemptionCategory_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 1: _description = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new DistrictByCoordinatesQuery.Exemption(
        _category,
        _description
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.Exemption value) throws IOException {
      writer.name("category");
      new NullableAdapter<>(ExemptionCategory_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.category);

      writer.name("description");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.description);
    }
  }

  public enum MaxNightCap implements Adapter<DistrictByCoordinatesQuery.MaxNightCap> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("annualLimit", "isEnforced");

    @Override
    public DistrictByCoordinatesQuery.MaxNightCap fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      Integer _annualLimit = null;
      Boolean _isEnforced = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _annualLimit = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _isEnforced = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new DistrictByCoordinatesQuery.MaxNightCap(
        _annualLimit,
        _isEnforced
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.MaxNightCap value) throws IOException {
      writer.name("annualLimit");
      Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.annualLimit);

      writer.name("isEnforced");
      Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isEnforced);
    }
  }

  public enum QualifiedPropertyType implements Adapter<DistrictByCoordinatesQuery.QualifiedPropertyType> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("subtype", "type");

    @Override
    public DistrictByCoordinatesQuery.QualifiedPropertyType fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _subtype = null;
      String _type = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _subtype = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _type = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      return new DistrictByCoordinatesQuery.QualifiedPropertyType(
        _subtype,
        _type
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.QualifiedPropertyType value) throws IOException {
      writer.name("subtype");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.subtype);

      writer.name("type");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.type);
    }
  }

  public enum RegistrationNumberRequirement implements Adapter<DistrictByCoordinatesQuery.RegistrationNumberRequirement> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("url", "allowPendingRegistrations", "format", "isExpirationDateRequired", "isOptional", "localName", "numberType", "numberTypeLabel", "purpose", "regex", "thirdPartyValidation");

    @Override
    public DistrictByCoordinatesQuery.RegistrationNumberRequirement fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      String _url = null;
      Boolean _allowPendingRegistrations = null;
      String _format = null;
      Boolean _isExpirationDateRequired = null;
      Boolean _isOptional = null;
      String _localName = null;
      RegistrationNumberType _numberType = null;
      String _numberTypeLabel = null;
      Purpose _purpose = null;
      String _regex = null;
      DistrictByCoordinatesQuery.ThirdPartyValidation _thirdPartyValidation = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _url = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 1: _allowPendingRegistrations = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 2: _format = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 3: _isExpirationDateRequired = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 4: _isOptional = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          case 5: _localName = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 6: _numberType = new NullableAdapter<>(RegistrationNumberType_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 7: _numberTypeLabel = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 8: _purpose = new NullableAdapter<>(Purpose_ResponseAdapter.INSTANCE).fromJson(reader, customScalarAdapters); break;
          case 9: _regex = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters); break;
          case 10: _thirdPartyValidation = new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.ThirdPartyValidation>(ThirdPartyValidation.INSTANCE, false)).fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_allowPendingRegistrations, "allowPendingRegistrations");
      Assertions.checkFieldNotMissing(_isExpirationDateRequired, "isExpirationDateRequired");
      Assertions.checkFieldNotMissing(_isOptional, "isOptional");

      return new DistrictByCoordinatesQuery.RegistrationNumberRequirement(
        _url,
        _allowPendingRegistrations,
        _format,
        _isExpirationDateRequired,
        _isOptional,
        _localName,
        _numberType,
        _numberTypeLabel,
        _purpose,
        _regex,
        _thirdPartyValidation
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.RegistrationNumberRequirement value) throws IOException {
      writer.name("url");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.url);

      writer.name("allowPendingRegistrations");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.allowPendingRegistrations);

      writer.name("format");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.format);

      writer.name("isExpirationDateRequired");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.isExpirationDateRequired);

      writer.name("isOptional");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.isOptional);

      writer.name("localName");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.localName);

      writer.name("numberType");
      new NullableAdapter<>(RegistrationNumberType_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.numberType);

      writer.name("numberTypeLabel");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.numberTypeLabel);

      writer.name("purpose");
      new NullableAdapter<>(Purpose_ResponseAdapter.INSTANCE).toJson(writer, customScalarAdapters, value.purpose);

      writer.name("regex");
      Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.regex);

      writer.name("thirdPartyValidation");
      new NullableAdapter<>(new ObjectAdapter<DistrictByCoordinatesQuery.ThirdPartyValidation>(ThirdPartyValidation.INSTANCE, false)).toJson(writer, customScalarAdapters, value.thirdPartyValidation);
    }
  }

  public enum ThirdPartyValidation implements Adapter<DistrictByCoordinatesQuery.ThirdPartyValidation> {
    INSTANCE;

    private static final List<String> RESPONSE_NAMES = Arrays.asList("attributes", "required");

    @Override
    public DistrictByCoordinatesQuery.ThirdPartyValidation fromJson(JsonReader reader,
        CustomScalarAdapters customScalarAdapters) throws IOException {
      List<String> _attributes = null;
      Boolean _required = null;

      loop:
      while(true) {
        switch (reader.selectName(RESPONSE_NAMES)) {
          case 0: _attributes = new NullableAdapter<>(new ListAdapter<>(Adapters.NullableStringAdapter)).fromJson(reader, customScalarAdapters); break;
          case 1: _required = Adapters.BooleanAdapter.fromJson(reader, customScalarAdapters); break;
          default: break loop;
        }
      }

      Assertions.checkFieldNotMissing(_required, "required");

      return new DistrictByCoordinatesQuery.ThirdPartyValidation(
        _attributes,
        _required
      );
    }

    @Override
    public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
        DistrictByCoordinatesQuery.ThirdPartyValidation value) throws IOException {
      writer.name("attributes");
      new NullableAdapter<>(new ListAdapter<>(Adapters.NullableStringAdapter)).toJson(writer, customScalarAdapters, value.attributes);

      writer.name("required");
      Adapters.BooleanAdapter.toJson(writer, customScalarAdapters, value.required);
    }
  }
}