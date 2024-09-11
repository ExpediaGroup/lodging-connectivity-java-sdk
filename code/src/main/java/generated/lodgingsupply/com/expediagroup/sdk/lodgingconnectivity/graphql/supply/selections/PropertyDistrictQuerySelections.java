//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo.api.CompiledArgument;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CompiledListType;
import com.apollographql.apollo.api.CompiledNotNullType;
import com.apollographql.apollo.api.CompiledSelection;
import com.apollographql.apollo.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AdditionalDataRequirement;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.District;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Exemption;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ExemptionCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLInt;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLString;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.JurisdictionRequirement;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.LegalPropertyType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.MaxNightCap;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Property;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Purpose;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Query;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegistrationNumberRequirement;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegistrationNumberType;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.RegulatoryCategory;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ThirdPartyValidation;
import java.util.Arrays;
import java.util.List;

public class PropertyDistrictQuerySelections {
  private static List<CompiledSelection> __legalPropertyTypes = Arrays.asList(
    new CompiledField.Builder("subtype", GraphQLString.type).build(),
    new CompiledField.Builder("type", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __additionalDataRequirements = Arrays.asList(
    new CompiledField.Builder("group", GraphQLString.type).build(),
    new CompiledField.Builder("groupLocalized", GraphQLString.type).build(),
    new CompiledField.Builder("isOptional", GraphQLString.type).build(),
    new CompiledField.Builder("key", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("keyLocalized", GraphQLString.type).build(),
    new CompiledField.Builder("subtype", GraphQLString.type).build(),
    new CompiledField.Builder("subtypeLocalized", GraphQLString.type).build(),
    new CompiledField.Builder("type", GraphQLString.type).build(),
    new CompiledField.Builder("typeLocalized", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __exemptions = Arrays.asList(
    new CompiledField.Builder("category", ExemptionCategory.type).build(),
    new CompiledField.Builder("description", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __maxNightCap = Arrays.asList(
    new CompiledField.Builder("annualLimit", GraphQLInt.type).build(),
    new CompiledField.Builder("isEnforced", GraphQLBoolean.type).build()
  );

  private static List<CompiledSelection> __qualifiedPropertyTypes = Arrays.asList(
    new CompiledField.Builder("subtype", GraphQLString.type).build(),
    new CompiledField.Builder("type", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __thirdPartyValidation = Arrays.asList(
    new CompiledField.Builder("attributes", new CompiledListType(GraphQLString.type)).build(),
    new CompiledField.Builder("required", new CompiledNotNullType(GraphQLBoolean.type)).build()
  );

  private static List<CompiledSelection> __registrationNumberRequirements = Arrays.asList(
    new CompiledField.Builder("allowPendingRegistrations", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("format", GraphQLString.type).build(),
    new CompiledField.Builder("isExpirationDateRequired", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("isOptional", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("localName", GraphQLString.type).build(),
    new CompiledField.Builder("numberType", RegistrationNumberType.type).build(),
    new CompiledField.Builder("numberTypeLabel", GraphQLString.type).build(),
    new CompiledField.Builder("purpose", Purpose.type).build(),
    new CompiledField.Builder("regex", GraphQLString.type).build(),
    new CompiledField.Builder("thirdPartyValidation", ThirdPartyValidation.type).selections(__thirdPartyValidation).build(),
    new CompiledField.Builder("url", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __requirements = Arrays.asList(
    new CompiledField.Builder("additionalDataRequirements", new CompiledListType(AdditionalDataRequirement.type)).selections(__additionalDataRequirements).build(),
    new CompiledField.Builder("exemptions", new CompiledListType(Exemption.type)).selections(__exemptions).build(),
    new CompiledField.Builder("isVacationRental", GraphQLBoolean.type).build(),
    new CompiledField.Builder("maxNightCap", MaxNightCap.type).selections(__maxNightCap).build(),
    new CompiledField.Builder("minStayNights", new CompiledNotNullType(GraphQLInt.type)).build(),
    new CompiledField.Builder("qualifiedPropertyTypes", new CompiledListType(LegalPropertyType.type)).selections(__qualifiedPropertyTypes).build(),
    new CompiledField.Builder("registrationNumberRequirements", new CompiledListType(new CompiledNotNullType(RegistrationNumberRequirement.type))).selections(__registrationNumberRequirements).build(),
    new CompiledField.Builder("regulatoryCategory", RegulatoryCategory.type).build(),
    new CompiledField.Builder("regulatoryCategoryLabel", GraphQLString.type).build()
  );

  private static List<CompiledSelection> __district = Arrays.asList(
    new CompiledField.Builder("description", GraphQLString.type).build(),
    new CompiledField.Builder("id", new CompiledNotNullType(GraphQLString.type)).build(),
    new CompiledField.Builder("legalPropertyTypes", new CompiledNotNullType(new CompiledListType(LegalPropertyType.type))).selections(__legalPropertyTypes).build(),
    new CompiledField.Builder("localizedName", GraphQLString.type).build(),
    new CompiledField.Builder("nativeLocale", GraphQLString.type).build(),
    new CompiledField.Builder("referenceUrls", new CompiledListType(GraphQLString.type)).build(),
    new CompiledField.Builder("registrationRequired", new CompiledNotNullType(GraphQLBoolean.type)).build(),
    new CompiledField.Builder("requirements", new CompiledListType(JurisdictionRequirement.type)).selections(__requirements).build()
  );

  private static List<CompiledSelection> __property = Arrays.asList(
    new CompiledField.Builder("district", District.type).arguments(Arrays.asList(new CompiledArgument.Builder(Property.__district_locale).value(new CompiledVariable("locale")).build())).selections(__district).build()
  );

  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("property", Property.type).arguments(Arrays.asList(new CompiledArgument.Builder(Query.__property_id).value(new CompiledVariable("propertyId")).build())).selections(__property).build()
  );
}
