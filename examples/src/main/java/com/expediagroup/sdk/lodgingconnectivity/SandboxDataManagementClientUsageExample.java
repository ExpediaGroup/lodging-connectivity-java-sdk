/*
 * Copyright (C) 2024 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.lodgingconnectivity;

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCancelReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxChangeReservationStayDatesMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDataManagementClient;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCreatePropertyMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxCreateReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeletePropertyMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDeleteReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxPropertiesQuery;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxUpdatePropertyMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxUpdateReservationMutation;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CancelReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeletePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.DeleteReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

/**
 * Example class to demonstrate different operations supported by the SandboxDataManagementClient
 * Run the main method to see these operations in action:
 * 1. Create a Property
 * 2. Update Property Name
 * 3. Create a Reservation
 * 4. Update the Reservation
 * 5. Update the Reservation's Stay Dates
 * 6. Cancel the Reservation
 * 7. Delete the Reservation
 * 8. Delete the Property
 **/
public class SandboxDataManagementClientUsageExample {

    private static final SandboxDataManagementClient client = new SandboxDataManagementClient(
            ClientConfiguration
                    .builder()
                    .key("KEY")
                    .secret("SECRET")
                    .build()
    );

    private static final String PROPERTY_NAME = "Lodging SDK Test Property";
    private static final String UPDATED_PROPERTY_NAME = "New Lodging SDK Test Property";

    public static void main(String[] args) {
        // Delete any old property if it has the same name used in the test run
        deletePropertyIfExists();

        //  ******* Create Property *******
        var createPropertyInput = CreatePropertyInput.builder().name(Optional.of(PROPERTY_NAME)).build();
        var createPropertyResponse = client.execute(new SandboxCreatePropertyMutation(createPropertyInput));


        var propertyId = createPropertyResponse.createProperty.property.id;

        System.out.println("Property Created: " + propertyId);
        System.out.println(createPropertyResponse);


        // ******* Update Property Name *******
        var updatePropertyInput = UpdatePropertyInput.builder().id(propertyId).name(Optional.of(UPDATED_PROPERTY_NAME)).build();
        var updatePropertyResponse = client.execute(new SandboxUpdatePropertyMutation(updatePropertyInput));

        System.out.println("Property Updated: " + propertyId);
        System.out.println(updatePropertyResponse);


        // ******* Create Reservation *******
        var createReservationInput = CreateReservationInput.builder().propertyId(propertyId).childCount(Optional.of(4)).adultCount(Optional.of(2)).build();
        var createReservationResponse = client.execute(new SandboxCreateReservationMutation(createReservationInput));


        var reservationId = createReservationResponse.createReservation.reservation.sandboxReservationFragment.id;

        System.out.println("Reservation Created: " + reservationId);
        System.out.println(createReservationResponse);


        // ******* Update Reservation *******
        var updateReservationInput = UpdateReservationInput.builder().id(reservationId).childAges(Optional.of(List.of(3, 5, 7))).build();
        var updateReservationResponse = client.execute(new SandboxUpdateReservationMutation(updateReservationInput));

        System.out.println("Reservation Updated: " + reservationId);
        System.out.println(updateReservationResponse);


        // ******* Update Reservation Stay Dates *******
        var changeStayDatesInput = ChangeReservationStayDatesInput
                .builder()
                .id(reservationId)
                .checkInDate(LocalDate.of(2024, 6, 5))
                .checkOutDate(LocalDate.of(2024, 6, 10))
                .build();

        var changeStayDatesResponse = client.execute(new SandboxChangeReservationStayDatesMutation(changeStayDatesInput));

        System.out.println("Reservation Stay Dates Updated: " + reservationId);
        System.out.println(changeStayDatesResponse);


        // ******* Cancel Reservation *******
        var cancelReservationInput = CancelReservationInput.builder().id(reservationId).sendNotification(Optional.of(false)).build();
        var cancelReservationResponse = client.execute(new SandboxCancelReservationMutation(cancelReservationInput));

        System.out.println("Reservation Was Canceled: " + reservationId);
        System.out.println(cancelReservationResponse);


        // ******* Delete Reservation *******
        var deleteReservationInput = DeleteReservationInput.builder().id(reservationId).build();
        var deleteReservationResponse = client.execute(new SandboxDeleteReservationMutation(deleteReservationInput));

        System.out.println("Reservation Was Deleted: " + reservationId);
        System.out.println(deleteReservationResponse);


        // ******* Delete Property *******
        var deletePropertyInput = DeletePropertyInput.builder().id(propertyId).build();
        var deletePropertyResponse = client.execute(new SandboxDeletePropertyMutation(deletePropertyInput));

        System.out.println("Property Was Deleted: " + propertyId);
        System.out.println(deletePropertyResponse);

        System.exit(0);
    }

    private static void deletePropertyIfExists() {
        var propertiesQuery = SandboxPropertiesQuery.builder().skipReservations(true).build();
        var propertiesResponse = client.execute(propertiesQuery);

        propertiesResponse.properties.elements.forEach(property -> {
            if (property.name.equals(PROPERTY_NAME) || property.name.equals(UPDATED_PROPERTY_NAME)) {
                System.out.println("Deleting existing property: ID: " + property.id + ", Name: " + property.name);
                var deletePropertyInput = DeletePropertyInput.builder().id(property.id).build();
                client.execute(new SandboxDeletePropertyMutation(deletePropertyInput));
            }
        });
    }
}
