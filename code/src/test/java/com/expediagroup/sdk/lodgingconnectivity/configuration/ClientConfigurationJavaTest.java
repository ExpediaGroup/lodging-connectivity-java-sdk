package com.expediagroup.sdk.lodgingconnectivity.configuration;

import com.expediagroup.sdk.core.client.Transport;
import com.expediagroup.sdk.core.http.Request;
import com.expediagroup.sdk.core.http.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientConfigurationJavaTest {

    @Test
    @DisplayName("should be able to access the default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() {
        ClientConfiguration.builder()
                .key("test-key")
                .secret("test-secret")
                .connectTimeout(1000)
                .build();
    }

    @Test
    @DisplayName("should be able to access builder static method with custom transport")
    public void builderWithTransportIsAccessibleFromJava() {
        Transport transport = new Transport() {
            @NotNull
            @Override
            public Response execute(@NotNull Request request) {
                return Response.builder().build();
            }

            @Override
            public void dispose() {
            }
        };

        ClientConfiguration.builder(transport)
                .key("test-key")
                .secret("test-secret")
                .build();
    }
}
