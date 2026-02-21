package com.company.dry_cleaners.config;

import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;

@Component
public class ProblemDebugSupport {

    private final boolean debug;

    public ProblemDebugSupport(Environment env) {
        this.debug = env.acceptsProfiles(Profiles.of("dev", "local"));
    }

    public boolean isDebug() {
        return debug;
    }
}