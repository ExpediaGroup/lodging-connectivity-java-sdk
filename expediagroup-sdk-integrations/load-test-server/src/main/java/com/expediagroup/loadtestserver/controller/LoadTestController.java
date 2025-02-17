package com.expediagroup.loadtestserver.controller;

import com.expediagroup.sdk.graphql.exemplar.ExemplarGraphQLClient;
import com.expediagroup.sdk.graphql.model.RawResponse;
import com.expediagroup.sdk.rapid.client.RapidClient;
import com.expediagroup.sdk.rapid.models.PropertyContent;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testservice.TestQuery;

@RestController
@RequestMapping("/load-test")
@RequiredArgsConstructor
public class LoadTestController {

    private final ExemplarGraphQLClient exemplarGraphQLClient = new ExemplarGraphQLClient();

    @GetMapping("/graphql/small/500ms-delay")
    public String hello() throws InterruptedException {
        Thread.sleep(500);
//        TestQuery query = new TestQuery();
//        RawResponse<TestQuery.Data> response = exemplarGraphQLClient.execute(query);
        return "Hello";
    }

//    String endpoint = "http://localhost:8081/contentCalls";
//
//    RapidClient contentClient = RapidClient
//            .builder()
//            .requestTimeout(90_000) // 90 seconds
//            .connectionTimeout(30_000) // 30 seconds
//            .socketTimeout(30_000) // 30 seconds
//            .endpoint(endpoint)
//            .build();
//
//    @RequestMapping("/propertyContent")
//    public String makeContentCall() {
//
////        getPropertyContent(contentClient);
//
//        return "What wiremock came back with:  " + getPropertyContent(contentClient);
//    }

//    static String getPropertyContent(RapidClient client) {
//        Map<String, PropertyContent> propertyContentMap = client.getPropertyContent("en-US", "expedia", "", null, null, null, null,
//                null, null, null, null, null, "", "", "",
//                "", List.of("name"), null, List.of("11775754"));
//        //System.out.println(propertyContentMap);
//        return propertyContentMap.get("11775754").getName();
//    }
}
