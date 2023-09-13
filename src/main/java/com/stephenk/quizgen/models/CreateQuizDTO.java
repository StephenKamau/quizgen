package com.stephenk.quizgen.models;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateQuizDTO(
                @NotBlank String quizTitle,
                @NotBlank String quizDescription,
                @NotEmpty List<String> quizOptions,
                @NotBlank String quizAnswer) {
}
