package com.stephenk.quizgen.services;

import com.stephenk.quizgen.models.CreateQuizDTO;
import com.stephenk.quizgen.models.Quiz;
import com.stephenk.quizgen.models.QuizDTO;
import com.stephenk.quizgen.models.QuizQuery;
import com.stephenk.quizgen.repositories.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class QuizService {
    private final QuizRepository quizRepo;

    public QuizService(QuizRepository quizRepo) {
        this.quizRepo = quizRepo;
    }

    @Transactional
    public QuizDTO createQuiz(CreateQuizDTO newQuiz) {
        Quiz quiz = Quiz.builder().quizTitle(newQuiz.quizTitle()).quizDescription(newQuiz.quizDescription()).quizOptions(newQuiz.quizOptions()).quizAnswer(newQuiz.quizAnswer()).build();
        log.info("***Saving quiz: " + newQuiz.quizTitle() + " to DB***");
        return QuizDTO.fromQuiz(quizRepo.save(quiz));
    }

    @Transactional
    public QuizDTO updateQuiz(QuizDTO updateQuiz) {
        Quiz quiz = quizRepo.findById(updateQuiz.id()).orElseThrow();
        quiz.setQuizTitle(updateQuiz.quizTitle());
        quiz.setQuizDescription(updateQuiz.quizDescription());
        quiz.setQuizOptions(updateQuiz.quizOptions());
        log.info("***Updating quiz with id: " + updateQuiz.id() + "***");
        return QuizDTO.fromQuiz(quizRepo.save(quiz));
    }

    public Page<QuizDTO> fetchAll(QuizQuery query) {
        int page = query.getPage();
        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, query.getSize(), query.getSort());
        log.info("***Fetching all records in page: " + pageable + "***");
        return quizRepo.findAllQuizzes(pageable);
    }
}
