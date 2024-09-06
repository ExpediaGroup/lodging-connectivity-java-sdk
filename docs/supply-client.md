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

<br />

**Summary:** Adds a message to a message thread.

**Operation Class Name:** `AddMessageMutation`

**Operation Inputs:**

| Name              | Type                            | Required |
|-------------------|---------------------------------|----------|
| `messageThreadId` | `ID!`                           | Yes      |
| `message`         | `AddMessageThreadMessageInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ArchivePropertyIds</summary>

<br />

**Summary:** Accepts a list of Property IDs that should be archived during the Property ID mapping process.

**Operation Class Name:** `ArchivePropertyIdsMutation`

**Operation Inputs:**

| Name    | Type                       | Required |
|---------|----------------------------|----------|
| `input` | `ArchivePropertyIdsInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelReservation</summary>

<br />

**Summary:** Mutation to cancel a pre-stay reservation

**Operation Class Name:** `CancelReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `CancelReservationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelReservationReconciliation</summary>

<br />

**Summary:** Cancel reservation reconciliation.

**Operation Class Name:** `CancelReservationReconciliationMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `CancelReservationReconciliationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelVrboReservation</summary>

<br />

**Summary:** Mutation for suppliers to cancel a VRBO reservation - pre & post arrival

**Operation Class Name:** `CancelVrboReservationMutation`

**Operation Inputs:**

| Name    | Type                          | Required |
|---------|-------------------------------|----------|
| `input` | `CancelVrboReservationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ChangeReservationReconciliation</summary>

<br />

**Summary:** Update reservation reconciliation.

**Operation Class Name:** `ChangeReservationReconciliationMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `ChangeReservationReconciliationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ConfirmReservationNotification</summary>

<br />

**Summary:** Confirm Reservation sent via Webhook

**Operation Class Name:** `ConfirmReservationNotificationMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `ConfirmReservationNotificationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateCancellationPolicyConfig</summary>

<br />

**Summary:** Creates cancellation policy config

**Operation Class Name:** `CreateCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `CreateCancellationPolicyConfigInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateDayOfWeekDiscountPromotion</summary>

<br />

**Summary:** Creates day of week discount promotion.

**Operation Class Name:** `CreateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                     | Required |
|--------------------|------------------------------------------|----------|
| `propertyId`       | `String!`                                | Yes      |
| `propertyIdSource` | `IdSource!`                              | Yes      |
| `promotion`        | `DayOfWeekDiscountPromotionCreateInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateFeeSet</summary>

<br />

**Summary:** Creates fee set

**Operation Class Name:** `CreateFeeSetMutation`

**Operation Inputs:**

| Name    | Type                 | Description | Required |
|---------|----------------------|-------------|----------|
| `input` | `CreateFeeSetInput!` | Description | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateMultiNightDiscountPromotion</summary>

<br />

**Summary:** Create multi night discount promotion.

**Operation Class Name:** `CreateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                      | Required |
|--------------------|-------------------------------------------|----------|
| `promotion`        | `MultiNightDiscountPromotionCreateInput!` | Yes      |
| `propertyId`       | `String!`                                 | Yes      |
| `propertyIdSource` | `IdSource!`                               | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateNotificationCallbackConfig</summary>

<br />

**Summary:** Create callback configuration for notification profile

**Operation Class Name:** `CreateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `CreateNotificationCallbackConfigInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateProperty</summary>

<br />

**Summary:** Creates a new property

**Operation Class Name:** `CreatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `CreatePropertyInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreatePropertyImage</summary>

<br />

**Summary:** Adds a new image for a property

**Operation Class Name:** `CreatePropertyImageMutation`

**Operation Inputs:**

| Name    | Type                        | Required |
|---------|-----------------------------|----------|
| `input` | `CreatePropertyImageInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateRatePlan</summary>

<br />

**Summary:** Create rate plan

**Operation Class Name:** `CreateRatePlanMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `CreateRatePlanInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateSingleDiscountPromotion</summary>

<br />

**Summary:** Create single discount promotion.

**Operation Class Name:** `CreateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                  | Required |
|--------------------|---------------------------------------|----------|
| `promotion`        | `SingleDiscountPromotionCreateInput!` | Yes      |
| `propertyId`       | `String!`                             | Yes      |
| `propertyIdSource` | `IdSource!`                           | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateUnitSpaces</summary>

<br />

**Summary:** Creates unit spaces

