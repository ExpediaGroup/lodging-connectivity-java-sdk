# Supply Client
`SupplyClient` is the largest and most versatile client in the Lodging Connectivity SDK. It provides access to various capabilities offered by the Lodging Connectivity GraphQL API, including _Reservations_, _Messaging_, _Promotions_, _Reviews_, and more.

### API Endpoint
This client is connected with https://api.expediagroup.com/supply/lodging/graphql endpoint by default. 

You can refer to the [configuration]() document to explore the full configuration options.

### Initialize the Client
```java
ClientConfiguration config = ClientConfiguration
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

| Name          | Type               | Required             |
|---------------|--------------------|----------------------|
| `Id`          | `String!`          | Yes                  |
| `idSource`    | `IdSource`         | No (default EXPEDIA) |
| `textFilters` | `TextFiltersInput` | No                   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/property_status/reference/property_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/Property.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyReservations</summary>

<br />

**Operation Class Name:** `PropertyReservationsQuery`

**Operation Inputs:**   

| Name                            | Type                     | Required              |
|---------------------------------|--------------------------|-----------------------|
| `propertyId`                    | `String!`                | Yes                   |
| `idSource`                      | `IdSource`               | No (default: EXPEDIA) |
| `pageSize`                      | `Int!`                   | Yes                   |
| `cursor`                        | `String`                 | No                    |
| `filter`                        | `ReservationFilterInput` | No                    |
| `checkOutDate`                  | `CheckOutDateFilter`     | No                    |
| `includePaymentInstrumentToken` | `Boolean`                | No (default: false)   |
| `includeSupplierAmount`         | `Boolean`                | No (default: false)   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/reservations_query/) 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyReservations.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyReservationsSummary</summary>

<br />

**Operation Class Name:** `PropertyReservationsSummaryQuery`

**Operation Inputs:**

| Name           | Type                     | Required              |
|----------------|--------------------------|-----------------------|
| `propertyId`   | `String!`                | Yes                   |
| `idSource`     | `IdSource`               | No (default: EXPEDIA) |
| `pageSize`     | `Int!`                   | Yes                   |
| `cursor`       | `String`                 | No                    |
| `filter`       | `ReservationFilterInput` | No                    |
| `checkOutDate` | `CheckOutDateFilter`     | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/reservations_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyReservationsSummary.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyAmenities</summary>

<br />

**Operation Class Name:** `PropertyAmenitiesQuery`

**Operation Inputs:**

| Name         | Type                    | Required              |
|--------------|-------------------------|-----------------------|
| `propertyId` | `String!`               | Yes                   |
| `idSource`   | `IdSource`              | No (default: EXPEDIA) |
| `filters`    | `AmenitiesFiltersInput` | No                    |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyAmenities.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyDistrict</summary>

<br />

**Operation Class Name:** `PropertyDistrictQuery`

**Operation Inputs:**

| Name         | Type       | Required              |
|--------------|------------|-----------------------|
| `propertyId` | `String!`  | Yes                   |
| `idSource`   | `IdSource` | No (default: EXPEDIA) |
| `locale`     | `String`   | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/district_query/) 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyDistrict.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyFeeSets</summary>

<br />

**Operation Class Name:** `PropertyFeeSetsQuery`

**Operation Inputs:**

| Name         | Type                          | Required              |
|--------------|-------------------------------|-----------------------|
| `propertyId` | `String!`                     | Yes                   |
| `idSource`   | `IdSource`                    | No (default: EXPEDIA) |
| `filters`    | `PropertyFeeSetsFiltersInput` | No                    |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyDistrict.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyListing</summary>

<br />

**Operation Class Name:** `PropertyListingQuery`

**Operation Inputs:**

| Name         | Type         | Required              |
|--------------|--------------|-----------------------|
| `propertyId` | `String!`    | Yes                   |
| `idSource`   | `IdSource`   | No (default: EXPEDIA) |
| `domains`    | `[String!]!` | Yes                   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/property_status/getting_started/intro/#retrieving-location-and-listing-urls)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyListing.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyListingBundleAdoption</summary>

<br />

**Operation Class Name:** `PropertyListingBundleAdoptionQuery`

**Operation Inputs:** None

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyListingBundleAdoption.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyMedia</summary>

<br />

**Operation Class Name:** `PropertyMediaQuery`

**Operation Inputs:**

| Name         | Type                 | Required              |
|--------------|----------------------|-----------------------|
| `propertyId` | `String!`            | Yes                   |
| `idSource`   | `IdSource`           | No (default: EXPEDIA) |
| `filters`    | `ImagesFiltersInput` | No                    |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMedia.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyMessages</summary>
<br />

**Operation Class Name:** `PropertyMessagesQuery`

**Operation Inputs:**

| Name         | Type                            | Required              |
|--------------|---------------------------------|-----------------------|
| `propertyId` | `String!`                       | Yes                   |
| `idSource`   | `IdSource`                      | No (default: EXPEDIA) |
| `filters`    | `PropertyMessagesFiltersInput!` | Yes                   |
| `pageSize`   | `Int`                           | No                    |
| `cursor`     | `String`                        | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messages_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMessages.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyMessageThreads</summary>

<br />

**Operation Class Name:** `PropertyMessageThreadsQuery`

**Operation Inputs:**

| Name         | Type                                 | Required              |
|--------------|--------------------------------------|-----------------------|
| `propertyId` | `String!`                            | Yes                   |
| `idSource`   | `IdSource`                           | No (default: EXPEDIA) |
| `filters`    | `PropertyMessageThreadsFiltersInput` | Yes                   |
| `orderBy`    | `PropertyMessageThreadsOrderByInput` | No                    |
| `pageSize`   | `Int`                                | No                    |
| `cursor`     | `String`                             | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messagethreads_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyMessageThreads.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyPolicies</summary>

<br />

**Operation Class Name:** `PropertyPolicies`

**Operation Inputs:**

| Name         | Type       | Required              |
|--------------|------------|-----------------------|
| `propertyId` | `String!`  | Yes                   |
| `idSource`   | `IdSource` | No (default: EXPEDIA) |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyPolicies.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyPromotions</summary>
<br />

**Operation Class Name:** `PropertyPromotionsQuery`

**Operation Inputs:**

| Name         | Type           | Required              |
|--------------|----------------|-----------------------|
| `propertyId` | `String!`      | Yes                   |
| `filters`    | `FiltersInput` | No                    |
| `idSource`   | `IdSource`     | No (default: EXPEDIA) |
| `pageSize`   | `Int!`         | Yes                   |
| `cursor`     | `String`       | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/promotions_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyPromotions.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyReviews</summary>
<br />

**Operation Class Name:** `PropertyReviewsQuery`

**Operation Inputs:**

| Name         | Type             | Required              |
|--------------|------------------|-----------------------|
| `propertyId` | `String!`        | Yes                   |
| `idSource`   | `IdSource`       | No (default: EXPEDIA) |
| `orderBy`    | `ReviewsOrderBy` | No                    |
| `filter`     | `ReviewFilter`   | No                    |
| `pageSize`   | `Int!`           | Yes                   |
| `cursor`     | `String`         | No                    |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/reviews/reference/reviews_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyReviews.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyUnits</summary>
<br />

**Operation Class Name:** `PropertyUnitsQuery`

**Operation Inputs:**

| Name                  | Type       | Required              |
|-----------------------|------------|-----------------------|
| `propertyId`          | `String!`  | Yes                   |
| `idSource`            | `IdSource` | No (default: EXPEDIA) |
| `includeRegistration` | `Boolean`  | No (default: false)   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/property_status/reference/property_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyUnits.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyUnitsRegistration</summary>
<br />

**Operation Class Name:** `PropertyUnitsRegistrationQuery`

**Operation Inputs:**

| Name                  | Type       | Required              |
|-----------------------|------------|-----------------------|
| `propertyId`          | `String!`  | Yes                   |
| `idSource`            | `IdSource` | No (default: EXPEDIA) |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/registration_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyUnitsRegistration.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertyAggregatedReviews</summary>
<br />

**Operation Class Name:** `PropertyAggregatedReviewsQuery`

**Operation Inputs:**

| Name         | Type                             | Required              |
|--------------|----------------------------------|-----------------------|
| `propertyId` | `String!`                        | Yes                   |
| `idSource`   | `IdSource`                       | No (default: EXPEDIA) |
| `filters`    | `AggregatedReviewsFiltersInput!` | Yes                   |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/reviews/reference/aggregatedReviews_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertyAggregatedReviews.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>PropertiesByAdvertiser</summary>
<br />

**Operation Class Name:** `PropertiesByAdvertiserQuery`

**Operation Inputs:**

| Name       | Type        | Required              |
|------------|-------------|-----------------------|
| `id`       | `String!`   | Yes                   |
| `idSource` | `IdSource!` | No (default: EXPEDIA) |
| `pageSize` | `Int`       | No                    |
| `cursor`   | `String`    | No                    |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/PropertiesByAdvertiser.graphql)
- [Reference]()

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

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/CancellationPolicyConfig.graphql)
- [Reference]()

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

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/districtByCoordinates_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/DistrictByCoordinates.graphql)
- [Reference]()

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

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/message_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/Message.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>MessageThread</summary>
<br />

**Operation Class Name:** `MessageThreadQuery`

**Operation Inputs:**

| Name              | Type                                | Required |
|-------------------|-------------------------------------|----------|
| `id`              | `ID!`                               | Yes      |
| `pageSize`        | `Int`                               | No       |
| `cursor`          | `String`                            | No       |
| `orderMessagesBy` | `MessageThreadMessagesOrderByInput` | No       |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/messagethread_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/MessageThread.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>NotificationEventTypes</summary>
<br />

**Operation Class Name:** `NotificationEventTypesQuery`

**Operation Inputs:** None

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/notificationeventtypes_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/NotificationEventTypes.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>NotificationProfile</summary>
<br />

**Operation Class Name:** `NotificationProfileQuery`

**Operation Inputs:** None

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/notificationprofile_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/NotificationProfile.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>RatePlan</summary>
<br />

**Operation Class Name:** `RatePlanQuery`

**Operation Inputs:**

| Name         | Type  | Required |
|--------------|-------|----------|
| `propertyId` | `ID!` | Yes      |
| `ratePlanId` | `Id`  | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/RatePlan.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>UndeliveredNotifications</summary>
<br />

**Operation Class Name:** `UndeliveredNotificationsQuery`

**Operation Inputs:**

| Name       | Type                                    | Required |
|------------|-----------------------------------------|----------|
| `filters`  | `UndeliveredNotificationsFiltersInput!` | Yes      |
| `cursor`   | `String`                                | No       |
| `pageSize` | `Int`                                   | No       |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/undeliverednotifications_query/)
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/UndeliveredNotifications.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>Unit</summary>
<br />

**Operation Class Name:** `UnitQuery`

**Operation Inputs:**

| Name | Type  | Required |
|------|-------|----------|
| `id` | `ID!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Query Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/queries/Unit.graphql)
- [Reference]()

