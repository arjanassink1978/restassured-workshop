package io.techchamps.workshop.client;

import generated.dtos.UserRequest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.techchamps.workshop.auth.TokenProvider;
import io.techchamps.workshop.spec.RequestSpecs;

import static io.restassured.RestAssured.given;

/** Knows the /users endpoints. Choose who calls: asAdmin(), asUser() or anonymous(). */
public class UserClient {

    private final RequestSpecification spec;

    private UserClient(RequestSpecification spec) {
        this.spec = spec;
    }

    public static UserClient asAdmin() {
        return new UserClient(RequestSpecs.bearer(TokenProvider.admin()));
    }

    public static UserClient asUser() {
        return new UserClient(RequestSpecs.bearer(TokenProvider.user()));
    }

    public static UserClient anonymous() {
        return new UserClient(RequestSpecs.base());
    }

    public Response getAll() {
        return given().spec(spec).when().get("/users");
    }

    public Response getById(int id) {
        return given().spec(spec).when().get("/users/{id}", id);
    }

    public Response getByUsername(String username) {
        return given().spec(spec).when().get("/users/username/{username}", username);
    }

    public Response create(UserRequest request) {
        return given().spec(spec).body(request).when().post("/users");
    }

    public Response delete(int id) {
        return given().spec(spec).when().delete("/users/{id}", id);
    }

    /** Test cleanup: deletes the user if it exists, does nothing if it does not. */
    public void deleteByUsername(String username) {
        Response user = getByUsername(username);
        if (user.statusCode() == 200) {
            delete(user.path("id"));
        }
    }
}
