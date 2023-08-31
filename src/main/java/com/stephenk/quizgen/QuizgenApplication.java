package com.stephenk.quizgen;

import com.stephenk.quizgen.utils.UserAuditAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing()
public class QuizgenApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizgenApplication.class, args);
    }

    @Bean
    UserAuditAware auditAware() {
        return new UserAuditAware();
    }
}
