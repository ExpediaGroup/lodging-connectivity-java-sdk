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
The SDK offers a set of queries & mutations you can execute using the `SupplyClient`. Below is an overview list of the available operations.

<br />

### SupplyClient - Queries

<hr />

<details>
   <summary>Property</summary>

<br /> 

**Operation Class Name:** `PropertyQuery`

**Operation Inputs:**

| Name | Type      | Required |
|------|-----------|----------|
| `Id` | `String!` | Yes      |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/property_status/reference/property_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/Property.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyReservations</summary>

<br />

**Operation Class Name:** `PropertyReservationsQuery`

**Operation Inputs:**   

| Name                            | Type                     | Required            |
|---------------------------------|--------------------------|---------------------|
| `propertyId`                    | `String!`                | Yes                 |
| `pageSize`                      | `Int!`                   | Yes                 |
| `after`                         | `String`                 | No                  |
| `filter`                        | `ReservationFilterInput` | No                  |
| `checkOutDate`                  | `CheckOutDateFilter`     | No                  |
| `includePaymentInstrumentToken` | `Boolean`                | No (default: false) |
| `includeSupplierAmount`         | `Boolean`                | No (default: false) |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/reservations_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyReservations.graphql)  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyAmenities</summary>

<br />

**Operation Class Name:** `PropertyAmenitiesQuery`

**Operation Inputs:**

| Name         | Type                    | Required |
|--------------|-------------------------|----------|
| `propertyId` | `String!`               | Yes      |
| `filters`    | `AmenitiesFiltersInput` | No       |

<br />

⚠️ Documentation is unavailable at the moment | **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyAmenities.graphql)  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyDistrict</summary>

<br />

**Operation Class Name:** `PropertyDistrictQuery`

**Operation Inputs:**

| Name         | Type      | Required |
|--------------|-----------|----------|
| `propertyId` | `String!` | Yes      |
| `locale`     | `String`  | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/district_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyDistrict.graphql)  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyFeeSets</summary>

<br />

**Operation Class Name:** `PropertyFeeSetsQuery`

**Operation Inputs:**

| Name         | Type                          | Required |
|--------------|-------------------------------|----------|
| `propertyId` | `String!`                     | Yes      |
| `filters`    | `PropertyFeeSetsFiltersInput` | No       |

<br />

⚠️ Documentation is unavailable at the moment | **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyDistrict.graphql)  |  [Reference]()**

</details>

<hr />

<details>
   <summary>PropertyListing</summary>

<br />

**Operation Class Name:** `PropertyListingQuery`

**Operation Inputs:**

| Name         | Type         | Required |
|--------------|--------------|----------|
| `propertyId` | `String!`    | Yes      |
| `domains`    | `[String!]!` | Yes      |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/property_status/getting_started/intro/#retrieving-location-and-listing-urls)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyListing.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyListingBundleAdoption</summary>

<br />

**Operation Class Name:** `PropertyListingBundleAdoptionQuery`

**Operation Inputs:** None

<br />

⚠️ Documentation is unavailable at the moment | **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyListingBundleAdoption.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMedia</summary>

<br />

**Operation Class Name:** `PropertyMediaQuery`

**Operation Inputs:**

| Name         | Type                 | Required |
|--------------|----------------------|----------|
| `propertyId` | `String!`            | Yes      |
| `filters`    | `ImagesFiltersInput` | No       |

<br />

⚠️ Documentation is unavailable at the moment  |  **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMedia.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMessages</summary>
<br />

**Operation Class Name:** `PropertyMessagesQuery`

**Operation Inputs:**

| Name         | Type                           | Description                   | Required |
|--------------|--------------------------------|-------------------------------|----------|
| `propertyId` | `String!`                      | The ID of the property        | Yes      |
| `filters`    | `PropertyMessagesFiltersInput` | Filter the requested messages | Yes      |
| `limit`      | `Int`                          | Messages limit per page       | No       |
| `cursor`     | `String`                       | Pagination cursor             | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messages_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMessages.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyMessageThreads</summary>

<br />

**Operation Class Name:** `PropertyMessageThreadsQuery`

**Operation Inputs:**

| Name         | Type                                 | Required |
|--------------|--------------------------------------|----------|
| `propertyId` | `String!`                            | Yes      |
| `filters`    | `PropertyMessageThreadsFiltersInput` | Yes      |
| `orderBy`    | `PropertyMessageThreadsOrderByInput` | No       |
| `limit`      | `Int`                                | No       |
| `cursor`     | `String`                             | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messagethreads_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMessageThreads.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyPromotions</summary>
<br />

**Operation Class Name:** `PropertyPromotionsQuery`

**Operation Inputs:**

