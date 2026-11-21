package io.techchamps.workshop.ex7_agent;

import generated.dtos.ProfileRequest;
import generated.dtos.ProfileResponse;
import generated.dtos.SignUpRequest;
import io.techchamps.workshop.builders.AddressRequestBuilder;
import io.techchamps.workshop.builders.ProfileRequestBuilder;
import io.techchamps.workshop.builders.SignUpRequestBuilder;
import io.techchamps.workshop.client.AuthClient;
import io.techchamps.workshop.client.ProfileClient;
import io.techchamps.workshop.client.UserClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Exercise 9: the kind of test class the agent should produce for the /profile endpoints:
 * a client, builders, DTOs, role checks and cleanup.
 */
public class ProfileTest {

    private final SignUpRequest newUser = new SignUpRequestBuilder().build();

    @AfterEach
    void cleanUp() {
        UserClient.asAdmin().deleteByUsername(newUser.getUsername());
    }

    @Test
    public void signedInUserCanUpdateAndReadOwnProfile() {
        new AuthClient().signUp(newUser).then().statusCode(200);
        ProfileClient profile = ProfileClient.as(newUser.getUsername(), newUser.getPassword());
        ProfileRequest update = new ProfileRequestBuilder()
                .withAddress(new AddressRequestBuilder().withCity("Amsterdam").build())
                .withInterest(ProfileRequest.InterestsEnum.MUSIC)
                .build();

        profile.update(update).then().statusCode(200);

        ProfileResponse stored = profile.get()
                .then().statusCode(200)
                .extract().as(ProfileResponse.class);
        assertThat(stored.getAddresses()).hasSize(1);
        assertThat(stored.getAddresses().get(0).getCity()).isEqualTo("Amsterdam");
        assertThat(stored.getInterests()).containsExactly(ProfileResponse.InterestsEnum.MUSIC);
    }

    @Test
    public void anonymousCannotReadProfile() {
        ProfileClient.anonymous().get().then().statusCode(401);
    }

    @Test
    public void userCannotDeleteProfile() {
        ProfileClient.asUser().delete(2).then().statusCode(403);
    }
}