</details>

<hr />

<br /><br />

### SupplyClient - Mutations

<hr />

<details>
   <summary>AddMessage</summary>

<br />

**Operation Class Name:** `AddMessageMutation`

**Operation Inputs:**

| Name              | Type                            | Required |
|-------------------|---------------------------------|----------|
| `messageThreadId` | `ID!`                           | Yes      |
| `message`         | `AddMessageThreadMessageInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/AddMessage.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>ArchivePropertyIds</summary>

<br />

**Operation Class Name:** `ArchivePropertyIdsMutation`

**Operation Inputs:**

| Name    | Type                       | Required |
|---------|----------------------------|----------|
| `input` | `ArchivePropertyIdsInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/ArchivePropertyIds.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CancelReservation</summary>

<br />

**Operation Class Name:** `CancelReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `CancelReservationInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/cancelReservation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CancelReservation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CancelReservationReconciliation</summary>

<br />

**Operation Class Name:** `CancelReservationReconciliationMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `CancelReservationReconciliationInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/cancelReservationReconciliation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CancelReservationReconciliation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CancelVrboReservation</summary>

<br />

**Operation Class Name:** `CancelVrboReservationMutation`

**Operation Inputs:**

| Name    | Type                          | Required |
|---------|-------------------------------|----------|
| `input` | `CancelVrboReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CancelVrboReservation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ChangeReservationReconciliation</summary>

<br />

**Operation Class Name:** `ChangeReservationReconciliationMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `ChangeReservationReconciliationInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/booking_apis/reservations/reference/changeReservationReconciliation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/ChangeReservationReconciliation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ConfirmReservationNotification</summary>

<br />

**Operation Class Name:** `ConfirmReservationNotificationMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `ConfirmReservationNotificationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/ConfirmReservationNotification.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateCancellationPolicyConfig</summary>

<br />

**Operation Class Name:** `CreateCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `CreateCancellationPolicyConfigInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateCancellationPolicyConfig.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateDayOfWeekDiscountPromotion</summary>

<br />

**Operation Class Name:** `CreateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                     | Required |
|--------------------|------------------------------------------|----------|
| `propertyId`       | `String!`                                | Yes      |
| `propertyIdSource` | `IdSource!`                              | Yes      |
| `promotion`        | `DayOfWeekDiscountPromotionCreateInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/createdayofweekdiscountpromotion/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateDayOfWeekDiscountPromotion.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateFeeSet</summary>

<br />

**Operation Class Name:** `CreateFeeSetMutation`

**Operation Inputs:**

| Name    | Type                 | Required |
|---------|----------------------|----------|
| `input` | `CreateFeeSetInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateFeeSet.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateMultiNightDiscountPromotion</summary>

