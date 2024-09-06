# Sandbox Client
`SandboxClient` contains sandbox-specific API operations useful to manage sandbox datasets for testing purposes.

### API Endpoint
This client is connected with https://api.sandbox.expediagroup.com/supply/lodging-sandbox/graphql endpoint by default.

You can refer to the [configuration]() document to explore the full configuration options.

### Initialize the Client
```java
ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
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

| Name               | Type               | Description                                    | Required            |
|--------------------|--------------------|------------------------------------------------|---------------------|
| `cursor`           | `String`           | Pagination cursor                              | No                  |
| `limit`            | `Int`              | Properties to retrieve per page                | No                  |
| `skipReservations` | `Boolean! = false` | Skips retrieving the reservation on a property | No (defaults false) |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxProperty</summary>

<br />

**Summary:** Retrieves a single property from the sandbox environment.

**Operation Class Name:** `SandboxPropertyQuery`

**Operation Inputs:**

| Name                 | Type               | Description                                    | Required            |
|----------------------|--------------------|------------------------------------------------|---------------------|
| `id`                 | `ID!`              | Property ID                                    | Yes                 |
| `reservationsCursor` | `String`           | Pagination cursor for property's reservations  | No                  |
| `reservationsLimit`  | `Int`              | Reservations limit per page                    | No                  |
| `skipReservations`   | `Boolean! = false` | Skips retrieving the reservation on a property | No (defaults false) |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

| Name    | Type                      | Description                                       | Required |
|---------|---------------------------|---------------------------------------------------|----------|
| `input` | `CancelReservationInput!` | Needed input to identify the canceled reservation | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxChangeReservationStayDates</summary>

<br />

**Summary:** Updates the stay dates of a reservation.

**Operation Class Name:** `SandboxChangeReservationStayDatesMutation`

**Operation Inputs:**

| Name    | Type                               | Description                                                        | Required |
|---------|------------------------------------|--------------------------------------------------------------------|----------|
| `input` | `ChangeReservationStayDatesInput!` | Needed input to identify the reservation and update the stay dates | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxCreateProperty</summary>

<br />

**Summary:** Creates a new property in the sandbox environment.

**Operation Class Name:** `SandboxCreatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Description                             | Required |
|---------|------------------------|-----------------------------------------|----------|
| `input` | `CreatePropertyInput!` | Needed input to create sandbox property | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxCreateReservation</summary>

<br />

**Summary:** Creates a new reservation on a sandbox property

**Operation Class Name:** `SandboxCreateReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Description                                                | Required |
|---------|---------------------------|------------------------------------------------------------|----------|
| `input` | `CreateReservationInput!` | Needed input to create a reservation on a sandbox property | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxDeleteProperty</summary>

<br />

**Summary:** Deletes sandbox property

**Operation Class Name:** `SandboxDeletePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Description                           | Required |
|---------|------------------------|---------------------------------------|----------|
| `input` | `DeletePropertyInput!` | Needed input to identify the property | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
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

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />
