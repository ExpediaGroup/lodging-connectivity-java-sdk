package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MediaTypeJavaTest {
    @Test
    @DisplayName("should be able to access of() static method with type and subtype as params")
    public void of_static_method_should_be_callable_with_type_and_subtype_only() {
        MediaType.of("application", "json");
    }

    @Test
    @DisplayName("should be able to access of() static method with typ, subtype, parameters map as params")
    public void of_static_method_should_be_callable_with_parameters_map() {
        MediaType.of("application", "json", new HashMap<>());
    }

    @Test
    @DisplayName("should be able to access of() static method with typ, subtype, parameters map as params")
    public void parse_static_method_should_be_accessible() {
        MediaType.parse("application/json; charset=utf-8");
    }
}
