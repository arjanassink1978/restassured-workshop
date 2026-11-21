package io.techchamps.workshop.auth;

import io.techchamps.workshop.client.AuthClient;
import io.techchamps.workshop.config.ConfigProperties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Signs in once per user and reuses the token, so a test run does not log in for every request. */
public final class TokenProvider {

    private static final Map<String, String> TOKENS = new ConcurrentHashMap<>();

    private TokenProvider() {
    }

    public static String tokenFor(String username, String password) {
        return TOKENS.computeIfAbsent(username, u -> new AuthClient().login(username, password).getToken());
    }

    public static String admin() {
        return tokenFor(ConfigProperties.getProperty("adminUsername"), ConfigProperties.getProperty("adminPassword"));
    }

    public static String user() {
        return tokenFor(ConfigProperties.getProperty("userUsername"), ConfigProperties.getProperty("userPassword"));
    }
}
