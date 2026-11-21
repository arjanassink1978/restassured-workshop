package io.techchamps.workshop.ex2_client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 2 - an API client instead of repeated setup. Work in three steps and run after each.
 *
 * Step 1 (spec):   implement RequestSpecs.base()   (spec/RequestSpecs.java)
 *                  check: SpecSmokeTest is green
 * Step 2 (client): implement AuthClient.signIn(..) (client/AuthClient.java), then write the valid-login test below
 *                    new AuthClient().signIn("admin", "admin1234").then().statusCode(200).extract().as(JwtResponse.class)
 *                  check: loginWithValidCredentials is green
 * Step 3 (proof):  write the invalid-login test, then change the port in config.properties:
 *                  both tests must fail. Change it back.
 *
 * Check content with AssertJ: assertThat(jwt.getToken()).isNotBlank()
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
