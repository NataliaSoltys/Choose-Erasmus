package com.app.chooseErasmus.faculty;

import com.app.chooseErasmus.studyField.StudyField;
import com.app.chooseErasmus.universityUser.UniversityUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String dean;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityUser university;




    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @JsonManagedReference(value = "studyFields")
    private List<StudyField> studyFields;

}