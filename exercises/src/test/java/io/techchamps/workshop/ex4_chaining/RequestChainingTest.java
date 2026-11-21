package io.techchamps.workshop.ex4_chaining;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 4 - request chaining and cleanup. One test, four calls:
 *   1. AuthClient.signUp(..)                  (SignUpRequestBuilder is given: unique username per run)
 *   2. UserClient.asUser().getByUsername(..)  (extract the generated id)
 *   3. UserClient.asUser().delete(id)
 *   4. UserClient.asUser().getById(id)        (expect 404)
 *
 * The test must clean up after itself, also when it fails halfway: use @AfterEach with
 * UserClient.asAdmin().deleteByUsername(username)  (given: it does nothing when the user is already gone).
 * Run the test twice in a row. It must stay green.
 */
public class RequestChainingTest {

    @AfterEach
    void cleanUp() {
        // TODO delete the user this test created
    }

    @Test
    public void signUpGetAndDeleteUser() {
        // TODO
        fail("TODO exercise 4");
    }
}