<br />

**Operation Class Name:** `CreateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                      | Required |
|--------------------|-------------------------------------------|----------|
| `promotion`        | `MultiNightDiscountPromotionCreateInput!` | Yes      |
| `propertyId`       | `String!`                                 | Yes      |
| `propertyIdSource` | `IdSource!`                               | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/createmultinightdiscountpromotion/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateMultiNightDiscountPromotion.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateNotificationCallbackConfig</summary>

<br />

**Operation Class Name:** `CreateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `CreateNotificationCallbackConfigInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/createnotificationcallbackconfig_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateNotificationCallbackConfig.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateProperty</summary>

<br />

**Operation Class Name:** `CreatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `CreatePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateProperty.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreatePropertyImage</summary>

<br />

**Operation Class Name:** `CreatePropertyImageMutation`

**Operation Inputs:**

| Name    | Type                        | Required |
|---------|-----------------------------|----------|
| `input` | `CreatePropertyImageInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreatePropertyImage.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateRatePlan</summary>

<br />

**Operation Class Name:** `CreateRatePlanMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `CreateRatePlanInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateRatePlan.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateSingleDiscountPromotion</summary>

<br />

**Operation Class Name:** `CreateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                  | Required |
|--------------------|---------------------------------------|----------|
| `promotion`        | `SingleDiscountPromotionCreateInput!` | Yes      |
| `propertyId`       | `String!`                             | Yes      |
| `propertyIdSource` | `IdSource!`                           | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/createsinglediscountpromotion/) 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateSingleDiscountPromotion.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>CreateUnitSpaces</summary>

<br />

**Operation Class Name:** `CreateUnitSpacesMutation`

**Operation Inputs:**

| Name    | Type                     | Required |
|---------|--------------------------|----------|
| `input` | `CreateUnitSpacesInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/CreateUnitSpaces.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>DeleteImage</summary>

