package io.techchamps.workshop.ex3_dto;

import generated.dtos.ErrorResponse;
import generated.dtos.JwtResponse;
import generated.dtos.LoginRequest;
import io.techchamps.workshop.spec.RequestSpecs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/** Exercise 3: the same tests with generated DTOs instead of JSON strings, and AssertJ for the content. */
public class LoginDtoTest {

    @Test
    public void loginWithValidCredentials() {
        LoginRequest request = new LoginRequest();
        request.setUsername("admin");
        request.setPassword("admin1234");

        JwtResponse jwt = given().spec(RequestSpecs.base()).body(request)
                .when().post("/auth/signin")
                .then().statusCode(200)
                .extract().as(JwtResponse.class);

        assertThat(jwt.getToken()).isNotBlank();
        assertThat(jwt.getType()).isEqualTo("Bearer");
        assertThat(jwt.getRoles()).contains("ROLE_USER", "ROLE_ADMIN");
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginRequest request = new LoginRequest();
        request.setUsername("dontExist");
        request.setPassword("wrong1234");

        ErrorResponse error = given().spec(RequestSpecs.base()).body(request)
                .when().post("/auth/signin")
                .then().statusCode(401)
                .extract().as(ErrorResponse.class);

        assertThat(error.getError()).isEqualTo("authentication_error");
        assertThat(error.getMessage()).isEqualTo("Invalid username or password");
    }
}