**Operation Class Name:** `CreateUnitSpacesMutation`

**Operation Inputs:**

| Name    | Type                     | Required |
|---------|--------------------------|----------|
| `input` | `CreateUnitSpacesInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteImage</summary>

<br />

**Summary:** Deletes Image by ID

**Operation Class Name:** `DeleteImageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `DeleteImageInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteNotificationCallbackConfig</summary>

<br />

**Summary:** Delete callback configuration from notification profile.

**Operation Class Name:** `DeleteNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `DeleteNotificationCallbackConfigInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteUnitSpace</summary>

<br />

**Summary:** Deletes unit space

**Operation Class Name:** `DeleteUnitSpaceMutation`

**Operation Inputs:**

| Name    | Type                    | Required |
|---------|-------------------------|----------|
| `input` | `DeleteUnitSpaceInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DisableProperty</summary>

<br />

**Summary:** Disables a property.

**Operation Class Name:** `DisablePropertyMutation`

**Operation Inputs:**

| Name    | Type                    | Required |
|---------|-------------------------|----------|
| `input` | `DisablePropertyInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>EnableProperty</summary>

<br />

**Summary:** Enables a property

**Operation Class Name:** `EnablePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `EnablePropertyInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>JoinNewListingDiscount</summary>

<br />

**Summary:** Add new listing discount.

**Operation Class Name:** `JoinNewListingDiscountMutation`

**Operation Inputs:**

| Name                       | Type        | Required |
|----------------------------|-------------|----------|
| `joinNewListingDiscountId` | `String!`   | Yes      |
| `idSource`                 | `IdSource!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RateGuest</summary>

<br />

**Summary:** Rate Guest

**Operation Class Name:** `RateGuestMutation`

**Operation Inputs:**

| Name               | Type              | Required |
|--------------------|-------------------|----------|
| `input`            | `RateGuestInput!` | Yes      |
| `propertyId`       | `ID!`             | Yes      |
| `propertyIdSource` | `IdSource!`       | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RefreshNotificationCallbackConfigSecret</summary>

<br />

**Summary:** Refresh secret for callback configuration based on callbackConfigId.

**Operation Class Name:** `RefreshNotificationCallbackConfigSecretMutation`

**Operation Inputs:**

| Name    | Type                                            | Required |
|---------|-------------------------------------------------|----------|
| `input` | `RefreshNotificationCallbackConfigSecretInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RefundReservation</summary>

<br />

**Summary:** Update reservation with good will refund.

**Operation Class Name:** `RefundReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `RefundReservationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ReplaceCancellationPolicyConfig</summary>

<br />

**Summary:** Replace cancellation policy config

**Operation Class Name:** `ReplaceCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `ReplaceCancellationPolicyConfigInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ReplaceFeeSet</summary>

<br />

**Summary:** Replace Fee Set 

**Operation Class Name:** `ReplaceFeeSetMutation`

**Operation Inputs:**

| Name    | Type                  | Required |
|---------|-----------------------|----------|
| `input` | `ReplaceFeeSetInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SavePropertyContact</summary>

<br />

**Summary:** Save property contact

**Operation Class Name:** `SavePropertyContactMutation`

**Operation Inputs:**

| Name         | Type                        | Required |
|--------------|-----------------------------|----------|
| `contact`    | `SavePropertyContactInput!` | Yes      |
| `propertyId` | `ID!`                       | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SendMessage</summary>

<br />

**Summary:** Send a new message to a message thread

**Operation Class Name:** `SendMessageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `SendMessageInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SendTestNotification</summary>

<br />

**Summary:** Send test notification using a given eventType and Payload

**Operation Class Name:** `SendTestNotificationMutation`

**Operation Inputs:**

| Name    | Type                         | Required |
|---------|------------------------------|----------|
| `input` | `SendTestNotificationInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetMessageThreadSpamStatus</summary>

<br />

**Summary:** Set spam status for a message thread

**Operation Class Name:** `SetMessageThreadSpamStatusMutation`

**Operation Inputs:**

| Name    | Type                               | Required |
|---------|------------------------------------|----------|
| `input` | `SetMessageThreadSpamStatusInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetPropertyTaxRecord</summary>

<br />

**Summary:** Mutation for setting the tax record for a property

**Operation Class Name:** `SetPropertyTaxRecordMutation`

**Operation Inputs:**

