package io.techchamps.workshop.ex3_auth;

import io.techchamps.workshop.Helper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/** Exercise 3: authentication with a JWT token and authorisation per role. */
public class GetAllUsersTest {

    @Test
    public void adminCanGetAllUsers() {
        given()
                .spec(Helper.adminSpec())
        .when()
                .get("/users")
        .then()
                .log().all()
                .statusCode(200)
                .body("username", hasItems("admin", "user", "moderator"));
    }

    @Test
    public void userIsForbiddenToGetAllUsers() {
        given()
                .spec(Helper.userSpec())
        .when()
                .get("/users")
        .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void anonymousIsUnauthorized() {
        given()
                .spec(Helper.requestSpec())
        .when()
                .get("/users")
        .then()
                .log().all()
                .statusCode(401);
    }
}