<br />

**Operation Class Name:** `DeleteImageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `DeleteImageInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/DeleteImage.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>DeleteNotificationCallbackConfig</summary>

<br />

**Operation Class Name:** `DeleteNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `DeleteNotificationCallbackConfigInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/deletenotificationcallbackconfig_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/DeleteNotificationCallbackConfig.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>DeleteUnitSpace</summary>

<br />

**Operation Class Name:** `DeleteUnitSpaceMutation`

**Operation Inputs:**

| Name    | Type                    | Required |
|---------|-------------------------|----------|
| `input` | `DeleteUnitSpaceInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/DeleteUnitSpace.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>DisableProperty</summary>

<br />

**Operation Class Name:** `DisablePropertyMutation`

**Operation Inputs:**

| Name    | Type                    | Required |
|---------|-------------------------|----------|
| `input` | `DisablePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/DisableProperty.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>EnableProperty</summary>

<br />

**Operation Class Name:** `EnablePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `EnablePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/EnableProperty.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>JoinNewListingDiscount</summary>

<br />

**Operation Class Name:** `JoinNewListingDiscountMutation`

**Operation Inputs:**

| Name                       | Type        | Required |
|----------------------------|-------------|----------|
| `joinNewListingDiscountId` | `String!`   | Yes      |
| `idSource`                 | `IdSource!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/JoinNewListingDiscount.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>RateGuest</summary>

<br />

**Operation Class Name:** `RateGuestMutation`

**Operation Inputs:**

| Name               | Type              | Required |
|--------------------|-------------------|----------|
| `input`            | `RateGuestInput!` | Yes      |
| `propertyId`       | `ID!`             | Yes      |
| `propertyIdSource` | `IdSource!`       | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/RateGuest.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>RefreshNotificationCallbackConfigSecret</summary>

<br />

**Operation Class Name:** `RefreshNotificationCallbackConfigSecretMutation`

**Operation Inputs:**

| Name    | Type                                            | Required |
|---------|-------------------------------------------------|----------|
| `input` | `RefreshNotificationCallbackConfigSecretInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/refreshnotificationcallbackconfigsecret_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/RefreshNotificationCallbackConfigSecret.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>RefundReservation</summary>

