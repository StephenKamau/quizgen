package com.stephenk.quizgen.models;

import java.time.Instant;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record QuizDTO(
        @NotBlank long id,
        @NotBlank Instant createdAt,
        @NotBlank Instant updatedAt,
        @NotBlank String quizTitle,
        @NotBlank String quizDescription,
        @NotEmpty List<String> quizOptions,
        @NotBlank String createdBy,
        @NotBlank String updatedBy) {
    public static QuizDTO fromQuiz(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getCreatedAt(), quiz.getUpdatedAt(), quiz.getQuizTitle(),
                quiz.getQuizDescription(), quiz.getQuizOptions(), quiz.getCreatedBy(),quiz.getModifiedBy());
    }
}
