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

import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.*;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.*;
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration;
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDataManagementClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * Example class to demonstrate different operations supported by the LodgingSupplySandboxDataManagementClient
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
public class LodgingSupplySandboxDataManagementClientUsageExample {

    private static final SandboxDataManagementClient client = new SandboxDataManagementClient(
            ClientConfiguration
                    .builder()
                    .key("KEY")
                    .secret("SECRET")
                    .environment(ClientEnvironment.TEST)
                    .build()
    );

    private static final String PROPERTY_NAME = "Lodging SDK Test Property";
    private static final String UPDATED_PROPERTY_NAME = "New Lodging SDK Test Property";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Delete any old property if it has the same name used in the test run
        deletePropertyIfExists();

        //  ******* Create Property *******
        CreatePropertyInput createPropertyInput = CreatePropertyInput.builder().name(Optional.of(PROPERTY_NAME)).build();
        SandboxCreatePropertyMutation.Data createPropertyResponse = client.executeAsync(new SandboxCreatePropertyMutation(createPropertyInput)).get();


        String propertyId = createPropertyResponse.createProperty.property.id;

        // ******* Update Property Name *******
        UpdatePropertyInput updatePropertyInput = UpdatePropertyInput.builder().id(propertyId).name(Optional.of(UPDATED_PROPERTY_NAME)).build();
        SandboxUpdatePropertyMutation.Data updatePropertyResponse = client.executeAsync(new SandboxUpdatePropertyMutation(updatePropertyInput)).get();

        // ******* Create Reservation *******
        CreateReservationInput createReservationInput = CreateReservationInput.builder().propertyId(propertyId).childCount(Optional.of(4)).adultCount(Optional.of(2)).build();
        SandboxCreateReservationMutation.Data createReservationResponse = client.executeAsync(new SandboxCreateReservationMutation(createReservationInput)).get();


        String reservationId = createReservationResponse.createReservation.reservation.sandboxReservationFragment.id;

        // ******* Update Reservation *******
        UpdateReservationInput updateReservationInput = UpdateReservationInput.builder().id(reservationId).childAges(Optional.of(new ArrayList<>(Arrays.asList(3, 5, 7)))).build();
        SandboxUpdateReservationMutation.Data updateReservationResponse = client.executeAsync(new SandboxUpdateReservationMutation(updateReservationInput)).get();

        // ******* Update Reservation Stay Dates *******
        ChangeReservationStayDatesInput changeStayDatesInput = ChangeReservationStayDatesInput
                .builder()
                .id(reservationId)
                .checkInDate(LocalDate.of(2024, 6, 5))
                .checkOutDate(LocalDate.of(2024, 6, 10))
                .build();

        SandboxChangeReservationStayDatesMutation.Data changeStayDatesResponse = client.executeAsync(new SandboxChangeReservationStayDatesMutation(changeStayDatesInput)).get();

        // ******* Cancel Reservation *******
        CancelReservationInput cancelReservationInput = CancelReservationInput.builder().id(reservationId).sendNotification(Optional.of(false)).build();
        SandboxCancelReservationMutation.Data cancelReservationResponse = client.executeAsync(new SandboxCancelReservationMutation(cancelReservationInput)).get();

        // ******* Delete Reservation *******
        DeleteReservationInput deleteReservationInput = DeleteReservationInput.builder().id(reservationId).build();
        SandboxDeleteReservationMutation.Data deleteReservationResponse = client.executeAsync(new SandboxDeleteReservationMutation(deleteReservationInput)).get();

        // ******* Delete Property *******
        DeletePropertyInput deletePropertyInput = DeletePropertyInput.builder().id(propertyId).build();
        SandboxDeletePropertyMutation.Data deletePropertyResponse = client.executeAsync(new SandboxDeletePropertyMutation(deletePropertyInput)).get();
    }

    private static void deletePropertyIfExists() throws ExecutionException, InterruptedException {
        SandboxPropertiesQuery propertiesQuery = SandboxPropertiesQuery.builder().skipReservations(true).build();
        SandboxPropertiesQuery.Data propertiesResponse = client.executeAsync(propertiesQuery).get();

        propertiesResponse.properties.elements.forEach(property -> {
            if (property.name.equals(PROPERTY_NAME) || property.name.equals(UPDATED_PROPERTY_NAME)) {
                DeletePropertyInput deletePropertyInput = DeletePropertyInput.builder().id(property.id).build();
                client.executeAsync(new SandboxDeletePropertyMutation(deletePropertyInput));
            }
        });
    }
}