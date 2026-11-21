package io.techchamps.workshop.ex1_basics;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 1 - your first REST-Assured tests (verbose on purpose).
 * Keep the backend running (see README) and check the API in Swagger first:
 * <a href="http://localhost:8085/swagger-ui/index.html">Swagger UI</a>
 *
 * Required: 1a. Do 1b and 1c if you are fast.
 */
public class BasicLoginTest {

    @Test
    public void loginWithValidCredentials() {
        given()
                .log().all().
                baseUri("http://localhost").
                port(8085).basePath("/api")
                .header("Content-type", "application/json")
                .body("""
                        {
                          "username": "admin",
                          "password": "admin1234"
                        }""")
                    .when().post("/auth/signin").then().log().all().statusCode(200).
                body("token", notNullValue()).
                body("type", equalTo("Bearer")).
                body("roles", hasItems("ROLE_USER", "ROLE_ADMIN"));
        // TODO POST /api/auth/signin with admin / admin1234
        //      Expect: status 200, body "token" is not null, "type" equals "Bearer",
        //              "roles" has items ROLE_USER and ROLE_ADMIN
        //      Hint: given().log().all().baseUri(..).port(..).basePath(..).header(..).body(..)
        //            .when().post(..).then().log().all().statusCode(..).body(..)
        fail("TODO exercise 1a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // OPTIONAL if you are fast (you write this one again in exercise 2)
        // TODO POST /api/auth/signin with an unknown user
        //      Expect: status 401, "error" equals "authentication_error",
        //              "message" equals "Invalid username or password"
        fail("TODO exercise 1b");
    }

    @Test
    public void loginWithoutPasswordIsABadRequest() {
        // TODO (bonus) send only a username. Which status code do you expect? Check Swagger, then try it.
        fail("TODO exercise 1c (bonus)");
    }
}
