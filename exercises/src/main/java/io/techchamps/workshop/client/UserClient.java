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

    /** Exercise 3: a client whose requests carry the admin token (see TokenProvider and RequestSpecs.bearer). */
    public static UserClient asAdmin() {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    /** Exercise 3: same, for the normal user. */
    public static UserClient asUser() {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    /** Exercise 3: a client without a token. */
    public static UserClient anonymous() {
        throw new UnsupportedOperationException("TODO exercise 3");
    }

    /** Exercise 3: GET /users. The other methods below are given. */
    public Response getAll() {
        throw new UnsupportedOperationException("TODO exercise 3");
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
