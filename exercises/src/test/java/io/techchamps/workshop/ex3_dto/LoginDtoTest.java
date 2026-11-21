package io.techchamps.workshop.ex3_dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Exercise 3 - DTOs instead of JSON strings.
 * The classes in generated.dtos (LoginRequest, JwtResponse, ErrorResponse) are generated from the OpenAPI spec: you only use them.
 *
 * Rewrite the two login tests with DTOs:
 *   LoginRequest request = new LoginRequest(); request.setUsername(..); request.setPassword(..);
 *   JwtResponse jwt = given().spec(RequestSpecs.base()).body(request).when().post("/auth/signin")
 *                       .then().statusCode(200).extract().as(JwtResponse.class);
 * Check the content with AssertJ: assertThat(jwt.getToken()).isNotBlank()
 * REST-Assured checks the status, AssertJ checks the DTO.
 */
public class LoginDtoTest {

    @Test
    public void loginWithValidCredentials() {
        // TODO JwtResponse: token not blank, type "Bearer", roles contain ROLE_USER and ROLE_ADMIN
        fail("TODO exercise 3a");
    }

    @Test
    public void loginWithInvalidCredentials() {
        // TODO 401; ErrorResponse: error "authentication_error", message "Invalid username or password"
        fail("TODO exercise 3b");
    }
}
