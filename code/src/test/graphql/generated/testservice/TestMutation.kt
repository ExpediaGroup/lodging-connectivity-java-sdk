//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.1.0'.
//
package testservice

import com.apollographql.apollo.annotations.ApolloAdaptableWith
import com.apollographql.apollo.api.Adapter
import com.apollographql.apollo.api.CompiledField
import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.DefaultFakeResolver
import com.apollographql.apollo.api.FakeResolver
import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.buildData
import com.apollographql.apollo.api.json.JsonWriter
import com.apollographql.apollo.api.obj
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import testservice.adapter.TestMutation_ResponseAdapter
import testservice.schema.__Schema
import testservice.selections.TestMutationSelections
import testservice.type.MutationBuilder
import testservice.type.__CustomScalarAdapters
import testservice.type.Mutation as CompiledMutation

public class TestMutation() : Mutation<TestMutation.Data> {
  override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  override fun hashCode(): Int = this::class.hashCode()

  override fun id(): String = OPERATION_ID

  override fun document(): String = OPERATION_DOCUMENT

  override fun name(): String = OPERATION_NAME

  override fun serializeVariables(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    withDefaultValues: Boolean,
  ) {
    // This operation doesn't have any variable
  }

  override fun adapter(): Adapter<Data> = TestMutation_ResponseAdapter.Data.obj()

  override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = CompiledMutation.type
  )
  .selections(selections = TestMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(TestMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val testMutation: TestMutation,
  ) : Mutation.Data

  public data class TestMutation(
    public val id: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "4a3cf8d814f5d3c49da7398a55dc7a47d4028bcd4af9fdd7c8b56ddcca4a1b7c"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * ```
     * mutation TestMutation {
     *   testMutation {
     *     id
     *   }
     * }
     * ```
     */
    public val OPERATION_DOCUMENT: String
      get() = "mutation TestMutation { testMutation { id } }"

    public const val OPERATION_NAME: String = "TestMutation"

    public fun Data(resolver: FakeResolver = DefaultFakeResolver(__Schema.all), block: MutationBuilder.() -> Unit = {}): Data = buildData(
      CompiledMutation,
      block,
      TestMutation_ResponseAdapter.Data,
      TestMutationSelections.__root,
      "Mutation",
      resolver,
      __CustomScalarAdapters,
    )
  }
}
