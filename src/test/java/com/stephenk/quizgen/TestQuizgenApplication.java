package com.stephenk.quizgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration(proxyBeanMethods = false)
@Testcontainers
public class TestQuizgenApplication {

    public static void main(String[] args) {
        SpringApplication.from(QuizgenApplication::main).with(PostgresContainerSetup.class).run(args);
    }

}
