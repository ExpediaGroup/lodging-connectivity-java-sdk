//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.0.0'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo.api.Adapter;
import com.apollographql.apollo.api.CompiledField;
import com.apollographql.apollo.api.CustomScalarAdapters;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.ObjectAdapter;
import com.apollographql.apollo.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdatePropertyMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdatePropertyMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.UpdatePropertyMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdatePropertyInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

public class UpdatePropertyMutation implements Mutation<UpdatePropertyMutation.Data> {
  public static final String OPERATION_ID = "fe611381d896f3df86a5b641dc00690cbbd73723b07cd816b50b4b651b073e47";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation UpdateProperty($input: UpdatePropertyInput!) {
   *   updateProperty(input: $input) {
   *     clientMutationId
   *     property {
   *       id
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation UpdateProperty($input: UpdatePropertyInput!) { updateProperty(input: $input) { clientMutationId property { id } } }";

  public static final String OPERATION_NAME = "UpdateProperty";

  public final UpdatePropertyInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdatePropertyMutation(UpdatePropertyInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdatePropertyMutation) {
      UpdatePropertyMutation that = (UpdatePropertyMutation) o;
      return ((this.input == null) ? (that.input == null) : this.input.equals(that.input));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (input == null) ? 0 : input.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "UpdatePropertyMutation{"
        + "input=" + input
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String id() {
    return OPERATION_ID;
  }

  @Override
  public String document() {
    return OPERATION_DOCUMENT;
  }

  @Override
  public String name() {
    return OPERATION_NAME;
  }

  @Override
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters,
      boolean withDefaultValues) throws IOException {
    UpdatePropertyMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(UpdatePropertyMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(UpdatePropertyMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private UpdatePropertyInput input;

    Builder() {
    }

    public Builder input(UpdatePropertyInput input) {
      this.input = input;
      return this;
    }

    public UpdatePropertyMutation build() {
      return new UpdatePropertyMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    public Optional<UpdateProperty> updateProperty;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(Optional<UpdateProperty> updateProperty) {
      this.updateProperty = updateProperty;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateProperty == null) ? (that.updateProperty == null) : this.updateProperty.equals(that.updateProperty));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (updateProperty == null) ? 0 : updateProperty.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateProperty=" + updateProperty
          + "}";
      }
      return $toString;
    }
  }

  public static class UpdateProperty {
    public Optional<String> clientMutationId;

    public Optional<Property> property;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UpdateProperty(Optional<String> clientMutationId, Optional<Property> property) {
      this.clientMutationId = clientMutationId;
      this.property = property;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateProperty) {
        UpdateProperty that = (UpdateProperty) o;
        return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
         &&((this.property == null) ? (that.property == null) : this.property.equals(that.property));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (clientMutationId == null) ? 0 : clientMutationId.hashCode();
        __h *= 1000003;
        __h ^= (property == null) ? 0 : property.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateProperty{"
          + "clientMutationId=" + clientMutationId + ", "
          + "property=" + property
          + "}";
      }
      return $toString;
    }
  }

  public static class Property {
    /**
     * the ID of the property whose reservations you want to retrieve
     */
    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Property(String id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Property) {
        Property that = (Property) o;
        return ((this.id == null) ? (that.id == null) : this.id.equals(that.id));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Property{"
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }
}