| Name    | Type                         | Required |
|---------|------------------------------|----------|
| `input` | `SetPropertyTaxRecordInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetReviewResponse</summary>

<br />

**Summary:** Set review response.

**Operation Class Name:** `SetReviewResponseMutation`

**Operation Inputs:**

| Name               | Type                    | Required |
|--------------------|-------------------------|----------|
| `body`             | `InputLocalizedString!` | Yes      |
| `propertyId`       | `ID!`                   | Yes      |
| `propertyIdSource` | `IdSource!`             | Yes      |
| `reviewId`         | `ID!`                   | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SubscribeNotificationEventType</summary>

<br />

**Summary:** Subscribe to notification event type for a given notification subscription profile.

**Operation Class Name:** `SubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `SubscribeNotificationEventTypeInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UnsubscribeNotificationEventType</summary>

<br />

**Summary:** Unsubscribe from notification event type for a given notification subscription profile.

**Operation Class Name:** `UnsubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `UnsubscribeNotificationEventTypeInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateDayOfWeekDiscountPromotion</summary>

<br />

**Summary:** Update day of week discount promotion

**Operation Class Name:** `UpdateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                     | Required |
|--------------------|------------------------------------------|----------|
| `promotion`        | `DayOfWeekDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                                | Yes      |
| `propertyIdSource` | `IdSource!`                              | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateImage</summary>

<br />

**Summary:** Updates an image

**Operation Class Name:** `UpdateImageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `UpdateImageInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateMultiNightDiscountPromotion</summary>

<br />

**Summary:** Update multi night discount promotion

**Operation Class Name:** `UpdateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                      | Required |
|--------------------|-------------------------------------------|----------|
| `promotion`        | `MultiNightDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                                 | Yes      |
| `propertyIdSource` | `IdSource!`                               | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateNotificationCallbackConfig</summary>

<br />

**Summary:** Update notification callback configuration profile attributes (callbackUrl, apiKey, requestTimeout) based on callbackConfigId.

**Operation Class Name:** `UpdateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `UpdateNotificationCallbackConfigInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateNotificationEventTypeSubscription</summary>

<br />

**Summary:** Update notification callback configuration for a subscribed notification event type

**Operation Class Name:** `UpdateNotificationEventTypeSubscriptionMutation`

**Operation Inputs:**

| Name    | Type                                            | Required |
|---------|-------------------------------------------------|----------|
| `input` | `UpdateNotificationEventTypeSubscriptionInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateProperty</summary>

<br />

**Summary:** Updates a property

**Operation Class Name:** `UpdatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `UpdatePropertyInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateRatePlan</summary>

<br />

**Summary:** Updates rate plan

**Operation Class Name:** `UpdateRatePlanMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `UpdateRatePlanInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateSingleDiscountPromotion</summary>

<br />

**Summary:** Update single discount promotion.

**Operation Class Name:** `UpdateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                  | Required |
|--------------------|---------------------------------------|----------|
| `promotion`        | `SingleDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                             | Yes      |
| `propertyIdSource` | `IdSource!`                           | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnit</summary>

<br />

**Summary:** Updates a unit

**Operation Class Name:** `UpdateUnitMutation`

**Operation Inputs:**

| Name    | Type                       | Required |
|---------|----------------------------|----------|
| `input` | `UpdatePropertyUnitInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnitRegistration</summary>

<br />

**Summary:** Update unit registration of property using property associated attributes id/idSource

**Operation Class Name:** `UpdateUnitRegistrationMutation`

**Operation Inputs:**

| Name               | Type                           | Required |
|--------------------|--------------------------------|----------|
| `propertyIdSource` | `IdSource!`                    | Yes      |
| `registration`     | `UpdateUnitRegistrationInput!` | Yes      |
| `forceSave`        | `Boolean`                      | No       |
| `propertyId`       | `String!`                      | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnitSpaces</summary>

<br />

**Summary:** Updates unit spaces

**Operation Class Name:** `UpdateUnitSpacesMutation`

**Operation Inputs:**

| Name    | Type                     | Required |
|---------|--------------------------|----------|
| `input` | `UpdateUnitSpacesInput!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>WithdrawNewListingDiscount</summary>

<br />

**Summary:** Remove new listing discount

**Operation Class Name:** `WithdrawNewListingDiscountMutation`

**Operation Inputs:**

| Name                           | Type        | Required |
|--------------------------------|-------------|----------|
| `withdrawNewListingDiscountId` | `String!`   | Yes      |
| `idSource`                     | `IdSource!` | Yes      |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />
