package io.techchamps.workshop.ex5_dto;

import generated.dtos.JwtResponse;
import generated.dtos.LoginRequest;
import generated.dtos.SignUpRequest;
import generated.dtos.SignupResponse;
import generated.dtos.UserRequest;
import generated.dtos.UserResponse;
import io.techchamps.workshop.Helper;
import io.techchamps.workshop.builders.SignUpRequestBuilder;
import io.techchamps.workshop.builders.UserRequestBuilder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

/** Exercise 5: generated DTOs + builders instead of raw JSON, and no hardcoded config. */
public class UserDtoTest {

    @Test
    public void loginWithDtoAndReadResponseAsDto() {
        LoginRequest login = new LoginRequest();
        login.setUsername("admin");
        login.setPassword("admin1234");

        JwtResponse jwt = given()
                .spec(Helper.requestSpec())
                .body(login)
        .when()
                .post("/auth/signin")
        .then()
                .statusCode(200)
                .extract().as(JwtResponse.class);

        assertThat(jwt.getToken()).isNotBlank();
        assertThat(jwt.getType()).isEqualTo("Bearer");
        assertThat(jwt.getRoles()).contains("ROLE_ADMIN", "ROLE_USER");
    }

    @Test
    public void signUpWithBuilderIsRepeatable() {
        SignUpRequest signUp = new SignUpRequestBuilder().build();

        SignupResponse response = given()
                .spec(Helper.requestSpec())
                .body(signUp)
        .when()
                .post("/auth/signup")
        .then()
                .statusCode(200)
                .extract().as(SignupResponse.class);

        assertThat(response.getUsername()).isEqualTo(signUp.getUsername());
    }

    @Test
    public void signUpWithTakenUsernameIsRejected() {
        SignUpRequest signUp = new SignUpRequestBuilder().withUsername("admin").build();

        given()
                .spec(Helper.requestSpec())
                .body(signUp)
        .when()
                .post("/auth/signup")
        .then()
                .statusCode(400)
                .body("message", equalTo("Username is already taken"));
    }

    @Test
    public void addUserWithProfile() {
        UserRequest user = new UserRequestBuilder().withName("Builder Bob").build();

        UserResponse created = given()
                .spec(Helper.userSpec())
                .body(user)
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .extract().as(UserResponse.class);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getUsername()).isEqualTo(user.getUsername());
        assertThat(created.getProfile().getAddresses()).hasSize(1);
    }
}
