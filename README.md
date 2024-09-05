# Expedia Group<sup>TM</sup> Lodging Connectivity Java SDK

Designed to simplify Lodging Connectivity API integration, handles the technical complexities, empowering partners to
focus on their core business needs.

With robust features and seamless integration, it enhances developer productivity, providing all necessary tools to efficiently query and mutate data from GraphQL APIs.

## Key Features
1. **Pre-Built Operations for Lodging Connectivity GraphQL APIs**
2. **Strongly Typed Responses**
3. **Authentication & Automatic Token Renewal**
4. **Logging & Sensitive Data Masking**
5. **Error Handling**

## Installation
Make sure you have **Java 8** or higher.

**Gradle**
```groovy
// gradle.build
dependencies {
    implementation 'com.expediagroup:lodging-connectivity-java-sdk:1.0.0'
}
```

**Maven**
```xml
<!-- pom.xml -->
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>lodging-connectivity-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Quick Start
Once you have the SDK dependency installed, you can start using its capabilities. The SDK contains four different clients, each linked to a separate endpoint

1. **Supply Client**
2. **Payment Client**
3. **Sandbox  Client**
4. **File Management Client**

### Typical Usage Flow
Follow these three simple steps to start using any client in the SDK:

1. Build the client configuration object.

   ```java
   ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
     .builder()
     .key("KEY")
     .secret("SECRET")
     .build();
   ```

2. Initialize a client.
   ```java
   SupplyClient supplyClient = new SupplyClient(config); // Taking SupplyClient as an example
   ```
3. Execute operations
   ```java
   supplyClient.execute(/* GraphQL Operation */);
   ```

## Documentation
