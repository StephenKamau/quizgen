package com.stephenk.quizgen.models;

import com.stephenk.quizgen.utils.Converters;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@EntityListeners(AuditingEntityListener.class)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    @Column(nullable = false)
    private String quizTitle;
    @Column(nullable = false)
    private String quizDescription;
    @Column(nullable = false)
    @Convert(converter = Converters.StringListConverter.class)
    private List<String> quizOptions;
    @Column(nullable = false)
    private String quizAnswer;
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;

    @PostPersist
    private void logQuizSaves() {
        log.info("***Quiz saved: " + id + "***");
    }
}