| Name         | Type           | Required |
|--------------|----------------|----------|
| `propertyId` | `String!`      | Yes      |
| `filters`    | `FiltersInput` | No       |
| `pageSize`   | `Int!`         | Yes      |
| `after`      | `String`       | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/promotions_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyPromotions.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyRegistration</summary>
<br />

**Operation Class Name:** `PropertyRegistrationQuery`

**Operation Inputs:**

| Name         | Type       | Required |
|--------------|------------|----------|
| `propertyId` | `String!`  | Yes      |
| `idSource`   | `IdSource` | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/registration_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyRegistration.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyReviews</summary>
<br />

**Operation Class Name:** `PropertyReviewsQuery`

**Operation Inputs:**

| Name         | Type             | Required |
|--------------|------------------|----------|
| `propertyId` | `String!`        | Yes      |
| `orderBy`    | `ReviewsOrderBy` | No       |
| `filter`     | `ReviewFilter`   | No       |
| `pageSize`   | `Int!`           | Yes      |
| `after`      | `String`         | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/reviews/reference/reviews_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyReviews.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertyAggregatedReviews</summary>
<br />

**Operation Class Name:** `PropertyAggregatedReviewsQuery`

**Operation Inputs:**

| Name         | Type                            | Required |
|--------------|---------------------------------|----------|
| `propertyId` | `String!`                       | Yes      |
| `filters`    | `AggregatedReviewsFiltersInput` | Yes      |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/reviews/reference/aggregatedReviews_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyAggregatedReviews.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>PropertiesByAdvertiser</summary>
<br />

**Operation Class Name:** `PropertiesByAdvertiserQuery`

**Operation Inputs:**

| Name       | Type        | Required |
|------------|-------------|----------|
| `id`       | `String!`   | Yes      |
| `idSource` | `IdSource!` | Yes      |
| `pageSize` | `Int`       | No       |
| `cursor`   | `String`    | No       |
<br />

⚠️ Documentation is unavailable at the moment  |  **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertiesByAdvertiser.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>CancellationPolicyConfig</summary>
<br />

**Operation Class Name:** `CancellationPolicyConfigQuery`

**Operation Inputs:**

| Name       | Type  | Required |
|------------|-------|----------|
| `id`       | `ID!` | Yes      |

<br />

⚠️ Documentation is unavailable at the moment  |  **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/CancellationPolicyConfig.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>DistrictByCoordinates</summary>
<br />

**Operation Class Name:** `DistrictByCoordinatesQuery`

**Operation Inputs:**

| Name        | Type     | Required |
|-------------|----------|----------|
| `latitude`  | `Float!` | Yes      |
| `longitude` | `Float!` | Yes      |
| `locale`    | `String` | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/districtByCoordinates_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/DistrictByCoordinates.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>Message</summary>
<br />

**Operation Class Name:** `MessageQuery`

**Operation Inputs:**

| Name        | Type  | Required |
|-------------|-------|----------|
| `messageId` | `ID!` | Yes      |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/message_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/Message.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>MessageThread</summary>
<br />

**Operation Class Name:** `MessageThreadQuery`

**Operation Inputs:**

| Name              | Type                                | Required |
|-------------------|-------------------------------------|----------|
| `messageThreadId` | `ID!`                               | Yes      |
| `messagesLimit`   | `Int`                               | No       |
| `messagesCursor`  | `String`                            | No       |
| `orderMessagesBy` | `MessageThreadMessagesOrderByInput` | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messagethread_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/MessageThread.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>NotificationEventTypes</summary>
<br />

**Operation Class Name:** `NotificationEventTypesQuery`

**Operation Inputs:** None

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/notificationeventtypes_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/NotificationEventTypes.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>NotificationProfile</summary>
<br />

**Operation Class Name:** `NotificationProfileQuery`

**Operation Inputs:** None

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/notificationprofile_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/NotificationProfile.graphql)  |  [Reference]()**
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

⚠️ Documentation is unavailable at the moment |  **[Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/RatePlan.graphql)  |  [Reference]()**
</details>

<hr />

<details>
   <summary>UndeliveredNotifications</summary>
<br />

**Operation Class Name:** `UndeliveredNotificationsQuery`

**Operation Inputs:**

| Name      | Type                                    | Description                         | Required |
|-----------|-----------------------------------------|-------------------------------------|----------|
| `filters` | `UndeliveredNotificationsFiltersInput!` | Filters the requested notifications | Yes      |
| `cursor`  | `String`                                | Pagination cursor                   | No       |
| `limit`   | `Int`                                   | notifications limit per page        | No       |

<br />

**[Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/undeliverednotifications_query/)  |  [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/UndeliveredNotifications.graphql)  |  [Reference]()**
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
