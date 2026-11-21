package io.techchamps.workshop.ex1_basics;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 1 - your first REST-Assured test. This is how a first test often looks: everything is in the test.
 * Keep the backend running (see README) and check the API in Swagger first:
 * <a href="http://localhost:8085/swagger-ui/index.html">Swagger UI</a>
 *
 * 1. Read loginWithValidCredentials below (given) and run it. Look at the log of the request and the response.
 * 2. Try it yourself: write loginWithInvalidCredentials in the same style.
 * 3. Bonus: loginWithoutPasswordIsABadRequest. Which status do you expect? Check Swagger, then try it.
 */
public class BasicLoginTest {

    @Test
    public void loginWithValidCredentials() {
        given()
                .log().all() // log request
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
                .log().all() // log response
                .statusCode(200)
                .body("token", notNullValue())
                .body("type", equalTo("Bearer"))
                .body("roles", hasItems("ROLE_USER", "ROLE_ADMIN"));
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO POST /api/auth/signin with an unknown user, for example dontExist / wrong1234
        //      Expect: status 401, "error" equals "authentication_error",
        //              "message" equals "Invalid username or password"
        fail("TODO exercise 1");
    }

    @Test
    public void loginWithoutPasswordIsABadRequest() {
        // TODO (bonus) send only a username. Which status do you expect?
        fail("TODO exercise 1 (bonus)");
    }
}
