# Expedia Group<sup>TM</sup> Lodging Connectivity Java SDK

Designed to simplify Lodging Connectivity API integration, handles the technical complexities, empowering partners to
focus on their core business needs.

## Overview

The SDK exports multiple clients, where each client communicate with one API endpoint. So far there are three different
clients available:

1. `LodgingSupplyClient`: Connected to [lodging supply **GraphQL
   ** API](https://test-api.expediagroup.com/supply/lodging/graphql)


2. `LodgingSupplyPaymentClient`: Connected to [lodging supply payments **GraphQL
   ** API](https://test-api.expediagroup.com/supply/payments/graphql)


3. `LodgingSupplyFileManagementClient`: Connected to [lodging supply file management service **REST
   ** API](https://test-api.expediagroup.com/supply-lodging/v1/files)

In addition, the SDK offers a set of useful features to facilitate the communication with the APIs. Below are some
highlighted features and capabilities:

1. Authentication and automatic token renewal.
2. Logging and sensitive data masking.
3. Schema and operation validation *(for GraphQL APIs)*.
4. Apollo Kotlin integration *(for GraphQL APIs)*.

## Installation

**NOTE: You can use the `/examples` module included in this repo as a quick start.**

This SDK is currently available as a `SNAPSHOT` version from our internal artifactory:

```groovy
// gradle.build.kts
dependencies {
    implementation 'com.expediagroup:lodging-connectivity-java-sdk:0.0.10-SNAPSHOT'
    implementation 'com.apollographql.apollo3:apollo-runtime:3.8.4'
}
```

Make sure you have the internal repository configured with the required credentials.

```groovy
repositories {
    mavenCentral()
    maven {
        url "https://artylab.expedia.biz/expediagroup-maven-snapshot-local/"
        credentials {
            username findProperty("artifactory_user")
            password findProperty("artifactory_password")
        }
    }
}
```

Please note that you must have the properties `artifactory_user` & `artifactory_password` defined in `gradle.properties`
file (or any parent `gradle.properties` file).

## Basic Usage Example

*Please refer to
this [exmaple](https://github.expedia.biz/eg-control-plane/lodging-connectivity-java-sdk/blob/main/examples/src/main/java/com/expediagroup/sdk/lodgingconnectivity/LodgingConnectivitySdkDemoApplication.java)
for more complete usage overview*

In general, you should follow these three steps to get the client up and running:
<details>
   <summary>Create Client Configuration Instance</summary>

To start using the SDK, you need to create a configuration object of type `ExpediaGroupClientConfiguration`, then pass
it as a parameter to your client. The same object can be used to instantiate any of the available clients in this SDK.

   ```java
   var config = ExpediaGroupClientConfiguration.builder()
        .key("KEY")
        .secret("SECRET")
        .authEndpoint("https://test-api.expediagroup.com/identity/oauth2/v3/token") // Optional
        .endpoint("https://test-api.expediagroup.com") // Optional (uses the prod endpoint by default)
        .build();
   ```

</details>

<details>
   <summary>Instantiate the Client</summary>
   You can either initialize all clients using the same configuration object, or create other configurations for any client if needed.

   ```java
   var lodgingSupplyClient = new LodgingSupplyClient(config);
   ```

   ```java
   var fileManagementClient = new LodgingSupplyFileManagementClient(config);
   ```

   ```java
   var paymentClient = new LodgingSupplyPaymentClient(config);
   ```

</details>

<details>
   <summary>Make Calls</summary>

   ```java
   lodgingSupplyClient.execute(/*GQL Operation*/);
   ```

   ```java
   paymentClient.execute(/*GQL Operation*/);
   ```

   ```java
   fileManagementClient.download(/*params*/);
   fileManagementClient.

upload(/*params*/);
   ```

</details>

## Capabilities & Available Clients

### File Management - REST Client

*This client calls https://api.expediagroup.com/supply-lodging/v1/files endpoint by default.*

```java
var client = new LodgingSupplyFileManagementClient(config);

// Download Attachment Example
try(
var bos = new BufferedOutputStream(new FileOutputStream("image.png"))){
var downloadedAttachment = fileManagementClient.download("f97e884e-6caf-4bee-8b83-32a7cb96daa8", "messageId", "63363feb-2370-4cca-8b85-232597ff7438");

// Write the downloaded attachment to a file
    bos.

write(downloadedAttachment);
}catch(
IOException e){
        e.

printStackTrace();
}
```

```java
// Upload Attachment Example
File file = new File("image.png");
var response = client.upload(file, "messageThreadId", "5b3423da-af09-485a-9490-95b4452fbca0");
```

### Lodging Supply - GraphQL Client

*This client calls https://api.expediagroup.com/supply/lodging/graphql endpoint by default.*

```java
// Execute predefined methods using your defined LodgingSupplyClient instance 
var client = new LodgingSupplyClient(config);

var getPropertyQuery = GetPropertyQuery.builder().id("100000015").build();

var response = client.execute(getPropertyQuery);

System.out.

println(response.data);
```

**Available Operations:**

| Name                                               | Operation Class                                   | Input Variables                                                                                                                                                     | Type     |
|----------------------------------------------------|---------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
| Property                                           | `PropertyQuery`                                   | `propertyId: String!`<br/>`idSource: IdSource`<br/>`checkOutDate: CheckOutDateFilter`<br/>`filter: ReservationFilterInput`<br/>`pageSize: Int!`<br/>`after: String` | Query    |
| Notification Profile                               | `NotificationProfileQuery`                        | -                                                                                                                                                                   | Query    |
| Notification Event Types                           | `NotificationEventTypesQuery`                     | -                                                                                                                                                                   | Query    |
| Subscribe Notification Event Type                  | `SubscribeNotificationEventTypeMutation`          | `input: SubscribeNotificationEventTypeInput!`                                                                                                                       | Mutation |
| Unsubscribe Notification Event Type                | `UnsubscribeNotificationEventTypeMutation`        | `input: UnsubscribeNotificationEventTypeInput!`                                                                                                                     | Mutation |
| Update Notification Event Type Subscription        | `UpdateNotificationEventTypeSubscriptionMutation` | `input: UpdateNotificationEventTypeSubscriptionInput!`                                                                                                              | Mutation |
| Send Test Notification                             | `SendTestNotificationMutation`                    | `input: SendTestNotificationInput!`                                                                                                                                 | Mutation |
| Create Notification Callback Configuration         | `CreateNotificationCallbackConfigMutation`        | `input: CreateNotificationCallbackConfigInput!`                                                                                                                     | Mutation |
| Update Notification Callback Configuration         | `UpdateNotificationCallbackConfigMutation`        | `input: UpdateNotificationCallbackConfigInput!`                                                                                                                     | Mutation |
| Delete Notification Callback Configuration         | `DeleteNotificationCallbackConfigMutation`        | `input: DeleteNotificationCallbackConfig!`                                                                                                                          | Mutation |
| Refresh Notification Callback Configuration Secret | `RefreshNotificationCallbackConfigSecretMutation` | `input: RefreshNotificationCallbackConfigSecretInput!`                                                                                                              | Mutation |
| Refund Reservation                                 | `RefundReservationMutation`                       | `input: RefundReservationInput!`                                                                                                                                    | Mutation |
| Cancel Reservation                                 | `CancelReservationMutation`                       | `input: CancelReservationInput!`                                                                                                                                    | Mutation |
| Confirm Reservation Notification                   | `ConfirmReservationNotificationMutation`          | `input: ConfirmReservationNotificationInput!`                                                                                                                       | Mutation |
| Change Reservation Reconciliation                  | `ChangeReservationReconciliationMutation`         | `input: ChangeReservationReconciliationInput!`                                                                                                                      | Mutation |
| Cancel Reservation Reconciliation                  | `CancelReservationReconciliationMutation`         | `input: CancelReservationReconciliationInput!`                                                                                                                      | Mutation |

### Lodging Supply Payments - GraphQL Client

*This client calls https://api.expediagroup.com/supply/payments/graphql endpoint by default.*

```java
var client = new LodgingSupplyPaymentClient(config);

var paymentInstrumentQuery = PaymentInstrumentQuery.builder().token("token1234").build();

var response = client.execute(paymentInstrumentQuery);

System.out.

println(response.data);
```

**Available Operations:**

| Name               | Operation Class          | Input Variables  | Type  |
|--------------------|--------------------------|------------------|-------|
| Payment Instrument | `PaymentInstrumentQuery` | `token: String!` | Query |

### Lodging Supply Sandbox - GraphQL Client

A special client connected to the Lodging Supply sandbox environment, allowing users to create and consume test data.
This makes integration and testing easier without the risk of corrupting live data.

This client calls https://api.expediagroup.com/supply/lodging-sandbox/graphql endpoint by default.

```java
var client = new LodgingSupplySandboxClient(config);

var createPropertyInput = CreatePropertyInput.builder().name("My Test Property").build();
var createPropertyMutation = new SandboxCreatePropertyMutation(input);

var createPropertyResponse = client.execute(createPropertyMutation);

System.out.

print(createPropertyResponse.data);
```

Check out the example
code [here](https://github.expedia.biz/eg-control-plane/lodging-connectivity-java-sdk/blob/main/examples/src/main/java/com/expediagroup/sdk/lodgingconnectivity/LodgingSupplySandboxClientUsageExample.java),
when you run the `main` method, it will:

1. Create a Property
2. Update the Property
3. Create a Reservation
4. Update the Reservation
5. Update the Reservation's Stay Dates
6. Cancel the Reservation
7. Delete the Reservation
8. Delete the Property

**Available Operations:**

| Name                          | Operation Class                     | Input Variables                                                                                          | Type     |
|-------------------------------|-------------------------------------|----------------------------------------------------------------------------------------------------------|----------|
| Properties                    | `SandboxPropertiesQuery`            | `cursor: String`<br/>`limit: Int`<br/>`skipReservations: Boolean!`                                       | Query    |
| Property                      | `SandboxPropertyQuery`              | `id: ID!`<br/>`reservationsCursor: String`<br/>`reservationsLimit: Int`<br/>`skipReservations: Boolean!` | Query    |
| Reservation                   | `SandboxReservation`                | `id: ID!`                                                                                                | Query    |
| Create Property               | `SandboxCreateProperty`             | `input: CreatePropertyInput!`                                                                            | Mutation |
| Update Property               | `SandboxUpdateProperty`             | `input: UpdatePropertyInput!`                                                                            | Mutation |
| Delete Property Reservations  | `SandboxDeletePropertyReservations` | `input: DeletePropertyReservationsInput!`                                                                | Mutation |
| Delete Property               | `SandboxDeleteProperty`             | `input: DeletePropertyInput!`                                                                            | Mutation |
| Create Reservation            | `SandboxCreateReservation`          | `input: CreateReservationInput!`                                                                         | Mutation |
| Update Reservation            | `SandboxUpdateReservation`          | `input: UpdateReservationInput!`                                                                         | Mutation |
| Change Reservation Stay Dates | `SandboxChangeReservationStayDates` | `input: ChangeReservationStayDatesInput!`                                                                | Mutation |
| Cancel Reservation            | `SandboxCancelReservation`          | `input: CancelReservationInput!`                                                                         | Mutation |
| Delete Reservation            | `SandboxDeleteReservation`          | `input: DeleteReservationInput!`                                                                         | Mutation |

```java
var client = new LodgingSupplyPaymentClient(config);

var paymentInstrument = client.getPaymentInstrument("token1234"); // convenience method

System.out.

println(paymentInstrument.data);
```

## Extended Operations for GraphQL Clients

The SDK uses [Apollo Kotlin](https://www.apollographql.com/docs/kotlin/) under the hood for the clients that communicate
with GraphQL APIs, this gives you the ability to define your own custom GraphQL operations and use the same client to
execute these operations.

You need to add Apollo Kotlin to the dependencies and apply the generation plugin:

```groovy
// Refer to Apollo's official documentation for more information about the setup steps.
// https://www.apollographql.com/docs/kotlin/tutorial/01-configure-project
plugins {
    id 'com.apollographql.apollo3' version '3.8.3'
}
```

Note: You have to fetch the schema and store it locally under `src/main/graphql` to be able to generate these
operations.

```java
 // Custom class generated from your custom query or mutation by Apollo Kotlin library
var myCustomQuery = new MyCustomQuery();

// Use the execute() method from your defined client instance
var response = client.execute(myCustomQuery);
        
System.out.

println(response.data);
```
