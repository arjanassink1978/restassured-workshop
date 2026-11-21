package io.techchamps.workshop.client;

import generated.dtos.ProfileRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.techchamps.workshop.auth.TokenProvider;
import io.techchamps.workshop.spec.RequestSpecs;

import static io.restassured.RestAssured.given;

/** Knows the /profile endpoints of the signed-in user. */
public class ProfileClient {

    private final RequestSpecification spec;

    private ProfileClient(RequestSpecification spec) {
        this.spec = spec;
    }

    public static ProfileClient asAdmin() {
        return new ProfileClient(RequestSpecs.bearer(TokenProvider.admin()));
    }

    public static ProfileClient asUser() {
        return new ProfileClient(RequestSpecs.bearer(TokenProvider.user()));
    }

    /** A specific user, for example one the test just signed up. */
    public static ProfileClient as(String username, String password) {
        return new ProfileClient(RequestSpecs.bearer(TokenProvider.tokenFor(username, password)));
    }

    public static ProfileClient anonymous() {
        return new ProfileClient(RequestSpecs.base());
    }

    public Response get() {
        return given().spec(spec).when().get("/profile");
    }

    public Response update(ProfileRequest request) {
        return given().spec(spec).body(request).when().put("/profile");
    }

    public Response delete(int userId) {
        return given().spec(spec).when().delete("/profile/{id}", userId);
    }
}
