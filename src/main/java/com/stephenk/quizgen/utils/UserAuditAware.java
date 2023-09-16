package com.stephenk.quizgen.utils;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class UserAuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Tester");
    }
}
