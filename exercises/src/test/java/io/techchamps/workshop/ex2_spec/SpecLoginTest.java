package io.techchamps.workshop.ex2_spec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 2 - one request specification instead of repeated setup.
 *
 * 1. Implement RequestSpecs.base() (spec/RequestSpecs.java): base URI, port and base path from ConfigProperties
 *    (see config.properties), content type JSON, and logging only when a check fails (the comment shows how).
 *    Check: SpecSmokeTest (given) is green.
 * 2. Rewrite your login tests from exercise 1 below: start with given().spec(RequestSpecs.base()).
 *    The body is still a JSON string, the checks are still Hamcrest .body(..). Only the setup moves.
 * 3. Prove it: change the port in config.properties and watch both tests fail. Change it back.
 */
public class SpecLoginTest {

    @Test
    public void loginWithValidCredentials() {
        // TODO 200, token not null, type "Bearer", roles ROLE_USER and ROLE_ADMIN
        fail("TODO exercise 2a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO 401, error "authentication_error", message "Invalid username or password"
        fail("TODO exercise 2b");
    }
}
