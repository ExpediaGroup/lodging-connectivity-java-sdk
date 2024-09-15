//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.ObjectAdapter;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.SetPropertyTaxRecordMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.SetPropertyTaxRecordMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.SetPropertyTaxRecordMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.SetPropertyTaxRecordInput;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class SetPropertyTaxRecordMutation implements Mutation<SetPropertyTaxRecordMutation.Data> {
  public static final String OPERATION_ID = "863fd28770c64f4adecbe3c272b770040cbe3650a2002daec69cf9f6c36d161f";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation SetPropertyTaxRecord($input: SetPropertyTaxRecordInput!) {
   *   setPropertyTaxRecord(input: $input) {
   *     clientMutationId
   *     taxRecords {
   *       attributes {
   *         name
   *         validationResult {
   *           messages
   *           valid
   *         }
   *         value {
   *           type
   *           value
   *         }
   *       }
   *       categoryCode
   *       validationResult {
   *         complianceStatusCode
   *         messages
   *       }
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation SetPropertyTaxRecord($input: SetPropertyTaxRecordInput!) { setPropertyTaxRecord(input: $input) { clientMutationId taxRecords { attributes { name validationResult { messages valid } value { type value } } categoryCode validationResult { complianceStatusCode messages } } } }";

  public static final String OPERATION_NAME = "SetPropertyTaxRecord";

  public final SetPropertyTaxRecordInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public SetPropertyTaxRecordMutation(SetPropertyTaxRecordInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SetPropertyTaxRecordMutation) {
      SetPropertyTaxRecordMutation that = (SetPropertyTaxRecordMutation) o;
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
      $toString = "SetPropertyTaxRecordMutation{"
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
  public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters)
      throws IOException {
    SetPropertyTaxRecordMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(SetPropertyTaxRecordMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(SetPropertyTaxRecordMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private SetPropertyTaxRecordInput input;

    Builder() {
    }

    public Builder input(SetPropertyTaxRecordInput input) {
      this.input = input;
      return this;
    }

    public SetPropertyTaxRecordMutation build() {
      return new SetPropertyTaxRecordMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     * Mutation for setting the tax record for a property
     */
    public SetPropertyTaxRecord setPropertyTaxRecord;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(SetPropertyTaxRecord setPropertyTaxRecord) {
      this.setPropertyTaxRecord = setPropertyTaxRecord;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.setPropertyTaxRecord == null) ? (that.setPropertyTaxRecord == null) : this.setPropertyTaxRecord.equals(that.setPropertyTaxRecord));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (setPropertyTaxRecord == null) ? 0 : setPropertyTaxRecord.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "setPropertyTaxRecord=" + setPropertyTaxRecord
          + "}";
      }
      return $toString;
    }
  }

  public static class SetPropertyTaxRecord {
    public String clientMutationId;

    /**
     * Tax records for the property after completion of the mutation
     */
    public List<TaxRecord> taxRecords;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public SetPropertyTaxRecord(String clientMutationId, List<TaxRecord> taxRecords) {
      this.clientMutationId = clientMutationId;
      this.taxRecords = taxRecords;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof SetPropertyTaxRecord) {
        SetPropertyTaxRecord that = (SetPropertyTaxRecord) o;
        return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
         &&((this.taxRecords == null) ? (that.taxRecords == null) : this.taxRecords.equals(that.taxRecords));
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
        __h ^= (taxRecords == null) ? 0 : taxRecords.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "SetPropertyTaxRecord{"
          + "clientMutationId=" + clientMutationId + ", "
          + "taxRecords=" + taxRecords
          + "}";
      }
      return $toString;
    }
  }

  public static class TaxRecord {
    /**
     * List of attributes for the tax record
     */
    public List<Attribute> attributes;

    /**
     * Category for the tax record.
     */
    public String categoryCode;

    public ValidationResult1 validationResult;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public TaxRecord(List<Attribute> attributes, String categoryCode,
        ValidationResult1 validationResult) {
      this.attributes = attributes;
      this.categoryCode = categoryCode;
      this.validationResult = validationResult;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof TaxRecord) {
        TaxRecord that = (TaxRecord) o;
        return ((this.attributes == null) ? (that.attributes == null) : this.attributes.equals(that.attributes))
         &&((this.categoryCode == null) ? (that.categoryCode == null) : this.categoryCode.equals(that.categoryCode))
         &&((this.validationResult == null) ? (that.validationResult == null) : this.validationResult.equals(that.validationResult));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (attributes == null) ? 0 : attributes.hashCode();
        __h *= 1000003;
        __h ^= (categoryCode == null) ? 0 : categoryCode.hashCode();
        __h *= 1000003;
        __h ^= (validationResult == null) ? 0 : validationResult.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "TaxRecord{"
          + "attributes=" + attributes + ", "
          + "categoryCode=" + categoryCode + ", "
          + "validationResult=" + validationResult
          + "}";
      }
      return $toString;
    }
  }

  public static class Attribute {
    /**
     * Key identifying an individual attribute of a regulatory record
     */
    public String name;

    public ValidationResult validationResult;

    /**
     * Value for the given key in the attribute
     */
    public Value value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Attribute(String name, ValidationResult validationResult, Value value) {
      this.name = name;
      this.validationResult = validationResult;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Attribute) {
        Attribute that = (Attribute) o;
        return ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
         &&((this.validationResult == null) ? (that.validationResult == null) : this.validationResult.equals(that.validationResult))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (name == null) ? 0 : name.hashCode();
        __h *= 1000003;
        __h ^= (validationResult == null) ? 0 : validationResult.hashCode();
        __h *= 1000003;
        __h ^= (value == null) ? 0 : value.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Attribute{"
          + "name=" + name + ", "
          + "validationResult=" + validationResult + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class ValidationResult {
    public List<String> messages;

    public Boolean valid;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ValidationResult(List<String> messages, Boolean valid) {
      this.messages = messages;
      this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ValidationResult) {
        ValidationResult that = (ValidationResult) o;
        return ((this.messages == null) ? (that.messages == null) : this.messages.equals(that.messages))
         &&((this.valid == null) ? (that.valid == null) : this.valid.equals(that.valid));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (messages == null) ? 0 : messages.hashCode();
        __h *= 1000003;
        __h ^= (valid == null) ? 0 : valid.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ValidationResult{"
          + "messages=" + messages + ", "
          + "valid=" + valid
          + "}";
      }
      return $toString;
    }
  }

  public static class Value {
    /**
     * Type for the regulatory attribute
     */
    public String type;

    /**
     * Value for the given key in the attribute
     */
    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Value(String type, String value) {
      this.type = type;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Value) {
        Value that = (Value) o;
        return ((this.type == null) ? (that.type == null) : this.type.equals(that.type))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        __h *= 1000003;
        __h ^= (value == null) ? 0 : value.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Value{"
          + "type=" + type + ", "
          + "value=" + value
          + "}";
      }
      return $toString;
    }
  }

  public static class ValidationResult1 {
    /**
     * Overall compliant status of the record for a given purpose
     */
    public String complianceStatusCode;

    /**
     * Validation messages concerning the compliance status
     */
    public List<String> messages;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public ValidationResult1(String complianceStatusCode, List<String> messages) {
      this.complianceStatusCode = complianceStatusCode;
      this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ValidationResult1) {
        ValidationResult1 that = (ValidationResult1) o;
        return ((this.complianceStatusCode == null) ? (that.complianceStatusCode == null) : this.complianceStatusCode.equals(that.complianceStatusCode))
         &&((this.messages == null) ? (that.messages == null) : this.messages.equals(that.messages));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (complianceStatusCode == null) ? 0 : complianceStatusCode.hashCode();
        __h *= 1000003;
        __h ^= (messages == null) ? 0 : messages.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ValidationResult1{"
          + "complianceStatusCode=" + complianceStatusCode + ", "
          + "messages=" + messages
          + "}";
      }
      return $toString;
    }
  }
}