<br />

**Operation Class Name:** `RefundReservationMutation`

**Operation Inputs:**

| Name    | Type                      | Required |
|---------|---------------------------|----------|
| `input` | `RefundReservationInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/RefundReservation.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ReplaceCancellationPolicyConfig</summary>

<br />

**Operation Class Name:** `ReplaceCancellationPolicyConfigMutation`

**Operation Inputs:**

| Name    | Type                                    | Required |
|---------|-----------------------------------------|----------|
| `input` | `ReplaceCancellationPolicyConfigInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/ReplaceCancellationPolicyConfig.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>ReplaceFeeSet</summary>

<br />

**Operation Class Name:** `ReplaceFeeSetMutation`

**Operation Inputs:**

| Name    | Type                  | Required |
|---------|-----------------------|----------|
| `input` | `ReplaceFeeSetInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/ReplaceFeeSet.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>SendMessage</summary>

<br />

**Operation Class Name:** `SendMessageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `SendMessageInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/messaging/reference/sendmessage_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SendMessage.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>SendTestNotification</summary>

<br />

**Operation Class Name:** `SendTestNotificationMutation`

**Operation Inputs:**

| Name    | Type                         | Required |
|---------|------------------------------|----------|
| `input` | `SendTestNotificationInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/sendtestnotification_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SendTestNotification.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>SetMessageThreadSpamStatus</summary>

<br />

**Operation Class Name:** `SetMessageThreadSpamStatusMutation`

**Operation Inputs:**

| Name    | Type                               | Required |
|---------|------------------------------------|----------|
| `input` | `SetMessageThreadSpamStatusInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SetMessageThreadSpamStatus.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>SetPropertyTaxRecord</summary>

<br />

**Operation Class Name:** `SetPropertyTaxRecordMutation`

**Operation Inputs:**

| Name    | Type                         | Required |
|---------|------------------------------|----------|
| `input` | `SetPropertyTaxRecordInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SetPropertyTaxRecord.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>SetReviewResponse</summary>

<br />

**Operation Class Name:** `SetReviewResponseMutation`

**Operation Inputs:**

| Name               | Type                    | Required |
|--------------------|-------------------------|----------|
| `body`             | `InputLocalizedString!` | Yes      |
| `propertyId`       | `ID!`                   | Yes      |
| `propertyIdSource` | `IdSource!`             | Yes      |
| `reviewId`         | `ID!`                   | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/reviews/reference/setReviewResponse_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SetReviewResponse.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>SubscribeNotificationEventType</summary>

<br />

**Operation Class Name:** `SubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name    | Type                                   | Required |
|---------|----------------------------------------|----------|
| `input` | `SubscribeNotificationEventTypeInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/subscribenotificationeventtype_mutation/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/SubscribeNotificationEventType.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>UnsubscribeNotificationEventType</summary>

<br />

**Operation Class Name:** `UnsubscribeNotificationEventTypeMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `UnsubscribeNotificationEventTypeInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/unsubscribenotificationeventtype_mutation/) 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UnsubscribeNotificationEventType.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateDayOfWeekDiscountPromotion</summary>

<br />

**Operation Class Name:** `UpdateDayOfWeekDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                     | Required |
|--------------------|------------------------------------------|----------|
| `promotion`        | `DayOfWeekDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                                | Yes      |
| `propertyIdSource` | `IdSource!`                              | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/updatedayofweekdiscountpromotion/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateDayOfWeekDiscountPromotion.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateImage</summary>

<br />

**Operation Class Name:** `UpdateImageMutation`

**Operation Inputs:**

