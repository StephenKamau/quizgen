package com.stephenk.quizgen.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stephenk.quizgen.models.CreateQuizDTO;
import com.stephenk.quizgen.models.QuizDTO;
import com.stephenk.quizgen.models.QuizQuery;
import com.stephenk.quizgen.services.QuizService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/quiz")
@Slf4j
@Validated
public class QuizController {
    private final QuizService qService;

    public QuizController(QuizService qService) {
        this.qService = qService;
    }

    @GetMapping
    public ResponseEntity<Page<QuizDTO>> fetchAll(@RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        QuizQuery query = QuizQuery.builder()
                .page(page)
                .size(size)
                .sort(Sort.by(Sort.Direction.DESC, "createdAt"))
                .build();
        log.info("***Fetch all quizzes***");
        return ResponseEntity.ok(qService.fetchAll(query));
    }

    @PostMapping
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody @Valid CreateQuizDTO newQuiz) {
        log.info("***Create new quiz***");
        return new ResponseEntity<>(qService.createQuiz(newQuiz), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<QuizDTO> updateQuiz(@RequestBody @Valid QuizDTO quiz) {
        log.info("***Update quiz***");
        return new ResponseEntity<>(qService.updateQuiz(quiz), HttpStatus.CREATED);
    }
}
