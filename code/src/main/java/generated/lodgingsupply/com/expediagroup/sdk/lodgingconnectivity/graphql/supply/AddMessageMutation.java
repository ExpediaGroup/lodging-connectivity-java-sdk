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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.AddMessageMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.AddMessageMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.AddMessageMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.AddMessageThreadMessageInput;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class AddMessageMutation implements Mutation<AddMessageMutation.Data> {
  public static final String OPERATION_ID = "14ee6301cd231a47b0b42ccf0ad00f01849d777fbc329114a8a36fb7aadd7156";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation AddMessage($messageThreadId: ID!, $message: AddMessageThreadMessageInput!) {
   *   addMessage(messageThreadId: $messageThreadId, message: $message) {
   *     id
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation AddMessage($messageThreadId: ID!, $message: AddMessageThreadMessageInput!) { addMessage(messageThreadId: $messageThreadId, message: $message) { id } }";

  public static final String OPERATION_NAME = "AddMessage";

  public final String messageThreadId;

  public final AddMessageThreadMessageInput message;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public AddMessageMutation(String messageThreadId, AddMessageThreadMessageInput message) {
    this.messageThreadId = messageThreadId;
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AddMessageMutation) {
      AddMessageMutation that = (AddMessageMutation) o;
      return ((this.messageThreadId == null) ? (that.messageThreadId == null) : this.messageThreadId.equals(that.messageThreadId))
       &&((this.message == null) ? (that.message == null) : this.message.equals(that.message));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (messageThreadId == null) ? 0 : messageThreadId.hashCode();
      __h *= 1000003;
      __h ^= (message == null) ? 0 : message.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "AddMessageMutation{"
        + "messageThreadId=" + messageThreadId + ", "
        + "message=" + message
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
    AddMessageMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(AddMessageMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(AddMessageMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private String messageThreadId;

    private AddMessageThreadMessageInput message;

    Builder() {
    }

    public Builder messageThreadId(String messageThreadId) {
      this.messageThreadId = messageThreadId;
      return this;
    }

    public Builder message(AddMessageThreadMessageInput message) {
      this.message = message;
      return this;
    }

    public AddMessageMutation build() {
      return new AddMessageMutation(messageThreadId, message);
    }
  }

  public static class Data implements Mutation.Data {
    /**
     *  Add message to message thread 
     */
    public AddMessage addMessage;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(AddMessage addMessage) {
      this.addMessage = addMessage;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.addMessage == null) ? (that.addMessage == null) : this.addMessage.equals(that.addMessage));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (addMessage == null) ? 0 : addMessage.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "addMessage=" + addMessage
          + "}";
      }
      return $toString;
    }
  }

  public static class AddMessage {
    /**
     *  The message Id
     */
    public String id;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public AddMessage(String id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof AddMessage) {
        AddMessage that = (AddMessage) o;
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
        $toString = "AddMessage{"
          + "id=" + id
          + "}";
      }
      return $toString;
    }
  }
}