package io.techchamps.workshop.builders;

import generated.dtos.ProfileRequest;
import generated.dtos.RoleRequest;
import generated.dtos.UserRequest;

import java.util.UUID;

public class UserRequestBuilder {

    private final UserRequest userRequest = new UserRequest();

    public UserRequestBuilder() {
        // Unique per run, so tests can be repeated against the same in-memory database
        String unique = UUID.randomUUID().toString().substring(0, 8);

        RoleRequest role = new RoleRequest();
        role.setName("USER");

        userRequest.setName("John");
        userRequest.setUsername("john-" + unique);
        userRequest.setEmail("john-" + unique + "@test.nl");
        userRequest.setPassword("test1234");
        userRequest.addRolesItem(role);
        userRequest.setProfile(new ProfileRequestBuilder().build());
    }

    public UserRequestBuilder withName(String name) {
        userRequest.setName(name);
        return this;
    }

    public UserRequestBuilder withUsername(String username) {
        userRequest.setUsername(username);
        return this;
    }

    public UserRequestBuilder withEmail(String email) {
        userRequest.setEmail(email);
        return this;
    }

    public UserRequestBuilder withPassword(String password) {
        userRequest.setPassword(password);
        return this;
    }

    public UserRequestBuilder withProfile(ProfileRequest profile) {
        userRequest.setProfile(profile);
        return this;
    }

    public UserRequest build() {
        return userRequest;
    }
}
