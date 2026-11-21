package io.techchamps.workshop.ex3_auth;

import generated.dtos.UserResponse;
import io.techchamps.workshop.client.UserClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** Exercise 3: who is allowed to do what. One test per kind of caller. */
public class GetAllUsersTest {

    @Test
    public void adminCanGetAllUsers() {
        UserResponse[] users = UserClient.asAdmin().getAll()
                .then().statusCode(200)
                .extract().as(UserResponse[].class);

        assertThat(users).extracting(UserResponse::getUsername)
                .contains("admin", "user", "moderator");
    }

    @Test
    public void userIsForbiddenToGetAllUsers() {
        UserClient.asUser().getAll()
                .then().statusCode(403);
    }

    @Test
    public void anonymousIsUnauthorized() {
        UserClient.anonymous().getAll()
                .then().statusCode(401);
    }
}
