package io.techchamps.workshop;

import generated.dtos.JwtResponse;
import generated.dtos.LoginRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.techchamps.workshop.config.ConfigProperties;

import static io.restassured.RestAssured.given;

public class Helper {

    private Helper() {
    }

    /** Base request: URI, port, base path and content type come from config.properties. */
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigProperties.getProperty("baseUri"))
                .setPort(ConfigProperties.getIntProperty("port"))
                .setBasePath(ConfigProperties.getProperty("basePath"))
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    /** Request with a JWT in the Authorization header. */
    public static RequestSpecification authenticatedSpec(String token) {
        return new RequestSpecBuilder()
                .addRequestSpecification(requestSpec())
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    /** Sign in and return the JWT token. */
    public static String getToken(String username, String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);

        return given()
                .spec(requestSpec())
                .body(loginRequest)
                .when()
                .post("/auth/signin")
                .then()
                .statusCode(200)
                .extract().as(JwtResponse.class)
                .getToken();
    }

    public static RequestSpecification adminSpec() {
        return authenticatedSpec(getToken(
                ConfigProperties.getProperty("adminUsername"),
                ConfigProperties.getProperty("adminPassword")));
    }

    public static RequestSpecification userSpec() {
        return authenticatedSpec(getToken(
                ConfigProperties.getProperty("userUsername"),
                ConfigProperties.getProperty("userPassword")));
    }
}
