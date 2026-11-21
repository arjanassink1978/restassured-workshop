package io.techchamps.workshop.client;

import generated.dtos.JwtResponse;
import generated.dtos.LoginRequest;
import generated.dtos.SignUpRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.techchamps.workshop.spec.RequestSpecs;

import static io.restassured.RestAssured.given;

/** Knows the /auth endpoints. Tests never write paths or specs themselves. */
public class AuthClient {

    private final RequestSpecification spec = RequestSpecs.base();

    public Response signIn(String username, String password) {
        LoginRequest request = new LoginRequest();
        request.setUsername(username);
        request.setPassword(password);
        return given().spec(spec).body(request)
                .when().post("/auth/signin");
    }

    /** Signs in and returns the response as DTO. Fails when the credentials are wrong. */
    public JwtResponse login(String username, String password) {
        return signIn(username, password)
                .then().statusCode(200)
                .extract().as(JwtResponse.class);
    }

    public Response signUp(SignUpRequest request) {
        return given().spec(spec).body(request)
                .when().post("/auth/signup");
    }
}
