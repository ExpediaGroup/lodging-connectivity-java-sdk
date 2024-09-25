# Payment Client
`PaymentClient` deals with payment instruments and PCI data.

### API Endpoint
This client is connected with https://api.expediagroup.com/supply/payments/graphql endpoint by default.

You can refer to the [configuration](configuration.md) document to explore the full configuration options.

### Initialize the Client
```java
ClientConfiguration config = ClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

PaymentClient paymentClient = new PaymentClient(config);
```

### Initialize GraphQL Operation
```java
PaymentInstrumentQuery paymentInstrumentQuery = PaymentInstrumentQuery
        .builder()
        .token("payment_token")
        .build();
```

### Execute the operation
```java
try {
    PaymentInstrumentQuery.Data paymentData = paymentClient.execute(paymentInstrumentQuery);
}
catch(ExpediaGroupServiceException e) {
    e.printStackTrace();
}
```

## Available Operations
At the moment, there is only one query called `PaymentInstrument` you can execute using the `PaymentClient`.

<hr />
<details>
   <summary>PaymentInstrument</summary>

<br />

**Summary:** Retrieve Payment instrument from external payment instrument token

**Operation Class Name:** `PaymentInstrumentQuery`

**Operation Inputs:**

| Name    | Type      | Description    | Required |
|---------|-----------|----------------|----------|
| `token` | `String!` | External token | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/payment/operations/mutations/PaymentInstrument.query.graphql)
- [Reference]()

</details>

<hr />
