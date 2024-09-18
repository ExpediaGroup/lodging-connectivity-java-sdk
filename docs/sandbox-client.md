# Sandbox Client
`SandboxClient` contains sandbox-specific API operations useful to manage sandbox datasets for testing purposes.

### API Endpoint
This client is connected with https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql endpoint by default.

You can refer to the [configuration]() document to explore the full configuration options.

### Initialize the Client
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

SandboxClient sandboxClient = new SandboxClient(config);
```

### Initialize GraphQL Operation
```java
SandboxPropertiesQuery propertiesQuery = SandboxPropertiesQuery.builder().build();
```

### Execute the operation
```java
try {
    SandboxPropertiesQuery.Data propertiesData = sandboxClient.execute(propertiesQuery);
}
catch(ExpediaGroupServiceException e) {
    e.printStackTrace();
}
```

## Available Operations
The SDK offers a set of queries & mutations you can execute using the `SandboxClient`. Below is a list of the available operations.

<br />

### SandboxClient - Queries

<hr />

<details>
   <summary>SandboxProperties</summary>

<br />

**Summary:** Retrieves a paginated results of properties in the sandbox environment

**Operation Class Name:** `SandboxPropertiesQuery`

**Operation Inputs:**

| Name               | Type               | Required            |
|--------------------|--------------------|---------------------|
| `cursor`           | `String`           | No                  |
| `limit`            | `Int`              | No                  |
| `skipReservations` | `Boolean! = false` | No (defaults false) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/queries/SandboxProperties.query.graphql) 
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxProperty</summary>

<br />

**Summary:** Retrieves a single property from the sandbox environment.

**Operation Class Name:** `SandboxPropertyQuery`

**Operation Inputs:**

| Name                 | Type               | Required            |
|----------------------|--------------------|---------------------|
| `id`                 | `ID!`              | Yes                 |
| `reservationsCursor` | `String`           | No                  |
| `reservationsLimit`  | `Int`              | No                  |
| `skipReservations`   | `Boolean! = false` | No (defaults false) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/queries/SandboxProperty.query.graphql)
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxReservation</summary>

<br />

**Summary:** Retrieves a single reservation

**Operation Class Name:** `SandboxReservationQuery`

**Operation Inputs:**

| Name | Type  | Description    | Required |
|------|-------|----------------|----------|
| `id` | `ID!` | Reservation ID | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/queries/SandboxReservation.query.graphql) 
- [Reference]()

</details>

<hr />

<br /><br />

### SandboxClient - Mutations

<hr />

<details>
   <summary>SandboxCancelReservation</summary>

<br />

**Summary:** Cancels a reservation

**Operation Class Name:** `SandboxCancelReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `CancelReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxCancelReservation.mutation.graphql)
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxChangeReservationStayDates</summary>

<br />

**Summary:** Updates the stay dates of a reservation.

**Operation Class Name:** `SandboxChangeReservationStayDatesMutation`

**Operation Inputs:**

| Name    | Type                               | Required |
|---------|------------------------------------|----------|
| `input` | `ChangeReservationStayDatesInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxChangeReservationStayDates.mutation.graphql) 
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxCreateProperty</summary>

<br />

**Summary:** Creates a new property in the sandbox environment.

**Operation Class Name:** `SandboxCreatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `CreatePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxCreateProperty.mutation.graphql)  
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxCreateReservation</summary>

<br />

**Summary:** Creates a new reservation on a sandbox property

**Operation Class Name:** `SandboxCreateReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `CreateReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxCreateReservation.mutation.graphql) 
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxDeleteProperty</summary>

<br />

**Summary:** Deletes sandbox property

**Operation Class Name:** `SandboxDeletePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `DeletePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxDeleteProperty.mutation.graphql) 
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxDeletePropertyReservations</summary>

<br />

**Summary:** Deletes all sandbox property's reservations

**Operation Class Name:** `SandboxDeletePropertyReservationsMutation`

**Operation Inputs:**

| Name    | Type                               | Required |
|---------|------------------------------------|----------|
| `input` | `DeletePropertyReservationsInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxDeletePropertyReservations.mutation.graphql) 
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxDeleteReservation</summary>

<br />

**Summary:** Deletes a single reservation on a sandbox property

**Operation Class Name:** `SandboxDeleteReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `DeleteReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxDeleteReservation.mutation.graphql)
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxUpdateProperty</summary>

<br />

**Summary:** Updates sandbox property data.

**Operation Class Name:** `SandboxUpdatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `UpdatePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxUpdateProperty.mutation.graphql)
- [Reference]()

</details>

<hr /><details>
   <summary>SandboxUpdateReservation</summary>

<br />

**Summary:** Updates single reservation on a sandbox property.

**Operation Class Name:** `SandboxUpdateReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `UpdateReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/sandbox/operations/mutations/SandboxUpdateReservation.mutation.graphql)
- [Reference]()

</details>

<hr />