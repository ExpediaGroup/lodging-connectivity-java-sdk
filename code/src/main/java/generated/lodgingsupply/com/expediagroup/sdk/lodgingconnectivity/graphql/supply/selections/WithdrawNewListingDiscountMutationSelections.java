//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.GraphQLBoolean;
import java.util.Arrays;
import java.util.List;

public class WithdrawNewListingDiscountMutationSelections {
  public static List<CompiledSelection> __root = Arrays.asList(
    new CompiledField.Builder("withdrawNewListingDiscount", GraphQLBoolean.type).arguments(Arrays.asList(new CompiledArgument.Builder("id", new CompiledVariable("withdrawNewListingDiscountId")).build(), new CompiledArgument.Builder("idSource", new CompiledVariable("idSource")).build())).build()
  );
}
