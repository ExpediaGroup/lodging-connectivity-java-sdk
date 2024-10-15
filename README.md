# Expedia Group Lodging Connectivity Java SDK

Designed to simplify Lodging Connectivity API integration, handles the technical complexities, empowering partners to
focus on their core business needs.

With robust features and seamless integration, it enhances developer productivity, providing all necessary tools to efficiently query and mutate data from GraphQL APIs.

## Key Features
1. Pre-Built Operations for Lodging Connectivity GraphQL APIs
2. Strongly Typed Responses
3. Authentication & Automatic Token Renewal
4. Logging & Sensitive Data Masking
5. Error Handling

## Installation
Make sure you have **Java 8** or higher.

**Gradle**
```groovy
// gradle.build
dependencies {
    implementation 'com.expediagroup:lodging-connectivity-sdk:1.0.4-SNAPSHOT'
}
```

**Maven**
```xml
<!-- pom.xml -->
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>lodging-connectivity-sdk</artifactId>
    <version>1.0.4-SNAPSHOT</version>
</dependency>
```

>[!NOTE]
> The SDK is currently published as SNAPSHOT versions, so you will need to configure your build tool to pull packages from the Maven snapshots repository
> 
> **Gradle**
> ```groovy
> repositories {
>   maven {
>      url "https://oss.sonatype.org/content/repositories/snapshots/"
>    }
> }
> ```
> 
> **Maven**
> ```xml
> <repositories>
>    <repository>
>        <id>sonatype-snapshots</id>
>        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
>        <releases>
>            <enabled>false</enabled>
>        </releases>
>        <snapshots>
>            <enabled>true</enabled>
>        </snapshots>
>    </repository>
> </repositories>
> ```
## Quick Start
Once you have the SDK dependency installed, you can start using its capabilities. The SDK contains three different clients, each used to interact with a specific capability in Lodging Connectivity APIs.

1. Reservation Client
2. Payment Client
3. Sandbox Data Management Client

### Typical Usage Flow
Follow these three simple steps to start using any client in the SDK:

1. Build the client configuration object.

   ```java
   ClientConfiguration config = ClientConfiguration
           .builder()
           .key("KEY")
           .secret("SECRET")
           .build();
   ```

2. Initialize a client.
   ```java
   ReservationClient reservationClient = new ReservationClient(config); // Taking ReservationClient as an example
   ```
3. Execute operations
   ```java
   reservationClient.execute(/* GraphQL Operation */);
   ```

## Documentation
The list below lists detailed documentation files for some components of the SDK. Whether you're looking to configure the SDK, explore the pre-built GraphQL operations, or learn how to use specific clients, the following resources will guide you through all the necessary steps.

1. [Reservation Client Documentation](docs/supply-client.md)
2. [Payment Client Documentation](docs/payment-client.md)
3. [Sandbox Data Management Client Documentation](docs/sandbox-data-management-client.md)
4. [Configuration](docs/configuration.md)
5. [Logging](docs/logging.md)
6. [Exception Handling](docs/exception-handling.md)

## Related Resources
- [EG Connectivity Hub](https://developers.expediagroup.com/supply/lodging)
- [EG Lodging Connectivity SDK GraphQL Operations Definitions](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations)
- [EG Lodging Connectivity Node.JS SDK](https://github.com/ExpediaGroup/lodging-connectivity-nodejs-sdk)
