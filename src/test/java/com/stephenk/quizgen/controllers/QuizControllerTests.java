package com.stephenk.quizgen.controllers;

import com.stephenk.quizgen.models.CreateQuizDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Sql("/schema.sql")
public class QuizControllerTests {

    @ServiceConnection
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    @Order(value = 2)
    void shouldGetAllQuizzesByPage() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/quiz")
                .then()
                .statusCode(200)
                .assertThat()
                .body("content.size()", equalTo(1))
        ;
    }

    @Test
    @Order(value = 1)
    void shouldCreateQuiz() {
        CreateQuizDTO quiz = new CreateQuizDTO("Test Quiz", "Sample quiz", List.of("Answer one", "Answer two", "Answer three"), "Answer one");
        given().contentType(ContentType.JSON)
                .body(quiz)
                .when()
                .post("/api/quiz")
                .then()
                .statusCode(201)
                .assertThat()
                .body("quizTitle", equalTo(quiz.quizTitle()));
    }
}
