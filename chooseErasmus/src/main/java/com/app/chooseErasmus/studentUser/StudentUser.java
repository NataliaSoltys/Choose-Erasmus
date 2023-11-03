package com.app.chooseErasmus.studentUser;

import com.app.chooseErasmus.studyField.StudyField;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class StudentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @ManyToOne(cascade = CascadeType.MERGE)
    private StudyField studyField;

    @Column
    private Integer semesterAbroad;

}