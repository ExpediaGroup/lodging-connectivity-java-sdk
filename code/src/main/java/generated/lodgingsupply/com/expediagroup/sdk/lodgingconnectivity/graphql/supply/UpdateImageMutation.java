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
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateImageMutation_ResponseAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.adapter.UpdateImageMutation_VariablesAdapter;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.selections.UpdateImageMutationSelections;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.ImageSource;
import com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.UpdateImageInput;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class UpdateImageMutation implements Mutation<UpdateImageMutation.Data> {
  public static final String OPERATION_ID = "85f1668a916ddd9eb1b4355db2fc1fd760c23849cbe24d4c7885c3ca6b4f85fb";

  /**
   * The minimized GraphQL document being sent to the server to save a few bytes.
   * The un-minimized version is:
   *
   * mutation UpdateImage($input: UpdateImageInput!) {
   *   updateImage(input: $input) {
   *     clientMutationId
   *     image {
   *       active
   *       captions {
   *         locale
   *         value
   *       }
   *       featured
   *       fileName
   *       id
   *       order
   *       originalUrl
   *       property {
   *         id
   *       }
   *       publishedUrl
   *       rotation
   *       source
   *       status {
   *         reason
   *         type
   *       }
   *       updatedDate
   *     }
   *   }
   * }
   */
  public static final String OPERATION_DOCUMENT = "mutation UpdateImage($input: UpdateImageInput!) { updateImage(input: $input) { clientMutationId image { active captions { locale value } featured fileName id order originalUrl property { id } publishedUrl rotation source status { reason type } updatedDate } } }";

  public static final String OPERATION_NAME = "UpdateImage";

  public final UpdateImageInput input;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public UpdateImageMutation(UpdateImageInput input) {
    this.input = input;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateImageMutation) {
      UpdateImageMutation that = (UpdateImageMutation) o;
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
      $toString = "UpdateImageMutation{"
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
    UpdateImageMutation_VariablesAdapter.INSTANCE.serializeVariables(writer, this, customScalarAdapters, withDefaultValues);
  }

  @Override
  public Adapter<Data> adapter() {
    return new ObjectAdapter<Data>(UpdateImageMutation_ResponseAdapter.Data.INSTANCE, false);
  }

  @Override
  public CompiledField rootField() {
    return new CompiledField.Builder(
      "data",
      com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type.Mutation.type
    )
    .selections(UpdateImageMutationSelections.__root)
    .build();
  }

  public static final class Builder {
    private UpdateImageInput input;

    Builder() {
    }

    public Builder input(UpdateImageInput input) {
      this.input = input;
      return this;
    }

    public UpdateImageMutation build() {
      return new UpdateImageMutation(input);
    }
  }

  public static class Data implements Mutation.Data {
    public UpdateImage updateImage;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Data(UpdateImage updateImage) {
      this.updateImage = updateImage;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateImage == null) ? (that.updateImage == null) : this.updateImage.equals(that.updateImage));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (updateImage == null) ? 0 : updateImage.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateImage=" + updateImage
          + "}";
      }
      return $toString;
    }
  }

  public static class UpdateImage {
    public String clientMutationId;

    public Image image;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public UpdateImage(String clientMutationId, Image image) {
      this.clientMutationId = clientMutationId;
      this.image = image;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateImage) {
        UpdateImage that = (UpdateImage) o;
        return ((this.clientMutationId == null) ? (that.clientMutationId == null) : this.clientMutationId.equals(that.clientMutationId))
         &&((this.image == null) ? (that.image == null) : this.image.equals(that.image));
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
        __h ^= (image == null) ? 0 : image.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateImage{"
          + "clientMutationId=" + clientMutationId + ", "
          + "image=" + image
          + "}";
      }
      return $toString;
    }
  }

  public static class Image {
    public Boolean active;

    public List<Caption> captions;

    public Boolean featured;

    public String fileName;

    public String id;

    public Integer order;

    public String originalUrl;

    public Property property;

    public String publishedUrl;

    /**
     * Clockwise rotation to be applied to the image. Accepted values are 0, 90, 180 and 270. Defaults to 0 when not provided.
     */
    public Integer rotation;

    public ImageSource source;

    public Status status;

    public Object updatedDate;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Image(Boolean active, List<Caption> captions, Boolean featured, String fileName,
        String id, Integer order, String originalUrl, Property property, String publishedUrl,
        Integer rotation, ImageSource source, Status status, Object updatedDate) {
      this.active = active;
      this.captions = captions;
      this.featured = featured;
      this.fileName = fileName;
      this.id = id;
      this.order = order;
      this.originalUrl = originalUrl;
      this.property = property;
      this.publishedUrl = publishedUrl;
      this.rotation = rotation;
      this.source = source;
      this.status = status;
      this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Image) {
        Image that = (Image) o;
        return ((this.active == null) ? (that.active == null) : this.active.equals(that.active))
         &&((this.captions == null) ? (that.captions == null) : this.captions.equals(that.captions))
         &&((this.featured == null) ? (that.featured == null) : this.featured.equals(that.featured))
         &&((this.fileName == null) ? (that.fileName == null) : this.fileName.equals(that.fileName))
         &&((this.id == null) ? (that.id == null) : this.id.equals(that.id))
         &&((this.order == null) ? (that.order == null) : this.order.equals(that.order))
         &&((this.originalUrl == null) ? (that.originalUrl == null) : this.originalUrl.equals(that.originalUrl))
         &&((this.property == null) ? (that.property == null) : this.property.equals(that.property))
         &&((this.publishedUrl == null) ? (that.publishedUrl == null) : this.publishedUrl.equals(that.publishedUrl))
         &&((this.rotation == null) ? (that.rotation == null) : this.rotation.equals(that.rotation))
         &&((this.source == null) ? (that.source == null) : this.source.equals(that.source))
         &&((this.status == null) ? (that.status == null) : this.status.equals(that.status))
         &&((this.updatedDate == null) ? (that.updatedDate == null) : this.updatedDate.equals(that.updatedDate));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (active == null) ? 0 : active.hashCode();
        __h *= 1000003;
        __h ^= (captions == null) ? 0 : captions.hashCode();
        __h *= 1000003;
        __h ^= (featured == null) ? 0 : featured.hashCode();
        __h *= 1000003;
        __h ^= (fileName == null) ? 0 : fileName.hashCode();
        __h *= 1000003;
        __h ^= (id == null) ? 0 : id.hashCode();
        __h *= 1000003;
        __h ^= (order == null) ? 0 : order.hashCode();
        __h *= 1000003;
        __h ^= (originalUrl == null) ? 0 : originalUrl.hashCode();
        __h *= 1000003;
        __h ^= (property == null) ? 0 : property.hashCode();
        __h *= 1000003;
        __h ^= (publishedUrl == null) ? 0 : publishedUrl.hashCode();
        __h *= 1000003;
        __h ^= (rotation == null) ? 0 : rotation.hashCode();
        __h *= 1000003;
        __h ^= (source == null) ? 0 : source.hashCode();
        __h *= 1000003;
        __h ^= (status == null) ? 0 : status.hashCode();
        __h *= 1000003;
        __h ^= (updatedDate == null) ? 0 : updatedDate.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Image{"
          + "active=" + active + ", "
          + "captions=" + captions + ", "
          + "featured=" + featured + ", "
          + "fileName=" + fileName + ", "
          + "id=" + id + ", "
          + "order=" + order + ", "
          + "originalUrl=" + originalUrl + ", "
          + "property=" + property + ", "
          + "publishedUrl=" + publishedUrl + ", "
          + "rotation=" + rotation + ", "
          + "source=" + source + ", "
          + "status=" + status + ", "
          + "updatedDate=" + updatedDate
          + "}";
      }
      return $toString;
    }
  }

  public static class Caption {
    public Object locale;

    public String value;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Caption(Object locale, String value) {
      this.locale = locale;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Caption) {
        Caption that = (Caption) o;
        return ((this.locale == null) ? (that.locale == null) : this.locale.equals(that.locale))
         &&((this.value == null) ? (that.value == null) : this.value.equals(that.value));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (locale == null) ? 0 : locale.hashCode();
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
        $toString = "Caption{"
          + "locale=" + locale + ", "
          + "value=" + value
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

  public static class Status {
    public String reason;

    public String type;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    private transient volatile String $toString;

    public Status(String reason, String type) {
      this.reason = reason;
      this.type = type;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Status) {
        Status that = (Status) o;
        return ((this.reason == null) ? (that.reason == null) : this.reason.equals(that.reason))
         &&((this.type == null) ? (that.type == null) : this.type.equals(that.type));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int __h = 1;
        __h *= 1000003;
        __h ^= (reason == null) ? 0 : reason.hashCode();
        __h *= 1000003;
        __h ^= (type == null) ? 0 : type.hashCode();
        $hashCode = __h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Status{"
          + "reason=" + reason + ", "
          + "type=" + type
          + "}";
      }
      return $toString;
    }
  }
}
