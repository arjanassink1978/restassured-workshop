package io.techchamps.workshop.ex5_dto;

import generated.dtos.ErrorResponse;
import generated.dtos.SignUpRequest;
import generated.dtos.SignupResponse;
import generated.dtos.UserRequest;
import generated.dtos.UserResponse;
import io.techchamps.workshop.builders.SignUpRequestBuilder;
import io.techchamps.workshop.builders.UserRequestBuilder;
import io.techchamps.workshop.client.AuthClient;
import io.techchamps.workshop.client.UserClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/** Exercise 5: builders with unique defaults, DTO assertions and cleanup of the data a test creates. */
public class UserDtoTest {

    private final List<String> createdUsernames = new ArrayList<>();

    @AfterEach
    void cleanUp() {
        createdUsernames.forEach(UserClient.asAdmin()::deleteByUsername);
    }

    @Test
    public void signUpWithBuilderIsRepeatable() {
        SignUpRequest signUp = new SignUpRequestBuilder().build();
        createdUsernames.add(signUp.getUsername());

        SignupResponse response = new AuthClient().signUp(signUp)
                .then().statusCode(200)
                .extract().as(SignupResponse.class);

        assertThat(response.getUsername()).isEqualTo(signUp.getUsername());
    }

    @Test
    public void signUpWithTakenUsernameIsRejected() {
        SignUpRequest signUp = new SignUpRequestBuilder().withUsername("admin").build();

        ErrorResponse error = new AuthClient().signUp(signUp)
                .then().statusCode(400)
                .extract().as(ErrorResponse.class);

        assertThat(error.getMessage()).isEqualTo("Username is already taken");
    }

    @Test
    public void addUserWithProfile() {
        UserRequest user = new UserRequestBuilder().withName("Builder Bob").build();
        createdUsernames.add(user.getUsername());

        UserResponse created = UserClient.asUser().create(user)
                .then().statusCode(201)
                .extract().as(UserResponse.class);

        assertThat(created.getId()).isNotNull();
        assertThat(created.getUsername()).isEqualTo(user.getUsername());
        assertThat(created.getProfile().getAddresses()).hasSize(1);
    }
}
