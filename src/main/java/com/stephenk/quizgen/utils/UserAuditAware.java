package com.stephenk.quizgen.utils;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public class UserAuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Tester");
    }
}
