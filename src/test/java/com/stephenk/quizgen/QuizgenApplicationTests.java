package com.stephenk.quizgen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Import(PostgresContainerSetup.class)
@Testcontainers
class QuizgenApplicationTests {

    @Test
    void contextLoads() {
    }

}
