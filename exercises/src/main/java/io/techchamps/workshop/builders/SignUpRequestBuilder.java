package io.techchamps.workshop.builders;

import generated.dtos.SignUpRequest;

import java.util.UUID;

public class SignUpRequestBuilder {

    private final SignUpRequest signUpRequest = new SignUpRequest();

    public SignUpRequestBuilder() {
        String unique = UUID.randomUUID().toString().substring(0, 8);

        signUpRequest.setName("Jane Doe");
        signUpRequest.setUsername("jane-" + unique);
        signUpRequest.setEmail("jane-" + unique + "@test.nl");
        signUpRequest.setPassword("secret123");
    }

    public SignUpRequestBuilder withName(String name) {
        signUpRequest.setName(name);
        return this;
    }

    public SignUpRequestBuilder withUsername(String username) {
        signUpRequest.setUsername(username);
        return this;
    }

    public SignUpRequestBuilder withEmail(String email) {
        signUpRequest.setEmail(email);
        return this;
    }

    public SignUpRequestBuilder withPassword(String password) {
        signUpRequest.setPassword(password);
        return this;
    }

    public SignUpRequest build() {
        return signUpRequest;
    }
}
