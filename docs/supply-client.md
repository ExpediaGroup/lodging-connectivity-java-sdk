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

**Summary:**

**Operation Class Name:** `AddMessageMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `messageThreadId` | `ID!` | Description | Yes |
| `message` | `AddMessageThreadMessageInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ArchivePropertyIds</summary>

<br />

**Summary:**

**Operation Class Name:** `ArchivePropertyIdsMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ArchivePropertyIdsInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `CancelReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CancelReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelReservationReconciliation</summary>

<br />

**Summary:**

**Operation Class Name:** `CancelReservationReconciliationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CancelReservationReconciliationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CancelVrboReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `CancelVrboReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CancelVrboReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ChangeReservationReconciliation</summary>

<br />

**Summary:**

**Operation Class Name:** `ChangeReservationReconciliationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ChangeReservationReconciliationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ConfirmReservationNotification</summary>

<br />

**Summary:**

**Operation Class Name:** `ConfirmReservationNotificationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ConfirmReservationNotificationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateCancellationPolicyConfig</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateCancellationPolicyConfigInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateDayOfWeekDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |
| `promotion` | `DayOfWeekDiscountPromotionCreateInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateFeeSet</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateFeeSetMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateFeeSetInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateMultiNightDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `promotion` | `MultiNightDiscountPromotionCreateInput!` | Description | Yes |
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateNotificationCallbackConfig</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateNotificationCallbackConfigInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `CreatePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreatePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreatePropertyImage</summary>

<br />

**Summary:**

**Operation Class Name:** `CreatePropertyImageMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreatePropertyImageInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateRatePlan</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateRatePlanMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateRatePlanInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateSingleDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `promotion` | `SingleDiscountPromotionCreateInput!` | Description | Yes |
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>CreateUnitSpaces</summary>

<br />

**Summary:**

**Operation Class Name:** `CreateUnitSpacesMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `CreateUnitSpacesInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteImage</summary>

<br />

**Summary:**

**Operation Class Name:** `DeleteImageMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeleteImageInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteNotificationCallbackConfig</summary>

<br />

**Summary:**

**Operation Class Name:** `DeleteNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeleteNotificationCallbackConfigInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DeleteUnitSpace</summary>

<br />

**Summary:**

**Operation Class Name:** `DeleteUnitSpaceMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DeleteUnitSpaceInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>DisableProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `DisablePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `DisablePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>EnableProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `EnablePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `EnablePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>JoinNewListingDiscount</summary>

<br />

**Summary:**

**Operation Class Name:** `JoinNewListingDiscountMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `joinNewListingDiscountId` | `String!` | Description | Yes |
| `idSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RateGuest</summary>

<br />

**Summary:**

**Operation Class Name:** `RateGuestMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `RateGuestInput!` | Description | Yes |
| `propertyId` | `ID!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RefreshNotificationCallbackConfigSecret</summary>

<br />

**Summary:**

**Operation Class Name:** `RefreshNotificationCallbackConfigSecretMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `RefreshNotificationCallbackConfigSecretInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>RefundReservation</summary>

<br />

**Summary:**

**Operation Class Name:** `RefundReservationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `RefundReservationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ReplaceCancellationPolicyConfig</summary>

<br />

**Summary:**

**Operation Class Name:** `ReplaceCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ReplaceCancellationPolicyConfigInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>ReplaceFeeSet</summary>

<br />

**Summary:**

**Operation Class Name:** `ReplaceFeeSetMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `ReplaceFeeSetInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SavePropertyContact</summary>

<br />

**Summary:**

**Operation Class Name:** `SavePropertyContactMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `contact` | `SavePropertyContactInput!` | Description | Yes |
| `propertyId` | `ID!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SendMessage</summary>

<br />

**Summary:**

**Operation Class Name:** `SendMessageMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `SendMessageInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SendTestNotification</summary>

<br />

**Summary:**

**Operation Class Name:** `SendTestNotificationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `SendTestNotificationInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetMessageThreadSpamStatus</summary>

<br />

**Summary:**

**Operation Class Name:** `SetMessageThreadSpamStatusMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `SetMessageThreadSpamStatusInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetPropertyTaxRecord</summary>

<br />

**Summary:**

**Operation Class Name:** `SetPropertyTaxRecordMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `SetPropertyTaxRecordInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SetReviewResponse</summary>

<br />

**Summary:**

**Operation Class Name:** `SetReviewResponseMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `body` | `InputLocalizedString!` | Description | Yes |
| `propertyId` | `ID!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |
| `reviewId` | `ID!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>SubscribeNotificationEventType</summary>

<br />

**Summary:**

**Operation Class Name:** `SubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `SubscribeNotificationEventTypeInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UnsubscribeNotificationEventType</summary>

<br />

**Summary:**

**Operation Class Name:** `UnsubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UnsubscribeNotificationEventTypeInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateDayOfWeekDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `promotion` | `DayOfWeekDiscountPromotionUpdateInput!` | Description | Yes |
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateImage</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateImageMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateImageInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateMultiNightDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `promotion` | `MultiNightDiscountPromotionUpdateInput!` | Description | Yes |
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateNotificationCallbackConfig</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateNotificationCallbackConfigInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateNotificationEventTypeSubscription</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateNotificationEventTypeSubscriptionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateNotificationEventTypeSubscriptionInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateProperty</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdatePropertyMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdatePropertyInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateRatePlan</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateRatePlanMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateRatePlanInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateSingleDiscountPromotion</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `promotion` | `SingleDiscountPromotionUpdateInput!` | Description | Yes |
| `propertyId` | `String!` | Description | Yes |
| `propertyIdSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnit</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateUnitMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdatePropertyUnitInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnitRegistration</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateUnitRegistrationMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `propertyIdSource` | `IdSource!` | Description | Yes |
| `registration` | `UpdateUnitRegistrationInput!` | Description | Yes |
| `forceSave` | `Boolean` | Description | No |
| `propertyId` | `String!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>UpdateUnitSpaces</summary>

<br />

**Summary:**

**Operation Class Name:** `UpdateUnitSpacesMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `input` | `UpdateUnitSpacesInput!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr /><details>
   <summary>WithdrawNewListingDiscount</summary>

<br />

**Summary:**

**Operation Class Name:** `WithdrawNewListingDiscountMutation`

**Operation Inputs:**

| Name              | Type                           | Description                                         | Required |
|-------------------|--------------------------------|-----------------------------------------------------|----------|
| `withdrawNewListingDiscountId` | `String!` | Description | Yes |
| `idSource` | `IdSource!` | Description | Yes |

<br />

**[Usage Example]()  |  [Query Definition]()  |  [Reference]()**
</details>

<hr />
