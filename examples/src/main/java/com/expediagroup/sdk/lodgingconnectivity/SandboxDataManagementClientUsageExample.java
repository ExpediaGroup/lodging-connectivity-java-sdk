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
import com.expediagroup.sdk.lodgingconnectivity.graphql.model.response.GraphQLResponse;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.SandboxDataManagementClient;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxPropertyData;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.fragment.SandboxReservationData;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CancelReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.ChangeReservationStayDatesInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.CreateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.graphql.sandbox.type.UpdateReservationInput;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        CreatePropertyInput createPropertyInput = CreatePropertyInput
                .builder()
                .name(Optional.of(PROPERTY_NAME))
                .build();

        SandboxPropertyData sandboxProperty = client.createProperty(createPropertyInput);

        System.out.println("Property Created: " + sandboxProperty.id);
        System.out.println(sandboxProperty);


        // ******* Update Property Name *******
        UpdatePropertyInput updatePropertyInput = UpdatePropertyInput
                .builder()
                .id(sandboxProperty.id)
                .name(Optional.of(UPDATED_PROPERTY_NAME))
                .build();

        sandboxProperty = client.updateProperty(updatePropertyInput);

        System.out.println("Property Updated: " + sandboxProperty.id);
        System.out.println(sandboxProperty);


        // ******* Create Reservation *******
        CreateReservationInput createReservationInput = CreateReservationInput
                .builder()
                .propertyId(sandboxProperty.id)
                .childCount(Optional.of(4))
                .adultCount(Optional.of(2))
                .build();

        SandboxReservationData sandboxPropertyReservation = client.createReservation(createReservationInput);

        System.out.println("Reservation Created: " + sandboxPropertyReservation.id);
        System.out.println(sandboxPropertyReservation);


        // ******* Update Reservation *******
        UpdateReservationInput updateReservationInput = UpdateReservationInput
                .builder()
                .id(sandboxPropertyReservation.id)
                .childAges(Optional.of(Arrays.asList(3, 5, 7)))
                .build();

        sandboxPropertyReservation = client.updateReservation(updateReservationInput);

        System.out.println("Reservation Updated: " + sandboxPropertyReservation.id);
        System.out.println(sandboxPropertyReservation);


        // ******* Update Reservation Stay Dates *******
        ChangeReservationStayDatesInput changeReservationStayDatesInput = ChangeReservationStayDatesInput
                .builder()
                .id(sandboxPropertyReservation.id)
                .checkInDate(LocalDate.of(2024, 6, 5))
                .checkOutDate(LocalDate.of(2024, 6, 10))
                .build();

        sandboxPropertyReservation = client.changeReservationStayDates(changeReservationStayDatesInput);

        System.out.println("Reservation Stay Dates Updated: " + sandboxPropertyReservation.id);
        System.out.println(sandboxPropertyReservation);

        // ******* Cancel Reservation *******
        CancelReservationInput cancelReservationInput = CancelReservationInput
                .builder()
                .id(sandboxPropertyReservation.id)
                .sendNotification(Optional.of(false))
                .build();

        sandboxPropertyReservation = client.cancelReservation(cancelReservationInput);

        System.out.println("Reservation Was Canceled: " + sandboxPropertyReservation.id);
        System.out.println(sandboxPropertyReservation);


        // ******* Delete Reservation *******
        client.deleteReservation(sandboxPropertyReservation.id);

        System.out.println("Reservation Was Deleted: " + sandboxPropertyReservation.id);

        // ******* Delete Property *******
        client.deleteProperty(sandboxProperty.id);

        System.out.println("Property Was Deleted: " + sandboxProperty.id);

        System.exit(0);
    }

    private static void deletePropertyIfExists() {
        GraphQLResponse<List<SandboxPropertyData>> properties = client.getProperties();

        properties.getData().forEach(property -> {
            if (property.name.equals(PROPERTY_NAME) || property.name.equals(UPDATED_PROPERTY_NAME)) {
                System.out.println("Deleting existing property: ID: " + property.id + ", Name: " + property.name);
                client.deleteProperty(property.id);
            }
        });
    }
}
