package io.techchamps.restbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Workshop only: deliberate bugs that can be switched on to check whether a test really catches them.
 * Start the backend with e.g. --workshop.bug.profile-delete-open=true
 */
@Component("bugFlags")
public class BugFlags {

    @Value("${workshop.bug.profile-delete-open:false}")
    private boolean profileDeleteOpen;

    public boolean isProfileDeleteOpen() {
        return profileDeleteOpen;
    }
}
