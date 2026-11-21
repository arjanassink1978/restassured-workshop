package io.techchamps.workshop.ex2_dry;

import io.techchamps.workshop.Helper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/** Exercise 2: same tests as exercise 1, but DRY thanks to the shared request specification. */
public class LoginTest {

    @Test
    public void loginWithValidCredentials() {
        given()
                .spec(Helper.requestSpec())
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
                .spec(Helper.requestSpec())
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
}
