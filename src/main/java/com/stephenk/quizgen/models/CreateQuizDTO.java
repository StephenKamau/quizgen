package com.stephenk.quizgen.models;

import java.util.List;


public record CreateQuizDTO(
        String quizTitle,
        String quizDescription,
        List<String> quizOptions,
        String quizAnswer) {
}
