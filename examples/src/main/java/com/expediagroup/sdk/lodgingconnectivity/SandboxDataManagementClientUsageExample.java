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
import com.expediagroup.sdk.lodgingconnectivity.sandbox.SandboxDataManagementClient;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.CreateSandboxPropertyResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.DeleteSandboxPropertyResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.GetSandboxPropertiesResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.UpdateSandboxPropertyResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CancelSandboxReservationResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.ChangeSandboxReservationStayDatesResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CreateSandboxReservationResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.DeleteSandboxReservationResponse;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.UpdateSandboxReservationResponse;

import java.time.LocalDate;
import java.util.Arrays;

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
                .name(PROPERTY_NAME)
                .build();

        CreateSandboxPropertyResponse createPropertyResponse = client.createProperty(createPropertyInput);

        String propertyId = createPropertyResponse.getData().getId();

        System.out.println("Property Created: " + propertyId);
        System.out.println(createPropertyResponse);


        // ******* Update Property Name *******
        UpdatePropertyInput updatePropertyInput = UpdatePropertyInput
                .builder()
                .id(propertyId)
                .name(UPDATED_PROPERTY_NAME)
                .build();

        UpdateSandboxPropertyResponse updatePropertyResponse = client.updateProperty(updatePropertyInput);

        System.out.println("Property Updated: " + propertyId);
        System.out.println(updatePropertyResponse);


        // ******* Create Reservation *******
        CreateReservationInput createReservationInput = CreateReservationInput
                .builder()
                .propertyId(propertyId)
                .childCount(4)
                .adultCount(2)
                .build();

        CreateSandboxReservationResponse createReservationResponse = client.createReservation(createReservationInput);

        SandboxReservationData reservationData = createReservationResponse.getData();

        System.out.println("Reservation Created: " + reservationData.getId());
        System.out.println(createReservationResponse);


        // ******* Update Reservation *******
        UpdateReservationInput updateReservationInput = UpdateReservationInput
                .builder()
                .id(reservationData.getId())
                .childAges(Arrays.asList(3, 5, 7))
                .build();

        UpdateSandboxReservationResponse updateReservationResponse = client.updateReservation(updateReservationInput);

        reservationData = updateReservationResponse.getData();

        System.out.println("Reservation Updated: " + reservationData.getId());
        System.out.println(updateReservationResponse);


        // ******* Update Reservation Stay Dates *******
        ChangeReservationStayDatesInput changeReservationStayDatesInput = ChangeReservationStayDatesInput
                .builder()
                .id(reservationData.getId())
                .checkInDate(LocalDate.of(2024, 6, 5))
                .checkOutDate(LocalDate.of(2024, 6, 10))
                .build();

        ChangeSandboxReservationStayDatesResponse changeStayDatesResponse = client.changeReservationStayDates(changeReservationStayDatesInput);

        reservationData = changeStayDatesResponse.getData();

        System.out.println("Reservation Stay Dates Updated: " + reservationData.getId());
        System.out.println(changeStayDatesResponse);

        // ******* Cancel Reservation *******
        CancelSandboxReservationResponse cancelReservationResponse = client.cancelReservation(reservationData.getId());

        reservationData = cancelReservationResponse.getData();

        System.out.println("Reservation Was Canceled: " + reservationData.getId());
        System.out.println(cancelReservationResponse);


        // ******* Delete Reservation *******
        DeleteSandboxReservationResponse deleteReservationResponse = client.deleteReservation(reservationData.getId());

        System.out.println("Reservation Was Deleted: " + reservationData.getId());
        System.out.println(deleteReservationResponse);


        // ******* Delete Property *******
        DeleteSandboxPropertyResponse deletePropertyResponse = client.deleteProperty(propertyId);

        System.out.println("Property Was Deleted: " + propertyId);
        System.out.println(deletePropertyResponse);

        System.exit(0);
    }

    private static void deletePropertyIfExists() {
        GetSandboxPropertiesResponse propertiesResponse = client.getProperties();

        propertiesResponse.getData().forEach(property -> {
            if (property.getName().equals(PROPERTY_NAME) || property.getName().equals(UPDATED_PROPERTY_NAME)) {
                System.out.println("Deleting existing property: ID: " + property.getId() + ", Name: " + property.getName());
                client.deleteProperty(property.getId());
            }
        });
    }
}
