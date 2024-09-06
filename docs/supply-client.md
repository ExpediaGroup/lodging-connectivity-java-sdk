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

<br />

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
<br />

**Summary:** Retrieves individual cancellation policy config by ID

**Operation Class Name:** `CancellationPolicyConfigQuery`

**Operation Inputs:**

| Name       | Type  | Description            | Required |
|------------|-------|------------------------|----------|
| `id`       | `ID!` | Cancellation Policy ID | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>DistrictByCoordinates</summary>
<br />

**Summary:** Retrieves District information by latitude/longitude coordinates and optionally locale.

**Operation Class Name:** `DistrictByCoordinatesQuery`

**Operation Inputs:**

| Name        | Type     | Description | Required |
|-------------|----------|-------------|----------|
| `latitude`  | `Float!` | _           | Yes      |
| `longitude` | `Float!` | _           | Yes      |
| `locale`    | `String` | _           | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>Message</summary>
<br />

**Summary:** Retrieves a single message using its unique identifier.

**Operation Class Name:** `MessageQuery`

**Operation Inputs:**

| Name        | Type  | Description        | Required |
|-------------|-------|--------------------|----------|
| `messageId` | `ID!` | Message identifier | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>MessageThread</summary>
<br />

**Summary:** Retrieves a single message thread using its unique identifier.

**Operation Class Name:** `MessageThreadQuery`

**Operation Inputs:**

| Name              | Type                                | Description                               | Required |
|-------------------|-------------------------------------|-------------------------------------------|----------|
| `messageThreadId` | `ID!`                               | Message identifier                        | Yes      |
| `messagesLimit`   | `Int`                               | messages per page                         | No       |
| `messagesCursor`  | `String`                            | Pagination Cursor                         | No       |
| `orderMessagesBy` | `MessageThreadMessagesOrderByInput` | Orders message threads by specified field | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>NotificationEventTypes</summary>
<br />

**Summary:** Retrieves available event types to subscribe to

**Operation Class Name:** `NotificationEventTypesQuery`

**Operation Inputs:** None

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>NotificationProfile</summary>
<br />

**Summary:** Retrieves configurations on notification platform

**Operation Class Name:** `NotificationProfileQuery`

**Operation Inputs:** None

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>RatePlan</summary>
<br />

**Summary:** Retrieves rate plan by property id and rate plan ID

**Operation Class Name:** `RatePlanQuery`

**Operation Inputs:**

| Name         | Type  | Description          | Required |
|--------------|-------|----------------------|----------|
| `propertyId` | `ID!` | Property identifier  | Yes      |
| `ratePlanId` | `Id`  | Rate plan identifier | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />

<details>
   <summary>UndeliveredNotifications</summary>
<br />

**Summary:** Retrieves failed notifications

**Operation Class Name:** `UndeliveredNotificationsQuery`

**Operation Inputs:**

| Name      | Type                                    | Description                         | Required |
|-----------|-----------------------------------------|-------------------------------------|----------|
| `filters` | `UndeliveredNotificationsFiltersInput!` | Filters the requested notifications | Yes      |
| `cursor`  | `String`                                | Pagination cursor                   | No       |
| `limit`   | `Int`                                   | notifications limit per page        | No       |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />
<br /><br />

### SupplyClient - Mutations

<hr />

<details>
   <summary>AddMessage</summary>
</details>

<hr />

<details>
   <summary>ArchivePropertyIds</summary>
</details>

<hr />

<details>
   <summary>CancelReservation</summary>
</details>

<hr />

<details>
   <summary>CancelReservationReconciliation</summary>
</details>

<hr />

<details>
   <summary>CancelVrboReservation</summary>
</details>

<hr />

<details>
   <summary>ChangeReservationReconciliation</summary>
</details>

<hr />

<details>
   <summary>ConfirmReservationNotification</summary>
</details>

<hr />

<details>
   <summary>CreateCancellationPolicyConfig</summary>
</details>

<hr />

<details>
   <summary>CreateDayOfWeekDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>CreateFeeSet</summary>
</details>

<hr />

<details>
   <summary>CreateMultiNightDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>CreateNotificationCallbackConfig</summary>
</details>

<hr />

<details>
   <summary>CreateProperty</summary>
</details>

<hr />

<details>
   <summary>CreatePropertyImage</summary>
</details>

<hr />

<details>
   <summary>CreateRatePlan</summary>
</details>

<hr />

<details>
   <summary>CreateSingleDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>CreateUnitSpaces</summary>
</details>

<hr />

<details>
   <summary>DeleteImage</summary>
</details>

<hr />

<details>
   <summary>DeleteNotificationCallbackConfig</summary>
</details>

<hr />

<details>
   <summary>DeleteUnitSpace</summary>
</details>

<hr />

<details>
   <summary>DisableProperty</summary>
</details>

<hr />

<details>
   <summary>EnableProperty</summary>
</details>

<hr />

<details>
   <summary>JoinNewListingDiscount</summary>
</details>

<hr />

<details>
   <summary>RateGuest</summary>
</details>

<hr />

<details>
   <summary>RefreshNotificationCallbackConfigSecret</summary>
</details>

<hr />

<details>
   <summary>RefundReservation</summary>
</details>

<hr />

<details>
   <summary>ReplaceFeeSet</summary>
</details>

<hr />

<details>
   <summary>SavePropertyContact</summary>
</details>

<hr />

<details>
   <summary>SendMessage</summary>
</details>

<hr />

<details>
   <summary>SendTestNotification</summary>
</details>

<hr />

<details>
   <summary>SetMessageThreadSpamStatus</summary>
</details>

<hr />

<details>
   <summary>SetPropertyTaxRecord</summary>
</details>

<hr />

<details>
   <summary>SetReviewResponse</summary>
</details>

<hr />

<details>
   <summary>SubscribeNotificationEventType</summary>
</details>

<hr />

<details>
   <summary>UnsubscribeNotificationEventType</summary>
</details>

<hr />

<details>
   <summary>UpdateDayOfWeekDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>UpdateImage</summary>
</details>

<hr />

<details>
   <summary>UpdateMultiNightDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>UpdateNotificationCallbackConfig</summary>
</details>

<hr />

<details>
   <summary>UpdateNotificationEventTypeSubscription</summary>
</details>

<hr />

<details>
   <summary>UpdateProperty</summary>
</details>

<hr />

<details>
   <summary>UpdateRatePlan</summary>
</details>

<hr />

<details>
   <summary>UpdateSingleDiscountPromotion</summary>
</details>

<hr />

<details>
   <summary>UpdateUnit</summary>
</details>

<hr />

<details>
   <summary>UpdateUnitRegistration</summary>
</details>

<hr />

<details>
   <summary>UpdateUnitSpaces</summary>
</details>

<hr />

<details>
   <summary>WithdrawNewListingDiscount</summary>
</details>
