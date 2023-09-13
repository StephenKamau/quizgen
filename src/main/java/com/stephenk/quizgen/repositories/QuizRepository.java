package com.stephenk.quizgen.repositories;

import com.stephenk.quizgen.models.Quiz;
import com.stephenk.quizgen.models.QuizDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("""
            SELECT new com.stephenk.quizgen.models.QuizDTO(q.id,q.createdAt,q.updatedAt,q.quizTitle,q.quizDescription,q.quizOptions,q.createdBy,q.modifiedBy) FROM Quiz q
            """)
    Page<QuizDTO> findAllQuizzes(Pageable pageable);
}
