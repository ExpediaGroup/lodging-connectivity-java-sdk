package com.expediagroup.sdk.core.okhttp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OkHttpClientFeatureJavaTest {
    @Test
    @DisplayName("should access default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() {
        OkHttpClientConfiguration.builder().connectTimeout(1000).build();
    }
}
