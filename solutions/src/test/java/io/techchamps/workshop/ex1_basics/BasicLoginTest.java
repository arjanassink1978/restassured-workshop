package io.techchamps.workshop.ex1_basics;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/** Exercise 1: verbose tests. Everything is in the test on purpose. */
public class BasicLoginTest {

    @Test
    public void loginWithValidCredentials() {
        given()
                .log().all()
                .baseUri("http://localhost")
                .port(8085)
                .basePath("/api")
                .header("Content-type", "application/json")
                .body("""
                        {
                          "username": "admin",
                          "password": "admin1234"
                        }""")
        .when()
                .post("/auth/signin")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", notNullValue())
                .body("type", equalTo("Bearer"))
                .body("roles", hasItems("ROLE_USER", "ROLE_ADMIN"));
    }

    @Test
    public void loginWithInvalidCredentials() {
        given()
                .log().all()
                .baseUri("http://localhost")
                .port(8085)
                .basePath("/api")
                .header("Content-type", "application/json")
                .body("""
                        {
                          "username": "dontExist",
                          "password": "wrong1234"
                        }""")
        .when()
                .post("/auth/signin")
        .then()
                .log().all()
                .statusCode(401)
                .body("error", equalTo("authentication_error"))
                .body("message", equalTo("Invalid username or password"));
    }

    @Test
    public void loginWithoutPasswordIsABadRequest() {
        given()
                .log().all()
                .baseUri("http://localhost")
                .port(8085)
                .basePath("/api")
                .header("Content-type", "application/json")
                .body("""
                        {
                          "username": "admin"
                        }""")
        .when()
                .post("/auth/signin")
        .then()
                .log().all()
                .statusCode(400);
    }
}
