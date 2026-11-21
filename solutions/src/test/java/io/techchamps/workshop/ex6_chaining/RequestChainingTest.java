package io.techchamps.workshop.ex6_chaining;

import generated.dtos.SignUpRequest;
import generated.dtos.UserResponse;
import io.techchamps.workshop.builders.SignUpRequestBuilder;
import io.techchamps.workshop.client.AuthClient;
import io.techchamps.workshop.client.UserClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** Exercise 6: request chaining. The output of one call is the input of the next. */
public class RequestChainingTest {

    private final SignUpRequest newUser = new SignUpRequestBuilder().build();

    /** Safety net: also runs when an assertion fails halfway the flow. */
    @AfterEach
    void cleanUp() {
        UserClient.asAdmin().deleteByUsername(newUser.getUsername());
    }

    @Test
    public void signUpGetAndDeleteUser() {
        // 1. sign up
        new AuthClient().signUp(newUser)
                .then().statusCode(200);

        // 2. get the user by username and keep the generated id
        UserResponse created = UserClient.asUser().getByUsername(newUser.getUsername())
                .then().statusCode(200)
                .extract().as(UserResponse.class);
        assertThat(created.getName()).isEqualTo(newUser.getName());

        // 3. delete it by id
        UserClient.asUser().delete(created.getId())
                .then().statusCode(200);

        // 4. it is really gone
        UserClient.asUser().getById(created.getId())
                .then().statusCode(404);
    }
}
