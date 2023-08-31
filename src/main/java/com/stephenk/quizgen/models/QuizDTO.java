package com.stephenk.quizgen.models;

import java.time.Instant;
import java.util.List;

public record QuizDTO(
        long id,
        Instant createdAt,
        Instant updatedAt,
        String quizTitle,
        String quizDescription,
        List<String> quizOptions,
        String quizAnswer
) {
    public static QuizDTO fromQuiz(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getCreatedAt(), quiz.getUpdatedAt(), quiz.getQuizTitle(), quiz.getQuizDescription(), quiz.getQuizOptions(), quiz.getQuizAnswer());
    }
}
