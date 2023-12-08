package com.app.chooseErasmus.course;

import com.app.chooseErasmus.enums.CourseCategory;;
import com.app.chooseErasmus.enums.SemesterType;
import com.app.chooseErasmus.studyField.StudyField;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column
    @Enumerated(EnumType.STRING)
    private CourseCategory courseCategory;

    @Enumerated(EnumType.STRING)
    private SemesterType semesterType;

    @Column
    private Integer ectsPoints;

    @Column
    private Integer semester;

    @Column
    private Integer hoursAmount;

    @Column
    private String courseDescription;

    @ManyToOne
    @JoinColumn(name = "study_field_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudyField studyField;
}