package com.stephenk.quizgen.controllers;

import com.stephenk.quizgen.models.CreateQuizDTO;
import com.stephenk.quizgen.models.QuizDTO;
import com.stephenk.quizgen.models.QuizQuery;
import com.stephenk.quizgen.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@Slf4j
public class QuizController {
    private final QuizService qService;

    public QuizController(QuizService qService) {
        this.qService = qService;
    }

    @GetMapping
    public ResponseEntity<Page<QuizDTO>> fetchAll(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        QuizQuery query = QuizQuery.builder()
                .page(page)
                .size(size)
                .sort(Sort.by(Sort.Direction.DESC, "createdAt"))
                .build();
        log.info("***Fetch all quizzes***");
        return ResponseEntity.ok(qService.fetchAll(query));
    }

    @PostMapping
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody CreateQuizDTO newQuiz) {
        log.info("***Create new quiz***");
        return new ResponseEntity<>(qService.createQuiz(newQuiz), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<QuizDTO> updateQuiz(@RequestBody QuizDTO quiz) {
        log.info("***Update quiz***");
        return new ResponseEntity<>(qService.updateQuiz(quiz), HttpStatus.CREATED);
    }
}
