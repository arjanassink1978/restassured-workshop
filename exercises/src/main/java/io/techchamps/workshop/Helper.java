package io.techchamps.workshop;

import io.restassured.specification.RequestSpecification;

/**
 * Shared test helpers: you build this up during the workshop.
 * The method signatures are given, the bodies are yours.
 *
 * Exercise 2: requestSpec()          - RequestSpecBuilder: baseUri, port, basePath, content type, log
 * Exercise 3: getToken(...)          - sign in, return the JWT
 *             authenticatedSpec(...) - requestSpec + header "Authorization: Bearer <token>"
 *             adminSpec(), userSpec()
 * Exercise 5: read baseUri, port, ... from ConfigProperties instead of hardcoding them
 */
public class Helper {

    private Helper() {
    }

    public static RequestSpecification requestSpec() {
        throw new UnsupportedOperationException("TODO exercise 2");
    }

    public static String getToken(String username, String password) {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    public static RequestSpecification authenticatedSpec(String token) {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    public static RequestSpecification adminSpec() {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    public static RequestSpecification userSpec() {
        throw new UnsupportedOperationException("TODO exercise 3");
    }
}
