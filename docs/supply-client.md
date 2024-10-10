# Supply Client
`SupplyClient` gives you access to the reservations capabilities in lodging connectivity APIs.

> [!NOTE]
> Supporting more capabilities like Promotions, Messaging, Reviews, etc... is work-in-progress at the moment and will be added soon to this client.


### API Endpoint
This client is connected with https://api.expediagroup.com/supply/lodging/graphql endpoint by default. 

You can refer to the [configuration](configuration.md) document to explore the full configuration options.

### Initialize the Client
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

SupplyClient supplyClient = new SupplyClient(config);
```

### Set the Environment (Optional)
`SupplyClient` can be configured to work in different environments, below is a list of the supported environments by this client:

| Environment                      | Corresponding API Endpoint                                       |
|----------------------------------|------------------------------------------------------------------|
| `ClientEnvironment.PROD`         | https://api.expediagroup.com/supply/lodging/graphql              |
| `ClientEnvironment.TEST`         | https://test-api.expediagroup.com/supply/lodging/graphql         |
| `ClientEnvironment.SANDBOX_PROD` | https://api.sandbox.expediagroup.com/supply/lodging/graphql      |
| `ClientEnvironment.SANDBOX_TEST` | https://test-api.sandbox.expediagroup.com/supply/lodging/graphql |

**Configuration with Environment Example**
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .environment(ClientEnvironement.SANDBOX_PROD)
        .build();
```

### Initialize GraphQL Operation 
```java
PropertyReservationsQuery reservationsQuery = PropertyReservationsQuery
        .builder()
        .propertyId("your_property_id")
        .pageSize(10)
        .build();
```

### Execute the operation
```java
try {
    PropertyReservationsQuery.Data reservationsData = supplyClient.execute(reservationsQuery);
}
catch(ExpediaGroupServiceException e) {
    e.printStackTrace();
}
```

## Available Operations
The SDK offers a set of queries & mutations you can execute using the `SupplyClient`. Below is an overview list of the available operations.

<br />

### SupplyClient - Queries

<hr />

<details>
   <summary>PropertyReservations</summary>

<br />

**Operation Class Name:** `PropertyReservationsQuery`

**Operation Inputs:**   

| Name                            | Type                     | Required              |
|---------------------------------|--------------------------|-----------------------|
| `propertyId`                    | `String!`                | Yes                   |
| `idSource`                      | `IdSource`               | No (default: EXPEDIA) |
| `pageSize`                      | `Int!`                   | No (default: 10)      |
| `cursor`                        | `String`                 | No                    |
| `filter`                        | `ReservationFilterInput` | No                    |
| `checkOutDate`                  | `CheckOutDateFilter`     | No                    |
| `includePaymentInstrumentToken` | `Boolean`                | No (default: false)   |
| `includeSupplierAmount`         | `Boolean`                | No (default: false)   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/reservations_query/) 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/queries/PropertyReservations.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyReservationsSummary</summary>

<br />

**Operation Class Name:** `PropertyReservationsSummaryQuery`

**Operation Inputs:**

| Name           | Type                     | Required              |
|----------------|--------------------------|-----------------------|
| `propertyId`   | `String!`                | Yes                   |
| `idSource`     | `IdSource`               | No (default: EXPEDIA) |
| `pageSize`     | `Int!`                   | No (default: 10)      |
| `cursor`       | `String`                 | No                    |
| `filter`       | `ReservationFilterInput` | No                    |
| `checkOutDate` | `CheckOutDateFilter`     | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/reservations_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/queries/PropertyReservationsSummary.graphql)
- [Reference]()

</details>

<hr />

<br /><br />

### SupplyClient - Mutations

<hr />


<details>
   <summary>CancelReservation</summary>

<br />

**Operation Class Name:** `CancelReservationMutation`

**Operation Inputs:**

