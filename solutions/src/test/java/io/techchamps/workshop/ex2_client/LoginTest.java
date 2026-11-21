package io.techchamps.workshop.ex2_client;

import generated.dtos.ErrorResponse;
import generated.dtos.JwtResponse;
import io.techchamps.workshop.client.AuthClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** Exercise 2: the same checks as exercise 1, now through the AuthClient and with DTOs. */
public class LoginTest {

    private final AuthClient auth = new AuthClient();

    @Test
    public void loginWithValidCredentials() {
        JwtResponse jwt = auth.signIn("admin", "admin1234")
                .then().statusCode(200)
                .extract().as(JwtResponse.class);

        assertThat(jwt.getToken()).isNotBlank();
        assertThat(jwt.getType()).isEqualTo("Bearer");
        assertThat(jwt.getRoles()).contains("ROLE_USER", "ROLE_ADMIN");
    }

    @Test
    public void loginWithInvalidCredentials() {
        ErrorResponse error = auth.signIn("dontExist", "wrong1234")
                .then().statusCode(401)
                .extract().as(ErrorResponse.class);

        assertThat(error.getError()).isEqualTo("authentication_error");
        assertThat(error.getMessage()).isEqualTo("Invalid username or password");
    }
}
