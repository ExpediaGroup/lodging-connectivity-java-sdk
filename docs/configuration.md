# SDK Configuration

The `ExpediaGroupClientConfiguration` object is used to configure the different clients provided from the SDK to interact with various endpoints and services. This section provides a detailed breakdown of how to configure these SDK clients and customize various settings.

## Basic Configuration

The essential configuration parameters are the `key` and `secret`. These are required for authenticating requests to the API.

### Example:

```java
ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
                    .builder()
                    .key("YOUR_API_KEY")
                    .secret("YOUR_API_SECRET")
                    .build();
```

## Optional Configuration Parameters

In addition to the basic configuration, the SDK offers several optional parameters to customize various aspects of the connection and request handling.

### 1. **Endpoint (Optional)**

```java
.endpoint("https://api.yourdomain.com")
```
- **Description**: This parameter allows you to specify a custom API domain.
- **Default**: If not provided, the SDK uses the default API domain https://api.expediagroup.com.

### 2. **Auth Endpoint (Optional)**

```java
.authEndpoint("https://auth.yourdomain.com")
```
- **Description**: If the API requires a separate authentication endpoint, this can be specified here.
- **Default**: If not provided, the SDK uses the default authentication endpoint.

### 3. **Connection Timeout (Optional)**

```java
.connectionTimeout(1000) // in milliseconds
```
- **Description**: Specifies the maximum time (in milliseconds) the SDK should wait to establish a connection to the API.
- **Default**: A reasonable default value is set internally, but it can be adjusted based on network conditions.

### 4. **Request Timeout (Optional)**

```java
.requestTimeout(1000) // in milliseconds
```
- **Description**: Sets the maximum time (in milliseconds) the SDK should wait for a response after a request is sent.
- **Default**: Defaults to an internal value but can be adjusted for long-running operations.

### 5. **Socket Timeout (Optional)**

```java
.socketTimeout(1000) // in milliseconds
```
- **Description**: The time (in milliseconds) the SDK will wait for data while reading from the API.
- **Default**: Similar to request timeout, an internal default is set.

### 6. **Masked Logging Headers (Optional)**

```java
.maskedLoggingHeaders(Set.of("API-Key"))
```
- **Description**: Allows you to specify which HTTP headers should be masked when logging requests and responses. This is particularly useful for sensitive headers like `Authorization`.
- **Default**: ['authorization', 'auth'] - Case Insensitive.

### 7. **Masked Logging Body Fields (Optional)**

```java
.maskedLoggingBodyFields(Set.of("password", "creditCardNumber"))
```
- **Description**: Allows you to specify which fields in the request/response body should be masked in logs. This is useful for protecting sensitive information like passwords or credit card details.
- **Default**: ['pin', 'access_token', 'card_number', 'security_code', 'account_number', 'card_avs_response', 'card_cvv_response'] - Case Insensitive.

## Full Example Configuration

Here’s an example that uses all the available configuration options:

```java
ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
                    .builder()
                    .key("YOUR_API_KEY")
                    .secret("YOUR_API_SECRET")
                    .endpoint("https://api.yourdomain.com")
                    .authEndpoint("https://auth.yourdomain.com")
                    .connectionTimeout(5000)
                    .requestTimeout(5000)
                    .socketTimeout(5000)
                    .maskedLoggingHeaders(Set.of("Authorization", "API-Key"))
                    .maskedLoggingBodyFields(Set.of("password", "creditCardNumber"))
                    .build();
```

## Summary of Configuration Options

| Parameter                 | Required | Description                                                        |
|---------------------------|----------|--------------------------------------------------------------------|
| `key`                     | Yes      | Your API key for authentication.                                   |
| `secret`                  | Yes      | Your API secret for authentication.                                |
| `endpoint`                | No       | Specifies the base URL for API requests.                           |
| `authEndpoint`            | No       | Specifies a custom authentication endpoint.                        |
| `connectionTimeout`       | No       | Time to wait when establishing a connection.                       |
| `requestTimeout`          | No       | Time to wait for a response after sending a request.               |
| `socketTimeout`           | No       | Time to wait for data while reading from the API.                  |
| `maskedLoggingHeaders`    | No       | Headers that should be masked when logging.                        |
| `maskedLoggingBodyFields` | No       | Fields in the request/response body that should be masked in logs. |
