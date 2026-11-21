package io.techchamps.workshop.ex2_spec;

import io.techchamps.workshop.spec.RequestSpecs;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Exercise 2 check (given, do not change): the API is reachable with your base specification.
 * It is green when RequestSpecs.base() works. Without a token the answer is 401: that is what we expect here.
 */
public class SpecSmokeTest {

    @Test
    public void apiIsReachableWithBaseSpec() {
        given().spec(RequestSpecs.base())
                .when().get("/users")
                .then().statusCode(401);
    }
}
