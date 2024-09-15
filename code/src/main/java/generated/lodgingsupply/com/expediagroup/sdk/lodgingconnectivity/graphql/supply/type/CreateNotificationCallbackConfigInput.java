//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.4'.
//
package com.expediagroup.sdk.lodgingconnectivity.graphql.supply.type;

import com.apollographql.apollo3.api.Optional;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.net.URL;

public class CreateNotificationCallbackConfigInput {
  public final URL callbackUrl;

  public final String apiKey;

  public final Optional<Integer> requestTimeoutSeconds;

  public final String contactEmail;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  private transient volatile String $toString;

  public CreateNotificationCallbackConfigInput(URL callbackUrl, String apiKey,
      Optional<Integer> requestTimeoutSeconds, String contactEmail) {
    this.callbackUrl = callbackUrl;
    this.apiKey = apiKey;
    this.requestTimeoutSeconds = requestTimeoutSeconds;
    this.contactEmail = contactEmail;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CreateNotificationCallbackConfigInput) {
      CreateNotificationCallbackConfigInput that = (CreateNotificationCallbackConfigInput) o;
      return ((this.callbackUrl == null) ? (that.callbackUrl == null) : this.callbackUrl.equals(that.callbackUrl))
       &&((this.apiKey == null) ? (that.apiKey == null) : this.apiKey.equals(that.apiKey))
       &&((this.requestTimeoutSeconds == null) ? (that.requestTimeoutSeconds == null) : this.requestTimeoutSeconds.equals(that.requestTimeoutSeconds))
       &&((this.contactEmail == null) ? (that.contactEmail == null) : this.contactEmail.equals(that.contactEmail));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int __h = 1;
      __h *= 1000003;
      __h ^= (callbackUrl == null) ? 0 : callbackUrl.hashCode();
      __h *= 1000003;
      __h ^= (apiKey == null) ? 0 : apiKey.hashCode();
      __h *= 1000003;
      __h ^= (requestTimeoutSeconds == null) ? 0 : requestTimeoutSeconds.hashCode();
      __h *= 1000003;
      __h ^= (contactEmail == null) ? 0 : contactEmail.hashCode();
      $hashCode = __h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "CreateNotificationCallbackConfigInput{"
        + "callbackUrl=" + callbackUrl + ", "
        + "apiKey=" + apiKey + ", "
        + "requestTimeoutSeconds=" + requestTimeoutSeconds + ", "
        + "contactEmail=" + contactEmail
        + "}";
    }
    return $toString;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private URL callbackUrl;

    private String apiKey;

    private Optional<Integer> requestTimeoutSeconds = Optional.absent();

    private String contactEmail;

    Builder() {
    }

    /**
     * Callback url of callback configuration
     */
    public Builder callbackUrl(URL callbackUrl) {
      this.callbackUrl = callbackUrl;
      return this;
    }

    /**
     * api key of callback configuration
     */
    public Builder apiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Request timeout in seconds of callback configuration
     */
    public Builder requestTimeoutSeconds(Integer requestTimeoutSeconds) {
      this.requestTimeoutSeconds = Optional.present(requestTimeoutSeconds);
      return this;
    }

    /**
     * Email address for correspondence
     */
    public Builder contactEmail(String contactEmail) {
      this.contactEmail = contactEmail;
      return this;
    }

    public CreateNotificationCallbackConfigInput build() {
      return new CreateNotificationCallbackConfigInput(callbackUrl, apiKey, requestTimeoutSeconds, contactEmail);
    }
  }
}