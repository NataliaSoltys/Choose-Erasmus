package com.app.chooseErasmus.studyField;


import com.app.chooseErasmus.course.Course;
import com.app.chooseErasmus.faculty.Faculty;
import com.app.chooseErasmus.studentUser.StudentUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
public class StudyField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Faculty faculty;

    @Column
    private Integer semesterAmount;

    @OneToMany(mappedBy = "studyField")
    @JsonIgnore
    @JsonManagedReference(value = "studentUsers")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<StudentUser> studentUsers;

    @OneToMany(mappedBy = "studyField")
    @JsonIgnore
    @JsonManagedReference(value = "studentUsers")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Course> courses;
}