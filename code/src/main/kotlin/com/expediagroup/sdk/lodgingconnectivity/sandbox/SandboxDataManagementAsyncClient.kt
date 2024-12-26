package com.expediagroup.sdk.lodgingconnectivity.sandbox

import com.expediagroup.sdk.graphql.common.AsyncGraphQLExecutor
import com.expediagroup.sdk.lodgingconnectivity.common.AsyncGraphQLClient
import com.expediagroup.sdk.lodgingconnectivity.common.AsyncRequestExecutor
import com.expediagroup.sdk.lodgingconnectivity.configuration.ClientConfiguration
import com.expediagroup.sdk.lodgingconnectivity.configuration.EndpointProvider
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CancelReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.ChangeReservationStayDatesInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.CreateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeletePropertyReservationsInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.DeleteReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdatePropertyInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.operation.type.UpdateReservationInput
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.CreateSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.DeleteSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.GetSandboxPropertiesResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.GetSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.UpdateSandboxPropertyResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.createSandboxPropertyOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.deleteSandboxPropertyOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertiesOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.getSandboxPropertyOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.operation.updateSandboxPropertyOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.property.paginator.SandboxPropertiesAsyncPaginator
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CancelSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.ChangeSandboxReservationStayDatesResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.CreateSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.DeleteSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.DeleteSandboxReservationsResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.GetSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.GetSandboxReservationsResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.UpdateSandboxReservationResponse
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.cancelSandboxReservationOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.changeSandboxReservationStayDatesOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.createSandboxReservationOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.deleteSandboxReservationOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.deleteSandboxReservationsOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.getSandboxReservationOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.getSandboxReservationsOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.operation.updateSandboxReservationOperationAsync
import com.expediagroup.sdk.lodgingconnectivity.sandbox.reservation.paginator.SandboxReservationsAsyncPaginator
import java.util.concurrent.CompletableFuture

class SandboxDataManagementAsyncClient(configuration: ClientConfiguration) : AsyncGraphQLClient() {
    override val apiEndpoint = EndpointProvider.getSandboxApiEndpoint(configuration.environment)

    override val asyncGraphQLExecutor = AsyncGraphQLExecutor(
        serverUrl = apiEndpoint.endpoint,
        asyncRequestExecutor = AsyncRequestExecutor(
            configuration = configuration,
            apiEndpoint = apiEndpoint
        )
    )

    fun getProperties(): CompletableFuture<GetSandboxPropertiesResponse> = run {
        getSandboxPropertiesOperationAsync(asyncGraphQLExecutor)
    }

    @JvmOverloads
    fun getPropertiesPaginator(pageSize: Int, initialCursor: String? = null): SandboxPropertiesAsyncPaginator = run {
        SandboxPropertiesAsyncPaginator(asyncGraphQLExecutor, pageSize, initialCursor)
    }

    fun getReservations(propertyId: String): CompletableFuture<GetSandboxReservationsResponse> = run {
        getSandboxReservationsOperationAsync(asyncGraphQLExecutor, propertyId)
    }

    @JvmOverloads
    fun getReservationsPaginator(
        propertyId: String,
        pageSize: Int,
        initialCursor: String? = null
    ): SandboxReservationsAsyncPaginator = run {
        SandboxReservationsAsyncPaginator(asyncGraphQLExecutor, propertyId, pageSize, initialCursor)
    }

    fun getProperty(propertyId: String): CompletableFuture<GetSandboxPropertyResponse> = run {
        getSandboxPropertyOperationAsync(asyncGraphQLExecutor, propertyId)
    }

    fun getReservation(reservationId: String): CompletableFuture<GetSandboxReservationResponse> = run {
        getSandboxReservationOperationAsync(asyncGraphQLExecutor, reservationId)
    }

    fun createProperty(): CompletableFuture<CreateSandboxPropertyResponse> = run {
        createSandboxPropertyOperationAsync(asyncGraphQLExecutor, CreatePropertyInput())
    }

    fun createProperty(input: CreatePropertyInput): CompletableFuture<CreateSandboxPropertyResponse> = run {
        createSandboxPropertyOperationAsync(asyncGraphQLExecutor, input)
    }

    fun updateProperty(input: UpdatePropertyInput): CompletableFuture<UpdateSandboxPropertyResponse> = run {
        updateSandboxPropertyOperationAsync(asyncGraphQLExecutor, input)
    }

    fun deleteProperty(propertyId: String): CompletableFuture<DeleteSandboxPropertyResponse> = run {
        deleteSandboxPropertyOperationAsync(asyncGraphQLExecutor, DeletePropertyInput(id = propertyId))
    }

    fun createReservation(propertyId: String): CompletableFuture<CreateSandboxReservationResponse> = run {
        createSandboxReservationOperationAsync(asyncGraphQLExecutor, CreateReservationInput(propertyId = propertyId))
    }

    fun createReservation(input: CreateReservationInput): CompletableFuture<CreateSandboxReservationResponse> = run {
        createSandboxReservationOperationAsync(asyncGraphQLExecutor, input)
    }

    fun updateReservation(input: UpdateReservationInput): CompletableFuture<UpdateSandboxReservationResponse> = run {
        updateSandboxReservationOperationAsync(asyncGraphQLExecutor, input)
    }

    fun changeReservationStayDates(
        input: ChangeReservationStayDatesInput
    ): CompletableFuture<ChangeSandboxReservationStayDatesResponse> = run {
        changeSandboxReservationStayDatesOperationAsync(asyncGraphQLExecutor, input)
    }

    fun cancelReservation(reservationId: String): CompletableFuture<CancelSandboxReservationResponse> = run {
        cancelSandboxReservationOperationAsync(asyncGraphQLExecutor, CancelReservationInput(id = reservationId))
    }

    fun cancelReservation(input: CancelReservationInput): CompletableFuture<CancelSandboxReservationResponse> = run {
        cancelSandboxReservationOperationAsync(asyncGraphQLExecutor, input)
    }

    fun deleteReservation(reservationId: String): CompletableFuture<DeleteSandboxReservationResponse> = run {
        deleteSandboxReservationOperationAsync(asyncGraphQLExecutor, DeleteReservationInput(id = reservationId))
    }

    fun deleteReservation(
        input: DeleteReservationInput
    ): CompletableFuture<DeleteSandboxReservationResponse> = run {
        deleteSandboxReservationOperationAsync(asyncGraphQLExecutor, input)
    }

    fun deleteReservations(propertyId: String): CompletableFuture<DeleteSandboxReservationsResponse> = run {
        deleteSandboxReservationsOperationAsync(
            asyncGraphQLExecutor,
            DeletePropertyReservationsInput(propertyId = propertyId)
        )
    }

    fun deleteReservations(
        input: DeletePropertyReservationsInput
    ): CompletableFuture<DeleteSandboxReservationsResponse> = run {
        deleteSandboxReservationsOperationAsync(asyncGraphQLExecutor, input)
    }
}
