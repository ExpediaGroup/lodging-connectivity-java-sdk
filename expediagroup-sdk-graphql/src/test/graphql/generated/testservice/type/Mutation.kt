//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.1.0'.
//
package testservice.type

import com.apollographql.apollo.api.BuilderFactory
import com.apollographql.apollo.api.BuilderScope
import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.ObjectBuilder
import com.apollographql.apollo.api.ObjectType
import kotlin.Any
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public class Mutation {
  public companion object : BuilderFactory<MutationBuilder> {
    public val type: ObjectType = ObjectType.Builder(name = "Mutation").build()

    override fun newBuilder(customScalarAdapters: CustomScalarAdapters): MutationBuilder = MutationBuilder(customScalarAdapters)
  }
}

public class MutationBuilder(
  customScalarAdapters: CustomScalarAdapters,
) : ObjectBuilder<MutationMap>(customScalarAdapters) {
  public var testMutation: TestDataMap by __fields

  init {
    __typename = "Mutation"}

  override fun build(): MutationMap = MutationMap(__fields)
}

public class MutationMap(
  __fields: Map<String, Any?>,
) : Map<String, Any?> by __fields

public fun BuilderScope.buildMutation(block: MutationBuilder.() -> Unit): MutationMap = MutationBuilder(customScalarAdapters).apply(block).build()
