package io.techchamps.workshop.ex3_auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 3 - Authentication and authorisation.
 * GET /api/users needs a JWT and the ADMIN role.
 *
 * 1. In Helper implement getToken(username, password): sign in and extract the "token" from the response
 * 2. In Helper implement authenticatedSpec(token): requestSpec + header "Authorization: Bearer <token>"
 * 3. In Helper implement adminSpec() and userSpec() (credentials: see config.properties)
 * 4. Implement the tests below
 */
public class GetAllUsersTest {

    @Test
    public void adminCanGetAllUsers() {
        // TODO expect 200 and usernames admin, user, moderator in the list
        fail("TODO exercise 3a");
    }

    @Test
    public void userIsForbiddenToGetAllUsers() {
        // TODO expect 403
        fail("TODO exercise 3b");
    }

    @Test
    public void anonymousIsUnauthorized() {
        // TODO expect 401
        fail("TODO exercise 3c");
    }
}