| Name    | Type                | Required |
|---------|---------------------|----------|
| `input` | `UpdateImageInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateImage.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateMultiNightDiscountPromotion</summary>

<br />

**Operation Class Name:** `UpdateMultiNightDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                      | Required |
|--------------------|-------------------------------------------|----------|
| `promotion`        | `MultiNightDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                                 | Yes      |
| `propertyIdSource` | `IdSource!`                               | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/updatemultinightdiscountpromotion/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateMultiNightDiscountPromotion.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateNotificationCallbackConfig</summary>

<br />

**Operation Class Name:** `UpdateNotificationCallbackConfigMutation`

**Operation Inputs:**

| Name    | Type                                     | Required |
|---------|------------------------------------------|----------|
| `input` | `UpdateNotificationCallbackConfigInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/updatenotificationcallbackconfig_mutation/) 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateNotificationCallbackConfig.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateNotificationEventTypeSubscription</summary>

<br />

**Operation Class Name:** `UpdateNotificationEventTypeSubscriptionMutation`

**Operation Inputs:**

| Name    | Type                                            | Required |
|---------|-------------------------------------------------|----------|
| `input` | `UpdateNotificationEventTypeSubscriptionInput!` | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/notifications/reference/updatenotificationeventtypesubscription_mutation/) 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateNotificationEventTypeSubscription.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateProperty</summary>

<br />

**Operation Class Name:** `UpdatePropertyMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `UpdatePropertyInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateProperty.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateRatePlan</summary>

<br />

**Operation Class Name:** `UpdateRatePlanMutation`

**Operation Inputs:**

| Name    | Type                   | Required |
|---------|------------------------|----------|
| `input` | `UpdateRatePlanInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateRatePlan.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateSingleDiscountPromotion</summary>

<br />

**Operation Class Name:** `UpdateSingleDiscountPromotionMutation`

**Operation Inputs:**

| Name               | Type                                  | Required |
|--------------------|---------------------------------------|----------|
| `promotion`        | `SingleDiscountPromotionUpdateInput!` | Yes      |
| `propertyId`       | `String!`                             | Yes      |
| `propertyIdSource` | `IdSource!`                           | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/avail_and_rate_apis/promotions/reference/updatesinglediscountpromotion/)
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateSingleDiscountPromotion.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateUnit</summary>

<br />

**Operation Class Name:** `UpdateUnitMutation`

**Operation Inputs:**

| Name    | Type                       | Required |
|---------|----------------------------|----------|
| `input` | `UpdatePropertyUnitInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateUnit.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateUnitRegistration</summary>

<br />

**Operation Class Name:** `UpdateUnitRegistrationMutation`

**Operation Inputs:**

| Name               | Type                           | Required |
|--------------------|--------------------------------|----------|
| `propertyIdSource` | `IdSource!`                    | Yes      |
| `registration`     | `UpdateUnitRegistrationInput!` | Yes      |
| `forceSave`        | `Boolean`                      | No       |
| `propertyId`       | `String!`                      | Yes      |

<br />

**Resources**
- [Documentation](https://developers.expediagroup.com/supply/lodging/docs/property_mgmt_apis/compliance/reference/updateUnitRegistration_mutation/) 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateUnitRegistration.graphql) 
- [Reference]()

</details>

<hr />

<details>
   <summary>UpdateUnitSpaces</summary>

<br />

**Operation Class Name:** `UpdateUnitSpacesMutation`

**Operation Inputs:**

| Name    | Type                     | Required |
|---------|--------------------------|----------|
| `input` | `UpdateUnitSpacesInput!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/UpdateUnitSpaces.graphql)
- [Reference]()

</details>

<hr />

<details>
   <summary>WithdrawNewListingDiscount</summary>

<br />

**Operation Class Name:** `WithdrawNewListingDiscountMutation`

**Operation Inputs:**

| Name                           | Type        | Required |
|--------------------------------|-------------|----------|
| `withdrawNewListingDiscountId` | `String!`   | Yes      |
| `idSource`                     | `IdSource!` | Yes      |

<br />

**Resources**
- ⚠️ Documentation is unavailable at the moment 
- [Mutation Definition](https://github.com/ExpediaGroup/lodging-connectivity-graphql-operations/blob/main/supply/operations/mutations/WithdrawNewListingDiscount.graphql)
- [Reference]()

</details>

<hr />
