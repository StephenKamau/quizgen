package com.stephenk.quizgen.models;

import lombok.*;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuizQuery {
    private int page;
    private int size;
    private Sort sort;
}
