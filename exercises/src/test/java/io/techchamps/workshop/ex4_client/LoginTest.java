package io.techchamps.workshop.ex4_client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 4 - an API client: tests say what to check, the client knows how to call.
 *
 * 1. Implement AuthClient.signIn(..) (client/AuthClient.java): fill a LoginRequest, send it with the spec, return the Response.
 *    Do not assert in the client: the test decides what to check.
 * 2. Rewrite the two login tests below with the client:
 *      new AuthClient().signIn("admin", "admin1234").then().statusCode(200).extract().as(JwtResponse.class)
 *    No given() in the test any more.
 * 3. Prove it: change the port in config.properties, both tests must fail. Change it back.
 */
public class LoginTest {

    @Test
    public void loginWithValidCredentials() {
        // TODO JwtResponse: token not blank, type "Bearer", roles contain ROLE_USER and ROLE_ADMIN
        fail("TODO exercise 4a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO 401; ErrorResponse: error "authentication_error", message "Invalid username or password"
        fail("TODO exercise 4b");
    }
}
