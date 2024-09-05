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

<hr />

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

<hr />

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

<hr />

<details>
   <summary>PropertyAmenities</summary>

<br /> 

**Summary:** Retrieves property's amenities

**Operation Class Name:** `PropertyAmenitiesQuery`

**Operation Inputs:**

| Name         | Type                    | Description            | Required |
|--------------|-------------------------|------------------------|----------|
| `propertyId` | `String!`               | The ID of the property | Yes      |
| `filters`    | `AmenitiesFiltersInput` | Amenities Filter       | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyDistrict</summary>

<br /> 

**Summary:** Retrieves district regulatory information

**Operation Class Name:** `PropertyDistrictQuery`

**Operation Inputs:**

| Name         | Type      | Description            | Required |
|--------------|-----------|------------------------|----------|
| `propertyId` | `String!` | The ID of the property | Yes      |
| `locale`     | `String`  | Response locale        | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyFeeSets</summary>

<br /> 

**Summary:** Retrieves property fee sets

**Operation Class Name:** `PropertyFeeSetsQuery`

**Operation Inputs:**

| Name         | Type                          | Description               | Required |
|--------------|-------------------------------|---------------------------|----------|
| `propertyId` | `String!`                     | The ID of the property    | Yes      |
| `filters`    | `PropertyFeeSetsFiltersInput` | Filter Fee Sets Responses | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyListing</summary>

<br />

**Summary:** Listings of the property on the requested domains, supported domains: [expedia.com, vrbo.com]

**Operation Class Name:** `PropertyListingQuery`

**Operation Inputs:**

| Name         | Type         | Description                                | Required |
|--------------|--------------|--------------------------------------------|----------|
| `propertyId` | `String!`    | The ID of the property                     | Yes      |
| `domains`    | `[String!]!` | supported domains: [expedia.com, vrbo.com] | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyListingBundleAdoption</summary>

<br />

**Summary:** Get Property Listing Bundle Adoption

**Operation Class Name:** `PropertyListingBundleAdoptionQuery`

**Operation Inputs:** None

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMedia</summary>

<br />

**Summary:** Get Property's media (images)

**Operation Class Name:** `PropertyMediaQuery`

**Operation Inputs:**

| Name         | Type                 | Description                | Required |
|--------------|----------------------|----------------------------|----------|
| `propertyId` | `String!`            | The ID of the property     | Yes      |
| `filters`    | `ImagesFiltersInput` | Filter the requested media | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMessages</summary>
<br />

**Summary:** Get Property's messages

**Operation Class Name:** `PropertyMessagesQuery`

**Operation Inputs:**

| Name         | Type                           | Description                   | Required |
|--------------|--------------------------------|-------------------------------|----------|
| `propertyId` | `String!`                      | The ID of the property        | Yes      |
| `filters`    | `PropertyMessagesFiltersInput` | Filter the requested messages | Yes      |
| `limit`      | `Int`                          | Messages limit per page       | No       |
| `cursor`     | `String`                       | Pagination cursor             | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMessageThreads</summary>

<br />

**Summary:** Retrieves multiple message threads for a property

**Operation Class Name:** `PropertyMessageThreadsQuery`

**Operation Inputs:**

| Name         | Type                                 | Description                                | Required |
|--------------|--------------------------------------|--------------------------------------------|----------|
| `propertyId` | `String!`                            | The ID of the property                     | Yes      |
| `filters`    | `PropertyMessageThreadsFiltersInput` | Filter the requested message threads       | Yes      |
| `orderBy`    | `PropertyMessageThreadsOrderByInput` | Orders messages threads by specified field | No       |
| `limit`      | `Int`                                | Message Threads limit per page             | No       |
| `cursor`     | `String`                             | Pagination cursor                          | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyPromotions</summary>
<br />

**Summary:** Retrieves property's promotions

**Operation Class Name:** `PropertyPromotionsQuery`

**Operation Inputs:**

| Name         | Type           | Description                     | Required |
|--------------|----------------|---------------------------------|----------|
| `propertyId` | `String!`      | The ID of the property          | Yes      |
| `filters`    | `FiltersInput` | Filter the requested promotions | No       |
| `pageSize`   | `Int!`         | Promotions per page             | Yes      |
| `after`      | `String`       | Pagination cursor               | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyRegistration</summary>
<br />

**Summary:** Retrieves a collection of Unit configurations for a Property

**Operation Class Name:** `PropertyRegistrationQuery`

**Operation Inputs:**

| Name         | Type       | Description                                 | Required |
|--------------|------------|---------------------------------------------|----------|
| `propertyId` | `String!`  | The ID of the property                      | Yes      |
| `idSource`   | `IdSource` | Describes the source of a given property ID | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyReviews</summary>
<br />

**Summary:** Retrieves Property's reviews

**Operation Class Name:** `PropertyReviewsQuery`

**Operation Inputs:**

| Name         | Type             | Description                               | Required |
|--------------|------------------|-------------------------------------------|----------|
| `propertyId` | `String!`        | The ID of the property                    | Yes      |
| `orderBy`    | `ReviewsOrderBy` | Orders reviews threads by specified field | No       |
| `filter`     | `ReviewFilter`   | Filter the requested reviews              | No       |
| `pageSize`   | `Int!`           | Reviews per page                          | Yes      |
| `after`      | `String`         | Pagination cursor                         | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyAggregatedReviews</summary>
<br />

**Summary:** Retrieves Property's reviews

**Operation Class Name:** `PropertyAggregatedReviewsQuery`

**Operation Inputs:**

| Name         | Type                            | Description                              | Required |
|--------------|---------------------------------|------------------------------------------|----------|
| `propertyId` | `String!`                       | The ID of the property                   | Yes      |
| `filters`    | `AggregatedReviewsFiltersInput` | Filters the requested aggregated reviews | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertiesByAdvertiser</summary>
<br />

**Summary:** Retrieve a list of Properties associated for a given Advertiser

**Operation Class Name:** `PropertiesByAdvertiserQuery`

**Operation Inputs:**

| Name       | Type        | Description                                 | Required |
|------------|-------------|---------------------------------------------|----------|
| `id`       | `String!`   | Advertiser ID                               | Yes      |
| `idSource` | `IdSource!` | Describes the source of a given property ID | Yes      |
| `pageSize` | `Int`       | Properties per page                         | No       |
| `cursor`   | `String`    | Pagination cursor                           | No       |
<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>CancellationPolicyConfig</summary>
</details>

<br />

**Summary:** Retrieves individual cancellation policy config by ID

**Operation Class Name:** `CancellationPolicyConfigQuery`

**Operation Inputs:**

| Name       | Type  | Description            | Required |
|------------|-------|------------------------|----------|
| `id`       | `ID!` | Cancellation Policy ID | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
<hr />

<details>
   <summary>DistrictByCoordinates</summary>
</details>

<hr />

<details>
   <summary>Message</summary>
</details>

<hr />

<details>
   <summary>MessageThread</summary>
</details>

<hr />

<details>
   <summary>NotificationEventTypes</summary>
</details>

<hr />

<details>
   <summary>NotificationProfile</summary>
</details>

<hr />

<details>
   <summary>RatePlan</summary>
</details>

<hr />

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
