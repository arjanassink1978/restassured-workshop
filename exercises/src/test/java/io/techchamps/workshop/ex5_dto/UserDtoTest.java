package io.techchamps.workshop.ex5_dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 5 - DTOs, builders and property files.
 *
 * The DTOs in package generated.dtos are generated from the backend's OpenAPI spec
 * (build the project once: mvn clean install -DskipTests from the repo root).
 *
 * 1. Move the hardcoded values of Helper.requestSpec() to config.properties (ConfigProperties is given)
 * 2. Use LoginRequest + JwtResponse in Helper.getToken() instead of a JSON string
 * 3. Create SignUpRequestBuilder in package builders (look at AddressRequestBuilder).
 *    Defaults must be unique per run (hint: UUID) so tests are repeatable.
 * 4. UserRequestBuilder and ProfileRequestBuilder are given: use them
 * 5. Implement the tests below
 */
public class UserDtoTest {

    @Test
    public void loginWithDtoAndReadResponseAsDto() {
        // TODO .body(loginRequest) and .extract().as(JwtResponse.class)
        fail("TODO exercise 5a");
    }

    @Test
    public void signUpWithBuilderIsRepeatable() {
        // TODO
        fail("TODO exercise 5b");
    }

    @Test
    public void signUpWithTakenUsernameIsRejected() {
        // TODO username "admin" is taken. Expect 400 and message "Username is already taken"
        fail("TODO exercise 5c");
    }

    @Test
    public void addUserWithProfile() {
        // TODO POST /api/users as a normal user (expect 201), read the answer as UserResponse
        fail("TODO exercise 5d");
    }
}
