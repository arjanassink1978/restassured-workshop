package io.techchamps.workshop.ex5_auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 5 - authentication and roles.
 * GET /api/users needs a JWT and the ADMIN role. TokenProvider (given) signs in once per user and caches the token.
 *
 * 1. In UserClient implement asAdmin(), asUser(), anonymous() and getAll()
 *    (hint: new UserClient(RequestSpecs.bearer(TokenProvider.admin())))
 * 2. Implement the tests below. Check the status with REST-Assured, the content with AssertJ.
 */
public class GetAllUsersTest {

    @Test
    public void adminCanGetAllUsers() {
        // TODO expect 200 and usernames admin, user, moderator (extract(): UserResponse[].class)
        fail("TODO exercise 5a");
    }

    @Test
    public void userIsForbiddenToGetAllUsers() {
        // TODO expect 403
        fail("TODO exercise 5b");
    }

    @Test
    public void anonymousIsUnauthorized() {
        // TODO expect 401
        fail("TODO exercise 5c");
    }
}
