# Sandbox Data Management Client

`SandboxDataManagementClient` allows communication with sandbox-specific API operations. Sandbox is a controlled environment used for testing and managing mocked data without impacting the live systems. It's worth noting that the sandbox APIs have more lax constraints in the data than the live APIs; for example, creating a property with the live APIs requires an address whereas the sandbox API does not.

View the examples package for specific usages of the `SandboxDataManagementClient`.

### API Endpoint
This client is connected with https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql endpoint by default.

You can refer to the [configuration](configuration.md) document to explore the full configuration options.

### Initialize the Client
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

SandboxDataManagementClient client = new SandboxDataManagementClient(config);
```

### Set the Environment (Optional)
`SandboxDataManagementClient` can be configured to work in different environments, below is a list of the supported environments by this client:

| Environment                      | Corresponding API Endpoint                                               |
|----------------------------------|--------------------------------------------------------------------------|
| `ClientEnvironment.SANDBOX_PROD` | https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql      |
| `ClientEnvironment.SANDBOX_TEST` | https://test-api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql |

**Configuration with Environment Example**
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .environment(ClientEnvironement.SANDBOX_TEST)
        .build();
```

### Initialize GraphQL Operation
```java
SandboxPropertiesQuery propertiesQuery = SandboxPropertiesQuery.builder().build();
```

### Execute the operation
```java
try {
    SandboxPropertiesQuery.Data propertiesData = client.execute(propertiesQuery);
}
catch(ExpediaGroupServiceException e) {
    e.printStackTrace();
}
```

## Available Operations
The SDK offers a set of queries & mutations you can execute using the `SandboxDataManagementClient`. Below is a list of the available operations.

<br />

### SandboxDataManagementClient - Queries

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

### SandboxDataManagementClient - Mutations

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
