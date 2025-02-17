package com.expediagroup.sdk.simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class BasicSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8080");

    private final ScenarioBuilder scn = scenario("Basic Simulation")
            .exec(http("GET Root").get("/load-test/graphql/small/500ms-delay").check(status().is(200)));

    private final ScenarioBuilder warmupScenario = scenario("Warmup")
            .exec(http("Warmup Request").get("/load-test/graphql/small/500ms-delay"));

    {
        setUp(
//                warmupScenario.injectOpen(rampUsers(50).during(30))
                scn.injectOpen(constantUsersPerSec(750).during(60))
        ).protocols(httpProtocol);
    }
}