# Logging
Expedia Group Lodging Connectivity SDK for Java does not impose a logging framework on clients, and instead supports logging via the `SLF4J` interface. `SLF4J` provides an abstraction for various logging frameworks, allowing clients to plug in their desired implementation when building their projects.

Without a logging framework plugged in, the SDK (SLF4J) defaults to a no-operation, discarding all log requests with a single warning message.

## Declaring Project Dependencies
Plug in a particular logging framework by declaring it as a project dependency. By design, `SLF4J` can use only one framework at a time, and it will emit a warning message if it finds multiple frameworks.

### Simple Logger

**Maven**
```xml
<!-- pom.xml -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <!-- version -->
</dependency>
```

**Gradle**
```groovy
// gradle.build
dependencies {
    implementation group: 'org.slf4j', name: 'slf4j-simple'
}
```

### Java Util Logging

**Maven**
```xml
<!-- pom.xml -->
<dependency> 
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-jdk14</artifactId>
  <!-- version -->
</dependency>
```

**Gradle**
```groovy
// gradle.build
dependencies {
    implementation group: org.apache.logging.log4j, name: 'log4j-api'
}
```

### Logback

**Maven**
```xml
<!-- pom.xml -->
<dependency> 
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <!-- version -->
</dependency>
```

**Gradle**
```groovy
// gradle.build
dependencies {
  implementation group: 'ch.qos.logback', name: 'logback-classic'
}
```

## Log Format
Logging frameworks support custom log formatting and layouts and including details such as the timestamp and the logger name at the origin of the logging event helps troubleshoot the SDK. In addition, log messages are annotated with the prefix `ExpediaGroupSDK` against which they could be filtered out.

```text
13:36:59.287 [DefaultDispatcher-worker-1] INFO  c.e.s.c.c.c.ConfigurationCollector MDC= - ExpediaSDK: Successfully loaded [endpoint] from [runtime configuration]
```

## Log Levels
If you want to keep track of request and response data originating from and received by the SDK, you can set your log level at INFO, which would log them including header and body content; however, this could generate a significant amount of logging data. Setting the log level to WARN or ERROR would only log exceptions and errors which would still include a transaction ID that you can share with Expedia Group in case of unexpected behavior.

If you are troubleshooting an issue, you can set the log level to DEBUG to get more detailed information about the request and response, the logs at the DEBUG level include more verbose logging of the OkHttp client events and the transaction ID.

Example log messages at the DEBUG level:
```text
17:40:08.490 [DefaultDispatcher-worker-3] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Call start for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
17:40:08.496 [OkHttp https://test.ean.com/...] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Connect start for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
17:40:08.508 [OkHttp https://test.ean.com/...] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Connect end for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
17:40:08.508 [OkHttp https://test.ean.com/...] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Connection acquired for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
17:40:08.510 [OkHttp https://test.ean.com/...] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Sending request headers start for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
17:40:08.510 [OkHttp https://test.ean.com/...] DEBUG com.expediagroup.sdk.core.client.OkHttpEventListener - ExpediaSDK: Sending request headers end for transaction-id: [aff4c00d-6f79-4690-8f60-dd1aaccbfaee]
```

## Traceability
The SDK generates a unique `transaction ID` for every API call, which is useful for troubleshooting issues by tracing requests end-to-end. The transactions IDs are added to the request and response headers, and they are logged at the DEBUG level.
