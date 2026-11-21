package io.techchamps.workshop.ex2_spec;

import io.techchamps.workshop.spec.RequestSpecs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/** Exercise 2: the same login tests as exercise 1, but the shared setup comes from one request specification. */
public class SpecLoginTest {

    @Test
    public void loginWithValidCredentials() {
        given().spec(RequestSpecs.base())
                .body("""
                        { "username": "admin", "password": "admin1234" }""")
        .when()
                .post("/auth/signin")
        .then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("type", equalTo("Bearer"))
                .body("roles", hasItems("ROLE_USER", "ROLE_ADMIN"));
    }

    @Test
    public void loginWithInvalidCredentials() {
        given().spec(RequestSpecs.base())
                .body("""
                        { "username": "dontExist", "password": "wrong1234" }""")
        .when()
                .post("/auth/signin")
        .then()
                .statusCode(401)
                .body("error", equalTo("authentication_error"))
                .body("message", equalTo("Invalid username or password"));
    }
}
