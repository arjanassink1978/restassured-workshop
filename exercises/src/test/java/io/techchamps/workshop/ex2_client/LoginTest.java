package io.techchamps.workshop.ex2_client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 2 - an API client instead of repeated setup.
 * 1. Implement RequestSpecs.base()  (spec/RequestSpecs.java)
 * 2. Implement AuthClient.signIn(..) (client/AuthClient.java)
 * 3. Rewrite your login tests from exercise 1 with the client:
 *      new AuthClient().signIn("admin", "admin1234").then().statusCode(200).extract().as(JwtResponse.class)
 *    Check the DTO with AssertJ: assertThat(jwt.getToken()).isNotBlank()
 * 4. Prove it: change the port in config.properties and watch both tests fail. Change it back.
 */
public class LoginTest {

    @Test
    public void loginWithValidCredentials() {
        // TODO expect 200; JwtResponse: token not blank, type "Bearer", roles contain ROLE_USER and ROLE_ADMIN
        fail("TODO exercise 2a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO expect 401; extract ErrorResponse: error "authentication_error", message "Invalid username or password"
        fail("TODO exercise 2b");
    }
}
