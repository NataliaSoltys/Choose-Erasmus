package com.app.chooseErasmus.course;

import com.app.chooseErasmus.enums.CourseCategory;;
import com.app.chooseErasmus.enums.SemesterType;
import com.app.chooseErasmus.studyField.StudyField;
import com.app.chooseErasmus.universityUser.UniversityUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name = "study_field_id")
    private StudyField studyField;
}