| Name                            | Type                                   | Required            |
|---------------------------------|----------------------------------------|---------------------|
| `propertyId`                    | `ID!`                                  | Yes                 |
| `reservationId`                 | `ID!`                                  | Yes                 |
| `reason`                        | `ReservationPreStayCancellationReason` | No                  |
| `skipReservation`               | `Boolean! = false`                     | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false`                     | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false`                     | No (default: false) |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/cancelReservation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/CancelReservation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CancelReservationReconciliation</summary>

<br />

**Operation Class Name:** `CancelReservationReconciliationMutation`

**Operation Inputs:**

| Name                            | Type                             | Required            |
|---------------------------------|----------------------------------|---------------------|
| `propertyId`                    | `ID!`                            | Yes                 |
| `reservationId`                 | `ID!`                            | Yes                 |
| `reason`                        | `ReservationCancellationReason!` | Yes                 |
| `currencyCode`                  | `String`                         | No                  |
| `penaltyAmount`                 | `Float`                          | No                  |
| `skipReservation`               | `Boolean! = false`               | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false`               | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false`               | No (default: false) |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/cancelReservationReconciliation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/CancelReservationReconciliation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CancelVrboReservation</summary>

<br />

**Operation Class Name:** `CancelVrboReservationMutation`

**Operation Inputs:**

| Name                            | Type                              | Required            |
|---------------------------------|-----------------------------------|---------------------|
| `propertyId`                    | `ID!`                             | Yes                 |
| `reservationId`                 | `ID!`                             | Yes                 |
| `primaryReason`                 | `VrboCancellationReason!`         | Yes                 |
| `secondaryReason`               | `VrboCancellationSecondaryReason` | No                  |
| `clientMutationId`              | `String`                          | No                  |
| `cancellationPolicyOverride`    | `VrboCancellationPolicyOverride`  | No                  |
| `skipReservation`               | `Boolean! = false`                | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false`                | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false`                | No (default: false) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/CancelVrboReservation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ChangeReservationReconciliation</summary>

<br />

**Operation Class Name:** `ChangeReservationReconciliationMutation`

**Operation Inputs:**

| Name                            | Type                      | Required            |
|---------------------------------|---------------------------|---------------------|
| `propertyId`                    | `ID!`                     | Yes                 |
| `reservationId`                 | `ID!`                     | Yes                 |
| `checkInDate`                   | `LocalDate!`              | Yes                 |
| `checkOutDate`                  | `LocalDate!`              | Yes                 |
| `reason`                        | `ReservationChangeReason` | No                  |
| `supplierAmount`                | `SupplierAmountInput`     | No                  |
| `skipReservation`               | `Boolean! = false`        | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false`        | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false`        | No (default: false) |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/changeReservationReconciliation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/ChangeReservationReconciliation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ConfirmReservationNotification</summary>

<br />

**Operation Class Name:** `ConfirmReservationNotificationMutation`

**Operation Inputs:**

| Name                            | Type               | Required            |
|---------------------------------|--------------------|---------------------|
| `propertyId`                    | `ID!`              | Yes                 |
| `reservationId`                 | `ID!`              | Yes                 |
| `confirmationToken`             | `String!`          | Yes                 |
| `actionType`                    | `String!`          | Yes                 |
| `confirmationCode`              | `String!`          | Yes                 |
| `clientMutationId`              | `String`           | No                  |
| `skipReservation`               | `Boolean! = false` | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false` | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false` | No (default: false) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/ConfirmReservationNotification.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>RefundReservation</summary>

<br />

**Operation Class Name:** `RefundReservationMutation`

**Operation Inputs:**

| Name                            | Type                       | Required            |
|---------------------------------|----------------------------|---------------------|
| `propertyId`                    | `ID!`                      | Yes                 |
| `reservationId`                 | `ID!`                      | Yes                 |
| `reason`                        | `ReservationRefundReason!` | Yes                 |
| `refund`                        | `MoneyInput!`              | Yes                 |
| `skipReservation`               | `Boolean! = false`         | No (default: false) |
| `includePaymentInstrumentToken` | `Boolean! = false`         | No (default: false) |
| `includeSupplierAmount`         | `Boolean! = false`         | No (default: false) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/reservations/mutations/RefundReservation.graphql)
- [Reference]()

</details>

<hr />
