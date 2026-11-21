package io.techchamps.workshop.ex5_dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 5 - builders and test data.
 * The DTOs (package generated.dtos) are generated from the backend's OpenAPI spec and used everywhere already.
 *
 * 1. Create UserRequestBuilder in package builders (look at the given SignUpRequestBuilder).
 *    Valid by default, unique username and email per run (hint: UUID), withX() methods to override,
 *    default profile: new ProfileRequestBuilder().build(), default role: a RoleRequest named "USER".
 *    SignUpRequestBuilder, ProfileRequestBuilder and AddressRequestBuilder are given.
 * 2. Implement the tests below with builders, clients and AssertJ.
 * 3. Clean up every user a test creates in @AfterEach.
 */
public class UserDtoTest {

    @AfterEach
    void cleanUp() {
        // TODO delete the users created in the test
    }

    @Test
    public void signUpWithBuilderIsRepeatable() {
        // TODO sign up, expect 200, SignupResponse username equals the requested username
        fail("TODO exercise 5a");
    }

    @Test
    public void signUpWithTakenUsernameIsRejected() {
        // TODO username "admin" is taken. Expect 400 and ErrorResponse message "Username is already taken"
        fail("TODO exercise 5b");
    }

    @Test
    public void addUserWithProfile() {
        // TODO UserClient.asUser().create(..) expect 201, UserResponse has an id and one address
        fail("TODO exercise 5c");
    }
}
