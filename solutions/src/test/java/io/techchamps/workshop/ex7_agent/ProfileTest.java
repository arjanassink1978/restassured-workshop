package io.techchamps.workshop.ex7_agent;

import generated.dtos.AddressRequest;
import generated.dtos.ProfileRequest;
import generated.dtos.ProfileResponse;
import io.techchamps.workshop.Helper;
import io.techchamps.workshop.builders.AddressRequestBuilder;
import io.techchamps.workshop.builders.ProfileRequestBuilder;
import io.techchamps.workshop.builders.SignUpRequestBuilder;
import generated.dtos.SignUpRequest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Exercise 7: the kind of test class the agent should produce for the /profile endpoints,
 * using our Helper, builders and generated DTOs.
 */
public class ProfileTest {

    @Test
    public void signedInUserCanUpdateAndReadOwnProfile() {
        SignUpRequest signUp = new SignUpRequestBuilder().build();
        given().spec(Helper.requestSpec()).body(signUp)
                .when().post("/auth/signup")
                .then().statusCode(200);

        var userSpec = Helper.authenticatedSpec(Helper.getToken(signUp.getUsername(), signUp.getPassword()));
        AddressRequest address = new AddressRequestBuilder().withCity("Amsterdam").build();
        ProfileRequest update = new ProfileRequestBuilder()
                .withAddress(address)
                .withInterest(ProfileRequest.InterestsEnum.MUSIC)
                .build();

        given().spec(userSpec).body(update)
                .when().put("/profile")
                .then().statusCode(200);

        ProfileResponse profile = given().spec(userSpec)
                .when().get("/profile")
                .then().statusCode(200)
                .extract().as(ProfileResponse.class);

        assertThat(profile.getAddresses()).hasSize(1);
        assertThat(profile.getAddresses().get(0).getCity()).isEqualTo("Amsterdam");
        assertThat(profile.getInterests()).containsExactly(ProfileResponse.InterestsEnum.MUSIC);
    }

    @Test
    public void anonymousCannotReadProfile() {
        given().spec(Helper.requestSpec())
                .when().get("/profile")
                .then().statusCode(401);
    }

    @Test
    public void userCannotDeleteProfile() {
        given().spec(Helper.userSpec())
                .when().delete("/profile/{id}", 2)
                .then().statusCode(403);
    }
}
