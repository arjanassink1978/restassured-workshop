package io.techchamps.workshop.ex4_chaining;

import io.techchamps.workshop.Helper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/** Exercise 4: request chaining. The output of one call is the input of the next. */
public class RequestChainingTest {

    @Test
    public void signUpGetAndDeleteUser() {
        String username = "chain-" + System.currentTimeMillis();

        // 1. sign up (no authentication needed)
        given()
                .spec(Helper.requestSpec())
                .body("""
                        {
                          "name": "Chain User",
                          "username": "%s",
                          "email": "%s@test.nl",
                          "password": "secret123"
                        }""".formatted(username, username))
        .when()
                .post("/auth/signup")
        .then()
                .statusCode(200)
                .body("username", equalTo(username));

        // 2. get the user by username and extract the generated id
        int id = given()
                .spec(Helper.userSpec())
        .when()
                .get("/users/username/{username}", username)
        .then()
                .statusCode(200)
                .body("name", equalTo("Chain User"))
                .extract().path("id");

        // 3. delete the user by id
        given()
                .spec(Helper.userSpec())
        .when()
                .delete("/users/{id}", id)
        .then()
                .statusCode(200)
                .body("username", equalTo(username));

        // 4. the user is really gone
        given()
                .spec(Helper.userSpec())
        .when()
                .get("/users/{id}", id)
        .then()
                .statusCode(404)
                .body("error", equalTo("user_not_found"));
    }
}
