package io.techchamps.workshop.ex4_chaining;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 4 - Request chaining. One test, four calls:
 *   1. POST   /api/auth/signup              (create a user with a unique username)
 *   2. GET    /api/users/username/{username} (needs a token; extract the generated "id")
 *   3. DELETE /api/users/{id}                (use the extracted id)
 *   4. GET    /api/users/{id}                (expect 404 "user_not_found")
 *
 * Hints: .extract().path("id")  and  .get("/users/{id}", id)
 * Make sure the test can be run twice in a row. How?
 */
public class RequestChainingTest {

    @Test
    public void signUpGetAndDeleteUser() {
        // TODO
        fail("TODO exercise 4");
    }
}
