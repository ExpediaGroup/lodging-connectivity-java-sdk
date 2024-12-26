package com.expediagroup.sdk.lodgingconnectivity;

import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration;
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientEnvironment;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.SandboxDataManagementAsyncClient;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.fragment.SandboxReservationData;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput;
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.DeleteSandboxPropertyResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SandboxDataManagementAsyncClientExample {
    private static final Logger logger = LoggerFactory.getLogger(SandboxDataManagementAsyncClientExample.class);

    private static final SandboxDataManagementAsyncClient client = new SandboxDataManagementAsyncClient(
            ClientConfiguration
                    .builder()
                    .environment(ClientEnvironment.SANDBOX_TEST)
                    .build()
    );

    private static final String PROPERTY_NAME = "Lodging SDK Test Property";
    private static final String UPDATED_PROPERTY_NAME = "New Lodging SDK Test Property";

    public static void main(String[] args) {

        // In a real application, you might keep references to IDs in local variables.
        // Here, we’ll use AtomicReferences so we can capture them inside lambdas:
        final AtomicReference<String> propertyIdRef = new AtomicReference<>();
        final AtomicReference<String> reservationIdRef = new AtomicReference<>();

        // 1) Delete any old property with the same names
        deletePropertyIfExists()

                // 2) Create Property
                .thenCompose(v -> {
                    CreatePropertyInput createPropertyInput = CreatePropertyInput.builder()
                            .name(PROPERTY_NAME)
                            .build();

                    return client.createProperty(createPropertyInput);
                })

                // 3) Update reference & log property creation, then update property
                .thenCompose(createPropertyResponse -> {
                    String propertyId = createPropertyResponse.getData().getId();
                    propertyIdRef.set(propertyId);
                    logger.info("Property Created: [{}]", propertyId);

                    UpdatePropertyInput updatePropertyInput = UpdatePropertyInput.builder()
                            .id(propertyId)
                            .name(UPDATED_PROPERTY_NAME)
                            .build();

                    return client.updateProperty(updatePropertyInput);
                })

                // 4) Log property update, then create reservation
                .thenCompose(updatePropertyResponse -> {
                    logger.info("Property Updated: [{}]", updatePropertyResponse.getData().getId());

                    CreateReservationInput createReservationInput = CreateReservationInput.builder()
                            .propertyId(propertyIdRef.get())
                            .childCount(4)
                            .adultCount(2)
                            .build();

                    return client.createReservation(createReservationInput);
                })

                // 5) Update reference & log reservation creation, then update reservation
                .thenCompose(createReservationResponse -> {
                    SandboxReservationData reservationData = createReservationResponse.getData();
                    reservationIdRef.set(reservationData.getId());
                    logger.info("Reservation Created: [{}]", reservationData.getId());

                    UpdateReservationInput updateReservationInput = UpdateReservationInput.builder()
                            .id(reservationData.getId())
                            .childAges(Arrays.asList(3, 5, 7))
                            .build();

                    return client.updateReservation(updateReservationInput);
                })

                // 6) Log reservation update, then change reservation stay dates
                .thenCompose(updateReservationResponse -> {
                    SandboxReservationData reservationData = updateReservationResponse.getData();
                    logger.info("Reservation Updated: [{}]", reservationData.getId());

                    ChangeReservationStayDatesInput changeReservationStayDatesInput = ChangeReservationStayDatesInput.builder()
                            .id(reservationData.getId())
                            .checkInDate(LocalDate.of(2024, 6, 5))
                            .checkOutDate(LocalDate.of(2024, 6, 10))
                            .build();

                    return client.changeReservationStayDates(changeReservationStayDatesInput);
                })

                // 7) Log stay date change, then cancel reservation
                .thenCompose(changeStayDatesResponse -> {
                    SandboxReservationData reservationData = changeStayDatesResponse.getData();
                    logger.info("Reservation Stay Dates Updated: [{}]", reservationData.getId());

                    return client.cancelReservation(reservationData.getId());
                })

                // 8) Log cancellation, then delete reservation
                .thenCompose(cancelReservationResponse -> {
                    SandboxReservationData reservationData = cancelReservationResponse.getData();
                    logger.info("Reservation Was Canceled: [{}]", reservationData.getId());

                    return client.deleteReservation(reservationData.getId());
                })

                // 9) Log deletion of reservation, then delete property
                .thenCompose(deleteReservationResponse -> {
                    logger.info("Reservation Was Deleted: [{}]", reservationIdRef.get());
                    return client.deleteProperty(propertyIdRef.get());
                })

                // 10) Log property deletion and dispose client
                .thenRun(() -> {
                    logger.info("Property Was Deleted: [{}]", propertyIdRef.get());
                    logger.info("Completed, disposing the client...");
                    client.dispose();
                })
                .join();
    }

    /**
     * Deletes any property if its name equals PROPERTY_NAME or UPDATED_PROPERTY_NAME.
     * Uses async methods and returns a CompletableFuture<Void>.
     */
    private static CompletableFuture<Void> deletePropertyIfExists() {
        return client.getProperties()  // returns CompletableFuture<GetSandboxPropertiesResponse>
                .thenCompose(propertiesResponse -> {
                    // Collect all future deletions into a list
                    List<CompletableFuture<DeleteSandboxPropertyResponse>> deletions = new ArrayList<>();

                    propertiesResponse.getData().forEach(property -> {
                        if (PROPERTY_NAME.equals(property.getName()) || UPDATED_PROPERTY_NAME.equals(property.getName())) {
                            logger.info("Deleting existing property: ID: [{}], Name: [{}]", property.getId(), property.getName());
                            // queue up a deletion
                            deletions.add(client.deleteProperty(property.getId()));
                        }
                    });

                    // Combine all deletions into a single CompletableFuture<Void>
                    return CompletableFuture.allOf(deletions.toArray(new CompletableFuture[0]));
                });
    }
}
