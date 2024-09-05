# Supply Client
`SupplyClient` is the largest and most versatile client in the Lodging Connectivity SDK. It provides access to various capabilities offered by the Lodging Connectivity GraphQL API, including _Reservations_, _Messaging_, _Promotions_, _Reviews_, and more.

### API Endpoint
This client is connected with https://api.expediagroup.com/supply/lodging/graphql endpoint by default. 

You can refer to the [configuration]() document to explore the full configuration options.

### Initialize the Client
```java
ExpediaGroupClientConfiguration config = ExpediaGroupClientConfiguration
        .builder()
        .key("KEY")
        .secret("SECRET")
        .build();

SupplyClient supplyClient = new SupplyClient(config);
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
The SDK offers a set of queries & mutations you can execute using the `SupplyClient`. Below is a list of the available operations.

### SupplyClient - Queries
<details>
   <summary>Property</summary>

<br /> 

**Summary:** Retrieves the basic data of a property

**Operation Class Name:** `PropertyQuery`

**Operation Inputs:**

| Name | Type      | Description                        | Required |
|------|-----------|------------------------------------|----------|
| `Id` | `String!` | The ID of the property to retrieve | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<br />

<details>
   <summary>PropertyReservations</summary>

<br /> 

**Summary:** Retrieves paginated reservations on a property

**Operation Class Name:** `PropertyReservationsQuery`

**Operation Inputs:**

| Name                            | Type                     | Description                                                           | Required            |
|---------------------------------|--------------------------|-----------------------------------------------------------------------|---------------------|
| `propertyId`                    | `String!`                | The ID of the property to retrieve                                    | Yes                 |
| `pageSize`                      | `Int!`                   | Reservations per page                                                 | Yes                 |
| `after`                         | `String`                 | Retrieve reservations after this cursor value                         | No                  |
| `filter`                        | `ReservationFilterInput` | Filters reservation results                                           | No                  |
| `checkOutDate`                  | `CheckOutDateFilter`     | Filter based on the checkout date                                     | No                  |
| `includePaymentInstrumentToken` | `Boolean`                | Whether to include the payment-instrument data in the response or not | No (default: false) |
| `includeSupplierAmount`         | `Boolean`                | Whether to include the supplier-amount data in the response or not    | No (default: false) |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**

</details>

<br />

<details>
   <summary>PropertyAmenities</summary>
</details>

<br />

<details>
   <summary>PropertyDistrict</summary>
</details>

<br />

<details>
   <summary>PropertyFeeSets</summary>
</details>

<br />

<details>
   <summary>PropertyListing</summary>
</details>

<br />

<details>
   <summary>PropertyListingBundleAdoption</summary>
</details>

<br />

<details>
   <summary>PropertyMedia</summary>
</details>

<br />

<details>
   <summary>PropertyMessages</summary>
</details>

<br />

<details>
   <summary>PropertyMessageThreads</summary>
</details>

<br />

<details>
   <summary>PropertyPromotions</summary>
</details>

<br />

<details>
   <summary>PropertyRegistration</summary>
</details>

<br />

<details>
   <summary>PropertyReviews</summary>
</details>

<br />

<details>
   <summary>PropertyAggregatedReviews</summary>
</details>

<br />

<details>
   <summary>PropertiesByAdvertiser</summary>
</details>

<br />

<details>
   <summary>CancellationPolicyConfig</summary>
</details>

<br />

<details>
   <summary>DistrictByCoordinates</summary>
</details>

<br />

<details>
   <summary>Message</summary>
</details>

<br />

<details>
   <summary>MessageThread</summary>
</details>

<br />

<details>
   <summary>NotificationEventTypes</summary>
</details>

<br />

<details>
   <summary>NotificationProfile</summary>
</details>

<br />

<details>
   <summary>RatePlan</summary>
</details>

<br />

<details>
   <summary>UndeliveredNotifications</summary>
</details>


### SupplyClient - Mutations
<details>
   <summary>AddMessage</summary>
</details>

<br />

<details>
   <summary>ArchivePropertyIds</summary>
</details>

<br />

<details>
   <summary>CancelReservation</summary>
</details>

<br />

<details>
   <summary>CancelReservationReconciliation</summary>
</details>

<br />

<details>
   <summary>CancelVrboReservation</summary>
</details>

<br />

<details>
   <summary>ChangeReservationReconciliation</summary>
</details>

<br />

<details>
   <summary>ConfirmReservationNotification</summary>
</details>

<br />

<details>
   <summary>CreateCancellationPolicyConfig</summary>
</details>

<br />

<details>
   <summary>CreateDayOfWeekDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>CreateFeeSet</summary>
</details>

<br />

<details>
   <summary>CreateMultiNightDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>CreateNotificationCallbackConfig</summary>
</details>

<br />

<details>
   <summary>CreateProperty</summary>
</details>

<br />

<details>
   <summary>CreatePropertyImage</summary>
</details>

<br />

<details>
   <summary>CreateRatePlan</summary>
</details>

<br />

<details>
   <summary>CreateSingleDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>CreateUnitSpaces</summary>
</details>

<br />

<details>
   <summary>DeleteImage</summary>
</details>

<br />

<details>
   <summary>DeleteNotificationCallbackConfig</summary>
</details>

<br />

<details>
   <summary>DeleteUnitSpace</summary>
</details>

<br />

<details>
   <summary>DisableProperty</summary>
</details>

<br />

<details>
   <summary>EnableProperty</summary>
</details>

<br />

<details>
   <summary>JoinNewListingDiscount</summary>
</details>

<br />

<details>
   <summary>RateGuest</summary>
</details>

<br />

<details>
   <summary>RefreshNotificationCallbackConfigSecret</summary>
</details>

<br />

<details>
   <summary>RefundReservation</summary>
</details>

<br />

<details>
   <summary>ReplaceFeeSet</summary>
</details>

<br />

<details>
   <summary>SavePropertyContact</summary>
</details>

<br />

<details>
   <summary>SendMessage</summary>
</details>

<br />

<details>
   <summary>SendTestNotification</summary>
</details>

<br />

<details>
   <summary>SetMessageThreadSpamStatus</summary>
</details>

<br />

<details>
   <summary>SetPropertyTaxRecord</summary>
</details>

<br />

<details>
   <summary>SetReviewResponse</summary>
</details>

<br />

<details>
   <summary>SubscribeNotificationEventType</summary>
</details>

<br />

<details>
   <summary>UnsubscribeNotificationEventType</summary>
</details>

<br />

<details>
   <summary>UpdateDayOfWeekDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>UpdateImage</summary>
</details>

<br />

<details>
   <summary>UpdateMultiNightDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>UpdateNotificationCallbackConfig</summary>
</details>

<br />

<details>
   <summary>UpdateNotificationEventTypeSubscription</summary>
</details>

<br />

<details>
   <summary>UpdateProperty</summary>
</details>

<br />

<details>
   <summary>UpdateRatePlan</summary>
</details>

<br />

<details>
   <summary>UpdateSingleDiscountPromotion</summary>
</details>

<br />

<details>
   <summary>UpdateUnit</summary>
</details>

<br />

<details>
   <summary>UpdateUnitRegistration</summary>
</details>

<br />

<details>
   <summary>UpdateUnitSpaces</summary>
</details>

<br />

<details>
   <summary>WithdrawNewListingDiscount</summary>
</details>
