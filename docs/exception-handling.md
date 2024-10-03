# Exception Handling

The Expedia Group Lodging Connectivity SDK for Java uses runtime (unchecked) exceptions to relay errors. At the root of the exception hierarchy is `ExpediaGroupException`, from which all other exceptions are extended. `ExpediaGroupException` is never thrown directly.


## `ExpediaGroupClientException`

Thrown at client errors, either when trying to send the request or parse the response. In principle, an `ExpediaGroupClientException` is assumed to be not retryable, and they should typically be fixed during development.

| Exception                               | Description                                                         |
|-----------------------------------------|---------------------------------------------------------------------|
| `ExpediaGroupConfigurationException`    | An exception that is thrown when a configuration error occurs.      |
| `ExpediaGroupInvalidFieldNameException` | Thrown to indicate that one or more passed field names are invalid. |


## `ExpediaGroupServiceException`

Thrown when the downstream service returns an error response; that is, the service successfully received the request, but it was not able to process it. The exception object provides the caller with several pieces of information about the error, including an HTTP status code and a detailed message.

An `ExpediaGroupServiceException` might be recoverable, such as errors resulting from a service being temporarily unavailable. Error handling, including retrying failed requests, should be focused on `ExpediaGroupServiceExceptions`.

| Exception                   | Description                                    |
|-----------------------------|------------------------------------------------|
| `ExpediaGroupAuthException` | Thrown when authentication with the API fails. |

### GraphQL Errors Handling
Conventionally, GraphQL APIs always return `200` HTTP status and rely on `GraphQLErrors` response object to hold the occurred errors. However, The SDK handles these `GraphQLErrors` by throwing a new `ExpediaGroupServiceException` if the response has any errors. So, users are expected to properly catch and handle these errors.

