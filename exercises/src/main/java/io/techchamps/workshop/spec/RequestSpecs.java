package io.techchamps.workshop.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.techchamps.workshop.config.ConfigProperties;

public final class RequestSpecs {

    private RequestSpecs() {
    }

    /**
     * Exercise 2: the shared part of every request.
     * Use RequestSpecBuilder with baseUri, port and basePath from ConfigProperties (see config.properties),
     * content type JSON, and logging only when a check fails:
     * .setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
     */
    public static RequestSpecification base() {
        throw new AssertionError("TODO exercise 2");
    }

    /** Base specification plus a JWT in the Authorization header. */
    public static RequestSpecification bearer(String token) {
        return new RequestSpecBuilder()
                .addRequestSpecification(base())
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
