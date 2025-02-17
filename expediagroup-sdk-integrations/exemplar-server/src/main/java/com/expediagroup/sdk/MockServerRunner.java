package com.expediagroup.sdk;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class MockServerRunner {

    public static void main(String[] args) {
        WireMockConfiguration wmConfig = options()
                .port(8081)
                .templatingEnabled(false)
                .disableRequestJournal()
                .maxRequestJournalEntries(0)
                .jettyAcceptors(100)
                .containerThreads(1000)
                .asynchronousResponseEnabled(true)
                .asynchronousResponseThreads(1000)
                .usingFilesUnderDirectory("expediagroup-sdk-integrations/exemplar-server/src/main/resources/wiremock");

        WireMockServer wireMockServer = new WireMockServer(wmConfig);

        wireMockServer.start();
    }
}
