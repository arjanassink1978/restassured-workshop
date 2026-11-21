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

    /** URI, port, base path and content type from config.properties. Logs request and response only when a check fails. */
    public static RequestSpecification base() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigProperties.getProperty("baseUri"))
                .setPort(ConfigProperties.getIntProperty("port"))
                .setBasePath(ConfigProperties.getProperty("basePath"))
                .setContentType(ContentType.JSON)
                .setConfig(RestAssuredConfig.config()
                        .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build();
    }

    /** Base specification plus a JWT in the Authorization header. */
    public static RequestSpecification bearer(String token) {
        return new RequestSpecBuilder()
                .addRequestSpecification(base())
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
