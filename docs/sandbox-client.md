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

### SupplyClient - Queries

<hr />

<details>
   <summary>SandboxProperties</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxPropertiesMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `cursor` | `String` | Description | No |
| `limit` | `Int` | Description | No |
| `skipReservations` | `Boolean! = false` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxPropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `id` | `ID!` | Description | Yes |
| `reservationsCursor` | `String` | Description | No |
| `reservationsLimit` | `Int` | Description | No |
| `skipReservations` | `Boolean! = false` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `id` | `ID!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<br /><br />

### SupplyClient - Mutations

<hr />

<details>
   <summary>SandboxCancelReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxCancelReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CancelReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxChangeReservationStayDates</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxChangeReservationStayDatesMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ChangeReservationStayDatesInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxCreateProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxCreatePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreatePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxCreateReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxCreateReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxDeleteProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxDeletePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeletePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxDeletePropertyReservations</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxDeletePropertyReservationsMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeletePropertyReservationsInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxDeleteReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxDeleteReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeleteReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxUpdateProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxUpdatePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdatePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SandboxUpdateReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `SandboxUpdateReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />
