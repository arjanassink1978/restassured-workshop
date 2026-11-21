package io.techchamps.workshop.ex2_dry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 2 - Don't Repeat Yourself.
 * 1. Open Helper.java and implement requestSpec()
 *    (RequestSpecBuilder: baseUri, port, basePath, contentType JSON, log all)
 * 2. Copy your two tests from exercise 1 into this class and replace the repeated
 *    setup with .spec(Helper.requestSpec())
 */
public class LoginTest {

    @Test
    public void loginWithValidCredentials() {
        // TODO
        fail("TODO exercise 2a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO
        fail("TODO exercise 2b");
    }
}
