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

import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.*;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Example class to demonstrate different operations supported by the LodgingSupplySandboxClient
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
public class LodgingSupplySandboxClientUsageExample {

    private static final SandboxClient client = new SandboxClient(
            ExpediaGroupClientConfiguration
                    .builder()
                    .key("KEY")
                    .secret("SECRET")
                    .endpoint("https://test-api.sandbox.expediagroup.com")
                    .authEndpoint("https://test-api.expediagroup.com/identity/oauth2/v3/token")
                    .build()
    );

    private static final String PROPERTY_NAME = "Lodging SDK Test Property";
    private static final String UPDATED_PROPERTY_NAME = "New Lodging SDK Test Property";

    public static void main(String[] args) {
        // Delete any old property if it has the same name used in the test run
        deletePropertyIfExists();

        //  ******* Create Property *******
        var createPropertyInput = CreatePropertyInput.builder().name(PROPERTY_NAME).build();
        var createPropertyResponse = client.execute(new SandboxCreatePropertyMutation(createPropertyInput));

        assert createPropertyResponse.data != null;

        var propertyId = createPropertyResponse.data.createProperty.property.id;

        System.out.println("Property Created: " + propertyId);
        System.out.println(createPropertyResponse.data);


        // ******* Update Property Name *******
        var updatePropertyInput = UpdatePropertyInput.builder().id(propertyId).name(UPDATED_PROPERTY_NAME).build();
        var updatePropertyResponse = client.execute(new SandboxUpdatePropertyMutation(updatePropertyInput));

        System.out.println("Property Updated: " + propertyId);
        System.out.println(updatePropertyResponse.data);


        // ******* Create Reservation *******
        var createReservationInput = CreateReservationInput.builder().propertyId(propertyId).childCount(4).adultCount(2).build();
        var createReservationResponse = client.execute(new SandboxCreateReservationMutation(createReservationInput));

        assert createReservationResponse.data != null;

        var reservationId = createReservationResponse.data.createReservation.reservation.sandboxReservationFragment.id;

        System.out.println("Reservation Created: " + reservationId);
        System.out.println(createReservationResponse.data);


        // ******* Update Reservation *******
        var updateReservationInput = UpdateReservationInput.builder().id(reservationId).childAges(List.of(3, 5, 7)).build();
        var updateReservationResponse = client.execute(new SandboxUpdateReservationMutation(updateReservationInput));

        System.out.println("Reservation Updated: " + reservationId);
        System.out.println(updateReservationResponse.data);


        // ******* Update Reservation Stay Dates *******
        var changeStayDatesInput = ChangeReservationStayDatesInput
                .builder()
                .id(reservationId)
                .checkInDate(LocalDate.of(2024, 6, 5))
                .checkOutDate(LocalDate.of(2024, 6, 10))
                .build();

        var changeStayDatesResponse = client.execute(new SandboxChangeReservationStayDatesMutation(changeStayDatesInput));

        System.out.println("Reservation Stay Dates Updated: " + reservationId);
        System.out.println(changeStayDatesResponse.data);


        // ******* Cancel Reservation *******
        var cancelReservationInput = CancelReservationInput.builder().id(reservationId).sendNotification(false).build();
        var cancelReservationResponse = client.execute(new SandboxCancelReservationMutation(cancelReservationInput));

        System.out.println("Reservation Was Canceled: " + reservationId);
        System.out.println(cancelReservationResponse.data);


        // ******* Delete Reservation *******
        var deleteReservationInput = DeleteReservationInput.builder().id(reservationId).build();
        var deleteReservationResponse = client.execute(new SandboxDeleteReservationMutation(deleteReservationInput));

        System.out.println("Reservation Was Deleted: " + reservationId);
        System.out.println(deleteReservationResponse.data);


        // ******* Delete Property *******
        var deletePropertyInput = DeletePropertyInput.builder().id(propertyId).build();
        var deletePropertyResponse = client.execute(new SandboxDeletePropertyMutation(deletePropertyInput));

        System.out.println("Property Was Deleted: " + propertyId);
        System.out.println(deletePropertyResponse.data);
    }

    private static void deletePropertyIfExists() {
        var propertiesQuery = SandboxPropertiesQuery.builder().skipReservations(true).build();
        var propertiesResponse = client.execute(propertiesQuery);

        assert propertiesResponse.data != null;

        propertiesResponse.data.properties.elements.forEach(property -> {
            if (property.name.equals(PROPERTY_NAME) || property.name.equals(UPDATED_PROPERTY_NAME)) {
                System.out.println("Deleting existing property: ID: " + property.id + ", Name: " + property.name);
                var deletePropertyInput = DeletePropertyInput.builder().id(property.id).build();
                client.execute(new SandboxDeletePropertyMutation(deletePropertyInput));
            }
        });
    }
}
